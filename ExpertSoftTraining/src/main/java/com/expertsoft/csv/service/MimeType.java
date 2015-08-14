package com.expertsoft.csv.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;


public class MimeType {
	public static List<String> getMimeTypes() {
		List<String> result = new ArrayList<String>();
		ResourceBundle resource = ResourceBundle.getBundle("mimeType");
		result = Arrays.asList(resource.getString("mime").split(","));
		return result;
	}
	
	
}