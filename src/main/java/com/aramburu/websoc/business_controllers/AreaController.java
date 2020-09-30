package com.aramburu.websoc.business_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aramburu.websoc.documents.Area;
import com.aramburu.websoc.dtos.AreaDto;
import com.aramburu.websoc.exceptions.BadRequestException;
import com.aramburu.websoc.exceptions.NotFoundException;
import com.aramburu.websoc.repositories.AreaReactRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AreaController {
	
	private AreaReactRepository areaReactRepository;
	
	@Autowired
	public AreaController(AreaReactRepository areaReactRepository) {
		this.areaReactRepository = areaReactRepository;
	}
	
	
	public Flux<AreaDto> getAllAreasDto() {
		return this.areaReactRepository.findAll()
				.switchIfEmpty(Flux.error(new BadRequestException("There are not any area")))
				.map(AreaDto::new );
	}
	
	
	public Mono<AreaDto> getAreaById(Mono<String> id) {
		return areaReactRepository.findById(id)
				.switchIfEmpty(Mono.error(new NotFoundException("The id:" + id + " not exist")))
				.map(AreaDto::new);	
	}
	
	
	public Mono<Area> getAreaById(String id) {
		return areaReactRepository.findById(id);
				
	}
	
	
	public Mono<Void> notExistByCodeAssured(AreaDto areaDto){
		return this.areaReactRepository.findByCode(areaDto.getCode())
				.handle((center, sink) ->sink.error(new BadRequestException("This code:" + areaDto.getCode() + " already exist")));
	}
	
	
	public Mono<Void> createArea(AreaDto areaDto) {
		Area area = new Area(areaDto.getCode(), areaDto.getName(), areaDto.getDescription(), areaDto.getActive());		
		return this.areaReactRepository.save(area)
				.then();
	}
	
	
	public Mono<AreaDto> createAreaDto(AreaDto areaDto) {
		if(areaDto.getId() == null) {
			Area area = new Area(areaDto.getCode(), areaDto.getName(), areaDto.getDescription(), areaDto.getActive());		
			Mono<Void> notExistCode = this.notExistByCodeAssured(areaDto);
			return Mono
					.when(notExistCode)
					.then(this.areaReactRepository.save(area))
					.map(AreaDto::new);
		}else {
			return Mono.error(new BadRequestException("You can't create the id"));
		}
				
	}
	
	
	public Mono<Void> deleteAreaById(Mono<String> id){
		Mono<Area> area = this.areaReactRepository.findById(id).switchIfEmpty(Mono.error(new NotFoundException("The id:" + id + " not exist")));
		return Mono
				.when(area)
				.then(this.areaReactRepository.deleteById(id));
	}
	
	
	public Mono<Void> deleteAreaByCode(Integer code){
		Mono<String> id = this.areaReactRepository.findByCode(code)
				.switchIfEmpty(Mono.error(new NotFoundException("The code:" + code + " don't exist")))
				.map(Area::getId);
		return this.deleteAreaById(id).then();
		
	}
	
	
	public Mono<Void> deleteAllAreas(){
		return this.areaReactRepository.deleteAll();
	}
	
	
	public Mono<AreaDto> updateArea(String id, AreaDto areaDto){
		Mono<Area> a = this.getAreaById(id)
				.switchIfEmpty(Mono.error(new NotFoundException("Not found id:" + id)))
				.map(area ->{
					area.setActive(areaDto.getActive());
					area.setCode(areaDto.getCode());
					area.setDescription(areaDto.getDescription());
					area.setId(areaDto.getId());
					area.setName(areaDto.getName());
					return area;
				});
		
		return Mono
				.when(a)
				.then(this.areaReactRepository.saveAll(a)
						.next()
						.map(AreaDto::new));
				
	}
	
	

}



