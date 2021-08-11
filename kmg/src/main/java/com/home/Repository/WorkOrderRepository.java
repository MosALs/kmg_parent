package com.home.Repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.home.entities.WorkOrderEntity;

@Repository
public interface WorkOrderRepository extends JpaRepository<WorkOrderEntity, Integer> {
	List<WorkOrderEntity> findByreceivingUserId(int userId);

//	@Modifying()
//	@Transactional
//	@Query(value = "UPDATE Address b SET b.addresName=:newaddresName WHERE b.addresName=:oldaddresName")
//
//	int updateArea(@Param("newaddresName") String newAreaName, @Param("newaddresName") String oldAreaName);
//	
//    @Modifying
	// @Query("update Customer u set u.phone = :phone where u.id = :id")
	// void updatePhone(@Param(value = "id") long id, @Param(value = "phone") String
	// phone);

	@Modifying()
	@Transactional
	@Query(value = "update WorkOrderEntity wo set wo.rating=:rating,wo.review=:review "
			+ "where wo.sendingClientId=:sendingClientId AND receivingUserId=:receivingUserId")
	int updataWorkOrder(@Param(value = "rating") int rating, @Param("review") String review,
			@Param(value = "receivingUserId") int receivingUserId,
			@Param(value = "sendingClientId") int sendingClientId);

	@Modifying()
	@Transactional
	@Query(value = "update WorkOrderEntity wo set wo.rating=:rating,wo.review=:review,wo.openDate=:openDate,workNeeded=:workNeeded,wo.paid=:paid,"
			+ "closedDate=:closedDate,wo.requsetDate=:requsetDate where wo.sendingClientId=:sendingClientId AND receivingUserId=:receivingUserId")
	int updateWo(@Param(value = "rating") int rating, @Param("review") String review, @Param("openDate") Date openDate,
			@Param("workNeeded") String workNeeded, @Param("paid") Boolean paid,
			@Param("closedDate") Timestamp closedDate, @Param("requsetDate") Timestamp requsetDate,
			@Param(value = "sendingClientId") int sendingClientId,
			@Param(value = "receivingUserId") int receivingUserId);

	@Query(value ="select wo from WorkOrderEntity wo where wo.receivingUserId =?1 and sendingClientId = ?2 ")
	List<WorkOrderEntity> findByReceivingUserIdAndSendingClientId(int receiverId, int senderId);

}
