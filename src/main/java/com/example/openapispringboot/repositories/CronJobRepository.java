package com.example.openapispringboot.repositories;

import com.example.openapispringboot.entities.CronJob;
import com.example.openapispringboot.enumable.CronJobType;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface CronJobRepository extends MongoRepository<CronJob, ObjectId> {

    @Override
    Optional<CronJob> findById(ObjectId id);

    Optional<CronJob> findByType(CronJobType type);
}
