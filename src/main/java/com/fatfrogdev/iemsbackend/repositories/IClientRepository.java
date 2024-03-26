package com.fatfrogdev.iemsbackend.repositories;

import com.fatfrogdev.iemsbackend.domain.models.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface IClientRepository extends JpaRepository<ClientEntity, String> {
    Optional<ClientEntity> findByUserUsernameAndUserDeletedIsFalse(String username);
}
