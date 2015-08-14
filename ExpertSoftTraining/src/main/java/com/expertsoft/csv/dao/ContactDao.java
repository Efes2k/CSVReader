package com.expertsoft.csv.dao;

import java.sql.SQLException;
import java.util.List;

import com.expertsoft.csv.entity.Contact;

public interface ContactDao  {

	void saveContacts(Contact contacts) throws SQLException;
	List<Contact> selectAll(int offset, int noOfRecords, String order, String field) throws SQLException;
	int getNoOfRecords();
	
}
