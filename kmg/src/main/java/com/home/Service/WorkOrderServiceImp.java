package com.home.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.aspectj.weaver.World;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.home.Repository.AppUserRepository;
import com.home.Repository.WorkOrderRepository;
import com.home.entities.WorkOrderEntity;
import com.home.util.ReturnedResultModel;

@Service
public class WorkOrderServiceImp implements WorkOrderService {

	@Autowired
	private AppUserRepository appUserRepository;
	@Autowired
	private WorkOrderRepository workOrderRepository;

	@Override
	public WorkOrderEntity save(WorkOrderEntity workOrderEntity) {
		if (appUserRepository.findById(workOrderEntity.getSendingClientId()) != null
				&& appUserRepository.findById(workOrderEntity.getReceivingUserId()) != null) {
			return workOrderRepository.save(workOrderEntity);
		} else {
			return null;
		}

	}

	@Override
	public Optional<WorkOrderEntity> findById(int userId) {
		// TODO Auto-generated method stub
		return workOrderRepository.findById(userId);
	}

	@Override
	public List<WorkOrderEntity> findAllById(int userId) {
		// TODO Auto-generated method stub
		return workOrderRepository.findByreceivingUserId(userId);
	}

	@Override
	public int Modify(int rating, String review, int sendingClientId, int receivingUserId) {
		workOrderRepository.updataWorkOrder(rating, review, receivingUserId, sendingClientId);
		return 0;
	}

	@Override
	public ReturnedResultModel updatawo(WorkOrderEntity workOrderEntity) {
		ReturnedResultModel r = new ReturnedResultModel();
		int senderId = workOrderEntity.getSendingClientId();
		int receiverId = workOrderEntity.getReceivingUserId();
		try {
			List<WorkOrderEntity> workOrders = workOrderRepository.findByReceivingUserIdAndSendingClientId(receiverId,senderId);
			WorkOrderEntity x;
			if(workOrders.size() > 0) {
				workOrderEntity.setId(workOrders.get(0).getId());
				x = workOrderRepository.save(workOrderEntity);	
				r.setMessage("Updated Successfully");

			}else {
				x = workOrderRepository.save(workOrderEntity);
				r.setMessage("Inserted Successfully");
			}
			r.setError(null);
			r.setResult(x);
			r.setStatus(HttpStatus.OK);
			
		} catch (ResponseStatusException e) {
			r.setError(e.getMessage());
			r.setMessage("Error Updating WorkOrder");
			r.setResult(null);
			r.setStatus(e.getStatus());
		}
		return r;
		
	}

}
