/**
 * 
 */
package com.netctoss2.entity;

import java.util.Date;

/**
 * 资费表的实体类
 * @author Administrator
 *
 */
public class Fee {
	private String fee_id;
	private String fee_name;
	private String fee_type;
	private int basic_time;
	private double basic_fee;
	private double unit_cost;
	private Date create_time;
	private Date start_time;
	private String instructions;
	private String fee_state;
	/**
	 * @param feeID
	 * @param feeName
	 * @param feeType
	 * @param basicTime
	 * @param basicFee
	 * @param unitCost
	 * @param creTime
	 * @param startTime
	 * @param instructions
	 * @param feeState
	 */
	public Fee(String feeID, String feeName, String feeType, int basicTime, double basicFee, double unitCost,
			Date creTime, Date startTime, String instructions, String feeState) {
		super();
		this.fee_id = feeID;
		this.fee_name = feeName;
		this.fee_type = feeType;
		this.basic_time = basicTime;
		this.basic_fee = basicFee;
		this.unit_cost = unitCost;
		this.create_time = creTime;
		this.start_time = startTime;
		this.instructions = instructions;
		this.fee_state = feeState;
	}
	/**
	 * 
	 */
	public Fee() {
		super();
	}
	/**
	 * @return the feeID
	 */
	public String getFeeID() {
		return fee_id;
	}
	/**
	 * @param feeID the feeID to set
	 */
	public void setFeeID(String feeID) {
		this.fee_id = feeID;
	}
	/**
	 * @return the feeName
	 */
	public String getFeeName() {
		return fee_name;
	}
	/**
	 * @param feeName the feeName to set
	 */
	public void setFeeName(String feeName) {
		this.fee_name = feeName;
	}
	/**
	 * @return the feeType
	 */
	public String getFeeType() {
		return fee_type;
	}
	/**
	 * @param feeType the feeType to set
	 */
	public void setFeeType(String feeType) {
		this.fee_type = feeType;
	}
	/**
	 * @return the basic_time
	 */
	public int getBasicTime() {
		return basic_time;
	}
	/**
	 * @param basic_time the basic_time to set
	 */
	public void setBasicTime(int basicTime) {
		this.basic_time = basicTime;
	}
	/**
	 * @return the basic_fee
	 */
	public double getBasicFee() {
		return basic_fee;
	}
	/**
	 * @param basic_fee the basic_fee to set
	 */
	public void setBasicFee(double basicFee) {
		this.basic_fee = basicFee;
	}
	/**
	 * @return the unit_cost
	 */
	public double getUnitCost() {
		return unit_cost;
	}
	/**
	 * @param unit_cost the unit_cost to set
	 */
	public void setUnitCost(double unitCost) {
		this.unit_cost = unitCost;
	}
	/**
	 * @return the creTime
	 */
	public Date getCreTime() {
		return create_time;
	}
	/**
	 * @param creTime the creTime to set
	 */
	public void setCreTime(Date creTime) {
		this.create_time = creTime;
	}
	/**
	 * @return the startTime
	 */
	public Date getStartTime() {
		return start_time;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Date startTime) {
		this.start_time = startTime;
	}
	/**
	 * @return the instructions
	 */
	public String getInstructions() {
		return instructions;
	}
	/**
	 * @param instructions the instructions to set
	 */
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	/**
	 * @return the feeState
	 */
	public String getFeeState() {
		return fee_state;
	}
	/**
	 * @param feeState the feeState to set
	 */
	public void setFeeState(String feeState) {
		this.fee_state = feeState;
	}
	
	
	
}
