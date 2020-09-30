package com.aramburu.websoc.api_rest_controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aramburu.websoc.business_controllers.CenterController;
import com.aramburu.websoc.dtos.CenterDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(CenterResource.CENTERS)
public class CenterResource {
	
	public static final String CENTERS = "/public/training/centers";
	public static final String CENTER_ID = "/{id}";
	
	@Autowired
	public CenterController centerController;
	
	@PostMapping
	public Mono<CenterDto> createCenter(@Valid @RequestBody CenterDto centerDto) {
		return this.centerController.createCenterDto(centerDto);	
	}

	@GetMapping
	public Flux<CenterDto> getAll(){
		return this.centerController.getAllCenterDto();
	}
	
	@GetMapping(value = CENTER_ID)
	public Mono<CenterDto> getById(@PathVariable String id) {
		Mono<String> idMono = Mono.just(id);
		return this.centerController.getCenterById(idMono);
				
	}
	
	@DeleteMapping(value = CENTER_ID)
	public Mono<Void> deleteCenter(@PathVariable String id) {
		Mono<String> idMono = Mono.just(id);
		return this.centerController.deleteCenterById(idMono);
	}
	
	@DeleteMapping
	
	public Mono<Void> deleteAllCenters() {
		return this.centerController.deleteAllCenters();
	}
	
	@PutMapping(value = CENTER_ID)
	public Mono<CenterDto> updateCenter(@PathVariable String id, @Valid @RequestBody CenterDto centerDto){
		return this.centerController.updateCenter(id, centerDto);
	}
}

