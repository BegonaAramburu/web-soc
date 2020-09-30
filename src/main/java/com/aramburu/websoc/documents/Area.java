package com.aramburu.websoc.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Area {
	
	@Id
	private String id;
	
	private Integer code;
	private String name;
	private String description;
	private boolean active;
	
	
	public Area() {
		
	}
	
	public Area(Integer code, String name, String description, boolean active) {
		this.code = code;
		this.name = name;
		this.description = description;
		this.active = active;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Area [id=" + id + ", code=" + code + ", name=" + name + ", description=" + description + ", active="
				+ active + "]";
	}
	
	
	
}
