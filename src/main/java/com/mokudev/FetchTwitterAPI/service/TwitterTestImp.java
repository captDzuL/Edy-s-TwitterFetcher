package com.mokudev.FetchTwitterAPI.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.mokudev.FetchTwitterAPI.common.AppProperties;
//import com.mokudev.FetchTwitterAPI.common.OkHttpUtil;
import com.mokudev.FetchTwitterAPI.model.TwitterModel;
import com.mokudev.FetchTwitterAPI.repository.TwitterRepo;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
//import okhttp3.Call;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.Response;

@Service
public class TwitterTestImp implements TwitterTest{
	
	@Autowired
	private Twitter twitter;
	
	@Autowired
	private AppProperties properties;
	
	@Autowired
	private TwitterRepo repo;
	
//    @Autowired
//    private OkHttpUtil okHttpUtil;
    
//    OkHttpClient client;
    
	@Override
	public String testService() {
		// TODO Auto-generated method stub
		return "test service";
	}

	@Override
	@Scheduled(fixedRate = 9000)
	public List<String> getHomeTimeline() {
		System.out.println("masuk service getTL");
		List<String> tweets = new ArrayList<>();
		try {
			
			TwitterFactory tf = config();
	        twitter = tf.getInstance();
	        
			ResponseList<Status> homeTimeline = twitter.getHomeTimeline();
			for (Status status : homeTimeline) {
                tweets.add(status.getText());
			}
			
		}catch(TwitterException e){
			System.out.println("error : "+ e);
		}
		return tweets;
	}

	
    private TwitterFactory config(){

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(properties.getDebug())
            .setOAuthConsumerKey(properties.getOauth().getConsumerKey())
            .setOAuthConsumerSecret(properties.getOauth().getConsumerSecret())
            .setOAuthAccessToken(properties.getOauth().getAccessToken())
            .setOAuthAccessTokenSecret(properties.getOauth().getAccessTokenSecret());
        TwitterFactory tf = new TwitterFactory(cb.build());
        return tf;
    }
    
    @Override
    public String saveTweet(TwitterModel model) {
    	repo.save(model);
		return "Tweets Stored to Database";
    }
    
    
//    @Override
//    public String hitAPI() {
//    	try {
//	    	okHttpUtil.init(true);
//	        client = okHttpUtil.getClient();
//	    	Request request = new Request.Builder().url(properties.getUrlGetTimeline()).build();
//	    	Call call = client.newCall(request);
//	        Response response = call.execute();
//	        String responsBody = response.body().string();
//	    	return responsBody;
//	    	
//    	}catch (Exception e) {
//            System.out.println(e);
//    	}
//		return "";
//    }

}
