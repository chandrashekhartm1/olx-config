package com.olx.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.olx.entity.AdvertisementEntity;

public interface AdvertiseRepository extends JpaRepository<AdvertisementEntity, Integer>{

	List<AdvertisementEntity> findByTitleContains(String name);
	/*
	 * List<StockEntity> findByName(String name); List<StockEntity>
	 * findByMarketName(String marketName); List<StockEntity>
	 * findByNameAndMarketName(String name, String marketName);
	 * 
	 * @Query(value="SELECT * FROM Stock ORDER BY current_value", nativeQuery =
	 * true) List<StockEntity> sortStocksByPriceDesc();
	 * 
	 * 
	 * @Query(value = "SELECT se from StockEntity se WHERE se.name LIKE %:name%")
	 * List<StockEntity> findByNameLike(@Param("name")String stockName);
	 * 
	 * List<StockEntity> findByNameContaining(String name); List<StockEntity>
	 * findByNameIsContaining(String name); List<StockEntity>
	 * findByNameContains(String name);
	 * 
	 * List<StockEntity> findByOrderByNameAsc(); List<StockEntity>
	 * findByOrderByNameDesc();
	 */
}
