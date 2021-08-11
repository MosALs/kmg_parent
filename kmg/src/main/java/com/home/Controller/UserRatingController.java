package com.home.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.home.Service.UserRatingAndReviewsService;
import com.home.entities.UserRatingAndReviews;
import com.home.util.ReturnedResultModel;

@RestController
public class UserRatingController {
	@Autowired
	private UserRatingAndReviewsService userRatingAndReviewsService;
	
	// Save

	@RequestMapping(value = "/adduserRating", method = RequestMethod.POST)
	public ResponseEntity<ReturnedResultModel> add(@RequestBody UserRatingAndReviews userRating) {
		if (userRatingAndReviewsService.save(userRating) != null) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ReturnedResultModel("Done", "no error", HttpStatus.OK, userRating));
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ReturnedResultModel("fail", "error found", HttpStatus.INTERNAL_SERVER_ERROR, null));
		}
	}

}
