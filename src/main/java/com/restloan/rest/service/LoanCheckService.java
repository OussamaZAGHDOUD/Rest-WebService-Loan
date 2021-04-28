package com.restloan.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.restloan.rest.models.CustomerRequest;
import com.restloan.rest.models.WsResponse;

@Service
public class LoanCheckService {
	public WsResponse checkLoanEligibility(CustomerRequest request) {

		WsResponse response = new WsResponse();
		List<String> mismatchList = new ArrayList<>();

		if (!(request.getAge() >= 30 && request.getAge() <= 50))
			mismatchList.add("Client age must be between 30 and 50 ! ");
		if (!(request.getYearlyInCome() >= 2500))
			mismatchList.add("Client yearly income must be greater than 2500");
		if (!(request.getCibilScore() >= 500))
			mismatchList.add("Client cibil score must be lower than 500)");

		if (mismatchList.isEmpty()) {
			response.setEligible(false);
			long amount = (long) ((60 - request.getAge()) * request.getYearlyInCome() * 0.4);
			response.setApprovedAmount(amount);
		} else {
			response.setEligible(false);
			response.setApprovedAmount(0);
			response.setCriteriaMismatch(mismatchList);
		}
		return null;
	}
}
