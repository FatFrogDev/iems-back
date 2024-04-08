package com.fatfrogdev.iemsbackend.repositories;

import com.fatfrogdev.iemsbackend.domain.models.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface IClientRepository extends JpaRepository<ClientEntity, String> {

    @Query("SELECT c.clientId FROM ClientEntity c WHERE c.user.username = :clientUsername and c.user.deleted = false")
    Optional<String> findClientEntityByClientUserUsername(String clientUsername);

    Optional<ClientEntity> findByUserUsernameAndUserDeletedIsFalse(String username);
}
