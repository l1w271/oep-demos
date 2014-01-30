package com.oracle.oep.event;

public class TargetBusinessEvent {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = -6756618669556637819L;

	protected String paymentID ;
	protected int industryID ;
	protected double latitude ;
	protected double longitude ;
	
	private int businessID ;
	private String businessName ;
    private String businessEmail ;
	private double businessLatitude ;
	private double businessLongitude ;
	private int businessIndustryID ;
	
	private double distance ;
	
	
	public String getPaymentID() {
		return paymentID;
	}
	public void setPaymentID(String paymentID) {
		this.paymentID = paymentID;
	}
	public int getIndustryID() {
		return industryID;
	}
	public void setIndustryID(int industryID) {
		this.industryID = industryID;
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
	public int getBusinessID() {
		return businessID;
	}
	public void setBusinessID(int businessID) {
		this.businessID = businessID;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getBusinessEmail() {
		return businessEmail;
	}
	public void setBusinessEmail(String businessEmail) {
		this.businessEmail = businessEmail;
	}
	public double getBusinessLatitude() {
		return businessLatitude;
	}
	public void setBusinessLatitude(double businessLatitude) {
		this.businessLatitude = businessLatitude;
	}
	public double getBusinessLongitude() {
		return businessLongitude;
	}
	public void setBusinessLongitude(double businessLongitude) {
		this.businessLongitude = businessLongitude;
	}
	public int getBusinessIndustryID() {
		return businessIndustryID;
	}
	public void setBusinessIndustryID(int businessIndustryID) {
		this.businessIndustryID = businessIndustryID;
	}
	
	
	
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	@Override
	public String toString() {
		return "TargetBusinessEvent [paymentID=" + paymentID + ", industryID="
				+ industryID + ", latitude=" + latitude + ", longitude="
				+ longitude + ", businessID=" + businessID + ", businessName="
				+ businessName + ", businessEmail=" + businessEmail
				+ ", businessLatitude=" + businessLatitude
				+ ", businessLongitude=" + businessLongitude
				+ ", businessIndustryID=" + businessIndustryID + ", distance="
				+ distance + "]";
	}
	
	
}
