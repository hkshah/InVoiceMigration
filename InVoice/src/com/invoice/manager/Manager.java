package com.invoice.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.invoice.db.DBConnection;

/**
 * @author Hardik Shah
 *
 */
public class Manager {

	private static HashMap<String, Integer> ownerMap = new HashMap<String, Integer>();
	private static HashMap<String, Integer> customerMap = new HashMap<String, Integer>();
	private static ArrayList<String> exceptionList = new ArrayList<String>();

	public static void main(String[] args) {
		try {
			Manager manager = new Manager();
			manager.getOwnerInfo();
			manager.getCustomerInfo();
			for (Map.Entry<String, Integer> entry : ownerMap.entrySet()) {
				if (customerMap.containsKey(entry.getKey())) {
					System.out.println("UPDATE Owner SET fbClientID = " + customerMap.get(entry.getKey())
							+ " WHERE id = " + entry.getValue() + ";");
				} else {
					exceptionList.add(entry.getKey());
				}
			}
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("Owners with no fb Client Id are : ");
			for (String string : exceptionList) {
				System.out.println(string);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getOwnerInfo() throws Exception {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		connection = new DBConnection().getWebAppDBConnection();
		String query = "SELECT o.id , CONCAT(p.firstName, ' ',p.lastName) as name FROM Owner o left join Person p on p.id = o.personId order by o.id";
		ps = connection.prepareStatement(query);
		rs = ps.executeQuery();
		while (rs.next()) {
			ownerMap.put(rs.getString("name"), rs.getInt("id"));
		}

	}

	private void getCustomerInfo() throws Exception {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		connection = new DBConnection().getInvoiceAppDBConnection();
		String query = "SELECT CONCAT(customer_first_name , ' ',customer_last_name) as name, fb_client_id as id FROM invoice.customer_info";
		ps = connection.prepareStatement(query);
		rs = ps.executeQuery();
		while (rs.next()) {
			customerMap.put(rs.getString("name"), rs.getInt("id"));
		}
	}
}
/*
 * ALTER TABLE `Owner` ADD COLUMN `fbClientId` int(11) NULL DEFAULT NULL AFTER
 * `userId`, ADD UNIQUE INDEX `fbClientId_UNIQUE` (`fbClientId` ASC);
 * 
 */