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

import com.aramburu.websoc.business_controllers.AreaController;
import com.aramburu.websoc.dtos.AreaDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(AreaResource.AREAS)
public class AreaResource {
	
	public static final String AREAS = "/public/training/areas";
	public static final String AREA_ID = "/{id}";
	
	@Autowired
	public AreaController areaController;
	
	@PostMapping
	public Mono<AreaDto> createArea(@Valid @RequestBody AreaDto areaDto) {
		return this.areaController.createAreaDto(areaDto);	
	}

	@GetMapping
	public Flux<AreaDto> getAll(){
		return this.areaController.getAllAreasDto();
	}
	
	@GetMapping(value = AREA_ID)
	public Mono<AreaDto> getById(@PathVariable String id) {
		Mono<String> idMono = Mono.just(id);
		return this.areaController.getAreaById(idMono);
				
	}
	
	@DeleteMapping(value = AREA_ID)
	public Mono<Void> deleteArea(@PathVariable String id) {
		Mono<String> idMono = Mono.just(id);
		return this.areaController.deleteAreaById(idMono);
	}
	
	@DeleteMapping
	public Mono<Void> deleteAllAreas() {
		return this.areaController.deleteAllAreas();
	}
	
	@PutMapping(value = AREA_ID)
	public Mono<AreaDto> updateArea(@PathVariable String id, @Valid @RequestBody AreaDto areaDto){
		return this.areaController.updateArea(id, areaDto);
	}
}

