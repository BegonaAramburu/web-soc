package com.aramburu.websoc.repositories;

import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;

import com.aramburu.websoc.documents.Area;

import reactor.core.publisher.Mono;

@Repository
public interface AreaReactRepository extends ReactiveSortingRepository<Area, String> {
	
	Mono<Area> findByCode(Integer code);

}
