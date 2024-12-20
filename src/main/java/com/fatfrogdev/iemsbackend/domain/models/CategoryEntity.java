package com.fatfrogdev.iemsbackend.domain.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class CategoryEntity {

    @Id
    @NotBlank(message = "Category name is required.")
    @Column(nullable = false, length = 45)
    private String categoryName;

    @Column(length = 250)
    @Size(max = 250)
    private String description;

    public CategoryEntity(String categoryName) {
        this.categoryName = categoryName;
    }
}