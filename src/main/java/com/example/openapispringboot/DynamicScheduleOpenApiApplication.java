package com.example.openapispringboot;

import com.example.openapispringboot.repositories.CronJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.example.openapispringboot.repositories")
@EnableScheduling
public class DynamicScheduleOpenApiApplication {

    @Autowired
    private CronJobRepository cronJobRepository;
//
//    @Bean
//    public String getCronValue() {
//        String cronTime = cronJobRepository.findById(0L).get().getValue();
//        System.out.println("getCronValue " + cronTime);
//        return cronTime;
//    }

    public static void main(String[] args) {
        SpringApplication.run(DynamicScheduleOpenApiApplication.class, args);
    }

}
