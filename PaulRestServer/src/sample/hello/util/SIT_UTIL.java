// This is a utility file I have created over time

package sample.hello.util;
import java.lang.*;
import java.net.*;
import java.io.*;
import java.awt.*;
import sun.misc.BASE64Decoder;
public class SIT_UTIL
{
	static String user="NOUSER";
	static String passwd="NOPASSWD";
	public static String get_passwd()
	{
		return passwd;
	}
	public static String get_usr()
	{
		return user;
	}
	public static  boolean isUserAuthenticated(String authString)
	{
         
        String decodedAuth = "";
        // Header is in the format "Basic 5tyc0uiDat4"
        // We need to extract data before decoding it back to original string
	if (authString==null)
	{
        	System.out.println("No authentic data!!");
		return false;
	}
        String[] authParts = authString.split("\\s+");
        System.out.println(authParts[0]);
        String authInfo = authParts[1];
        // Decode the data back to original string
        byte[] bytes = null;
        try {
            bytes = new BASE64Decoder().decodeBuffer(authInfo);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
			return false;
        }
        decodedAuth = new String(bytes);
        System.out.println(decodedAuth);
	user = SIT_UTIL.get_string_before_token(decodedAuth, ":");
	passwd = SIT_UTIL.get_string_after_token(decodedAuth, ":");
	if ((!user.equals("tomcat")) || (!passwd.equals("tomcat")))
	{
		return false;
	}
        return true;
    }
	public static void sleep(int milli_sec)
	{
		try
		{
			Thread.sleep(milli_sec);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public static String get_string_after_token(String in_str, String token)
	{
		int pos =in_str.indexOf(token);
		int len = token.length();
		if (pos < 0 ) return null;
		String var_name = in_str.substring(pos+len, in_str.length());
		var_name=var_name.trim();
		if (var_name.length() <=0 ) return null;
		return var_name;
	}
	public static String get_string_before_last_token(String in_str, String token)
	{
		int pos =in_str.lastIndexOf(token);
		if (pos <= 0 ) return null;
		String var_name = in_str.substring(0, pos );
		var_name=var_name.trim();
		if (var_name.length() <=0 ) return null;
		return var_name;
	}
	public static String get_string_before_token(String in_str, String token)
	{
		int pos =in_str.indexOf(token);
		if (pos <= 0 ) return null;
		String var_name = in_str.substring(0, pos );
		var_name=var_name.trim();
		if (var_name.length() <=0 ) return null;
		return var_name;
	}
	public static String get_string_between_token(String in_str, 
			String first_token, String second_token)
	{
	String tmp_str=null;
	/* get string after the first_token */
	if (in_str == null) return null;
	int pos =in_str.indexOf(first_token); /* the first occurrence */
	int len = first_token.length();
	if (pos < 0 ) return null;
	String var_name = in_str.substring(pos+len, in_str.length());
	var_name=var_name.trim();
	if (var_name.length() <=0 ) return null;
	if (var_name.indexOf(second_token) < 0)
	{
		// System.out.println("last value to get: " + first_token +"="+ var_name);
		return var_name;
	}
	/* get string before the second_token */
	pos =var_name.indexOf(second_token);
	if (pos <= 0 ) return null;
	tmp_str = var_name.substring(0,	 pos );
	var_name=tmp_str.trim();
	if (var_name.length() <=0 ) return null;
	return var_name;
	}
	
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

}
