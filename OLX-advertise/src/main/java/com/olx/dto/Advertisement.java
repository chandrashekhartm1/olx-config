package com.olx.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Advertisement model")
public class Advertisement {
	@ApiModelProperty("Unique Id Auto generated")
	private int id;
	@ApiModelProperty("Title")
	private String title;
	@ApiModelProperty("Price")
	private double price;
	@ApiModelProperty("Category Id")
	private int categoryId;
	@ApiModelProperty("Category")
	private String category;
	@ApiModelProperty("Description")
	private String description;
	@ApiModelProperty("Username")
	private String username;
	@ApiModelProperty("Automatically create date")
	private String createdDate;
	@ApiModelProperty("Automatically modified date")
	private String modifiedDate;
	@ApiModelProperty("Status Id")
	private int statusId;
	@ApiModelProperty("Status like-Open/Closed")
	private String status;

	public Advertisement() {
	}

	public Advertisement(String title, double price, int categoryId, String category, String description,
			String username, String createdDate, String modifiedDate, int statusId, String status) {
		super();
		this.title = title;
		this.price = price;
		this.categoryId = categoryId;
		this.category = category;
		this.description = description;
		this.username = username;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.statusId = statusId;
		this.status = status;
	}

	public Advertisement(int id, String title, double price, int categoryId, String category, String description,
			String username, String createdDate, String modifiedDate, int statusId, String status) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.categoryId = categoryId;
		this.category = category;
		this.description = description;
		this.username = username;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.statusId = statusId;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

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

}
