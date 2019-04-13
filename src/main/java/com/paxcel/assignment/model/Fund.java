package com.paxcel.assignment.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * This class act as a model for fund.
 * 
 * @author shikshank
 *
 */
public class Fund {

	@Min(value=0, message = "Initial Funds cannot be negative")
	private double initialFund;

	@NotNull(message = "Values are mandatory")
	private double values[];

	public double getInitialFund() {
		return initialFund;
	}

	public void setInitialFund(double initialFund) {
		this.initialFund = initialFund;
	}

	public double[] getValues() {
		return values;
	}

	public void setValues(double[] values) {
		this.values = values;
	}

}
