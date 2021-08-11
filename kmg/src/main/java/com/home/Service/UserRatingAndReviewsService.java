package com.home.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.home.entities.UserRatingAndReviews;

@Service	
public interface UserRatingAndReviewsService {

	UserRatingAndReviews save(UserRatingAndReviews ranking);

	public UserRatingAndReviews Modify(int id);
	
	Optional<UserRatingAndReviews> findById(int userId);

	
	List<UserRatingAndReviews> findAllById(int userId);

}
