package com.olx.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Status model")
public class Status {
	
	@ApiModelProperty("Status Id")
	private int statusId;
	@ApiModelProperty("Status(Open/Closed)")
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

	public Status(int statusId, String status) {
		super();
		this.statusId = statusId;
		this.status = status;
	}

	public Status() {
	
	}
}
