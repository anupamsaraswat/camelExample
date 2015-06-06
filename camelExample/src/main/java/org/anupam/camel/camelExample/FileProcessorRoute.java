package org.anupam.camel.camelExample;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.camel.builder.RouteBuilder;

public class FileProcessorRoute extends RouteBuilder{

	private Properties defaultProps = new Properties();
	@Override
	public void configure() throws Exception {
		String userDir = System.getProperty("user.dir");
		FileInputStream in = new FileInputStream(userDir+"/application.properties");
		defaultProps.load(in);
		in.close();
				
		//from("file:"+defaultProps.getProperty("outputDir")+"?noop=true&fileName=example")
		try{
		from(buildFtpURI())
		.to("file:"+defaultProps.getProperty("outputDir"));
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	private String buildFtpURI(){
		StringBuilder ftpURI = new StringBuilder("ftp://");
		ftpURI.append(defaultProps.get("ftpSite"));
		ftpURI.append("?");
		ftpURI.append("username="+defaultProps.get("ftpUser")+"&");
		ftpURI.append("password="+defaultProps.get("ftpPwd"));
		System.out.println(ftpURI);
		return ftpURI.toString();
	}

}
