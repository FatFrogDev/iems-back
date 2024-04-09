package com.fatfrogdev.iemsbackend.services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;

public interface UploadFileService {

        public String copy(MultipartFile file) throws IOException;

        public Resource load(String filename) throws MalformedURLException;

        public boolean delete(String filename);
}
