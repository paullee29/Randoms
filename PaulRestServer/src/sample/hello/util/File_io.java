//This is a Utilities files I have created over time, mostly for file_io operations

package sample.hello.util;
import java.util.*;
import java.io.*;
import java.lang.*;
import java.text.*;
public class File_io 
{
		static DataInputStream	data_in;
		static FileInputStream file_in;
		FileOutputStream fos=null;
		FileOutputStream test_result_ptr=null;
		String file_name =  new String();
		String test_result_file_name = null;
		String	long_file_name = new String();
		static String _r_file_name;
		String _w_file_name;
		static BufferedReader br_05022016= null;
		BufferedReader br= null;
		PrintWriter out_text_ptr=null;
		FileReader fr;
		String	data_dir = System.getProperty("data_dir");

		public File_io()
		{
		} 
		public void close_r_file() //tries to close the file
		{
			try {
				file_in.close();
			} catch (IOException e)
			{
			  System.err.println("ERROR on closing input file " +
					 _r_file_name+  ". " + e);
			}
		}
		public void close_in_file()
		{
			try {
				fr.close();
				br.close();
			} catch (IOException e)
			{
			   System.err.println("ERROR on closing input file " + e);
			}
		}
		public String read_data() // read data from the file line by line
		{
			String line_data = null;
			try {
				line_data = br.readLine();
			} catch (IOException e)
			{
				System.err.println("ERROR on opening input file " +  e);
				return null;
			}
			return line_data;
		}
		
		public void write_text(String in_data) //writes text in the file
		{
			out_text_ptr.println(in_data);
			out_text_ptr.flush();
		}
		public void close_text_file() //closes text file
		{
			out_text_ptr.close();
		}
		public void flush_text_file() //flushes the text file
		{
		}
		public boolean set_out_text_file(String out_name)
		{
			String fn = out_name;
			if (data_dir != null)
				fn = data_dir + "/" + fn;
			
			if (delete_file(fn))
				System.out.println("ERROR on deleting file  " + fn);
			try
			{
				out_text_ptr=new PrintWriter(new BufferedWriter(new FileWriter(fn, false)));
			}catch (IOException e)
			{
				System.out.println("ERROR on opening out text file " + fn+ "  "+ e);
				return false;
			}
			return true;
		}

		public boolean set_input_file(String in_file)
		{
			try
			{
				File i_file = new File(in_file);
				fr=new FileReader(i_file);
				br= new BufferedReader(fr);
			}catch (IOException e)
			{
				System.out.println("ERROR on opening input file " + in_file+ "  "+ e);
				return false;
			}
			return true;
		}
		public boolean delete_file(String file_name)
		{
				File t_file = new File(file_name);
				t_file.delete();
				System.out.println("Delete file " + file_name);
				return true;
		}
		public static void delete_f(String file_name)
		{
			File t_file = new File(file_name);
			t_file.delete();
		}
		public void copy_file(String f_file, String to_file)
		{
			InputStream ips=null;
			OutputStream ops = null;
			try {
					ips = new FileInputStream(f_file);
					ops = new FileOutputStream(to_file);
					byte[] buf = new byte[1024];
					int byteRead;
					while((byteRead=ips.read(buf))> 0)
					{
						ops.write(buf, 0, byteRead);
					}
					ips.close();
					ops.close();
				} catch (IOException e)
				{
					System.out.println("\n Unable to open input file " + f_file + "  or saved copy file " + to_file + " \nError message " + e);
				}
		}
		public static boolean	open_file_to_r(String file_name)
		{
				_r_file_name = file_name;
				try 
				{
					file_in = new FileInputStream( file_name);
					data_in = new DataInputStream(file_in);
					br_05022016=new BufferedReader(new InputStreamReader(file_in));

				} catch (IOException e)
				{
					System.out.println("\n Unable to open input file " + file_name + "  END" + " \nError message " + e);
					return false;
				}
				return true;
		}

		public boolean	open_data_file_to_r(String file_name)
		{
				_r_file_name = file_name;
				if (data_dir != null)
				_r_file_name= data_dir + "/"+ file_name;
				try 
				{
					file_in = new FileInputStream( _r_file_name);
					data_in = new DataInputStream(file_in);
					br_05022016=new BufferedReader(new InputStreamReader(file_in));
				} catch (IOException e)
				{
					System.out.println("\n Unable to open input file " + _r_file_name + " END" + " \nError message " + e);
					return false;
				}
				return true;
		}



