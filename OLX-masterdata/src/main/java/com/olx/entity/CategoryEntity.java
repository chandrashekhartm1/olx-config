package com.olx.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "Category")
@ApiModel("Category model")
public class CategoryEntity {

	@ApiModelProperty("Category Id")
	@Id
	@GeneratedValue
	private int categoryId;
	@ApiModelProperty("Category full name")
	private String category;
	public CategoryEntity(int categoryId, String category) {
		super();
		this.categoryId = categoryId;
		this.category = category;
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
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", category=" + category + "]";
	}
	
	public CategoryEntity() {
		
	}
}
