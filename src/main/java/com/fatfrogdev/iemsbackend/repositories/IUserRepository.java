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

    Optional<UserEntity> findByUserIdAndAndDeletedIsTrue(String userID);

    @SoftDelete
    @Modifying
    @Transactional
    @Query("update UserEntity u set u.deleted = true where u.userId = ?1")
    void deleteByUserId(String id);

    Optional<UserEntity> findByUsername(String username);
}
