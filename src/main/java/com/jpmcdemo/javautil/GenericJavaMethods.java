package com.jpmcdemo.javautil;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class GenericJavaMethods{
private Properties properties;
private static GenericJavaMethods configReader;
private final String propertyFilePath = "Config//Config.properties";
   private GenericJavaMethods() {
BufferedReader reader;
    	
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        } 
}

   public static GenericJavaMethods getInstance( ) {
   	if(configReader == null) {
    configReader = new GenericJavaMethods();
   	}
       return configReader;
   }
   public void setProperty(String key, String value) throws ConfigurationException{
   PropertiesConfiguration conf = new PropertiesConfiguration(propertyFilePath);
   conf.setProperty(key, value);
   conf.save();   
   }

   public String getBaseUrl() {
       String baseUrl = properties.getProperty("BASE_URL");
       if(baseUrl != null) return baseUrl;
       else throw new RuntimeException("base_Url not specified in the Config.properties file.");
   }
   public String getPostBody() {
       String postBody = properties.getProperty("POST_BODY");
       if(postBody != null) return postBody;
       else throw new RuntimeException("POST_BODY not specified in the Config.properties file.");
   }
   public String getPostTitle() {
       String postTitle = properties.getProperty("POST_TITLE");
       if(postTitle != null) return postTitle;
       else throw new RuntimeException("POST_TITLE not specified in the Config.properties file.");
   }
   public String getCommentBody() {
       String commentBody = properties.getProperty("COMMENT_BODY");
       if(commentBody != null) return commentBody;
       else throw new RuntimeException("commentBody not specified in the Config.properties file.");
   }
   
}
