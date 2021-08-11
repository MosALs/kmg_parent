package com.home.DTO;

public class WorkOrderDTO {

	   private int rating;
	    private String review;   
	    private int sendingClientId;
	    private int receivingUserId;
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
		public WorkOrderDTO(int rating, String review, int sendingClientId, int receivingUserId) {
			super();
			this.rating = rating;
			this.review = review;
			this.sendingClientId = sendingClientId;
			this.receivingUserId = receivingUserId;
		}
		public WorkOrderDTO() {
			super();
		}
	    
	    
	    
}

