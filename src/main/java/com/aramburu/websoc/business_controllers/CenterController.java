package com.aramburu.websoc.business_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aramburu.websoc.documents.Center;
import com.aramburu.websoc.dtos.CenterDto;
import com.aramburu.websoc.exceptions.BadRequestException;
import com.aramburu.websoc.exceptions.NotFoundException;
import com.aramburu.websoc.repositories.CenterReactRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CenterController {
	
	private CenterReactRepository centerReactRepository;
	
	@Autowired
	public CenterController(CenterReactRepository centerReactRepository) {
		this.centerReactRepository = centerReactRepository;
	}
	
	
	public Flux<CenterDto> getAllCenterDto() {
		return this.centerReactRepository.findAll()
				.switchIfEmpty(Flux.error(new BadRequestException("There are not any center")))
				.map(CenterDto::new );
	}
	
	
	public Mono<CenterDto> getCenterById(Mono<String> id) {
		return centerReactRepository.findById(id)
				.switchIfEmpty(Mono.error(new NotFoundException("The id:" + id + " not exist")))
				.map(CenterDto::new);	
	}
	
	
	public Mono<Center> getCenterById(String id) {
		return centerReactRepository.findById(id);
				
	}
	
	
	public Mono<Void> notExistByCodeAssured(CenterDto centerDto){
		return this.centerReactRepository.findByCode(centerDto.getCode())
				.handle((center, sink) ->sink.error(new BadRequestException("This code:" + centerDto.getCode() + " already exist")));
	}
	
	
	public Mono<Void> createCenter(CenterDto centerDto) {
		Center center = Center.builder(centerDto.getCode()).name(centerDto.getName()).acces(centerDto.getAcces()).address(centerDto.getAcces()).description(centerDto.getDescription()).email(centerDto.getEmail()).img(centerDto.getImg()).lat(centerDto.getLat()).lng(centerDto.getLng()).phone(centerDto.getPhone()).schedule(centerDto.getSchedule()).build();		return this.centerReactRepository.save(center)
				.then();
	}
	
	public Mono<CenterDto> createCenterDto(CenterDto centerDto) {
		if(centerDto.getId() == null) {
			Center center = Center.builder(centerDto.getCode()).name(centerDto.getName()).acces(centerDto.getAcces()).address(centerDto.getAcces()).description(centerDto.getDescription()).email(centerDto.getEmail()).img(centerDto.getImg()).lat(centerDto.getLat()).lng(centerDto.getLng()).phone(centerDto.getPhone()).schedule(centerDto.getSchedule()).build();			Mono<Void> notExistCode = this.notExistByCodeAssured(centerDto);
			return Mono
					.when(notExistCode)
					.then(this.centerReactRepository.save(center))
					.map(CenterDto::new);
		}else {
			return Mono.error(new BadRequestException("You can't create the id"));
		}
				
	}
	
	
	public Mono<Void> deleteCenterById(Mono<String> id){
		Mono<Center> center = this.centerReactRepository.findById(id).switchIfEmpty(Mono.error(new NotFoundException("The id:" + id + " not exist")));
		return Mono
				.when(center)
				.then(this.centerReactRepository.deleteById(id));
	}
	
	
	public Mono<Void> deleteCenterByCode(Integer code){
		Mono<String> id = this.centerReactRepository.findByCode(code)
				.switchIfEmpty(Mono.error(new NotFoundException("The code:" + code + " don't exist")))
				.map(Center::getId);
		return this.deleteCenterById(id).then();
		
	}
	
	
	public Mono<Void> deleteAllCenters(){
		return this.centerReactRepository.deleteAll();
	}

}



