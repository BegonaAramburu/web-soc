package com.aramburu.websoc.api_rest_controllers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import com.aramburu.websoc.business_controllers.CenterController;
import com.aramburu.websoc.dtos.CenterDto;

import reactor.test.StepVerifier;

@ApiTestConfig
public class CenterResourceIT {
	
	@Autowired
	private WebTestClient webTestClient;
	
	@Autowired
	private CenterResource centerResource;
	
	@Autowired
	private CenterController centerController;
	
	
	@BeforeEach
	void fillCenters() {
		
		CenterDto centerDto1 = new CenterDto(1, "Nombre del centro 1", "111111111");
		StepVerifier
				.create(this.centerController.createCenter(centerDto1))
				.expectNext()
				.expectComplete()
				.verify();
	
	}
	
	
	@SuppressWarnings({ "deprecation", "static-access" })
	@Test
	void testCreateCenter() {
		this.webTestClient
			.post().uri(centerResource.CENTERS)
			.body(BodyInserters.fromObject(new CenterDto(100,"Nombre100", "100100100")))
			.exchange()
			.expectStatus().isOk().expectBody(CenterDto.class);
			
	}
	
	@Test
	void testCreateCenterWithError() {
		this.webTestClient
			.post().uri(centerResource.CENTERS)
			.body(BodyInserters.fromObject(new CenterDto(1, "Nombre100", "100100100")))
			.exchange()
			.expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
	}
	
	@Test
	void testGetAll() {
		this.webTestClient
			.get().uri(centerResource.CENTERS)
			.exchange()
			.expectBodyList(CenterDto.class);
	}
	
	@Test
	void testDeleteAll() {
		this.webTestClient
			.delete().uri(centerResource.CENTERS)
			.exchange()
			.expectStatus().isOk();
	}
	
	@AfterEach
	void deleteCenters() {
		this.centerController.deleteAllCenters();
	}
	
	

}
