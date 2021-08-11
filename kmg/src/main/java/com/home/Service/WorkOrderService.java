package com.home.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.home.entities.WorkOrderEntity;
import com.home.util.ReturnedResultModel;

@Service
public interface WorkOrderService {

	WorkOrderEntity save(WorkOrderEntity workOrderEntity);

	Optional<WorkOrderEntity> findById(int userId);

	List<WorkOrderEntity> findAllById(int userId);
//	UserRatingAndReviews save(UserRatingAndReviews ranking);
	
	int Modify(int rating, String review,int sendingClientId,int receivingUserId);
	ReturnedResultModel updatawo(WorkOrderEntity workOrderEntity);
}
