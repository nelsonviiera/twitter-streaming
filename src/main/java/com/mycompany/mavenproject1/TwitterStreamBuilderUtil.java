package com.mycompany.mavenproject1;

import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterStreamBuilderUtil {
    public static TwitterStream getStream(){
        ConfigurationBuilder cb = new ConfigurationBuilder();
            cb.setDebugEnabled(true);
            cb.setOAuthConsumerKey("yyUT4Mz5bQCOkHsrdoKIY7cwI");
            cb.setOAuthConsumerSecret("fiq9h6O1psVdkwXFCdxlam2r7ETebrcE1exFNWd4mHO8EX2jmO");
            cb.setOAuthAccessToken("864260329840267264-IdX2y8hxQ8WmVYbC9XyhFkVd19edh7E");
            cb.setOAuthAccessTokenSecret("witcbozYWD3SGzetKkHXpxN3UfgU63yGDGGzvnXggGKYL");
                               
        return new TwitterStreamFactory(cb.build()).getInstance();
    }
}
