package com.home.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.Repository.AppUserRepository;
import com.home.Repository.UserRatingAndReviewsRepository;
import com.home.entities.UserRatingAndReviews;

@Service
public class UserRatingAndReviewsServiceImp implements UserRatingAndReviewsService {

	@Autowired
	private UserRatingAndReviewsRepository ratingAndReviewsRepository;
	@Autowired
	private AppUserRepository appUserRepository;

	@Override
	public UserRatingAndReviews save(UserRatingAndReviews ratingAndReviews) {
		if (appUserRepository.findById(ratingAndReviews.getSendingClientId()) != null
				&& appUserRepository.findById(ratingAndReviews.getReceivingUserId()) != null) {
			return ratingAndReviewsRepository.save(ratingAndReviews);
		}else {
			return null;
		}
	}

	@Override
	public UserRatingAndReviews Modify(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<UserRatingAndReviews> findById(int userId) {
		// TODO Auto-generated method stub
		return ratingAndReviewsRepository.findById(userId);
	}

	@Override
	public List<UserRatingAndReviews> findAllById(int userId) {
		
		return ratingAndReviewsRepository.findByReceivingUserId(userId) ;
	}

}
