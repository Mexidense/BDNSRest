package com.bdns.source;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import com.bdns.source.Download;

import com.bdns.resources.StringES;

public class DownloadTest {
	
	@Before
	public void deleteSource() {
		File file = new File(StringES.DESTINATION_FILE);
		if(file.exists())
			file.delete();
	}

	@Test
	public void downloadFile() {
		try {
			Download.downloadSource();
			File file = new File(StringES.DESTINATION_FILE);
			if(file.exists())
				Assert.assertTrue(true);
			else
				Assert.assertTrue(false);
			
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}
}
