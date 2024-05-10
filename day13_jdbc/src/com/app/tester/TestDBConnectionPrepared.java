package com.app.tester;

import static com.app.utils.DBUtils.openConnection;
import static com.app.dbutils.DBOpsUtils.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class TestDBConnectionPrepared {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in);
				// get DB connection
				Connection cn = openConnection();
				// create Precompiled statement
				PreparedStatement pst = cn.prepareStatement("select * from users where email=? and password=?");

		) {
			System.out.println("Enter email and password");
			pst.setString(1, sc.next());
			pst.setString(2, sc.next());
			try (// creating a result for resultset of sql Select query
					ResultSet res = pst.executeQuery()) {
				if (!res.next())
					System.out.println("Invalid Credentials!!!!!!!");
				System.out.println("Hello! " + res.getString(2) + " " + res.getString(3));
			}
			//dissplayBornBetween(sc);
			System.out.println("Adding new user");
			addNewUser(sc);
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
