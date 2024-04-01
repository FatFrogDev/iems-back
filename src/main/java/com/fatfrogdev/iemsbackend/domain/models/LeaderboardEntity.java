package com.fatfrogdev.iemsbackend.domain.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "leaderboards")
public class LeaderboardEntity {
    @Id
    @UuidGenerator
    private String leaderboardId;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    ClientEntity client;
}


