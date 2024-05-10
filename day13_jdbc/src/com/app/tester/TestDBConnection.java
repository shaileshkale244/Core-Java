package com.app.tester;

import static com.app.utils.DBUtils.openConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDBConnection {

	public static void main(String[] args) {
		try (
				// get DB connection
				Connection cn = openConnection();
				// create empty statement
				Statement st = cn.createStatement();

				// creating a result for resultset of sql Select query
				ResultSet res = st.executeQuery("select * from users");) {

			// System.out.println("connected to DB " + cn);
			System.out.printf("Id  \t Name  \t Email  \t Passwd  \t DOB \t Status  \t Role \n");

			while (res.next()) {
				System.out.printf("%d \t %s %s \t %s \t %s \t%s \t%b \t%s \n", res.getInt(1), res.getString(2),
						res.getString(3), res.getString(4), res.getString(5), res.getDate(6), res.getBoolean(7),
						res.getString(8));
			}

		} // JVM : cn.close()
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
