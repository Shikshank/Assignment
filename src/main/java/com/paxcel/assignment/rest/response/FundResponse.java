package com.paxcel.assignment.rest.response;

import java.util.List;

import com.paxcel.assignment.dto.RoundedDown;
import com.paxcel.assignment.dto.RoundedUp;

/**
 * This class is used as Response object.
 * 
 * @author shikshank
 *
 */

public class FundResponse {

	private List<RoundedUp> roundedUp;
	private List<RoundedDown> roundedDown;

	private double remainingFunds;

	public List<RoundedUp> getRoundedUp() {
		return roundedUp;
	}

	public void setRoundedUp(List<RoundedUp> roundedUp) {
		this.roundedUp = roundedUp;
	}

	public List<RoundedDown> getRoundedDown() {
		return roundedDown;
	}

	public void setRoundedDown(List<RoundedDown> roundedDown) {
		this.roundedDown = roundedDown;
	}

	public double getRemainingFunds() {
		return remainingFunds;
	}

	public void setRemainingFunds(double remainingFunds) {
		this.remainingFunds = remainingFunds;
	}

}
