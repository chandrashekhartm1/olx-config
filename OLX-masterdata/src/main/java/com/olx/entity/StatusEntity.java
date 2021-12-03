package com.olx.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Status")
public class StatusEntity {

	@Id
	@GeneratedValue
	private int statusId;
	private String status;
	
	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public StatusEntity(int statusId, String status) {
		super();
		this.statusId = statusId;
		this.status = status;
	}

	public StatusEntity() {
	
	}
}
