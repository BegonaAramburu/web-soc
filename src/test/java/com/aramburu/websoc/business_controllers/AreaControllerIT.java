package com.aramburu.websoc.business_controllers;



import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.aramburu.websoc.TestConfig;
import com.aramburu.websoc.documents.Area;
import com.aramburu.websoc.documents.Center;
import com.aramburu.websoc.dtos.AreaDto;
import com.aramburu.websoc.dtos.CenterDto;
import com.aramburu.websoc.exceptions.BadRequestException;
import com.aramburu.websoc.exceptions.NotFoundException;
import com.aramburu.websoc.repositories.AreaReactRepository;
import com.aramburu.websoc.repositories.CenterReactRepository;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@TestConfig
public class AreaControllerIT {
	
	@Autowired
	private AreaController areaController;
	
	@Autowired
	private AreaReactRepository areaReactRepository;
	
	
	
	@BeforeEach
	void fillAreas() {
		
		AreaDto areaDto1 = new AreaDto("1111111", 1, "Nombre del area 1", "description area 1", true);
		AreaDto areaDto2 = new AreaDto("222222", 2, "Nombre del area 2", "description area 2", true);
		AreaDto areaDto9 = new AreaDto("299992", 2, "Nombre del area 9", "description area 9", true);
		StepVerifier
				.create(this.areaController.createArea(areaDto1))
				.expectNext()
				.expectComplete()
				.verify();
		StepVerifier
				.create(this.areaController.createArea(areaDto2))
				.expectNext()
				.expectComplete()
				.verify();
		StepVerifier
				.create(this.areaController.createArea(areaDto9))
				.expectNext()
				.expectComplete()
				.verify();
	}
	
	@Test
	void testCreateArea() {
		AreaDto areaDto = new AreaDto(null, 4, "Nombre del area 4", "description area 4", true);
		StepVerifier
			.create(this.areaController.createArea(areaDto))
			.expectNext()
			.expectComplete()
			.verify();
		
	}
	
	@Test
	void testCreateAreaDto() {
		AreaDto areaDto = new AreaDto(null, 3, "Nombre del area 3", "description area 3", true);
		StepVerifier
			.create(this.areaController.createAreaDto(areaDto))
			.expectNextCount(1)
			.expectComplete()
			.verify();
	}
	
	@Test
	void testCreateAreaDtoWithId() {
		AreaDto areaDto = new AreaDto(null, 5, "Nombre del area 5", "description area 5", true);
		areaDto.setId("jjjjjjj");
		StepVerifier
			.create(this.areaController.createAreaDto(areaDto))
			.expectError(BadRequestException.class)
			.verify();
	}
	
	@Test
	void testNotExistByCodeAssured() {
		AreaDto areaDto = new AreaDto(null, 5, "Nombre del area 5", "description area 5", true);
		StepVerifier
			.create(this.areaController.notExistByCodeAssured(areaDto))
			.expectNext()
			.expectComplete()
			.verify();
	}
	
	@Test
	void testNotExistByCodeAssuredWithExistingCode() {
		AreaDto areaDto = new AreaDto(null, 1, "Nombre del area 5", "description area 5", true);
		StepVerifier
			.create(this.areaController.notExistByCodeAssured(areaDto))
			.expectError(BadRequestException.class)
			.verify();
	}
	
	
	@Test
	void testGetAllAreasDto() {
		
		StepVerifier
				.create(this.areaController.getAllAreasDto())
				.expectNextCount(2)
                .thenCancel()
                .verify();
	}
	
	@Test    
	void testGetAllAreasDtoEmptyList() {  
		this.testDeleteAllAreas();
		StepVerifier
				.create(this.areaController.getAllAreasDto())
				.expectError(BadRequestException.class)
				.verify();
	}
	
	@Test
	void testGetAreaById() {
		Mono<String> id = this.areaReactRepository.findByCode(1)
				.map(Area::getId);
		
		StepVerifier
				.create(this.areaController.getAreaById(id))
				.expectNextCount(1)
				.expectComplete()
				.verify();
		
	}
	
	@Test
	void testGetAreaByIdNotFound() {
		
		Mono<String> idMono = this.areaController.getAreaById("0000")
				.map(Area::getId);
		StepVerifier
				.create(this.areaController.deleteAreaById(idMono))
				.expectError(NotFoundException.class)
				.verify();
	}
	
	@Test
	void testDeleteAreaById() {
		
		Mono<String> id = this.areaReactRepository.findByCode(1).map(Area::getId);
		
		StepVerifier
				.create(this.areaController.deleteAreaById(id))
				.expectComplete()
				.verify();
	}
	
	@Test
	void testDeleteAreaByIdEmpty() {
		
		Mono<String> id = this.areaReactRepository.findByCode(00).map(Area::getId);
		
		StepVerifier
				.create(this.areaController.deleteAreaById(id))
				.expectError(NotFoundException.class)
				.verify();
	}
	
	@Test
	void testDeleteAllAreas() {
		
		StepVerifier
				.create(this.areaController.deleteAllAreas())
				.expectComplete()
				.verify();
		
	}
	
	
	
	@AfterEach
	void deleteAreas() {
		this.testDeleteAllAreas();
	}
	
	

}