		public boolean	open_data(String file_name)
		{
				_r_file_name = file_name;
				try 
				{
					file_in = new FileInputStream( file_name);
					data_in = new DataInputStream(file_in);
					br_05022016=new BufferedReader(new InputStreamReader(file_in));
				} catch (IOException e)
				{
					System.out.println("\n Unable to open input file " + file_name + " END" + " \nError message " + e);
					return false;
				}
				return true;
		}
		public void set_test_result_file(String str)
		{
			String temp_name = str;				
			if (data_dir != null)
				temp_name = data_dir + "/" + str;				
			try
			{
				test_result_file_name = new String(temp_name);
				test_result_ptr = new FileOutputStream(temp_name, true);
			}
			catch (IOException e)
			{
				System.err.println("ERROR on opening file " + temp_name+ "  "+ e);
			}
		}
		public File_io(String log_file_name)
		{
			long_file_name = log_file_name;
			String log_dir = System.getProperty("log_dir");
			if (log_dir != null)
				long_file_name = log_dir + "/" + log_file_name;
			try
			{
				fos = new FileOutputStream(long_file_name, true);
			}
			catch (IOException e)
			{
				System.err.println("ERROR on opening file " + long_file_name+ "  "+ e);
			}
		}
		public void close_data_file()
		{
			try{
				test_result_ptr.close();
			} catch (IOException e )
			{
				System.err.println("Error on closing  file " + test_result_file_name+ "  "+ e);
			}
		}
		public void close_test_result_file()
		{
			try{
				test_result_ptr.close();
			} catch (IOException e )
			{
				System.err.println("Error on closing  file " + test_result_file_name+ "  "+ e);
			}
		}
		public void close()
		{
			try{
			fos.close();
			} catch (IOException e )
			{
				System.err.println("Error on closing  file " + file_name+ "  "+ e);
			}
		}
		public void write_data(String in_data)
		{
			try{
				byte[] buf = new byte[in_data.length()];
				in_data.getBytes(0, in_data.length(), buf, 0);
				test_result_ptr.write(buf);
				String s_lfeed="\n";
				byte[] b_lfeed = new byte[1];
				s_lfeed.getBytes(0, 1, b_lfeed, 0);
				test_result_ptr.write(b_lfeed);
				test_result_ptr.flush();
			}
			catch(IOException e)
			{
				System.err.println("Error on writing data to  file " + test_result_file_name+ "  "+ e);
			}
		}
		public void write_test_result(String in_data)
		{
			try{
				byte[] buf = new byte[in_data.length()];
				in_data.getBytes(0, in_data.length(), buf, 0);
				test_result_ptr.write(buf);
				String s_lfeed="\n";
				byte[] b_lfeed = new byte[1];
				s_lfeed.getBytes(0, 1, b_lfeed, 0);
				test_result_ptr.write(b_lfeed);
				test_result_ptr.flush();
			}
			catch(IOException e)
			{
				System.err.println("Error on writing data to  file " + test_result_file_name+ "  "+ e);
			}
		}
		public void log_data(String in_data)
		{
			try{
				byte[] buf = new byte[in_data.length()];
				in_data.getBytes(0, in_data.length(), buf, 0);
				fos.write(buf);
				String s_lfeed="\n";
				byte[] b_lfeed = new byte[1];
				s_lfeed.getBytes(0, 1, b_lfeed, 0);
				fos.write(b_lfeed);
				fos.flush();
			}
			catch(IOException e)
			{
				System.err.println("Error on writing data to  file " + file_name+ "  "+ e);
			}
		}
	public String get_str_by_token(String data, String tag, String token, int token_num, boolean before)
	{
		int i = 1;
		String  c_curr = null;
		String  ret_str = null;
		boolean next = false;
		if (data == null) return null;
		StringTokenizer parser = new StringTokenizer(data, token);
		while (parser.hasMoreTokens())
		{
			Object obj = parser.nextToken();
			c_curr = obj.toString();
			ret_str = c_curr;
			if (before)
			{
				if (token_num == i )
					break;
			}
			else
			{
				if ((token_num +1) == i )
					break;
			}
			i++;
		}
		return ret_str;
	}

	static long	get_millisec()
	{
		Date today = new Date();
		long  sys_mili = System.currentTimeMillis();
		return sys_mili;
	}	
	public static String get_simple_format_time()
	{
		Date today = new Date();
		SimpleDateFormat fter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return fter.format(today);
	}
	public static String	get_time()
	{
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
	public String get_line()
	{
		String data=null;
		int	idx=0;
		try 
		{

			data = br_05022016.readLine();
			if (data == null) return null;
		} catch (IOException e) {
            		System.out.println("\nUnable to open read data for  " + 
					_r_file_name + " \nError message " + e);
            		return null;
       	}
		if (data.length() <=0) return "#";
        System.out.println("DATA123= " + data  + " strlen=" + data.length());
		return data;
	}
	
	/* example 
	 * in_data = AAA|BB|CC
	 *  set token to "|"
	 *  set token_num = 1
	 *  set before = true
	 *  return AAA
	 *  set before = false
	 *  return BB
	 *  to get last value set token_num = 2 and before = false
	 */
	public String get_my_pattern(String in_data, String not_use, String token, 
					int token_num, boolean before)
	{
		int c_idx=0;
		int c_count = 0;
		String ret_str=null;
		int t_len = token.length();
		while (true)
		{
			int idx = in_data.indexOf(token, c_idx);
			if (idx ==-1 ) 
			  break;
		    else 
			  c_count++;
			if  (c_count == token_num)
			{
				if (before) 
				{
					ret_str= in_data.substring(c_idx, idx);
					break;
				}
				else
				{
					/* the entire string after the token */
					// ret_str= in_data.substring(idx+1, in_data.length());
					 ret_str= in_data.substring(idx+t_len, in_data.length());
					break;
				}
			}
			// c_idx=idx +1;
			 c_idx=idx +t_len;
		}
		return ret_str;
	}
	public int get_token_number(String in_data, String token)
	{
		int c_idx=0;
		int c_count = 0;
		String ret_str=null;
		while (true)
		{
			int idx = in_data.indexOf(token, c_idx);
			if (idx ==-1 ) 
			{
				return c_count;
			}
		    else 
			  c_count++;
			c_idx=idx +1;
		}
	}

	public int get_token_pos(String in_data, String token, int token_num)
	{
		int c_idx=0;
		int c_count = 0;
		String ret_str=null;
		while (true)
		{
			int idx = in_data.indexOf(token, c_idx);
			if (idx ==-1 ) 
			{
				return -1;
			}
		    else 
			  c_count++;
			if  (c_count == token_num)
			{
					return idx;
			}
			c_idx=idx +1;
		}
	}
}
