package com.bdns.source;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.bdns.resources.StringES;

public class Download {
	
	 public static void downloadSource() throws IOException{
		 
		 URL url = new URL(StringES.URL_SOURCE);
		 HttpURLConnection http = (HttpURLConnection) url.openConnection();
		 http.setConnectTimeout(300000);
		 http.setReadTimeout(300000);
		 
		 int responseCode = http.getResponseCode();
		 
		 if(responseCode == HttpURLConnection.HTTP_OK) {
			 InputStream inputStream = http.getInputStream();
			 FileOutputStream outputStream = new FileOutputStream(StringES.DESTINATION_FILE);
			 
			 int byteRead = -1;
			 byte[] buffer = new byte[1024];
			 while((byteRead= inputStream.read(buffer)) != -1) {
				 outputStream.write(buffer, 0, byteRead);
			 }
			 
			 outputStream.close();
			 inputStream.close();
		 }
		 http.disconnect();
		 
    }
	
}
