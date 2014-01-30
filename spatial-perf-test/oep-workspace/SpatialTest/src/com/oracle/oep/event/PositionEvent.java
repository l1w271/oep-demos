package com.oracle.oep.event;

public class PositionEvent {

	protected String paymentID ;
	protected int industryID ;
	protected Integer industry;
	protected double latitude ;
	protected double longitude ;
	protected Double latd ;
	protected Double lond ;

	public Double getLatd() {
		return latd;
	}
	public void setLatd(Double latd) {
		this.latd = latd;
		this.latitude = latd.doubleValue();
	}
	public Double getLond() {
		return lond;
	}
	public void setLond(Double lond) {
		this.lond = lond;
		this.longitude = lond.doubleValue();
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public int getIndustryID() {
		return industryID;
	}
	public void setIndustryID(int industryID) {
		this.industryID = industryID;
	}
	
	public Integer getIndustry() {
		return industry;
	}
	public void setIndustry(Integer industry) {
		this.industry = industry;
		this.industryID = industry.intValue();
	}
	public String getPaymentID() {
		return paymentID;
	}
	public void setPaymentID(String paymentID) {
		this.paymentID = paymentID;
	}
	@Override
	public String toString() {
		return "PositionEvent [paymentID=" + paymentID + ", industryID="
				+ industryID + ", latitude=" + latitude + ", longitude="
				+ longitude + "]";
	}
	
	
}
