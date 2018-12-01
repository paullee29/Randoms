package client.utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;

import client.Main.HttpURLConnectionRequest;

public class Utilities {
	
	public static void dumpHTML (HttpURLConnection con) {
		BufferedReader br = null;
		try {
			br = new BufferedReader (new InputStreamReader(con.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String inputLine;
		try {
			while ((inputLine = br.readLine()) != null) {
			     System.out.println(inputLine);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//return HTMLdump;
	}
	
	
	//stringbuilder
	
	public static String string_builder(String file_name) {
		StringBuilder contentBuilder = new StringBuilder();
		try {
		
		    BufferedReader in = new BufferedReader(new FileReader(file_name));
		    String str;
		    while ((str = in.readLine()) != null) {
		        contentBuilder.append(str);
		    }
		    in.close();
		} catch (IOException e) {
		}
		String content = contentBuilder.toString();
		
		return content;
	}
	
	
	//writes string to file
	
	public static void textFileWriter(String input) {
		String filename = Long.toString(time_util.get_millisec());
		PrintWriter writer;
		try {
			writer = new PrintWriter(filename+".txt", "UTF-8");
			writer.println(input);
			writer.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
