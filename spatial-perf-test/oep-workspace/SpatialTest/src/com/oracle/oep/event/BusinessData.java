package com.oracle.oep.event;

//import oracle.spatial.geometry.JGeometry;
import com.oracle.cep.cartridge.spatial.Geometry;

public class BusinessData {

	private int businessID ;
	private String businessName ;
    private String businessEmail ;
	private double latitude ;
	private double longitude ;
	private int industryID ;
	private Geometry geometry ;
	
	public Geometry getGeometry() {
		return geometry;
	}
	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
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
	@Override
	public String toString() {
		return "BusinessData [businessID=" + businessID + ", businessName="
				+ businessName + ", businessEmail=" + businessEmail
				+ ", latitude=" + latitude + ", longitude=" + longitude
				+ ", industryID=" + industryID + "]";
	}
	
	
	
}
