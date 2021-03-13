package com.home.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.home.DTO.UserProfileFullInfoDTO;
import com.home.Repository.AccountTypeRepository;
import com.home.Repository.AppUserRepository;
import com.home.Repository.AreasRepository;
import com.home.Repository.LocationRepository;
import com.home.Repository.PhoneRepository;
import com.home.Repository.ShopRepository;
import com.home.Repository.SpecializationRepository;
import com.home.Repository.UserRoleRepository;
import com.home.entities.AccountTypeEntity;
import com.home.entities.AppUserEntity;
import com.home.entities.LocationEntity;
import com.home.entities.PhoneEntity;
import com.home.entities.ShopEntity;
import com.home.entities.SpecializationEntity;
import com.home.util.HelperResultUtil;
import com.home.util.ReturnedResultModel;

import javassist.NotFoundException;

@Service
public class ShopServiceImp implements ShopService {

	@Autowired
	AppUserRepository appUsersRepository;
	@Autowired
	LocationService locationService;
	@Autowired
	LocationRepository locationRepository;
	AreasService areasService;
	@Autowired
	ShopRepository shopRepository;
	@Autowired
	ShopService shopService;

	@Autowired
	PhoneEntityService phoneService;
	@Autowired
	AppUserService appUserService;
	@Autowired
	UserRoleRepository userRoleRepository;
	@Autowired
	AreasRepository areasRepository;
	@Autowired
	AccountTypeRepository accountTypeRepository;
	@Autowired
	SpecializationRepository specializationRepository;

	@Autowired
	SpecializationService specializationService;
	@Autowired
	AccountTypeService accountTypeService;

	@Autowired
	PhoneRepository phoneRepository;

	@Override
	public int save(ShopEntity shopEntity) {
		shopRepository.save(shopEntity);
		return 0;
	}

	@Override
	public List<ShopEntity> getAllShop() {

		return shopRepository.findAll();

	}

	@Override
	public ShopEntity getByShopID(int id) {
		return shopRepository.getOne(id);
	}

	@Override
	public int getByshopName(String shopName) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteByshopID(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public int ModifyByshop(String newshopName, String oldshopNamee) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ReturnedResultModel getByUserId(int userId) throws NotFoundException {

		UserProfileFullInfoDTO infoDTO = new UserProfileFullInfoDTO();

		List<LocationEntity> locations = new ArrayList<LocationEntity>();

		List<PhoneEntity> phones = new ArrayList<PhoneEntity>();

		List<SpecializationEntity> specializations = new ArrayList<SpecializationEntity>();

		List<ShopEntity> shops = shopRepository.findByUserId(userId);
		if (shops == null || shops.size() == 0) {
			throw new NotFoundException("Shops not found for this user");
//			ReturnedResultModel r = HelperResultUtil.fillResultModel(null, "Shops not found for this user", HttpStatus.NOT_FOUND, null);
		}
		// user is worker or client.
		ShopEntity shopEntity = shops.get(0);

		int usersId = shopEntity.getUserId();
		System.out.println("usersId: " + usersId);
		AppUserEntity appUserEntity = appUserService.getUserById(userId);

		if (shopEntity.getLocationId() != null) {
			int locationId = shopEntity.getLocationId();
			System.out.println("locationId: " + locationId);
			LocationEntity locationEntity = locationService.getByLocationID(locationId);
			locations.add(locationEntity);
		}

		int accountTypeId = shopEntity.getAccountTypeId();
		System.out.println("acccountTypeId: " + accountTypeId);
		AccountTypeEntity accountTypeEntity = accountTypeService.getByAcccountTypeId(accountTypeId);

		int phoneId = shopEntity.getPhoneId();
		System.out.println("phonId: " + phoneId);
		PhoneEntity phoneEntity = phoneService.getPhoneById(phoneId);
		phones.add(phoneEntity);

		int specializationId = shopEntity.getSpecializationId();
		System.out.println("specializationId: " + specializationId);
		SpecializationEntity specializationEntity = specializationService.getBySpecializationID(specializationId);
		// specializations.add(specializationEntity);

		Boolean notClient = true;
		if (!accountTypeEntity.getAccountTypeName().equals("عميل")) {
			notClient =  false;
//			int specializationId = shopEntity.getSpecializationId();
//			System.out.println("specializationId: " + specializationId);
//			SpecializationEntity specializationEntity = specializationService.getBySpecializationID(specializationId);

		}

		if (shops.size() > 1) {
			// create list of locati oentity and list of phone entity and fill them with all
			// objects .

			for (int i = 0; i < shops.size(); i++) {
				if (i > 0) {
					if (notClient) {
						int speId = shops.get(i).getSpecializationId();
						SpecializationEntity specializationEn = specializationService.getBySpecializationID(speId);
						specializations.add(specializationEn);
					}

					int locId = shops.get(i).getLocationId();
					System.out.println("locationId: " + locId);
					LocationEntity locEntity = locationService.getByLocationID(locId);
					locations.add(locEntity);

					int phonId = shops.get(i).getPhoneId();
					System.out.println("phonId: " + phonId);
					PhoneEntity phonEntit = phoneService.getPhoneById(phoneId);
					phones.add(phonEntit);

				}
			}
		}

		infoDTO.setAccountTypeName(accountTypeEntity.getAccountTypeName());
		infoDTO.setLocations(locations);
		infoDTO.setPhones(phones);
		infoDTO.setSpecialization(specializations);
//		infoDTO.setSpecialization(specializations);
		infoDTO.setActive(shopEntity.getActive());
		infoDTO.setDeliveryNoDelivery(shopEntity.getDeliveryNoDelivery());
		infoDTO.setFacbookLink(appUserEntity.getFacbookLink());
		infoDTO.setMobile(appUserEntity.getUserMobile());
		infoDTO.setName(appUserEntity.getName());

		ReturnedResultModel r = HelperResultUtil.fillResultModel("profile returned successfully", "no error",
				HttpStatus.OK, infoDTO);

		return r;

	}

}

//List<String> locNames = new ArrayList<>();
//locations.forEach(location -> {
//	String locName = location.getLocationName();
//	locNames.add(locName);
//});
//
//List<String> phNambers = new ArrayList<>();
//phones.forEach(phone -> {
//	String phoneNamber = phone.getMobileOne();
//	
//	phNambers.add(phoneNamber);
//});

//List<PhoneEntity> userPhones = new ArrayList<>();
//phones.forEach(phone -> {
//	String phoneNamber = phone.getMobileOne();
//	
//	phNambers.add(phoneNamber);
//});
//
