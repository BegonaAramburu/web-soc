package com.aramburu.websoc.repositories;

import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;

import com.aramburu.websoc.documents.Center;

@Repository
public interface CenterReactRepository extends ReactiveSortingRepository<Center, String> {

}
