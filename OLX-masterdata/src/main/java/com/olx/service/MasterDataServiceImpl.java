package com.olx.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olx.dto.Category;
import com.olx.dto.Status;
import com.olx.entity.CategoryEntity;
import com.olx.entity.StatusEntity;
import com.olx.repo.CategoryRepository;
import com.olx.repo.StatusRepository;

@Service
public class MasterDataServiceImpl implements MasterDataService {

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	StatusRepository statusRepository;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<Category> getAllCategories() {
		List<CategoryEntity> categoryEntityList = categoryRepository.findAll();
		return getCategoryDtoList(categoryEntityList);
	}

	private List<Category> getCategoryDtoList(List<CategoryEntity> stockEntityList) {
		List<Category> categoryDtoList = new ArrayList<Category>();
		for (CategoryEntity categoryEntity : stockEntityList) {
			Category stockDto = this.modelMapper.map(categoryEntity, Category.class);
			categoryDtoList.add(stockDto);
		}
		return categoryDtoList;
	}

	@Override
	public List<Status> getPossibleStatus() {
		List<StatusEntity> statusEntityList = statusRepository.findAll();
		return getStatusDtoList(statusEntityList);
	}

	private List<Status> getStatusDtoList(List<StatusEntity> statusEntityList) {
		List<Status> statusDtoList = new ArrayList<Status>();
		for (StatusEntity StatusEntity : statusEntityList) {
			Status statusDto = this.modelMapper.map(StatusEntity, Status.class);
			statusDtoList.add(statusDto);
		}
		return statusDtoList;
	}

}


























