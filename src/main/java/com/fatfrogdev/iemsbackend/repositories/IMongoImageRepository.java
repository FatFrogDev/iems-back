package com.fatfrogdev.iemsbackend.repositories;

import com.fatfrogdev.iemsbackend.domain.models.mongo.ImageMongoEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface IMongoImageRepository extends MongoRepository<ImageMongoEntity, String> {

    Optional<ImageMongoEntity> findBySqlId(String sqlId);

    @Transactional(readOnly = true)
    boolean existsBySqlId(String sqlId);

    @Transactional
    void deleteBySqlId(String sqlId);
}
