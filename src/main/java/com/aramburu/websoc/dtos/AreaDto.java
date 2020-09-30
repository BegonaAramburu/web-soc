package com.aramburu.websoc.dtos;

import com.aramburu.websoc.documents.Area;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;


@Validated
public class AreaDto {
	
	
	private String id;
	
	@NotNull(message = "Code can't be null")
	private Integer code;
	
	@NotNull(message = "Name can't be null")
	private String name;
	
	private Boolean active;
	
	@JsonInclude(Include.NON_NULL)
	private String description;
	
	public AreaDto() {}
	
	public AreaDto(String id, @NotNull(message = "Code can't be null") Integer code,
			@NotNull(message = "Name can't be null") String name, String description, Boolean active) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.active = active;
		this.description = description;
	}

	public AreaDto(Area area) {
		this.id = area.getId();
		this.code = area.getCode();
		this.description = area.getDescription();
		this.name = area.getName();
		this.active = area.isActive();
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "AreaDto [id=" + id + ", code=" + code + ", name=" + name + ", active=" + active + ", description="
				+ description + "]";
	}
	


}
