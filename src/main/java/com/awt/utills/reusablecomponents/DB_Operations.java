package com.awt.utills.reusablecomponents;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import com.awt.testbase.MyLogger;
import com.mysql.cj.jdbc.result.ResultSetMetaData;

/**
 * @author Ankit Yadav
 */
public class DB_Operations {
	/**
	 * this method is used to read a data from the data pase you need to pass only
	 * query
	 *
	 * @param query
	 * @return Requested column name with  column data
	 */
	public static synchronized HashMap<String, String> getResultDataFromFromDataBase(String query) {
		HashMap<String, String> data = new HashMap<>();

		try {
			// for connection to my sql
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://http://13.235.137.100:81/phpmyadmin/sql.php?server=1&db=oms&table=geomapapi_site_d&pos=0",
					PropertiesOperations.getPropertyValueByKey("DATABASENAME"),
					PropertiesOperations.getPropertyValueByKey("DATABASEPASSWORD"));
			Statement st = con.createStatement();
			ResultSet result = st.executeQuery(query);
			ResultSetMetaData meta_data = (ResultSetMetaData) result.getMetaData();

			while (result.next()) {
				for (int i = 1; 1 <= meta_data.getColumnCount(); i++) {
					data.put(meta_data.getColumnClassName(i), result.getString(i));
				}
			}

		} catch (Exception e) {
			MyLogger.info("❌ DATABASE CONNECTION FAILURE! PLEASE CHECK YOUR CONNECTION PARAMETERS AND SERVER STATUS. ❌",
					e);
		}
		return data;

	}
}
