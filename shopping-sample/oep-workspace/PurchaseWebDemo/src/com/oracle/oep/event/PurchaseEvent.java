package com.oracle.oep.event;

public class PurchaseEvent {

	protected String purchaseID ;
	protected String customerID ;
	protected String cardNo ;
	protected double price ;
	protected String latitude ;
	protected String longitude ;
	protected String status ;
	protected String merchantLabel ;
	protected String modelMCC1 ;
	protected String modelMCC2 ;
	protected String modelMCC3 ;
	//protected String modelClse1 ;
	//protected String modelClse2 ;
	//protected String modelClse3 ;
	//protected String modelClseCluster1 ;
	//protected String modelClseCluster2 ;
	//protected String modelClseCluster3 ;
	protected String txTime ;
	protected String txDate ;
	protected int rtoMerchantID ;
	protected int rtoMerchantBranchID ;
    protected String merchantMCC ;
	protected int regionID ;
	protected String zipCode ;
	protected String cardTY ;
	
	

	public String getPurchaseID() {
		return purchaseID;
	}
	public void setPurchaseID(String purchaseID) {
		this.purchaseID = purchaseID;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMerchantLabel() {
		return merchantLabel;
	}
	public void setMerchantLabel(String merchantLabel) {
		this.merchantLabel = merchantLabel;
	}
	public String getModelMCC1() {
		return modelMCC1;
	}
	public void setModelMCC1(String modelMCC1) {
		this.modelMCC1 = modelMCC1;
	}
	public String getModelMCC2() {
		return modelMCC2;
	}
	public void setModelMCC2(String modelMCC2) {
		this.modelMCC2 = modelMCC2;
	}
	public String getModelMCC3() {
		return modelMCC3;
	}
	public void setModelMCC3(String modelMCC3) {
		this.modelMCC3 = modelMCC3;
	}
	public String getTxTime() {
		return txTime;
	}
	public void setTxTime(String txTime) {
		this.txTime = txTime;
	}
	public String getTxDate() {
		return txDate;
	}
	public void setTxDate(String txDate) {
		this.txDate = txDate;
	}
	public int getRtoMerchantID() {
		return rtoMerchantID;
	}
	public void setRtoMerchantID(int rtoMerchantID) {
		this.rtoMerchantID = rtoMerchantID;
	}
	public int getRtoMerchantBranchID() {
		return rtoMerchantBranchID;
	}
	public void setRtoMerchantBranchID(int rtoMerchantBranchID) {
		this.rtoMerchantBranchID = rtoMerchantBranchID;
	}
	public String getMerchantMCC() {
		return merchantMCC;
	}
	public void setMerchantMCC(String merchantMCC) {
		this.merchantMCC = merchantMCC;
	}
	public int getRegionID() {
		return regionID;
	}
	public void setRegionID(int regionID) {
		this.regionID = regionID;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCardTY() {
		return cardTY;
	}
	public void setCardTY(String cardTY) {
		this.cardTY = cardTY;
	}
	@Override
	public String toString() {
		return "PurchaseEvent [purchaseID=" + purchaseID + ", customerID="
				+ customerID + ", cardNo=" + cardNo + ", price=" + price
				+ ", latitude=" + latitude + ", longitude=" + longitude
				+ ", status=" + status + ", merchantLabel=" + merchantLabel
				+ ", modelMCC1=" + modelMCC1 + ", modelMCC2=" + modelMCC2
				+ ", modelMCC3=" + modelMCC3 + ", txTime=" + txTime
				+ ", txDate=" + txDate + ", rtoMerchantID=" + rtoMerchantID
				+ ", rtoMerchantBranchID=" + rtoMerchantBranchID
				+ ", merchantMCC=" + merchantMCC + ", regionID=" + regionID
				+ ", zipCode=" + zipCode + ", cardTY=" + cardTY + "]";
	}
	
	
	
	

}
