package com.fatfrogdev.iemsbackend.repositories;

import com.fatfrogdev.iemsbackend.domain.models.UserEntity;
import jakarta.transaction.Transactional;
import org.hibernate.annotations.SoftDelete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, String> {

    Optional<UserEntity> findByUserIdAndActiveIsTrue(String userId);

    @SoftDelete
    @Modifying
    @Transactional
    @Query("update UserEntity u set u.active=false where u.userId = :id")
    void deactivateByUserId(String id);

    @Modifying
    @Transactional
    @Query("update UserEntity u set u.active=true where u.userId = :id")
    void activateByUserId(String id);

    @Query("select u.active from UserEntity u where u.username = :username")
    Optional<Boolean> findActiveByUsername(String username);

    @Query("select u from UserEntity u where u.username=:username")
    Optional<UserEntity> findByUsername(String username);

    Optional<UserEntity> findByUsernameAndActiveIsTrue(String username);
}