package com.fatfrogdev.iemsbackend.domain.models;

import ch.qos.logback.core.net.server.Client;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clients")
public class ClientEntity {
    @Id
    @UuidGenerator
    private String clientId;

    private String name;

    private String country;

    private int age;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    public ClientEntity(String clientId){
        this.clientId = clientId;
    }

    public ClientEntity(String clientId, UserEntity userEntity) {
        this.clientId = clientId;
        this.user = userEntity;
    }
}
