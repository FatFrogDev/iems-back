package com.fatfrogdev.iemsbackend.repositories;

import com.fatfrogdev.iemsbackend.domain.models.FileEntity;
import jakarta.transaction.Transactional;
import org.hibernate.annotations.SQLDelete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface IFileRepository extends JpaRepository<FileEntity, String> {

    @Query("select f.type from FileEntity f where f.fileId = ?1")
    Optional<String> findFileTypeById(String fileId);

    @Query("select f from  FileEntity f where f.fileId = :fileId and f.type like :type%")
    @Transactional
    Optional<FileEntity> findImageDataByFileIdAndTypeStartsWith(@Param("fileId") String fileId,@Param("type") String type);

    @Transactional
    boolean existsByFileIdAndTypeStartsWith(String fileId, String type);
}