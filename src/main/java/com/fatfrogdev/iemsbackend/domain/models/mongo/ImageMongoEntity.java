package com.fatfrogdev.iemsbackend.domain.models.mongo;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "images")
public class ImageMongoEntity {

    @Id
    private String sqlId;

    private String title;

    private Binary image;


    public ImageMongoEntity(String title) {
        this.title = title;
    }
}
