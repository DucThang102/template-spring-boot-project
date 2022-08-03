package com.example.openapispringboot.repositories;

import com.example.openapispringboot.entities.CronJob;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CronJobRepository extends MongoRepository<CronJob, Long> {
}
