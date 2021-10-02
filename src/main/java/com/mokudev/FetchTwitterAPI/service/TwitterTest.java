package com.mokudev.FetchTwitterAPI.service;

import java.util.List;

import com.mokudev.FetchTwitterAPI.model.TwitterModel;

public interface TwitterTest {
	public String testService();
	public List<String> getHomeTimeline();
	String saveTweet(TwitterModel model);
}
