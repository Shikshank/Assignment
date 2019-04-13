package com.paxcel.assignment.rest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paxcel.assignment.model.Fund;
import com.paxcel.assignment.rest.response.FundResponse;
import com.paxcel.assignment.service.FundsService;

/**
 * This class act as a controller for rounding off funds.
 * 
 * @author shikshank
 *
 */

@RestController
@RequestMapping("/funds")
public class FundController {

	/**
	 * Fund Service.
	 */
	@Autowired
	private FundsService fundService;

	/**
	 * This method is used to round off the funds.
	 * 
	 * @param fund Corresponds to {@link Fund} object
	 * @return {@link FundResponse} object
	 */
	@PostMapping("/roundOff")
	public ResponseEntity<FundResponse> roundFunds(@Valid @RequestBody Fund fund) {
		FundResponse fundResp = fundService.roundFunds(fund);
		
		return new ResponseEntity<FundResponse>(fundResp, HttpStatus.OK);

	}
}
