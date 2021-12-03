package com.olx.service;

import java.util.Collection;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.olx.dto.Advertisement;

public interface AdvertiseService {
	public Advertisement getSpecifcAd(@PathVariable("advertiseId") int id, @RequestHeader("auth-token") String token);

	public Collection<Advertisement> getAllAds();

	public Advertisement postNewAdvertise(@RequestBody Advertisement advertisement,
			@RequestHeader("auth-token") String token);

	public boolean deleteSpecifcAd(@PathVariable("advertiseId") int id, @RequestHeader("Authorization") String token);

	public Advertisement updateAdvertise(@RequestBody Advertisement advertisement,
			@RequestHeader("Authorization") String header, @PathVariable("id") int id);
	public Collection<Advertisement> getSearchedList(@RequestParam("searchText") String searchText) ;
}
