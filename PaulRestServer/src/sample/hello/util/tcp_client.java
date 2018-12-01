//tcp_client that is supposed to operate in conjunction with a tcp_server

package sample.hello.util;
import java.net.*;
import java.io.*;

public class tcp_client 
{
	BufferedReader input;
	PrintWriter output;
	String server_ip = "";
	InetAddress server_inet_addr=null;
	String server = "localhost";
	Socket socket = null;
	int port=0;
	boolean exit_c=false;
	boolean do_send=true;
	File_io fio=null;
    public static void main(String[] args) 
    {
		tcp_client tc = new tcp_client();
		tc.do_main(args);

	}
	public void do_main(String[] args)
	{
		BufferedReader key_b_input;
	    key_b_input = new BufferedReader(new InputStreamReader(System.in)); 
		String msg="";
		fio = new File_io("Even.data");
		for (int i = 1; i < args.length; i++)
		{
			String s = args[i];

			if (s.indexOf("SERVER_IP=") >=0) 
			{
				server_ip = SIT_UTIL.get_string_after_token(args[i], "=");
				try {
						server_inet_addr=InetAddress.getByName(server_ip);
				} catch (Exception e)
				{
					System.out.println("Error on getting Inet address for " + server_ip);
					server_inet_addr=null;
				}
				System.out.println("Server address =" + server_ip);
				continue;
			}
			if (s.indexOf("SERVER_PORT=") >=0) 
			{
				String s_port = SIT_UTIL.get_string_after_token(args[i], "=");
				try { 
	    			port = Integer.parseInt(s_port);
				} catch (Exception e)
				{
					System.out.println("Error on getting port value  " + s_port);
					System.exit(0);
				}
				System.out.println("Server port =" + port);
				continue;
			}
		}
		startup(server_ip, port);
		while(true) {
			try {
				msg = key_b_input.readLine();
				// stop if input line is "."
				if(msg.equals("GET OUT"))
				{
					send_data(msg);
					SIT_UTIL.sleep(1000);
					break;
				}
				send_data(msg);
			} catch (Exception e)
			{
				System.out.println("Error on reading std input");
				break;
			}
	    }
    }
	public tcp_client()
	{
	}
	public tcp_client(String svr_ip, int port, File_io p_fio)
	{
			fio=p_fio;
			startup(svr_ip,  port);
	}
	public void send_data(String msg)
	{
		if (do_send)
			output.println(msg);
	}
   	public void startup(String server_ip, int port)
	{

		try {
				server_inet_addr=InetAddress.getByName(server_ip);
		} catch (Exception e)
		{
			fio.log_data("Error on getting Inet address for " + server_ip);
			server_inet_addr=null;
		}
		try 
		{
			if (server_inet_addr!=null)
			{
	   			socket = new Socket(server_inet_addr, port);
	   			System.out.println("1 Connected with server " +
			   		socket.getInetAddress() +
			   		":" + socket.getPort());
			} else
			{
	   			socket = new Socket(server, port);
	   			System.out.println("2 Connected with server " +
			   		socket.getInetAddress() +
			   		":" + socket.getPort());
			} 
		}
		catch (Exception e) {
	    	System.out.println(e);
			exit_c=true;
		}
		if (!exit_c)
		{
			try {
	   		input = new BufferedReader (new InputStreamReader(socket.getInputStream()));
			output = new PrintWriter(socket.getOutputStream(),true);
			}
			catch (Exception e) {
	    		System.out.println("Error on getting IO" + e);
				do_send=false;
			}
		}
	}
	public void close_socket()
	{
		try {
	    	socket.close();
		}
		catch (IOException e) {
	    	System.out.println(e);
		}
   	}    
}
