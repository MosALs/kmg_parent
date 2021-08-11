package com.home.DTO;

import javax.persistence.Column;

public class UserRatingAndReviewsDTO {
	
    private int rating;
    private String review;   
    private int sendingClientId;
    private int receivingUserId;
    
    
    
    
    
    
	public UserRatingAndReviewsDTO() {
		super();
	}

	public UserRatingAndReviewsDTO(int rating, String review, int sendingClientId, int receivingUserId) {
		super();
		this.rating = rating;
		this.review = review;
		this.sendingClientId = sendingClientId;
		this.receivingUserId = receivingUserId;
	}

	public int getRating() {
		return rating;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public int getSendingClientId() {
		return sendingClientId;
	}
	public void setSendingClientId(int sendingClientId) {
		this.sendingClientId = sendingClientId;
	}
	public int getReceivingUserId() {
		return receivingUserId;
	}
	public void setReceivingUserId(int receivingUserId) {
		this.receivingUserId = receivingUserId;
	}

	@Override
	public String toString() {
		return "UserRatingAndReviewsDTO [rating=" + rating + ", review=" + review + ", sendingClientId="
				+ sendingClientId + ", receivingUserId=" + receivingUserId + "]";
	}

	
}
