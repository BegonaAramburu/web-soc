package com.aramburu.websoc.business_controllers;



import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.aramburu.websoc.TestConfig;
import com.aramburu.websoc.documents.Center;
import com.aramburu.websoc.dtos.CenterDto;
import com.aramburu.websoc.exceptions.BadRequestException;
import com.aramburu.websoc.exceptions.NotFoundException;
import com.aramburu.websoc.repositories.CenterReactRepository;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@TestConfig
public class CenterControllerIT {
	
	@Autowired
	private CenterController centerController;
	
	@Autowired
	private CenterReactRepository centerReactRepository;
	
	
	
	@BeforeEach
	void fillCenters() {
		
		CenterDto centerDto1 = new CenterDto(1, "Nombre del centro 1", "111111111");
		CenterDto centerDto2 = new CenterDto(2, "Nombre del centro 2", "222222222");
		CenterDto centerDto3 = new CenterDto(3, "Nombre del centro 3", "333333333");
		StepVerifier
				.create(this.centerController.createCenter(centerDto1))
				.expectNext()
				.expectComplete()
				.verify();
		StepVerifier
				.create(this.centerController.createCenter(centerDto2))
				.expectNext()
				.expectComplete()
				.verify();
		StepVerifier
				.create(this.centerController.createCenter(centerDto3))
				.expectNext()
				.expectComplete()
				.verify();
	}
	
	@Test
	void testCreateCenter() {
		CenterDto centerDto = new CenterDto(4, "Nombre del centro 4","444444444");
		StepVerifier
			.create(this.centerController.createCenter(centerDto))
			.expectNext()
			.expectComplete()
			.verify();
		
	}
	
	@Test
	void testCreateCenterDto() {
		CenterDto centerDto = new CenterDto(4, "Nombre del centro 4","444444444");
		StepVerifier
			.create(this.centerController.createCenterDto(centerDto))
			.expectNextCount(1)
			.expectComplete()
			.verify();
	}
	
	@Test
	void testCreateCenterDtoWithId() {
		CenterDto centerDto = new CenterDto(4, "Nombre del centro 4","444444444");
		centerDto.setId("jjjjjjj");
		StepVerifier
			.create(this.centerController.createCenterDto(centerDto))
			.expectError(BadRequestException.class)
			.verify();
	}
	
	@Test
	void testNotExistByCodeAssured() {
		CenterDto centerDto = new CenterDto(5, "Nombre del centro 5","55555555");
		StepVerifier
			.create(this.centerController.notExistByCodeAssured(centerDto))
			.expectNext()
			.expectComplete()
			.verify();
	}
	
	@Test
	void testNotExistByCodeAssuredWithExistingCode() {
		CenterDto centerDto = new CenterDto(3, "Nombre del centro 3", "333333333");
		StepVerifier
			.create(this.centerController.notExistByCodeAssured(centerDto))
			.expectError(BadRequestException.class)
			.verify();
	}
	
	
	@Test
	void testGetAllCenterDto() {
		
		StepVerifier
				.create(this.centerController.getAllCenterDto())
				.expectNextCount(2)
                .thenCancel()
                .verify();
	}
	
	@Test    
	void testGetAllCenterDtoEmptyList() {  
		this.testDeleteAllCenters();
		StepVerifier
				.create(this.centerController.getAllCenterDto())
				.expectError(BadRequestException.class)
				.verify();
	}
	
	@Test
	void testGetCenterById() {
		Mono<String> id = this.centerReactRepository.findByCode(1)
				.map(Center::getId);
		
		StepVerifier
				.create(this.centerController.getCenterById(id))
				.expectNextCount(1)
				.expectComplete()
				.verify();
		
	}
	
	@Test
	void testGetCenterByIdNotFound() {
		
		Mono<String> idMono = this.centerController.getCenterById("0000")
				.map(Center::getId);
		StepVerifier
				.create(this.centerController.getCenterById(idMono))
				.expectError(NotFoundException.class)
				.verify();
	}
	
	@Test
	void testDeleteCenterById() {
		
		Mono<String> id = this.centerReactRepository.findByCode(1).map(Center::getId);
		
		StepVerifier
				.create(this.centerController.deleteCenterById(id))
				.expectComplete()
				.verify();
	}
	
	@Test
	void testDeleteCenterByIdEmpty() {
		
		Mono<String> id = this.centerReactRepository.findByCode(00).map(Center::getId);
		
		StepVerifier
				.create(this.centerController.deleteCenterById(id))
				.expectError(NotFoundException.class)
				.verify();
	}
	
	@Test
	void testDeleteAllCenters() {
		
		StepVerifier
				.create(this.centerController.deleteAllCenters())
				.expectComplete()
				.verify();
		
	}
	
	
//	@Test //No lo puedo probar xq el id es diferente cada vez
//	void testUpdateCenter() {
//		
//		
//		CenterDto centerDto10 = new CenterDto("8787878787", 10, "Name", "000000000");
//		
//		StepVerifier
//		.create(this.centerController.createCenter(centerDto10))
//		.expectNext()
//		.expectComplete()
//		.verify();
//		
//		
//
//		CenterDto centerDto = new CenterDto("8787878787", 10, "This is a new name", "999999999");
//		StepVerifier
//		
//				.create(this.centerController.updateCenter(centerDto))
//				.expectNextCount(1)
//				.expectComplete()
//				.verify();
//	}
//	  
	
	@AfterEach
	void deleteCenters() {
		this.testDeleteAllCenters();
	}
	
	

}
