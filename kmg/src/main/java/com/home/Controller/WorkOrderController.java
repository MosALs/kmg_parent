package com.home.Controller;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.home.Service.WorkOrderService;
import com.home.entities.WorkOrderEntity;
import com.home.util.ReturnedResultModel;

@RestController
public class WorkOrderController {

	@Autowired
	private WorkOrderService workOrderService;
	// Save

	@RequestMapping(value = "/addworkorder", method = RequestMethod.POST)
	public ResponseEntity<ReturnedResultModel> save(@RequestBody WorkOrderEntity workOrderEntity) {
		if (workOrderService.save(workOrderEntity) != null) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ReturnedResultModel("Done", "no error", HttpStatus.OK, workOrderEntity));
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ReturnedResultModel("fail", "error found", HttpStatus.INTERNAL_SERVER_ERROR, null));
		}
	}
	

	@RequestMapping(value = "/updatework", method = RequestMethod.PUT)
	public int update(@RequestParam(name = "rating") int rating,
			          @RequestParam(name = "review") String review,
			          @RequestParam(name = "receivingUserId") int receivingUserId,
			          @RequestParam(name = "sendingClientId") int sendingClientId){
		return workOrderService.Modify(rating, review, sendingClientId, receivingUserId);
	}

	@RequestMapping(value = "/updatawo", method = RequestMethod.PUT)
	public ResponseEntity<ReturnedResultModel> update(@RequestBody WorkOrderEntity workOrderEntity){
		ReturnedResultModel r= workOrderService.updatawo(workOrderEntity);
		return new ResponseEntity<ReturnedResultModel>(r,r.getStatus());
	}
}

