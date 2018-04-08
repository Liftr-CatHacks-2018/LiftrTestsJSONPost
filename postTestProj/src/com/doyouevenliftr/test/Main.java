package com.doyouevenliftr.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.HttpClients;

public class Main {
	private static String jsonStr = "{  \r\n" + 
			"   \"liftData\":[  \r\n" + 
			"      {  \r\n" + 
			"         \"AquisitionTime\":\"2018-04-08 00:29:10\",\r\n" + 
			"         \"LifterID\":\"2\",\r\n" + 
			"         \"Score\":\"95.84\"\r\n" + 
			"      },\r\n" + 
			"      {  \r\n" + 
			"         \"AquisitionTime\":\"2018-04-08 00:29:12\",\r\n" + 
			"         \"LifterID\":\"2\",\r\n" + 
			"         \"Score\":\"89.49\"\r\n" + 
			"      },\r\n" + 
			"      {  \r\n" + 
			"         \"AquisitionTime\":\"2018-04-08 00:29:14\",\r\n" + 
			"         \"LifterID\":\"2\",\r\n" + 
			"         \"Score\":\"92.37\"\r\n" + 
			"      }\r\n" + 
			"   ]\r\n" + 
			"}";
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		HttpClient httpclient = HttpClients.createDefault();
		
		HttpPost httppost = new HttpPost("http://localhost/LiftrWebServer/AddScore.php");  
		httppost.addHeader("Content-Type", "application/json");
		httppost.setEntity(new ByteArrayEntity(jsonStr.getBytes("UTF8")));
		
		HttpResponse response;
		try {
			response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			
		   String inputLine ;
		   BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent()));
		   try {
		         while ((inputLine = br.readLine()) != null) {
		                System.out.println(inputLine);
		         }
		         br.close();
		    } catch (IOException e) {
		         e.printStackTrace();
		    }
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}
}
