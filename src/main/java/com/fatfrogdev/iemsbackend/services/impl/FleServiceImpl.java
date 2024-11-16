package com.fatfrogdev.iemsbackend.services.impl;

import com.fatfrogdev.iemsbackend.domain.models.FileEntity;
import com.fatfrogdev.iemsbackend.exceptions.file.FileNotFoundException;
import com.fatfrogdev.iemsbackend.repositories.IFileRepository;
import com.fatfrogdev.iemsbackend.services.IFileService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@AllArgsConstructor
public class FleServiceImpl implements IFileService {

    private final IFileRepository fileRepository;

    private static final long MAX_IMAGE_SIZE = 7 * 1024 * 1024; // Equals to 10MB

    private static  final String[] DEFAULT_VALID_FILE_EXTENSIONS = {"jpg", "jpeg", "pdf"};

    @Override
    public byte[] findImageById(String fileId) {
        FileEntity fileEntity = fileRepository.findImageDataByFileIdAndTypeStartsWith(fileId, "image/")
                .orElseThrow(() -> new FileNotFoundException(String.format("Error: Image with id %s not found or it is not marked as image", fileId)));
        return fileEntity.getData();
    }

    @Override
    public void deleteImageById(String fileId) {
        boolean imageExists = fileRepository.existsByFileIdAndTypeStartsWith(fileId, "image/");
        if (!imageExists)
            throw new FileNotFoundException(String.format("Error: Image with id %s not found or it is not marked as image.", fileId));
        else
            fileRepository.deleteById(fileId);
    }

    /**
     * Given a file, it validates if it has a valid extension.<br>
     * First is validated that the originalFileName is not null, then it is validated that the extension is valid according to the validExtensions array arg.
     * @param  validExtensions the valid extensions for the file.
     * @return true or false if the file has a valid extension or no.
     * */
    @Override
    public boolean hasValidImageExtension(String fileName, String... validExtensions) {
        validExtensions = validExtensions == null ? DEFAULT_VALID_FILE_EXTENSIONS : validExtensions;
        if (fileName != null) {
            // Check the last point index which is usually the extension separator. Also, checks that last point index found is valid.
            int lastPointIndex = fileName.lastIndexOf(".");
            if (lastPointIndex > 0 && lastPointIndex < fileName.length() - 1) {
                String extension = fileName.substring(lastPointIndex + 1).toLowerCase();
                // Validate the extension format.
                for (String validExtension : validExtensions) {
                    if (!extension.equals(validExtension.toLowerCase())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public boolean imageHasValidSize(MultipartFile file){
        return file.getSize() <= MAX_IMAGE_SIZE;
    }
}