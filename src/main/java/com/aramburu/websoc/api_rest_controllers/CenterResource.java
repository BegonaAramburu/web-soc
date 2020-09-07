package com.aramburu.websoc.api_rest_controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aramburu.websoc.business_controllers.CenterController;
import com.aramburu.websoc.dtos.CenterDto;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping(CenterResource.CENTERS)
public class CenterResource {
	
	public static final String CENTERS = "/public/training/centers";
	
	@Autowired
	public CenterController centerController;
	
	@PostMapping
	public Mono<CenterDto> createCenter(@Valid @RequestBody CenterDto centerDto) {
		return this.centerController.createCenterDto(centerDto);	
	}

}

