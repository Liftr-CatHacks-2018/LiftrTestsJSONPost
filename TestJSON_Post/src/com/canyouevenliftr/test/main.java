package com.canyouevenliftr.test;

import org.apache.commons.httpclient.*;

public class main {
	
	public main ()
	{
		HttpClient httpClient = HttpClient.createDefault();
		HttpPost httppost = new HttpPost("http://your/url/path/");  
		httppost.addHeader("Content-Type", "application/json");
		httppost.setEntity(new ByteArrayEntity(json.toString().getBytes("UTF8")));
	}
}
