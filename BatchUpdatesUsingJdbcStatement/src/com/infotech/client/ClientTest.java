package com.infotech.client;

import java.sql.Connection;
import java.sql.Statement;

import com.infotech.util.DBUtil;

public class ClientTest {

	public static void main(String[] args) {

		try(Connection connection = DBUtil.getConnection();Statement statement = connection.createStatement()) {
			String SQLINSERT = "INSERT INTO employee_table(employee_name,email,salary,date_of_joining,bonus) "
					+ "VALUES('Paul','paul.cs2009@yahoo.com',60000.00,'2017-05-17',400.00)";
			String UPDATESQL="UPDATE employee_table set email='martin.cs2017@yahoo.com' WHERE employee_id=1";
			String DELETESQL="DELETE FROM employee_table WHERE employee_id=20";

			statement.addBatch(SQLINSERT);
			statement.addBatch(UPDATESQL);
			statement.addBatch(DELETESQL);
			
			int[] executeBatch = statement.executeBatch();
			for (int i : executeBatch) {
				System.out.println(i);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
