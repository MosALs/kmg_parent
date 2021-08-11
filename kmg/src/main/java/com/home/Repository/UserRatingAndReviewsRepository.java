package com.home.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.home.entities.UserRatingAndReviews;


@Repository
public interface UserRatingAndReviewsRepository extends JpaRepository<UserRatingAndReviews, Integer> {

	List<UserRatingAndReviews> findByReceivingUserId(int userId);
	
	
}
