package com.fatfrogdev.iemsbackend.services.impl;

import com.fatfrogdev.iemsbackend.domain.models.ReviewEntity;
import com.fatfrogdev.iemsbackend.services.IUploadFileService;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class UploadFileServiceImpl implements IUploadFileService {

    // Name of the folder that contains the uploads
    private final static String UPLOADS_FOLDER = "uploads";

    // Saves the file sent into the uploads folder
    @Override
    public String copy(MultipartFile file) throws IOException {
        String uniqueFileName = file.getOriginalFilename() + "_" + UUID.randomUUID();
        Path rooPath = getPath(uniqueFileName);
        Files.copy(file.getInputStream(), rooPath);
        return uniqueFileName;
    }

    // Loads up the file to be showed in the browser
    @Override
    public Resource load(String filename) throws MalformedURLException {
        Path filePath = getPath(filename);

        Resource resource = new UrlResource(filePath.toUri());

        if (!resource.exists() || !resource.isReadable()) {
            throw new RuntimeException("Error: Image could not be charged: " + filePath); // TODO: Add personalized this exception
        }

        return resource;
    }

    @Override
    public boolean delete(String filename) {
        Path rootPath = getPath(filename);
        File file = rootPath.toFile();

        if (file.exists() && file.canRead()) {
            return file.delete();
        }
        return false;
    }

    @Override
    public Path getPath(String filename) {
        return Paths.get(UPLOADS_FOLDER).resolve(filename).toAbsolutePath();
    }



    private boolean saveFileList(List<MultipartFile> files) throws IOException {
        if (files.isEmpty()) throw new IllegalArgumentException("File List must have at least one element"); // TODO: Add exception.

        String[] filesIds = new String[files.size()];
        boolean allFilesWasSaved = true;

        for (int index = 0; index < files.size(); index++) {
            MultipartFile file = files.get(index);
             filesIds[index] = copy(file);
        }

        // Check if all files were saved properly.
        for (MultipartFile file : files) {
            allFilesWasSaved = load(file.getOriginalFilename()).exists();
        }

        if (allFilesWasSaved) return true;
        else {
            Arrays.stream(filesIds).forEach(this::delete);
            return false;
        }
    }
}
