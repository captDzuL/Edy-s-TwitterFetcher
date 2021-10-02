package com.mokudev.FetchTwitterAPI.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name="TwitterData")
@Table(name="TwitterData")
public class TwitterModel {
	
	@Id
	@GeneratedValue
	private long userID;
	
	private String Tweet;
	
	public TwitterModel() {
		
	}
	
	public TwitterModel(Long userID, String Tweet) {
		this.userID = userID;
		this.Tweet = Tweet;
	}
	
	public long getUserID() {
		return userID;
	}
	public void setUserID(long UserID) {
		UserID = userID;
	}
	public String getTweet() {
		return Tweet;
	}
	public void setTweet(String tweet) {
		Tweet = tweet;
	}

}
