package com.aramburu.websoc.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Center {
	
	@Id
	private String id;
	
	@Indexed//(unique=true)
	private Integer code;
	
	private String name;
	private String email;
	private String phone;
	private String address;
	private String description;
	private String equipment;
	private String acces;
	private String schedule;
	private Double lat;
	private Double lng;
	private String img;
	private boolean active;
	
	
	public Center() {
		
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



	public boolean isActive() {
		return active;
	}



	public void setActive(boolean active) {
		this.active = active;
	}

	
	@Override
	public String toString() {
		return "Center [id=" + id + ", code=" + code + ", name=" + name + ", email=" + email + ", phone=" + phone + ", address=" + address
				+ ", description=" + description + ", equipment=" + equipment + ", acces=" + acces + ", schedule="
				+ schedule + ", lat=" + lat + ", lng=" + lng + ", img=" + img + ", active=" + active + "]";
	}


	public static class Builder{
		private Center center;
		
		private Builder(Integer code) {
			this.center = new Center();
			this.center.code = code;
			this.center.active = true;
		}
		
		public Builder name(String name) {
			this.center.name = name;
			return this;
		}
		
		public Builder id(String id) {
			this.center.id = id;
			return this;
		}
		
		public Builder email(String email) {
			this.center.email = email;
			return this;
		}
		
		public Builder phone(String phone) {
			this.center.phone = phone;
			return this;
		}
		
		public Builder address(String address) {
			this.center.address = address;
			return this;
		}
		
		public Builder description(String description) {
			this.center.description = description;
			return this;
		}
		
		public Builder equipment(String equipment) {
			this.center.equipment = equipment;
			return this;
		}
		
		public Builder acces(String acces) {
			this.center.acces = acces;
			return this;
		}
		
		public Builder schedule(String schedule) {
			this.center.schedule = schedule;
			return this;
		}
		
		public Builder lat(Double lat) {
			this.center.lat = lat;
			return this;
		}
		
		public Builder lng(Double lng) {
			this.center.lng = lng;
			return this;
		}
		
		public Builder img(String img) {
			this.center.img = img;
			return this;
		}
		
		public Builder active(boolean active) {
			this.center.active = active;
			return this;
		}
		
		public Center build() {
			return this.center;
		}
	}
	
	public static Builder builder(Integer code) {
		return new Builder(code);
	}
	
}
