package com.tsystems.javaschool.serverappl.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import com.tsystems.javaschool.common.ServiceRequest;
import com.tsystems.javaschool.common.ServiceResponse;

/**
 * Search for trains going from station A to station B in a fixed time interval
 * 
 * @author Alexander Markov
 */
public class JDBCService {

	private final static Logger logger = Logger.getLogger(JDBCService.class);

	private final static String className = JDBCService.class.getSimpleName();

	public static ServiceResponse service(ServiceRequest request) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		StringBuilder strBuilder = new StringBuilder();
		// List<?> parameters = request.getParameters();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			logger.error(className
					+ ": com.mysql.jdbc.Driver class could not be instantiated");
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
			return new ServiceResponse(false, null, "SQL exception");
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
		List<String> data = Collections.emptyList();
		data.add(strBuilder.toString());
		return new ServiceResponse(true, data, null);
	}
} // class TrainSearchService