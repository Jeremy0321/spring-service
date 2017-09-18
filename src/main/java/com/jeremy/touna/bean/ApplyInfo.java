/**
 * 
 */
package com.jeremy.touna.bean;

import com.jeremy.dms.bean.AbstractBean;

/**
 * @author jeremy
 *
 */
public class ApplyInfo extends AbstractBean{

	private String id;
	private String siteCode;
	private String productCode;
	private String loanWay;
	private String repayment;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSiteCode() {
		return siteCode;
	}
	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getLoanWay() {
		return loanWay;
	}
	public void setLoanWay(String loanWay) {
		this.loanWay = loanWay;
	}
	public String getRepayment() {
		return repayment;
	}
	public void setRepayment(String repayment) {
		this.repayment = repayment;
	}
	
	
}
