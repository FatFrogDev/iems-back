package com.fatfrogdev.iemsbackend.services.impl;

import com.fatfrogdev.iemsbackend.services.UploadFileService;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class UploadFileServiceImpl implements UploadFileService {

    // Name of the folder that contains the uploads
    private final static String UPLOADS_FOLDER = "uploads";

    // Saves the file sent into the uploads folder
    @Override
    public String copy(MultipartFile file) throws IOException {
        String uniqueFileName = file.getOriginalFilename() + "_" + UUID.randomUUID().toString();
        Path rooPath = getPath(uniqueFileName);
        Files.copy(file.getInputStream(), rooPath);
        return uniqueFileName;
    }

    // Loads up the file to be showed in the browser
    @Override
    public Resource load(String filename) throws MalformedURLException {
        Path pathFoto = getPath(filename);

        Resource recurso = new UrlResource(pathFoto.toUri());

        if (!recurso.exists() || !recurso.isReadable()) {
            throw new RuntimeException("Error: no se puede cargar la imagen: " + pathFoto.toString());
        }
        return recurso;
    }

    @Override
    public boolean delete(String filename) {
        Path rooPath = getPath(filename);
        File archivo = rooPath.toFile();

        if (archivo.exists() && archivo.canRead()) {
            if (archivo.delete()) {
                return true;
            }
        }

        return false;
    }

    public Path getPath(String filename) {
        return Paths.get(UPLOADS_FOLDER).resolve(filename).toAbsolutePath();
    }
}
