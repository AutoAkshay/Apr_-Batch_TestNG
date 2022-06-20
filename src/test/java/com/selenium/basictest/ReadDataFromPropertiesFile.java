package com.selenium.basictest;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadDataFromPropertiesFile {

	public static void main(String[] args) throws Exception {

		FileInputStream fi = new FileInputStream(".\\Config\\config.properties");

		Properties prop = new Properties();
		prop.load(fi);

		String browser = prop.getProperty("browser");
		String fd_url = prop.getProperty("url_fd");

		fi.close();

	}

}
