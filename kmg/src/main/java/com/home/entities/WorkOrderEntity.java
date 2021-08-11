package com.home.entities;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "work_order", schema = "dbo", catalog = "kmgnew")
public class WorkOrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "rating")
	private int rating;
	@Column(name = "review")
	private String review;
	@Column(name = "sending_client_id")
	private int sendingClientId;
	@Column(name = "receiving_user_id")
	private int receivingUserId;
	private Timestamp requsetDate;
	private Timestamp closedDate;
	private Date openDate;
	private String workNeeded;
	private Boolean paid;
//	private Collection<ProductTransactionEntity> productTransactionsById;
//	private AppUserEntity appUserByRequsetUserId;
//	private ShopEntity shopByWorkUserId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public int getRating() {
		return rating;
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

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Basic
	@Column(name = "requset_date")
	public Timestamp getRequsetDate() {
		return requsetDate;
	}

	public void setRequsetDate(Timestamp requsetDate) {
		this.requsetDate = requsetDate;
	}

	@Basic
	@Column(name = "closed_date")
	public Timestamp getClosedDate() {
		return closedDate;
	}

	public void setClosedDate(Timestamp closedDate) {
		this.closedDate = closedDate;
	}

	@Basic
	@Column(name = "open_date")
	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	@Basic
	@Column(name = "work_needed")
	public String getWorkNeeded() {
		return workNeeded;
	}

	public void setWorkNeeded(String workNeeded) {
		this.workNeeded = workNeeded;
	}

	@Basic
	@Column(name = "paid")
	public Boolean getPaid() {
		return paid;
	}
	

	public void setPaid(Boolean paid) {
		this.paid = paid;
	}
//	                     //workOrderByWorkorderId
//	@OneToMany(mappedBy = "workOrderByWorkorderId")
//	public Collection<ProductTransactionEntity> getProductTransactionsById() {
//		return productTransactionsById;
//	}
//
//	public void setProductTransactionsById(Collection<ProductTransactionEntity> productTransactionsById) {
//		this.productTransactionsById = productTransactionsById;
//	}


    

}
