package sample.hello.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import sample.hello.util.*;


@Path("/")
public class HelloResource {

	
	
//File_io fio = new File_io("EVENT.log");
// http://192.168.1.101:8080/rest/rest/showhtml
	@Path("index")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public Response get_html1() {
		System.out.println("SHOW Index");
		String html_str = " <!DOCTYPE html> <html> <head> <title>Hello, This is Paul</title> </head> <body> Hello, this is Paul, today is 11/8/2018 and the time is " + time_util.get_time()+ "</body> </html> ";

			 return Response.status(200).entity(html_str).build();
	}
	
	
	@Path("hello") //loads up a page I created for Udacity's Nanodegree program
	@GET
	@Produces(MediaType.TEXT_HTML)
	public Response get_html() {
		System.out.println("SHOW Hello");
		
		

		String html_str = SIT_UTIL.string_builder("/Program Files/Apache Software Foundation/Tomcat 8.5/webapps/rest/WEB-INF/classes/sample/hello/resources/Paul's Udacity Nanodegree Project.txt");

			 return Response.status(200).entity(html_str).build();
	}
	
	
	
	

}
