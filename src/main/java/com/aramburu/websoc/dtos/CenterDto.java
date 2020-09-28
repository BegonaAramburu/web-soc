package com.aramburu.websoc.dtos;

import com.aramburu.websoc.documents.Center;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import reactor.core.publisher.Mono;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.validation.annotation.Validated;


@Validated
public class CenterDto {
	
	
	private String id;
	
	@NotNull(message = "Code can't be null")
	private Integer code;
	
	@NotNull(message = "Name can't be null")
	private String name;
	
	private Boolean active;
	
	@Pattern(regexp = com.aramburu.websoc.dtos.validations.Pattern.EMAIL_FORMAT, message = "The mail format it's not correct")
	private String email;
	
	@Pattern(regexp = com.aramburu.websoc.dtos.validations.Pattern.NINE_DIGITS, message = "The phone must have 9 numbers")
	private String phone;
	
	private String address;
	
	@JsonInclude(Include.NON_NULL)
	private String description;
	
	@JsonInclude(Include.NON_NULL)
	private String equipment;
	
	@JsonInclude(Include.NON_NULL)
	private String acces;
	
	@JsonInclude(Include.NON_NULL)
	private String schedule;
	
	private Double lat;
	
	private Double lng;
	
	@JsonInclude(Include.NON_NULL)
	private String img;
	
	public CenterDto() {}
	
	
	
	public CenterDto(String id, Integer code, String name, Boolean active,
			@Pattern(regexp = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@[a-z0-9-]+(.[a-z0-9-]+)*(.[a-z]{2,4})$") @NotNull String email,
			@Pattern(regexp = "\\d{9}") @NotNull String phone, @NotNull String address, String description,
			String equipment, String acces, String schedule, @NotNull Double lat, @NotNull Double lng, String img) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.active = active;
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



	public CenterDto(Integer code, String name, String phone) {
		this.code = code;
		this.name = name;
		this.phone = phone;
	}
	
	public CenterDto(Center center) {
		this.id = center.getId();
		this.code = center.getCode();
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
		this.active = center.getActive();
		
	}
	

	public CenterDto(Mono<String> id2, int i, String string, String string2) {
		// TODO Auto-generated constructor stub
	}



	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
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


	public void setId(String id) {
		this.id = id;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "CenterDto [id=" + id + ", code=" + code + ", name=" + name + ", email=" + email + ", phone=" + phone + ", address=" + address
				+ ", description=" + description + ", equipment=" + equipment + ", acces=" + acces + ", schedule="
				+ schedule + ", lat=" + lat + ", lng=" + lng + ", img=" + img + "]";
	}
	
	

}
