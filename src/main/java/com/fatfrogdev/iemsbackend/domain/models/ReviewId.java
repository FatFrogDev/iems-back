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
@Builder
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
}
