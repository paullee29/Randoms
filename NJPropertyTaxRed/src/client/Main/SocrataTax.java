package client.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.*;

import com.google.gson.Gson;


import client.utilities.*;


public class SocrataTax {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		String url = null;
//		System.out.println("What website to dump HTML? :");
//		Scanner sc = new Scanner(System.in);
//		url = sc.nextLine();
//		sc.close();
		
		
		String JsonData = getJSON ("https://data.nj.gov/resource/qfwz-btpu.json", 10000000);
		
		System.out.println(JsonData);
//		Utilities.textFileWriter(JsonData);
		
		
//		AuthMsg msg = new Gson().fromJson(JsonData, AuthMsg.class);
//		System.out.println(msg);
		
		JsonParser(JsonData);
		
		

	}
	public static String getJSON(String url, int timeout) {
	    HttpURLConnection c = null;
	    try {
	        URL u = new URL(url);
	        c = (HttpURLConnection) u.openConnection();
	        c.setRequestMethod("GET");
	        c.setRequestProperty("Content-length", "0");
	        c.setUseCaches(false);
	        c.setAllowUserInteraction(false);
	        c.setConnectTimeout(timeout);
	        c.setReadTimeout(timeout);
	        c.connect();
	        int status = c.getResponseCode();

	        switch (status) {
	            case 200:
	            case 201:
	                BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
	                StringBuilder sb = new StringBuilder();
	                String line;
	                while ((line = br.readLine()) != null) {
	                    sb.append(line+"\n");
	                }
	                br.close();
	                line = sb.toString();
	                return line;
	        }

	    } catch (MalformedURLException ex) {
	      //  Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
	    } catch (IOException ex) {
	       // Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
	    } finally {
	       if (c != null) {
	          try {
	              c.disconnect();
	          } catch (Exception ex) {
	            // Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
	          }
	       }
	    }
	    return null;
	}
	
	public static void JsonParser (String JsonData) {



		JSONArray jsonarray = new JSONArray(JsonData);
		for (int i = 0; i < jsonarray.length(); i++) {
		    JSONObject jsonobject = jsonarray.getJSONObject(i);
		    String name = jsonobject.getString("blck");
		    System.out.println(name);
//		    String url = jsonobject.getString("url");
		}

	
	
	}
}
