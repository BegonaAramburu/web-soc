package com.aramburu.websoc.business_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aramburu.websoc.documents.Center;
import com.aramburu.websoc.dtos.CenterDto;
import com.aramburu.websoc.exceptions.BadRequestException;
import com.aramburu.websoc.repositories.CenterReactRepository;

import reactor.core.publisher.Mono;

@Service
public class CenterController {
	
	private CenterReactRepository centerReactRepository;
	
	@Autowired
	public CenterController(CenterReactRepository centerReactRepository) {
		this.centerReactRepository = centerReactRepository;
	}
	
	public Mono<CenterDto> createCenterDto(CenterDto centerDto){
		
		if(centerDto.getId() == null) {
			Center center = new Center();
			String idCenter = center.getId();
			center = Center.builder(idCenter).name(centerDto.getName()).acces(centerDto.getAcces()).address(centerDto.getAcces()).description(centerDto.getDescription()).email(centerDto.getEmail()).img(centerDto.getImg()).lat(centerDto.getLat()).lng(centerDto.getLng()).phone(centerDto.getPhone()).schedule(centerDto.getSchedule()).build();
			return this.centerReactRepository.save(center).map(CenterDto::new);
		}
		else {
			return Mono.error(new BadRequestException("This id already exist"));
		}
		
		
		
	}

}
