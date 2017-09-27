package com.lift.rest.server;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import org.apache.commons.io.FileUtils;

@Path("/rest")
public class RestRequestHandler {

	private static File logfile;
	private static long counter; 
	private static Calendar cal;
	private static SimpleDateFormat sdf ;
	static {
		counter = 0; 
		String filePath;
		cal = Calendar.getInstance();
		sdf = new SimpleDateFormat("YYYYMMDDHHmmssSSS");
		String time = sdf.format(cal.getTime());
		sdf = new SimpleDateFormat("YYYY/MM/DD HH:mm:ss:SSS");
		if(System.getProperty("os.name").equalsIgnoreCase("linux")) {
			filePath = "/root/Desktop/liftrest" + time + ".log";
		}else {
			filePath = "C:\\Users\\mulna01\\desktop\\liftrest" + time + ".log";
		}
		
		logfile = new File(filePath);
	}
	@Context
	private HttpServletResponse httpResponse;
	
	@Context
	private HttpServletRequest httpRequest;
	
	@Context 
	private HttpHeaders httpHeaders;
	


    @GET
    @Path("v1/{param}")
    public String testServer(@PathParam("param") String param) throws IOException {
    	FileUtils.writeStringToFile(logfile, ++counter + " "+sdf.format(cal.getTime()) + " " + param + "\n" , java.nio.charset.Charset.defaultCharset(), true);
    	return "Server Response :" + param;
    	
    }
 
}
