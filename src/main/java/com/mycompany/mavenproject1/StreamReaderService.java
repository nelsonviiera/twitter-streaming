package com.mycompany.mavenproject1;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.TextMessage;
import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;

/**
 *
 * @author nelsonjr
 */
public class StreamReaderService {
    
    public void readTwitterFeed() {

        TwitterStream stream = TwitterStreamBuilderUtil.getStream();
        Sender sender = new Sender();

        StatusListener listener = new StatusListener() {            
            @Override
            public void onException(Exception e) {
                  System.out.println("Exception occured:" + e.getMessage());
            }
            
            @Override
            public void onTrackLimitationNotice(int n) {
                  System.out.println("Track limitation notice for " + n);
            }
            
            @Override
            public void onStatus(Status status) {
                //System.out.println("Got twit:" + status.getText());
                //TwitterStreamBean bean = new TwitterStreamBean();
                //String username = status.getUser().getScreenName();
                //System.out.println("Username: " + username);
                //bean.setUsername(username);
                //long tweetId = status.getId();
                //System.out.println("tweetId: " + tweetId);
                //bean.setId(tweetId);
                //bean.setInReplyUserName(status.getInReplyToScreenName());
                //if (status != null && status.getRetweetedStatus() != null && status.getRetweetedStatus().getUser() != null) {
                //    bean.setRetwitUserName(status.getRetweetedStatus().getUser().getScreenName());
                //}
                String content = status.getText();
                System.out.println("Conteúdo enviado para o sender: " + content);
                try {
                    sender.sender(content);
                    //bean.setContent(content);
                } catch (Exception ex) {
                    Logger.getLogger(StreamReaderService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            @Override
            public void onStallWarning(StallWarning arg0) {
                  System.out.println("Stall warning");
            }
            
            @Override
            public void onScrubGeo(long arg0, long arg1) {
                  System.out.println("Scrub geo with:" + arg0 + ":" + arg1);
            }
            
            @Override
            public void onDeletionNotice(StatusDeletionNotice arg0) {
                  System.out.println("Status deletion notice");
            }
        };

        FilterQuery qry = new FilterQuery();
        String[] keywords = {"Brazil","Futebol"};

        qry.track(keywords);

        stream.addListener(listener);
        stream.filter(qry);
    }    
}
