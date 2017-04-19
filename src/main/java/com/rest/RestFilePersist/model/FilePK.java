package com.rest.RestFilePersist.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


public class FilePK implements Serializable{
	
	
	@Column
	private String uuid;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	
	

	
}
