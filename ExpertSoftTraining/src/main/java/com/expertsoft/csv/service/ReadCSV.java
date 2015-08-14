package com.expertsoft.csv.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.expertsoft.csv.entity.Contact;

public class ReadCSV {
	public static final Logger logger = Logger.getLogger(ReadCSV.class);
	
	
	public List<Contact> getContactListFromCVS(InputStream is) {
		List<Contact> list = new ArrayList<Contact>();
		String line = "";
		String cvsSplitBy = "[,;]";
		try (BufferedReader br = new BufferedReader(new InputStreamReader(is));) {
			while ((line = br.readLine()) != null) {
				String[] contact = line.split(cvsSplitBy);
				list.add(new Contact(contact[0], contact[1], contact[2], contact[3], Integer.parseInt(contact[4])));
			}
		} catch (FileNotFoundException e) {
			logger.warn("file not found");
		} catch (IOException e) {
			logger.error("IOException in getContactListFromCVS()");
		}

		return list;
	}

}