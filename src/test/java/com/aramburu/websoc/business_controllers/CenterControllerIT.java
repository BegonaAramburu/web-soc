package com.aramburu.websoc.business_controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.aramburu.websoc.TestConfig;
import com.aramburu.websoc.documents.Center;
import com.aramburu.websoc.dtos.CenterDto;

import reactor.test.StepVerifier;

@TestConfig
public class CenterControllerIT {
	
	@Autowired
	private CenterController centerController;
	
	@Test
	void testCreateCenterDto() {
		
		CenterDto centerDto = new CenterDto(null, "Nombre del centro", "este es el email", "666666666", "esta es la dirección", "esta es la descripción", "equipamientooo", "este es el acceso", "horario", 0.0, 0.0, "imagen");
		StepVerifier
				.create(this.centerController.createCenterDto(centerDto))
				.expectNextCount(1)
				.expectComplete()
				.verify();
		
	}
	
//	@Test
//	void testCreateCenterDtoWithoutPhone() {
//		
//		CenterDto centerDto = new CenterDto(null, null, "este es el email", "666666666" , "esta es la dirección", "esta es la descripción", "equipamientooo", "este es el acceso", "horario", 0.0, 0.0, "imagen");
//		StepVerifier
//				.create(this.centerController.createCenterDto(centerDto))
//				.expectErrorMessage("Expected not null or empty")
//				.verify();
//		
//	}
	

}
