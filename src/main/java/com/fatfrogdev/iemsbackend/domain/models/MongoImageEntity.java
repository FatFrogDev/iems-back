package com.fatfrogdev.iemsbackend.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="mongo_images")
public class MongoImageEntity {

    @Id
    private String mongoImageId;

}
