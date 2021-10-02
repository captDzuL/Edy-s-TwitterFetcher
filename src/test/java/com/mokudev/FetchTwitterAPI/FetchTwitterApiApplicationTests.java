package com.mokudev.FetchTwitterAPI;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.mokudev.FetchTwitterAPI.service.TwitterTest;

import twitter4j.TwitterException;

@SpringBootTest
class FetchTwitterApiApplicationTests {
	
	@Autowired
	TwitterTest service;
	
    @Test
    public void testGetTweets() throws TwitterException {
        List<String> tweets = service.getHomeTimeline();
        for (String tweet : tweets) {
            System.err.println(tweet);
        }
    }

}
