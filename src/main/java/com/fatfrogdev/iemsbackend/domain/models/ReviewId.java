package com.fatfrogdev.iemsbackend.domain.models;

import ch.qos.logback.core.net.server.Client;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ReviewId implements Serializable {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", nullable = false)
    private ClientEntity client;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="product_id", nullable = false)
    private ProductEntity product;


    @Positive(message = "Review number must be greater than 0.")
    @Size(message = "You can only create between 1 and 2 reviews per product.", min = 1, max = 2)
    @Column(length = 1, nullable = false)
    private Integer reviewNumber;
}
