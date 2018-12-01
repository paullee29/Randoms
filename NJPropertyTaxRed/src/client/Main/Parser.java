package client.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import client.utilities.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.xml.sax.SAXException;

import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;


public class Parser {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		String url = null;
		System.out.println("What website to dump HTML? :");
		Scanner sc = new Scanner(System.in);
		url = sc.nextLine();
		sc.close();
		
		
		
		//USING HTTPURLCONNECTIONRequest REST
		
//		HttpURLConnectionRequest con = new HttpURLConnectionRequest();
//		try {
//			con.sendGet(url);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		Utilities.dumpHTML(con);
		
		
		//Using HttpURLConnection
		
		
//		try {
//			URL ConURL = new URL(url);
//			URLConnection con = ConURL.openConnection();
//			
//            // open the stream and put it into BufferedReader
//            BufferedReader br = new BufferedReader(
//                               new InputStreamReader(con.getInputStream()));
//
//            String inputLine;
//            String HTMLdump="";
//            while ((inputLine = br.readLine()) != null) {
//            	
//                    System.out.println(inputLine);
//                    HTMLdump = HTMLdump + "\n" + inputLine;
//            }
//            br.close();
//            
//            Utilities.textFileWriter(HTMLdump);
//
//            System.out.println("Done");
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		// USING JSOUP
//		try {
//			Document doc = Jsoup.connect(url).get();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		// Using HTTPUnit
		
		
	    WebConversation wc = new WebConversation();
	    WebRequest     req = new GetMethodWebRequest( "http://www.google.com" );
	    try {
			WebResponse   resp = wc.getResponse( req );
			String text = resp.getText();
			System.out.println(text);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		

	}

}