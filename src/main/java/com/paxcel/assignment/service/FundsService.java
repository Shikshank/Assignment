package com.paxcel.assignment.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.paxcel.assignment.dto.RoundedDown;
import com.paxcel.assignment.dto.RoundedUp;
import com.paxcel.assignment.model.Fund;
import com.paxcel.assignment.rest.response.FundResponse;

/**
 * This class acts as a service to roundoff the funds.
 * 
 * @author shikshank
 *
 */
@Service
public class FundsService {

	public FundResponse roundFunds(Fund fund) {

		FundResponse fundResponse = roundOffFunds(fund);

		return fundResponse;
	}

	/**
	 * This method is used to Round off the funds.
	 * 
	 * @param fund
	 * @return
	 */
	private FundResponse roundOffFunds(Fund fund) {
		FundResponse fundResponse = null;

		double[] numbers = fund.getValues();
		double initialCapacity = fund.getInitialFund();
		int length = numbers.length;
		double difference = 0;
		List<RoundedUp> roundedUp = new ArrayList<>();
		List<RoundedDown> roundedDown = new ArrayList<>();

		if (length > 0) {
			fundResponse = new FundResponse();
			for (int i = 0; i < length; i++) {
				if (initialCapacity == 0) {
					difference = numbers[i] - Math.floor(numbers[i]);
					RoundedDown rd = new RoundedDown();
					rd.setAfterRounding((long) Math.floor(numbers[i]));
					rd.setDifference(Math.abs(round(difference)));
					rd.setValue(numbers[i]);
					roundedDown.add(rd);
				} else {
					double roundedNumber = Math.rint(numbers[i]);
					difference = numbers[i] - roundedNumber;
					if (difference < 0) {
						RoundedUp rUp = new RoundedUp();
						rUp.setAfterRounding((long) Math.rint(numbers[i]));
						rUp.setDifference(Math.abs(round(difference)));
						rUp.setValue(numbers[i]);
						roundedUp.add(rUp);
					} else {
						RoundedDown rd = new RoundedDown();
						rd.setAfterRounding((long) Math.rint(numbers[i]));
						rd.setDifference(Math.abs(round(difference)));
						rd.setValue(numbers[i]);
						roundedDown.add(rd);
					}
				}

				if (initialCapacity > 0)
					initialCapacity = initialCapacity + difference;
				if (initialCapacity < 0) {
					initialCapacity = 0.0;
				}
			}
			fundResponse.setRemainingFunds(round(initialCapacity));
			fundResponse.setRoundedDown(roundedDown);
			fundResponse.setRoundedUp(roundedUp);
		}
		return fundResponse;

	}

	/**
	 * This method is used to round upto 2 decimal places.
	 * 
	 * @param value
	 * @return double value
	 */
	private double round(double value) {
		return new BigDecimal(Double.toString(value)).
				setScale(2, RoundingMode.HALF_UP).doubleValue();
	}
}
