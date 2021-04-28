package com.restloan.rest.models;

import lombok.Data;

@Data
public class CustomerRequest {
	private String customerName;
	private int age;
	private long yearlyInCome;
	private int cibilScore;
	private String employmentMode;
}
