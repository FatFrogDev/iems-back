package com.fatfrogdev.iemsbackend.services;


import org.springframework.web.multipart.MultipartFile;

public interface IFileService {

    byte[] findImageById(String fileId);

    boolean hasValidImageExtension(String fileName, String... validExtensions);

    boolean imageHasValidSize(MultipartFile file);
        
    void deleteFileById(String fileId, String fileType);

    byte[] findDocumentById(String fileId, String fileType);
}
