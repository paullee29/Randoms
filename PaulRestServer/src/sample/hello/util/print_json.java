package sample.hello.util;
import java.util.*;
import java.io.*;
import java.lang.*;
import java.text.*;
/* "{ { assa, [ 123, 456, 789 ], { xx }, { BB }, "Paul": "vv" }}" */
public class print_json {
	public static File_io fio = null;
	public print_json (String not_used_yet)
	{
		fio = new File_io(not_used_yet);
	}
	public static void main(String args[])
	{
		String fn=null;
		print_json pj = new print_json("C:/temp/data/test_js_out.data");
		for (int i = 0; i < args.length; i++)
		{
			if (args[i].indexOf("IN_FILE_NAME=") >=0 )
			{
				fn= SIT_UTIL.get_string_after_token(args[i], "=");
				System.out.println( "File_name = " + fn);
				continue;
			}
		}
		if (fn != null)
		{
			boolean ok = fio.open_file_to_r(fn);
		} else
			System.exit(0);

		String in_data=null;
		in_data= "" ;
		while ( (in_data = fio.get_line()) != null)
		{
			in_data = in_data.trim();
			if (in_data.length() <=0) continue;
			if (in_data.charAt(0)== '#') continue;
			in_data = SIT_UTIL.get_string_after_token(in_data, "Msg=");
			pj.make_it_readble(in_data);
		}
	}
	public String replace_time(String in_data)
	{
		String t_str = "";
		if (in_data == null) return t_str ;
		if (in_data.length() <=0) return t_str ;
		if (in_data.indexOf("commonEventHeader") <= 0)  return in_data;
		String new_l= "\n";
		StringTokenizer parser = new StringTokenizer(in_data, new_l);
		String c_cur="";
 		while (parser.hasMoreTokens())
 		{
         		Object obj = parser.nextToken();
         		c_cur = obj.toString();
			if (c_cur.indexOf("startEpochMicrosec") >=0)
			{
				c_cur = get_time_from_microsec(c_cur);
			} else
			if (c_cur.indexOf("lastEpochMicrosec") >=0)
			{
				c_cur = get_time_from_microsec(c_cur);
			}
			t_str=t_str+c_cur+"\n";
 		}
		return t_str;

	}
	public String get_time_from_microsec(String in_str)
	{
		String time_str = SIT_UTIL.get_string_between_token(in_str, ":", ",");
		long number = Long.parseLong(time_str);
		number = number/1000;
		String st_time = time_util.long_time_to_string(number);
		String ret_st = in_str.replaceFirst(time_str, st_time);
		return ret_st;
	}
	public String make_it_readble(String in_data)
	{
		String t1 = "";
		char c = 'S';
		int cur_pos=0;
		String nl = "";
		String jstr = "\n";
		t1 = String.valueOf(c);
		char s = '#';
		char prev_c = '#';
		String sv ="";
		for (int i=0; i < in_data.length(); i++)
		{
			s = in_data.charAt(i);
			sv = String.valueOf(s);
			if ((s == '{') || (s == '['))
			{
				/* advance to new line for { and [ after any prev_c not = the char below 
				 * if take the line below out then
				 * if ((prev_c != ',') && (prev_c != '}') && (prev_c != ']') && (prev_c != '['))
				 * the output will be e.g. 
				 *
				 * "shelves":[ 
				 *
				 * instead of 
				 *
				 * "shelves":
				 * [
				 *
				 */
				if ((prev_c != ',') && (prev_c != '}') && (prev_c != ']') && (prev_c != '['))
			   		jstr = jstr + nl+ space_dent(cur_pos) + sv;
				else
			   	jstr = jstr + sv;
				cur_pos++;
				/* advane to new line with one more space */
			   	jstr = jstr + "\n" + space_dent(cur_pos);
			} else
			if ((s == '}') || (s == ']'))
			{
				cur_pos--;
				jstr = jstr + nl+ space_dent(cur_pos) +sv;
			} else
			if (s == ',')
			{
				jstr = jstr + sv+ nl + space_dent(cur_pos);
			} else
			{
				jstr = jstr + sv;
			}
			prev_c = s;
			nl= "\n";
		}
		// System.out.println("JS=\n" + jstr);File_io.get_simple_format_time()File_io.get_simple_format_time() + ":"+ jstr);
		return jstr;
	}
	public static String space_dent(int pos)
	{
		String sp2 = "  ";
		String ret_str="";
		for (int k=0; k<pos; k++)
			ret_str=ret_str+sp2;
		return ret_str;
	}
}
