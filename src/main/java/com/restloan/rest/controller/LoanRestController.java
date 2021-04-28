package com.restloan.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restloan.rest.models.CustomerRequest;
import com.restloan.rest.models.WsResponse;
import com.restloan.rest.service.LoanCheckService;

@RestController
@RequestMapping("/api")
public class LoanRestController {
	@Autowired
	private LoanCheckService service;

	@PostMapping("/get-statuts")
	public ResponseEntity<WsResponse> getLoanStatus(@RequestBody CustomerRequest customerRequest) {
		WsResponse response = service.checkLoanEligibility(customerRequest);
		return new ResponseEntity<WsResponse>(response, HttpStatus.OK);
	}
}
