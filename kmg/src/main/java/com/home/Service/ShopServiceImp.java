package com.home.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.home.DTO.ShopProductDTO;
import com.home.DTO.ShopProductUserDataDTO;
import com.home.DTO.UserDataCollectionDTO;
import com.home.DTO.UserProfileFullInfoDTO;
import com.home.DTO.WorkOrderDTO;
import com.home.Repository.AccountTypeRepository;
import com.home.Repository.AppUserRepository;
import com.home.Repository.AreasRepository;
import com.home.Repository.LocationRepository;
import com.home.Repository.PhoneRepository;
import com.home.Repository.ShopProductRepository;
import com.home.Repository.ShopRepository;
import com.home.Repository.SpecializationRepository;
import com.home.Repository.UserRoleRepository;
import com.home.entities.AccountTypeEntity;
import com.home.entities.AppUserEntity;
import com.home.entities.LocationEntity;
import com.home.entities.PhoneEntity;
import com.home.entities.ShopEntity;
import com.home.entities.SpecializationEntity;
import com.home.entities.WorkOrderEntity;
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

	@Autowired
	ShopProductRepository shopProductRepository;
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

	@Autowired
	private UserRatingAndReviewsService ratingService;

	@Autowired
	WorkOrderService workOrderService;

	@Override
	public ReturnedResultModel getByUserId(int userId) throws NotFoundException {

		UserProfileFullInfoDTO infoDTO = new UserProfileFullInfoDTO();

		List<LocationEntity> locations = new ArrayList<LocationEntity>();

		List<PhoneEntity> phones = new ArrayList<PhoneEntity>();
//		List<UserRatingAndReviewsDTO> userRatingAndReviewsDTOs = new ArrayList<UserRatingAndReviewsDTO>();
		List<WorkOrderDTO> workOrderDTOs = new ArrayList<WorkOrderDTO>();
		List<SpecializationEntity> specializations = new ArrayList<SpecializationEntity>();
//		List<ShopProductDTO> shopProductDTOs= new ArrayList<ShopProductDTO>();
		List<UserDataCollectionDTO> userCollection = new ArrayList<UserDataCollectionDTO>();

		List<ShopEntity> shops = shopRepository.findByUserId(userId);
		if (shops == null || shops.size() == 0) {
//			throw new NotFoundException("Shops not found for this user");
			ReturnedResultModel r = HelperResultUtil.fillResultModel("This user is not found in our records",
					"Not Found", HttpStatus.NOT_FOUND, null);
			return r;

		}

		// user is worker or client.
//		List<ShopEntity> list=(List<ShopEntity>) shops.get(0);

//		List<UserRatingAndReviews> list = ratingService.findAllById(userId);
//		if (list != null || list.size() != 0) {
//			userRatingAndReviewsDTOs = list.stream().map(r -> new UserRatingAndReviewsDTO(r.getRating(), r.getReview(),
//					r.getSendingClientId(), r.getReceivingUserId())).collect(Collectors.toList());
//		}

		List<WorkOrderEntity> list = workOrderService.findAllById(userId);
		if (list != null || list.size() != 0) {
			workOrderDTOs = list.stream().map(
					r -> new WorkOrderDTO(r.getRating(), r.getReview(), r.getSendingClientId(), r.getReceivingUserId()))
					.collect(Collectors.toList()); 
		}

		ShopEntity shopEntity = shops.get(0);
		UserDataCollectionDTO userDataCollectionDTO = new UserDataCollectionDTO(shopEntity.getPhoneByPhoneId(),
				shopEntity.getLocationByLocationId().getLocationName(),

				shopEntity.getLocationByLocationId().getAreasByAreaId() != null
						? shopEntity.getLocationByLocationId().getAreasByAreaId().getAreaName()
						: "Not Found",

				shopEntity.getLocationByLocationId().getAreasByAreaId() != null ? shopEntity.getLocationByLocationId()
						.getAreasByAreaId().getGovernoratByGovernoratId().getGovernoratName() : "Not Found",

				shopEntity.getLocationByLocationId().getAreasByAreaId() != null ? shopEntity.getLocationByLocationId()
						.getAreasByAreaId().getGovernoratByGovernoratId().getCountriesByCountryId().getArabicShort()
						: "Not Found",
					

				shopEntity.getSpecializationBySpecializationId().getSpecializationName(),
				shopEntity.getShopProductsById()
//				shopEntity.getUserRatingAndReviewsByUserRatingAndReviewsId().getRating(),
//				shopEntity.getUserRatingAndReviewsByUserRatingAndReviewsId().getReceivingUserId(),
//				shopEntity.getUserRatingAndReviewsByUserRatingAndReviewsId().getSendingClientId(),
//				shopEntity.getUserRatingAndReviewsByUserRatingAndReviewsId().getRating(),
//				
		);
//		UserDataCollectionDTO userDataCollectionDTO = new UserDataCollectionDTO(shopEntity.getPhoneByPhoneId(),
//				shopEntity.getLocationByLocationId().getLocationName(),
//
//				shopEntity.getLocationByLocationId().getAreasByAreaId() != null
//						? shopEntity.getLocationByLocationId().getAreasByAreaId().getAreaName()
//						: "Not Found",
//
//				shopEntity.getLocationByLocationId().getAreasByAreaId() != null ? shopEntity.getLocationByLocationId()
//						.getAreasByAreaId().getGovernoratByGovernoratId().getGovernoratName() : "Not Found",
//
//				shopEntity.getLocationByLocationId().getAreasByAreaId() != null ? shopEntity.getLocationByLocationId()
//						.getAreasByAreaId().getGovernoratByGovernoratId().getCountriesByCountryId().getArabicShort()
//						: "Not Found",
//					
//
//				shopEntity.getSpecializationBySpecializationId().getSpecializationName()
////				shopEntity.getUserRatingAndReviewsByUserRatingAndReviewsId().getRating(),
////				shopEntity.getUserRatingAndReviewsByUserRatingAndReviewsId().getReceivingUserId(),
////				shopEntity.getUserRatingAndReviewsByUserRatingAndReviewsId().getSendingClientId(),
////				shopEntity.getUserRatingAndReviewsByUserRatingAndReviewsId().getRating(),
////				
//		);

		userCollection.add(userDataCollectionDTO);

		if (shopEntity.getUserId() != null) {
			int usersId = shopEntity.getUserId();
			System.out.println("usersId: " + usersId);
			AppUserEntity appUserEntity = appUserService.getUserById(userId);

			if (shopEntity.getAccountTypeId() != null) {
				int accountTypeId = shopEntity.getAccountTypeId();
				System.out.println("acccountTypeId: " + accountTypeId);
				AccountTypeEntity accountTypeEntity = accountTypeService.getByAcccountTypeId(accountTypeId);

				if (shopEntity.getPhoneId() != null) {
					int phoneId = shopEntity.getPhoneId();
					System.out.println("phonId: " + phoneId);
					PhoneEntity phoneEntity = phoneService.getPhoneById(phoneId);
					phones.add(phoneEntity);
				}
				if (shopEntity.getSpecializationId() != null) {
					int specializationId = shopEntity.getSpecializationId();
					System.out.println("specializationId: " + specializationId);
					SpecializationEntity specializationEntity = specializationService
							.getBySpecializationID(specializationId);
					specializations.add(specializationEntity);
				}
				if (shopEntity.getLocationId() != null) {
					int locationId = shopEntity.getLocationId();
					System.out.println("locationId: " + locationId);
					LocationEntity locationEntity = locationService.getByLocationID(locationId);
					locations.add(locationEntity);
				}
				

				Boolean notClient = false;
				if (!accountTypeEntity.getAccountTypeName().equals("عميل")) {
					notClient = true;

				}

				// checked for rebate

				if (shops.size() >= 0) {

					Set<Integer> specIds = new HashSet<>();
					Set<Integer> locationIds = new HashSet<>();
					Set<Integer> phoneIds = new HashSet<>();
					
					for (int i = 0; i < shops.size(); i++) {

						if (i > 0) {
							UserDataCollectionDTO userDataCollectionDTO1 = new UserDataCollectionDTO(
									shops.get(i).getPhoneByPhoneId(),
									shops.get(i).getLocationByLocationId().getLocationName(),
									shops.get(i).getLocationByLocationId().getAreasByAreaId() != null
											? shops.get(i).getLocationByLocationId().getAreasByAreaId().getAreaName()
											: "Not Found",
									shops.get(i).getLocationByLocationId().getAreasByAreaId() != null
											? shops.get(i).getLocationByLocationId().getAreasByAreaId()
													.getGovernoratByGovernoratId().getGovernoratName()
											: "Not Found",
									shops.get(i).getLocationByLocationId().getAreasByAreaId() != null ? shops.get(i)
											.getLocationByLocationId().getAreasByAreaId().getGovernoratByGovernoratId()
											.getCountriesByCountryId().getArabicShort() : "Not Found",
									shops.get(i).getSpecializationBySpecializationId().getSpecializationName(),
									shops.get(i).getShopProductsById());

							userCollection.add(userDataCollectionDTO1);
						}

						if (notClient) {
							if (shops.get(0).getSpecializationId() != shops.get(i).getSpecializationId()) {
								specIds.add(shops.get(i).getSpecializationId());
//								specIds.add(userCollection.get(i).getSpecializationId());
							}

						}

						if (shops.get(0).getLocationId() != shops.get(i).getLocationId()) {
							locationIds.add(shops.get(i).getLocationId());

						}

						if (shops.get(0).getPhoneId() != shops.get(i).getPhoneId()) {
							phoneIds.add(shops.get(i).getPhoneId());
						}
					}
					specializations.addAll(specializationService.getAllspecializationIn(specIds));
					locations.addAll(locationService.getAllLocationIn(locationIds));
					phones.addAll(phoneService.geAllPhoneIn(phoneIds));
					
				}

				infoDTO.setAccountTypeName(accountTypeEntity.getAccountTypeName());
				// infoDTO.setLocations(locations);
				// infoDTO.setPhones(phones);
				// infoDTO.setSpecialization(specializations);
				
				infoDTO.setUserCollection(userCollection);
//				infoDTO.setActive(shopEntity.getActive());
				infoDTO.setDeliveryNoDelivery(shopEntity.getDeliveryNoDelivery());
				infoDTO.setFacbookLink(appUserEntity.getFacbookLink());
				infoDTO.setMobile(appUserEntity.getUserMobile());
				infoDTO.setName(appUserEntity.getName());
				infoDTO.setUserName(appUserEntity.getUserName());
//				infoDTO.setUserRatingsAndReviews(userRatingAndReviewsDTOs);
				infoDTO.setWorkOrderDTOs(workOrderDTOs);

			}
		}
		ReturnedResultModel r = HelperResultUtil.fillResultModel("profile returned successfully", "no error",
				HttpStatus.OK, infoDTO);

		return r;

	}

	
	
	@Override
	public ReturnedResultModel getByUserIdShop(int userId) throws NotFoundException {
		UserProfileFullInfoDTO infoDTO = new UserProfileFullInfoDTO();

		List<LocationEntity> locations = new ArrayList<LocationEntity>();

		List<PhoneEntity> phones = new ArrayList<PhoneEntity>();
//		List<UserRatingAndReviewsDTO> userRatingAndReviewsDTOs = new ArrayList<UserRatingAndReviewsDTO>();
		List<WorkOrderDTO> workOrderDTOs = new ArrayList<WorkOrderDTO>();
		List<SpecializationEntity> specializations = new ArrayList<SpecializationEntity>();

		List<UserDataCollectionDTO> userCollection = new ArrayList<UserDataCollectionDTO>();

		List<ShopProductDTO> shopProductDTOs= new ArrayList<ShopProductDTO>();
		List<ShopEntity> shops = shopRepository.findByUserId(userId);
		if (shops == null || shops.size() == 0) {
//			throw new NotFoundException("Shops not found for this user");
			ReturnedResultModel r = HelperResultUtil.fillResultModel("This user is not found in our records",
					"Not Found", HttpStatus.NOT_FOUND, null);
			return r;

		}

		// user is worker or client.
//		List<ShopEntity> list=(List<ShopEntity>) shops.get(0);

//		List<UserRatingAndReviews> list = ratingService.findAllById(userId);
//		if (list != null || list.size() != 0) {
//			userRatingAndReviewsDTOs = list.stream().map(r -> new UserRatingAndReviewsDTO(r.getRating(), r.getReview(),
//					r.getSendingClientId(), r.getReceivingUserId())).collect(Collectors.toList());
//		}

		List<WorkOrderEntity> list = workOrderService.findAllById(userId);
		if (list != null || list.size() != 0) {
			workOrderDTOs = list.stream().map(
					r -> new WorkOrderDTO(r.getRating(), r.getReview(), r.getSendingClientId(), r.getReceivingUserId()))
					.collect(Collectors.toList()); 
		}

		ShopEntity shopEntity = shops.get(0);
		UserDataCollectionDTO userDataCollectionDTO = new UserDataCollectionDTO(shopEntity.getPhoneByPhoneId(),
				shopEntity.getLocationByLocationId().getLocationName(),

				shopEntity.getLocationByLocationId().getAreasByAreaId() != null
						? shopEntity.getLocationByLocationId().getAreasByAreaId().getAreaName()
						: "Not Found",

				shopEntity.getLocationByLocationId().getAreasByAreaId() != null ? shopEntity.getLocationByLocationId()
						.getAreasByAreaId().getGovernoratByGovernoratId().getGovernoratName() : "Not Found",

				shopEntity.getLocationByLocationId().getAreasByAreaId() != null ? shopEntity.getLocationByLocationId()
						.getAreasByAreaId().getGovernoratByGovernoratId().getCountriesByCountryId().getArabicShort()
						: "Not Found",

				shopEntity.getSpecializationBySpecializationId().getSpecializationName()
//				shopEntity.getUserRatingAndReviewsByUserRatingAndReviewsId().getRating(),
//				shopEntity.getUserRatingAndReviewsByUserRatingAndReviewsId().getReceivingUserId(),
//				shopEntity.getUserRatingAndReviewsByUserRatingAndReviewsId().getSendingClientId(),
//				shopEntity.getUserRatingAndReviewsByUserRatingAndReviewsId().getRating(),
//				
		);

		userCollection.add(userDataCollectionDTO);

		if (shopEntity.getUserId() != null) {
			int usersId = shopEntity.getUserId();
			System.out.println("usersId: " + usersId);
			AppUserEntity appUserEntity = appUserService.getUserById(userId);

			if (shopEntity.getAccountTypeId() != null) {
				int accountTypeId = shopEntity.getAccountTypeId();
				System.out.println("acccountTypeId: " + accountTypeId);
				AccountTypeEntity accountTypeEntity = accountTypeService.getByAcccountTypeId(accountTypeId);

				if (shopEntity.getPhoneId() != null) {
					int phoneId = shopEntity.getPhoneId();
					System.out.println("phonId: " + phoneId);
					PhoneEntity phoneEntity = phoneService.getPhoneById(phoneId);
					phones.add(phoneEntity);
				}
				if (shopEntity.getSpecializationId() != null) {
					int specializationId = shopEntity.getSpecializationId();
					System.out.println("specializationId: " + specializationId);
					SpecializationEntity specializationEntity = specializationService
							.getBySpecializationID(specializationId);
					specializations.add(specializationEntity);
				}
				if (shopEntity.getLocationId() != null) {
					int locationId = shopEntity.getLocationId();
					System.out.println("locationId: " + locationId);
					LocationEntity locationEntity = locationService.getByLocationID(locationId);
					locations.add(locationEntity);
				}

				Boolean notClient = false;
				if (!accountTypeEntity.getAccountTypeName().equals("عميل")) {
					notClient = true;

				}

				// checked for rebate

				if (shops.size() >= 0) {

					Set<Integer> specIds = new HashSet<>();
					Set<Integer> locationIds = new HashSet<>();
					Set<Integer> phoneIds = new HashSet<>();
					for (int i = 0; i < shops.size(); i++) {

						if (i > 0) {
							UserDataCollectionDTO userDataCollectionDTO1 = new UserDataCollectionDTO(
									shops.get(i).getPhoneByPhoneId(),
									shops.get(i).getLocationByLocationId().getLocationName(),
									shops.get(i).getLocationByLocationId().getAreasByAreaId()!= null
											? shops.get(i).getLocationByLocationId().getAreasByAreaId().getAreaName()
											: "Not Found",
									shops.get(i).getLocationByLocationId().getAreasByAreaId() != null
											? shops.get(i).getLocationByLocationId().getAreasByAreaId()
													.getGovernoratByGovernoratId().getGovernoratName()
											: "Not Found",
									shops.get(i).getLocationByLocationId().getAreasByAreaId() != null ? shops.get(i)
											.getLocationByLocationId().getAreasByAreaId().getGovernoratByGovernoratId()
											.getCountriesByCountryId().getArabicShort() : "Not Found",
									shops.get(i).getSpecializationBySpecializationId().getSpecializationName());

							userCollection.add(userDataCollectionDTO1);
						}

						if (notClient) {
							if (shops.get(0).getSpecializationId() != shops.get(i).getSpecializationId()) {
								specIds.add(shops.get(i).getSpecializationId());
//								specIds.add(userCollection.get(i).getSpecializationId());
							}

						}

						if (shops.get(0).getLocationId() != shops.get(i).getLocationId()) {
							locationIds.add(shops.get(i).getLocationId());

						}

						if (shops.get(0).getPhoneId() != shops.get(i).getPhoneId()) {
							phoneIds.add(shops.get(i).getPhoneId());
						}
					}
					specializations.addAll(specializationService.getAllspecializationIn(specIds));
					locations.addAll(locationService.getAllLocationIn(locationIds));
					phones.addAll(phoneService.geAllPhoneIn(phoneIds));
				}

				infoDTO.setAccountTypeName(accountTypeEntity.getAccountTypeName());
				// infoDTO.setLocations(locations);
				// infoDTO.setPhones(phones);
				// infoDTO.setSpecialization(specializations);
				infoDTO.setUserCollection(userCollection);
//				infoDTO.setActive(shopEntity.getActive());
//				infoDTO.setShopProductDTOs(shopProductDTOs);
				infoDTO.setDeliveryNoDelivery(shopEntity.getDeliveryNoDelivery());
				infoDTO.setFacbookLink(appUserEntity.getFacbookLink());
				infoDTO.setMobile(appUserEntity.getUserMobile());
				infoDTO.setName(appUserEntity.getName());
				infoDTO.setUserName(appUserEntity.getUserName());
//				infoDTO.setUserRatingsAndReviews(userRatingAndReviewsDTOs);
				infoDTO.setWorkOrderDTOs(workOrderDTOs);

			}
		}
		ReturnedResultModel r = HelperResultUtil.fillResultModel("profile returned successfully", "no error",
				HttpStatus.OK, infoDTO);

		return r;

	}

}
