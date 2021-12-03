package com.olx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olx.dto.Category;
import com.olx.dto.Status;
import com.olx.service.MasterDataService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("olx/masterdata")
public class MasterdataController {

	@Autowired
	MasterDataService masterDataService;

	// API number:5 completed
	@ApiOperation(value = "returns all categories")
	@GetMapping(value = "/advertise/category", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public List<Category> getAllCategories() {
		return masterDataService.getAllCategories();
	}

	// API number:6  completed
	@ApiOperation(value = "returns all status")
	@GetMapping(value = "/advertise/status", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public List<Status> getAllStatus() {
		return masterDataService.getPossibleStatus();
	}

}
