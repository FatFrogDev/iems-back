package com.fatfrogdev.iemsbackend.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "files")
public class FileEntity {

    @Id
    @UuidGenerator
    private String fileId;

    private String name;

    private String type;

    @Lob
    private byte[] data;

    public  FileEntity(String name, String type, byte[] data) {
        this.name = name;
        this.type = type;
        this.data = data;
    }
}