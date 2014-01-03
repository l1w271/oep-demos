package com.oracle.oep.demo.event;

public class Sentiment {

	protected String watchName ;
	protected Integer sentimentScore ;
	
	public String getWatchName() {
		return watchName;
	}
	public void setWatchName(String watchName) {
		this.watchName = watchName;
	}
	
	public Integer getSentimentScore() {
		return sentimentScore;
	}
	public void setSentimentScore(Integer sentimentScore) {
		this.sentimentScore = sentimentScore;
	}
	@Override
	public String toString() {
		return "Sentiment [watchName=" + watchName + ", sentimentScore="
				+ sentimentScore + "]";
	}
	
	
	
	
}
