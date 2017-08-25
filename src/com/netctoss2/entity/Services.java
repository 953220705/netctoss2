/**
 * 
 */
package com.netctoss2.entity;

import java.util.Date;

/**
 * 业务账号的实体类
 * @author Administrator
 *
 */
public class Services {
	private String ser_id;
	private Accounts acc;
	private String ser_oslog;
	private String ser_ospsw;
	private String ser_state;
	private String ser_ip;
	private Fee fee;
	private Date cretime;
	private Date dstime;
	/**
	 * 
	 */
	public Services() {
		super();
	}
	/**
	 * @param ser_id
	 * @param acc
	 * @param ser_oslog
	 * @param ser_ospsw
	 * @param ser_state
	 * @param ser_ip
	 * @param fee
	 * @param cretime
	 * @param dstime
	 */
	public Services(String ser_id, Accounts acc, String ser_oslog, String ser_ospsw, String ser_state, String ser_ip,
			Fee fee, Date cretime, Date dstime) {
		super();
		this.ser_id = ser_id;
		this.acc = acc;
		this.ser_oslog = ser_oslog;
		this.ser_ospsw = ser_ospsw;
		this.ser_state = ser_state;
		this.ser_ip = ser_ip;
		this.fee = fee;
		this.cretime = cretime;
		this.dstime = dstime;
	}
	/**
	 * @return the ser_id
	 */
	public String getSer_id() {
		return ser_id;
	}
	/**
	 * @param ser_id the ser_id to set
	 */
	public void setSer_id(String ser_id) {
		this.ser_id = ser_id;
	}
	/**
	 * @return the acc
	 */
	public Accounts getAcc() {
		return acc;
	}
	/**
	 * @param acc the acc to set
	 */
	public void setAcc(Accounts acc) {
		this.acc = acc;
	}
	/**
	 * @return the ser_oslog
	 */
	public String getSer_oslog() {
		return ser_oslog;
	}
	/**
	 * @param ser_oslog the ser_oslog to set
	 */
	public void setSer_oslog(String ser_oslog) {
		this.ser_oslog = ser_oslog;
	}
	/**
	 * @return the ser_ospsw
	 */
	public String getSer_ospsw() {
		return ser_ospsw;
	}
	/**
	 * @param ser_ospsw the ser_ospsw to set
	 */
	public void setSer_ospsw(String ser_ospsw) {
		this.ser_ospsw = ser_ospsw;
	}
	/**
	 * @return the ser_state
	 */
	public String getSer_state() {
		return ser_state;
	}
	/**
	 * @param ser_state the ser_state to set
	 */
	public void setSer_state(String ser_state) {
		this.ser_state = ser_state;
	}
	/**
	 * @return the ser_ip
	 */
	public String getSer_ip() {
		return ser_ip;
	}
	/**
	 * @param ser_ip the ser_ip to set
	 */
	public void setSer_ip(String ser_ip) {
		this.ser_ip = ser_ip;
	}
	/**
	 * @return the fee
	 */
	public Fee getFee() {
		return fee;
	}
	/**
	 * @param fee the fee to set
	 */
	public void setFee(Fee fee) {
		this.fee = fee;
	}
	/**
	 * @return the cretime
	 */
	public Date getCretime() {
		return cretime;
	}
	/**
	 * @param cretime the cretime to set
	 */
	public void setCretime(Date cretime) {
		this.cretime = cretime;
	}
	/**
	 * @return the dstime
	 */
	public Date getDstime() {
		return dstime;
	}
	/**
	 * @param dstime the dstime to set
	 */
	public void setDstime(Date dstime) {
		this.dstime = dstime;
	}

	
	
}
