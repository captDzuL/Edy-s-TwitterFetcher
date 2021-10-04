package com.mokudev.FetchTwitterAPI.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@ConfigurationProperties(prefix= AppProperties.TWITTER4J_PREFIX)
public class AppProperties {
	
	public static final String TWITTER4J_PREFIX = "twitter4j";
	
	private Boolean debug = false;
	
	@Value("${url.hitGetTimeline}")
	public String urlGetTimeline;
	
	@Value("${sdk.connectTimeout}")
	public String sdkConnectTimeout;
	
	@Value("${sdk.readTimeout}")
	public String sdkReadTimeout;
	
	public String getSdkConnectTimeout() {
		return sdkConnectTimeout;
	}

	public void setSdkConnectTimeout(String sdkConnectTimeout) {
		this.sdkConnectTimeout = sdkConnectTimeout;
	}

	public String getSdkReadTimeout() {
		return sdkReadTimeout;
	}

	public void setSdkReadTimeout(String sdkReadTimeout) {
		this.sdkReadTimeout = sdkReadTimeout;
	}

	public String getUrlGetTimeline() {
		return urlGetTimeline;
	}

	public void setUrlGetTimeline(String urlGetTimeline) {
		this.urlGetTimeline = urlGetTimeline;
	}

	@NestedConfigurationProperty
    private OAuth oauth = new OAuth();
    
    public Boolean getDebug() {
        return debug;
    }

    public void setDebug(Boolean debug) {
        this.debug = debug;
    }

    public OAuth getOauth() {
        return oauth;
    }

    public void setOauth(OAuth oauth) {
        this.oauth = oauth;
    }
    
    public static class OAuth {

        private String consumerKey;
        private String consumerSecret;
        private String accessToken;
        private String accessTokenSecret;

        public String getConsumerKey() {
            return consumerKey;
        }
        public void setConsumerKey(String consumerKey) {
            this.consumerKey = consumerKey;
        }
        public String getConsumerSecret() {
            return consumerSecret;
        }
        public void setConsumerSecret(String consumerSecret) {
            this.consumerSecret = consumerSecret;
        }
        public String getAccessToken() {
            return accessToken;
        }
        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }
        public String getAccessTokenSecret() {
            return accessTokenSecret;
        }
        public void setAccessTokenSecret(String accessTokenSecret) {
            this.accessTokenSecret = accessTokenSecret;
        }
    }
}
