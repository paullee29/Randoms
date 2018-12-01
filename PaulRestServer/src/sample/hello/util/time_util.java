//this is a utility file for all sorts of time operations


package sample.hello.util;
import java.util.*;
import java.io.*;
import java.lang.*;
import java.text.*;
public class time_util 
{
	public time_util()	{
	}
	
	public	static long	get_millisec()	{
		long  sys_mili = System.currentTimeMillis();
		return sys_mili;
	}	
	
	public static String get_no_dash_format_time()	{
		Date today = new Date();
		SimpleDateFormat fter = new SimpleDateFormat("yyyyMMddHHmmss");
		return fter.format(today);
	}
	
	public static String get_no_dash_format_SystemV_CST6_time()	{
		Date today = new Date();
		TimeZone tz = TimeZone.getTimeZone("SystemV/CST6");
		SimpleDateFormat fter = new SimpleDateFormat("yyyyMMddHHmmss");
		fter.setTimeZone(tz);
		return fter.format(today);
	}
	
	public static String long_time_to_string(long milli)	{
		SimpleDateFormat t_fmt = new SimpleDateFormat("yyyyMMddHHmmss");
		Date day_1 =new Date(milli);
		String str=t_fmt.format(day_1);
		return str;
	}
	
	public static String get_no_dash_format_SystemV_CST6CDT_time()	{
		Date today = new Date();
		TimeZone tz = TimeZone.getTimeZone("SystemV/CST6CDT");
		SimpleDateFormat fter = new SimpleDateFormat("yyyyMMddHHmmss");
		fter.setTimeZone(tz);
		return fter.format(today);
	}
	
	public static String get_no_dash_format_cst_time()	{
		Date today = new Date();
		TimeZone tz = TimeZone.getTimeZone("CST");
		SimpleDateFormat fter = new SimpleDateFormat("yyyyMMddHHmmss");
		fter.setTimeZone(tz);
		return fter.format(today);
	}
	
	public static long get_milli_from_string(String t_str)	{
		Date day_1 = null;
		SimpleDateFormat t_fmt = new SimpleDateFormat("yyyyMMddHHmmss");
		try{
			day_1= t_fmt.parse(t_str);
		} catch (Exception e)
		{
			System.out.println("Error: Unable to parse time - " + t_str);
			System.out.println("Error: Exception: " + e);
		}
		return(day_1.getTime());
	}
	/* input time values - 
	 * 20160322100101
	 */
	
	public static int get_diff_in_minutes(String newtime, String oldtime)	{
		long old_t, new_t;
		int diff_m=-1;

		Date day_1 = null;
		SimpleDateFormat t_fmt = new SimpleDateFormat("yyyyMMddHHmmss");
		try{
			day_1= t_fmt.parse(newtime);
		} catch (Exception e)
		{
			System.out.println("Error: Unable to parse new time - " + newtime);
			System.out.println("Error: Exception: " + e);
		}
		new_t =day_1.getTime();
		try{
			day_1= t_fmt.parse(oldtime);
		} catch (Exception e)
		{
			System.out.println("Error: Unable to parse old time - " + oldtime);
			System.out.println("Error: Exception: " + e);
		}
		old_t =day_1.getTime();
		diff_m = (int)((new_t - old_t)/(60*1000));
		return diff_m;
	}
	
	public static boolean is_more_than_y(long old_milli, long cur_milli, long y)	{
		if ((cur_milli-old_milli) >= y)
		 return true;
		return false;
	}
	/* after March - only one hour different between CST and EST */
	
	public static long get_milli_from_CST(String cst)	{
		Date day_1 = new Date();
		TimeZone tz = TimeZone.getTimeZone("CST");
		/* already removed .0 */
		SimpleDateFormat t_fmt = new SimpleDateFormat("yyyyMMddHHmmss");
		t_fmt.setTimeZone(tz);
		try{
			day_1=t_fmt.parse(cst);
		} catch (Exception e)
		{
			System.out.println("Error: Unable to parse time - " + cst);
			System.out.println("Error: Exception: " + e);
		}
		return(day_1.getTime());
	}
	
	public static String get_milli_from_CST6(String cst_6)	{
		String r_str = "";
		SimpleDateFormat t_fmt = new SimpleDateFormat("yyyyMMddHHmmss");
		try{
			long li = Long.decode(cst_6);
			Date day_1 = new Date(li);
			r_str =  t_fmt.format(day_1);
		} catch (Exception e)
		{
			System.out.println("Error: Unable to parse time - " + cst_6);
			System.out.println("Error: Exception: " + e);
		}
		return(r_str);
	}
	
	public static long get_milli_from_GMT_6(String gmt_6)	{
		Date day_1 = new Date();
		TimeZone tz = TimeZone.getTimeZone("GMT-6");
		/* already removed .0 */
		SimpleDateFormat t_fmt = new SimpleDateFormat("yyyyMMddHHmmss");
		// t_fmt.setTimeZone(tz);
		try{
			day_1=t_fmt.parse(gmt_6);
		} catch (Exception e)
		{
			System.out.println("Error: Unable to parse time - " + gmt_6);
			System.out.println("Error: Exception: " + e);
		}
		return(day_1.getTime());
	}
	
	public static String get_simple_format_time()	{
		Date today = new Date();
		SimpleDateFormat fter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return fter.format(today);
	}
	
	public static String	get_time()	{
		Date today = new Date();
		int  hr = today.getHours();
		int min = today.getMinutes();
		int sec = today.getSeconds();
		long  sys_mili = System.currentTimeMillis();
		// System.out.println("Time= " + hr+":"+min+":" +sec+":" + sys_mili);
		// String str_time = hr+":"+min+":" +sec+":" + sys_mili;
		String str_time = today.toString()+" "+ hr+":"+min+":" +sec;
		// System.out.println("Time= " + str_time);
		return str_time;
	 }


}
