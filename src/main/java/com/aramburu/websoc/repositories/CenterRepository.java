package com.aramburu.websoc.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aramburu.websoc.documents.Center;

@Repository
public interface CenterRepository extends MongoRepository<Center, String> {

}
