package com.aramburu.websoc.dtos;

import com.aramburu.websoc.documents.Center;
import com.aramburu.websoc.dtos.validations.StringNotNullOrEmpty;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.validation.annotation.Validated;


@Validated
public class CenterDto {
	
	private String id;
	
	//@StringNotNullOrEmpty
	private String name;
	
	@Pattern(regexp = com.aramburu.websoc.dtos.validations.Pattern.EMAIL_FORMAT)
	@NotNull
	private String email;
	
	@Pattern(regexp = com.aramburu.websoc.dtos.validations.Pattern.NINE_DIGITS)
	@NotNull
	private String phone;
	
	@NotNull
	private String address;
	
	@JsonInclude(Include.NON_NULL)
	private String description;
	
	@JsonInclude(Include.NON_NULL)
	private String equipment;
	
	@JsonInclude(Include.NON_NULL)
	private String acces;
	
	@JsonInclude(Include.NON_NULL)
	private String schedule;
	
	@NotNull
	private Double lat;
	
	@NotNull
	private Double lng;
	
	@JsonInclude(Include.NON_NULL)
	private String img;
	
	public CenterDto() {}
	
	public CenterDto(String id, String name, String email, String phone, String address, String description, String equipment, String acces, String schedule, Double lat, Double lng, String img) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.description = description;
		this.equipment = equipment;
		this.acces = acces;
		this.schedule = schedule;
		this.lat = lat;
		this.lng = lng;
		this.img = img;
	}
	
	public CenterDto(Center center) {
		this.id = center.getId();
		this.acces = center.getAcces();
		this.address = center.getAddress();
		this.description = center.getDescription();
		this.email = center.getEmail();
		this.equipment = center.getEquipment();
		this.img = center.getImg();
		this.lat = center.getLat();
		this.lng = center.getLng();
		this.name = center.getName();
		this.phone = center.getPhone();
		this.schedule = center.getSchedule();
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEquipment() {
		return equipment;
	}

	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

	public String getAcces() {
		return acces;
	}

	public void setAcces(String acces) {
		this.acces = acces;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
	

	public String getId() {
		return id;
	}


	@Override
	public String toString() {
		return "CenterDto [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", address=" + address
				+ ", description=" + description + ", equipment=" + equipment + ", acces=" + acces + ", schedule="
				+ schedule + ", lat=" + lat + ", lng=" + lng + ", img=" + img + "]";
	}
	
	

}