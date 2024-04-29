package com.fatfrogdev.iemsbackend.repositories;

import com.fatfrogdev.iemsbackend.domain.models.MongoImageEntity;
import org.springframework.data.repository.CrudRepository;

public interface IMongoImageEntityRepository extends CrudRepository<MongoImageEntity, String> {
}
