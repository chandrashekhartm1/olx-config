package com.olx.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olx.dto.Advertisement;
import com.olx.entity.AdvertisementEntity;
import com.olx.exception.NoAdvertiseFoundException;
import com.olx.repo.AdvertiseRepository;

@Service
public class AdvertiseServiceImpl implements AdvertiseService {

	@Autowired
	MasterDataDelegate masterDataDelegate;

	@Autowired
	AdvertiseRepository advertiseRepository;

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	LoginDelegate loginDelegate;

	@Autowired
	EntityManager entityManager;

	@Override
	public Advertisement getSpecifcAd(int id, String token) {
		// if (!loginDelegate.validateToken(token)) {
		boolean isValidSession = loginDelegate.validateToken(token);
		if (isValidSession) {
			List<Map> categories = masterDataDelegate.getAllCategories();

			Optional<AdvertisementEntity> opAdvertiseEntity = advertiseRepository.findById(id);
			if (opAdvertiseEntity.isPresent()) { // Correct opAdvertiseEntity
				AdvertisementEntity stockEntity = opAdvertiseEntity.get();
				Advertisement advertisementDto = this.modelMapper.map(stockEntity, Advertisement.class);
				return advertisementDto;
			}
		}
		throw new NoAdvertiseFoundException("" + id);

	}

	@Override
	public Advertisement postNewAdvertise(Advertisement advertisement, String token) {
		boolean isValidSession = loginDelegate.validateToken(token);
		if (isValidSession) {
			List<Map> categories = masterDataDelegate.getAllCategories();
			advertisement.setStatus("OPEN");
			advertisement.setStatusId(1);
			advertisement.setCreatedDate(LocalDate.now().toString());
			advertisement.setModifiedDate(LocalDate.now().toString());
			advertisement.setUsername("Chandru");
			// advertisement.setCategory(categories.get(advertisement.getCategoryId()).get(advertisement.getCategoryId()).toString());
			advertisement.setCategory("Cars");

			AdvertisementEntity advertisementEntity = this.modelMapper.map(advertisement, AdvertisementEntity.class);
			advertisementEntity = this.advertiseRepository.save(advertisementEntity);
			Advertisement advertisemenDto = this.modelMapper.map(advertisementEntity, Advertisement.class);
			advertiseRepository.save(advertisementEntity);
			return advertisemenDto;
		}
		return null;
	}

	@Override
	public Collection<Advertisement> getAllAds() {
		List<AdvertisementEntity> advertisements = advertiseRepository.findAll();
		return getStockDtoList(advertisements);

	}

	private List<Advertisement> getStockDtoList(List<AdvertisementEntity> stockEntityList) {
		List<Advertisement> stockDtoList = new ArrayList<Advertisement>();
		for (AdvertisementEntity stockEntity : stockEntityList) {
			Advertisement stockDto = this.modelMapper.map(stockEntity, Advertisement.class);
			stockDtoList.add(stockDto);
		}
		return stockDtoList;
	}

	@Override
	public boolean deleteSpecifcAd(int id, String token) {
		boolean isValidSession = loginDelegate.validateToken(token);
		if (isValidSession) {
			Optional<AdvertisementEntity> opAdvertiseEntity = advertiseRepository.findById(id);
			if (opAdvertiseEntity.isPresent()) { // Correct opAdvertiseEntity
				advertiseRepository.delete(opAdvertiseEntity.get());
				return true;
			}
		}
		return false;
	}

	@Override
	public Advertisement updateAdvertise(Advertisement advertise, String token, int id) {
		boolean isValidSession = loginDelegate.validateToken(token);
		if (isValidSession) {
			Optional<AdvertisementEntity> opAdvertiseEntity = advertiseRepository.findById(id);
			if (opAdvertiseEntity.isPresent()) { // Correct opAdvertiseEntity

				AdvertisementEntity advertisementEntity = opAdvertiseEntity.get();
				Advertisement advertisement = this.modelMapper.map(advertisementEntity, Advertisement.class);
				if (advertise.getStatusId() == 2)
					advertisement.setStatus("CLOSED");
				else
					advertisement.setStatus("OPEN");
				advertisement.setStatusId(advertise.getStatusId());
				advertisement.setTitle(advertise.getTitle());
				advertisement.setPrice(advertise.getPrice());
				advertisement.setDescription(advertise.getDescription());
				advertisement.setModifiedDate(LocalDate.now().toString());

				advertisementEntity = this.advertiseRepository.save(advertisementEntity);
				advertiseRepository.save(advertisementEntity);
				return advertisement;
			}
			throw new NoAdvertiseFoundException("" + id);
		}
		throw new NoAdvertiseFoundException("" + id);
	}

	@Override
	public Collection<Advertisement> getSearchedList(String searchText) {
		List<AdvertisementEntity> advertisements = advertiseRepository.findByTitleContains(searchText);

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<AdvertisementEntity> criteriaQuery = criteriaBuilder.createQuery(AdvertisementEntity.class);
		Root<AdvertisementEntity> rootEntity = criteriaQuery.from(AdvertisementEntity.class);

		Predicate titlePredicate = criteriaBuilder.equal(rootEntity.get("title"), searchText); // title=searchText
		// Predicate categoryPredicate =
		// criteriaBuilder.equal(rootEntity.get("categoryId"), searchText);
		// Predicate pricePredicate = criteriaBuilder.equal(rootEntity.get("price"),
		// searchText);

		// Predicate finalPredicate = criteriaBuilder.and(titlePredicate,
		// categoryPredicate,pricePredicate);
		Predicate finalPredicate = criteriaBuilder.and(titlePredicate);
		criteriaQuery.where(finalPredicate);
		TypedQuery<AdvertisementEntity> query = entityManager.createQuery(criteriaQuery);
		List<AdvertisementEntity> advertiseEntityList = query.getResultList();

		return getStockDtoList(advertisements);
	}

}
