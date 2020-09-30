package com.aramburu.websoc.api_rest_controllers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import com.aramburu.websoc.business_controllers.AreaController;
import com.aramburu.websoc.business_controllers.CenterController;
import com.aramburu.websoc.dtos.AreaDto;
import com.aramburu.websoc.dtos.CenterDto;

import reactor.test.StepVerifier;

@ApiTestConfig
public class AreaResourceIT {
	
	@Autowired
	private WebTestClient webTestClient;
	
	@Autowired
	private AreaResource areaResource;
	
	@Autowired
	private AreaController areaController;
	
	
	@BeforeEach
	void fillCenters() {
		
		AreaDto areaDto1 = new AreaDto("1111111", 1, "Nombre del area 1", "description area 1", true);
		StepVerifier
				.create(this.areaController.createArea(areaDto1))
				.expectNext()
				.expectComplete()
				.verify();
	
	}
	
	
	@SuppressWarnings({ "deprecation", "static-access" })
	@Test
	void testCreateArea() {
		this.webTestClient
			.post().uri(areaResource.AREAS)
			.body(BodyInserters.fromObject(new AreaDto(null, 2, "Nombre del area 2", "description area 2", true)))
			.exchange()
			.expectStatus().isOk().expectBody(AreaDto.class);
			
	}
	
	@Test
	void testCreateAreaWithError() {
		this.webTestClient
			.post().uri(areaResource.AREAS)
			.body(BodyInserters.fromObject(new AreaDto("2222222222", 1, "Nombre del area 2", "description area 2", true)))
			.exchange()
			.expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
	}
	
	@Test
	void testGetAll() {
		this.webTestClient
			.get().uri(areaResource.AREAS)
			.exchange()
			.expectBodyList(AreaDto.class);
	}
	
	@Test
	void testDeleteAll() {
		this.webTestClient
			.delete().uri(areaResource.AREAS)
			.exchange()
			.expectStatus().isOk();
	}
	
	@AfterEach
	void deleteAreas() {
		this.testDeleteAll();
	}
	
	

}
