package com.olx.controller;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.olx.dto.Advertisement;
import com.olx.service.AdvertiseService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("olx/advertise")
public class AdvertisementController {

	@Autowired
	AdvertiseService advertiseService;

	// API number: 7 completed
	@ApiOperation("returns new Advertisement")
	@PostMapping(value = "/advertise", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public Advertisement postNewAdvertise(@RequestBody Advertisement advertisement,
			@RequestHeader("Authorization") String token) {
		return advertiseService.postNewAdvertise(advertisement, token);

	}

	// API number:8 completed
	@ApiOperation("returns updated Advertisement")
	@PutMapping(value = "/advertise/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public Advertisement updateAdvertise(@RequestBody Advertisement advertisement,
			@RequestHeader("Authorization") String header, @PathVariable("id") int id) {
		return advertiseService.updateAdvertise(advertisement, header, id);

	}

	// API number: 9 completed
	@ApiOperation("returns all Advertisements")
	@GetMapping(value = "/user/advertise", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public Collection<Advertisement> getAllAds() {

		return advertiseService.getAllAds();
	}

	// API number: 10 completed
	@ApiOperation("returns specified Advertisement")
	@GetMapping(value = "/user/advertise/{advertiseId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public Advertisement getUserSpecifcAd(@PathVariable("advertiseId") int id,
			@RequestHeader("Authorization") String header) {

		return advertiseService.getSpecifcAd(id, header);
	}

	// API number: 11 completed
	@ApiOperation("returns boolen after successful deletion")
	@DeleteMapping(value = "/user/advertise/{advertiseId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public boolean deleteSpecifcAd(@PathVariable("advertiseId") int id, @RequestHeader("Authorization") String header) {
		return advertiseService.deleteSpecifcAd(id, header);
	}

	// API number: 13 completed based on single field,Need to implement for all
	// field at one search
	@ApiOperation("returns all Advertisement based on search text")
	@GetMapping(value = "/advertise/", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public Collection<Advertisement> getSearchedList(@RequestParam("searchText") String searchText) {
		return advertiseService.getSearchedList(searchText);
	}

	// API number: 14 completed
	@ApiOperation("returns specified Advertisement")
	@GetMapping(value = "/advertise/{advertiseId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public Advertisement getSpecifcAd(@PathVariable("advertiseId") int id,
			@RequestHeader("Authorization") String header) {

		return advertiseService.getSpecifcAd(id, header);
	}

}
