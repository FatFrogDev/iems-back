package com.fatfrogdev.iemsbackend.repositories;

import com.fatfrogdev.iemsbackend.domain.models.UserEntity;
import jakarta.transaction.Transactional;
import org.hibernate.annotations.SQLUpdate;
import org.hibernate.annotations.SoftDelete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, String> {

    Optional<UserEntity> findByUserIdAndAndDeletedIsTrue(String userId);

    @SoftDelete
    @Modifying
    @Transactional
    @Query("update UserEntity u set u.deleted = true where u.userId = :id")
    void deleteByUserId(String id);


    @Modifying
    @Transactional
    @Query("update UserEntity u set u.deleted = false where u.userId = :id")
    void activateByUserId(String id);

    @Query("select u.deleted from UserEntity u where u.username = :username")
    Optional<Boolean> findByUsernameAndDeletedIsTrue(String username);



    Optional<UserEntity> findByUsername(String username);

}