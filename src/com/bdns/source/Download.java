package com.bdns.source;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import com.bdns.resources.StringES;

public class Download {
	
	 public static void downloadSource() throws IOException{
	        URL url = new URL(StringES.URL_SOURCE);
	        
	        url.openConnection();
	        BufferedInputStream bis = new BufferedInputStream(url.openStream());
	        FileOutputStream fis = new FileOutputStream(StringES.DESTINATION_FILE);
	        byte[] buffer = new byte[1024];
	        int count=0;
	        while((count = bis.read(buffer,0,1024)) != -1)
	        {
	            fis.write(buffer, 0, count);
	        }
	        fis.close();
	        bis.close();
    }
	
}
