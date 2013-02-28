package com.tsystems.javaschool.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;

/**
 * Search for trains going from station A to station B in a fixed time interval
 * 
 * @author Alexander Markov
 */
public class TrainSearchService {

	private final static Logger logger = Logger
			.getLogger(TrainSearchService.class);
	
	private final static String className = TrainSearchService.class.getSimpleName();

	public static ServiceResponse service(ServiceRequest request) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		StringBuilder strBuilder = new StringBuilder();
		// List<?> parameters = request.getParameters();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			logger.error(className + ": com.mysql.jdbc.Driver class could not be instantiated");
		} catch (IllegalAccessException e) {
			logger.error("com.mysql.jdbc.Driver class is not accessible");
		} catch (ClassNotFoundException e) {
			logger.error("com.mysql.jdbc.Driver class could not be located");
		}
		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost/railway", "rwclient", "db13RWAY");
			statement = connection
					.prepareStatement("SELECT name FROM Stations ORDER BY name ASC");
			// statement.setInt(1, (Integer) parameters.get(0));
			result = statement.executeQuery();
			// ResultSetMetaData md = rs.getMetaData();
			// md.getColumnCount();md.getColumn(1);
			System.out.println("Stations:");
			while (result.next()) {
				System.out.println(result.getString(1));
				strBuilder.append(result.getString(1) + "\n");
			}
		} catch (SQLException e) {
			logger.error("DB connection error");
			return new ServiceResponse("", false);
		} finally {
			if (result != null) {
				try {
					result.close();
				} catch (SQLException e) {
					logger.error("Could not close result set");
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					logger.error("Could not close statement");
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					logger.error("Could not close connection");
				}
			}
		}
		return new ServiceResponse(strBuilder.toString(), true);
	}
} // class TrainSearchService