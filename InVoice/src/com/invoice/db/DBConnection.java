package com.invoice.db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Hardik Shah
 */
public class DBConnection {

	Connection weAppDBConnection = null;
	Connection invoiceAppDBConnection = null;

	public Connection getWebAppDBConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		weAppDBConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fl_local", "root", "");
		return weAppDBConnection;
	}

	public Connection getInvoiceAppDBConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		invoiceAppDBConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/invoice", "root", "");
		return invoiceAppDBConnection;
	}

	public static void main(String[] args) {
		DBConnection dbConnection = new DBConnection();
		try {
			dbConnection.getWebAppDBConnection();
			dbConnection.getInvoiceAppDBConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}