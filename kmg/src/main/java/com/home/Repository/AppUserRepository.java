package com.home.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.home.DTO.SearchResultDTO;
import com.home.Entity.AppUser;
import com.home.entities.AppUserEntity;

@Repository
public interface AppUserRepository extends JpaRepository<AppUserEntity, Integer>, JpaSpecificationExecutor {

	@Query(value = "select a.area_name ,s.specialization_name, u.user_name ,u.user_mobile , u.account_type "
			+ "from address addr  inner join\n"
			+ "app_user u on addr.appuser_id = u.id inner join areas a on a.id = addr.area_id \n"
			+ "inner join specialization s on s.id=u.specialization_id\n"
			+ "where a.area_name = :area_name  and u.account_type= :account_type and\n"
			+ "s.specialization_name= :specialization_name", nativeQuery = true)
	  List<SearchResultDTO> search(@Param("area_name") String areaName, @Param("account_type") String accountType,
			@Param("specialization_name") String specializationName);
	
	  @Transactional
	 // Registration finishes
	  @Procedure(procedureName = "selectAllUser") List<AppUser>
	  searchALL(@Param("area_name") String areaName,
			    @Param("account_type") String accountType,
			    @Param("specialization_name") String specializationName,
			    @Param("governorat_name") String governoratName);
	 
	// AppUser findByUserNameAndPassword(String userName, String password);
	
	AppUserEntity findByUserNameAndPassword(String userName, String password);

	// AppUser findByUserMobileAndPassword(String userMobile, String password);
	AppUserEntity findByUserMobileAndPassword(String userMobile, String password);

	//Optional<AppUser> findByUserName(String userName);

	Optional<AppUserEntity> findByUserName(String userName);
	@Query(value="select ap.userName from AppUserEntity ap")
	List<AppUserEntity> findAllUserName();
	
	AppUserEntity findById(int id); 

}
