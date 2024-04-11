package com.fatfrogdev.iemsbackend.services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;

public interface IUploadFileService {

        String copy(MultipartFile file) throws IOException;

        Resource load(String filename) throws MalformedURLException;

        boolean delete(String filename);

        Path getPath(String filename);
}
