package com.mokudev.FetchTwitterAPI.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mokudev.FetchTwitterAPI.model.TwitterModel;
import com.mokudev.FetchTwitterAPI.service.TwitterTest;

@RestController
@RequestMapping("/api")
@Controller
public class TwitterController {
	
	
	@Autowired
	TwitterTest tesService;
	
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@GetMapping("/getTimeline")
	public String getTimeline() {
		//System.out.println("Masuk ga?");
        List<String> tweets = tesService.getHomeTimeline();
        for (String tweet : tweets) {
        	System.out.println(tweet);
        	TwitterModel model = new TwitterModel();
        	String substr = tweet.substring(0, tweet.length()-10);
        	model.setTweet(substr);
        	String save = tesService.saveTweet(model);
        	System.out.println(save);
        }
        return "Fetch Tweet data on "+ dateFormat.format(new Date(0));
	}
	@GetMapping("/getUserID")
	public void getUserID() {
		String id;
		id = tesService.testService();
		System.out.println("test" + id);
	}
	
}
