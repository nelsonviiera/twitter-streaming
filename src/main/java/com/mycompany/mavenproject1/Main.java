/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nelsonjr
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Receiver receiver = new Receiver();
        Thread thread[] = new Thread[3];
        StreamReaderService stream = new StreamReaderService();
        stream.readTwitterFeed();
        for(int i = 0; i < 3; i++){
            thread[i] = new Thread(){
                @Override
                public void run(){
                    try{
                        while(true){
                            receiver.receiver();
                            //Thread.sleep(2000);
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            };
            thread[i].start();
        }
        
         
    }
}
