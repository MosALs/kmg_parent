/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 *
 * @author goher
 */	




@Entity
@Table(name = "rating_and_reviews", schema = "dbo", catalog = "kmgnew")
public class UserRatingAndReviews implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
   
    @Column(name ="rating")
    private int rating;
    @Column(name ="review")
    private String review;   
    
    
    @Column(name ="client_id")
    private int sendingClientId;
    
    @Column(name ="rated_user_id")
    private int receivingUserId;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "UserRatingAndReviews [id=" + id + ", rating=" + rating + ", review=" + review + ", sendingClientId="
				+ sendingClientId + ", receivingUserId=" + receivingUserId + "]";
	}

	public UserRatingAndReviews(Integer id, int rating, String review, int sendingClientId, int receivingUserId) {
		super();
		this.id = id;
		this.rating = rating;
		this.review = review;
		this.sendingClientId = sendingClientId;
		this.receivingUserId = receivingUserId;
	}

	public UserRatingAndReviews() {
		super();
	}




    
	


	
}
