package com.home.Repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.home.entities.PhoneEntity;



@Repository
public interface PhoneRepository extends JpaRepository<PhoneEntity, Integer> {

	@Query(value="select p from PhoneEntity p where p.id in :phoneIds")
	List<PhoneEntity> findAllIn(Set<Integer> phoneIds);

	 
}
