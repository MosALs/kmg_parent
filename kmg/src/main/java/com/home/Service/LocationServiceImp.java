package com.home.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.DTO.LocationAreaDTO;
import com.home.DTO.SearchDtoNew;
import com.home.DTO.SearchGetAll;
import com.home.DTO.ShopSearch;
import com.home.Repository.InterfaceProjectionMethod;
import com.home.Repository.LocationRepository;
import com.home.entities.LocationEntity;


@Service
public class LocationServiceImp implements LocationService {

	@Autowired
	LocationRepository locationRepository;
	@Autowired
	InterfaceProjectionMethod interfaceProjectionMethod;

	@Override
	public int save(LocationEntity locationEntity) {
		locationRepository.save(locationEntity);
		return 0;
	}

	@Override
	public List<LocationEntity> getAllLocation() {
		return locationRepository.findAll();
	}

	// get location and areas
	@Override
	public List<LocationAreaDTO> getAllLocationNameByAreaName() {

		return locationRepository.findInfoLocationAndArea();
	}

	@Override
	public LocationEntity getByLocationID(int id) {
		Optional<LocationEntity> optional = locationRepository.findById(id);
		LocationEntity entity = optional.get();
		
		return entity;
	
	}

	@Override
	public int getByLocationName(String locationName) {
		locationRepository.findByLocationName(locationName);
		return 0;
	}

	@Override
	public void deleteByLocationID(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public int ModifyByLocationName(String newlocationName, String oldlocationName) {
		locationRepository.updateLocation(newlocationName, oldlocationName);
		return 0;
	}

	@Override
	public List<SearchDtoNew> searchAll(String areaName) {
		return locationRepository.search(areaName);

	}

	@Override
	public List<ShopSearch> searchAllnew(String areaName, String specializationName, String accountTypeName) {

		return locationRepository.searchdto(areaName, specializationName, accountTypeName);
	}

	@Override
	public List<SearchGetAll> searchAllALL() {

		return locationRepository.allFourDto1();
	}

	@Override
	public List<SearchGetAll> searchAllALLtest() {

		return interfaceProjectionMethod.allFourDto1();
	}

	@Override
	public List<LocationEntity> getName() {
		
		return locationRepository.findAllName();
	}

}
