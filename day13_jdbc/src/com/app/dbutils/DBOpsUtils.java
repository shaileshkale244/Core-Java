package com.app.dbutils;

import static com.app.utils.DBUtils.openConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DBOpsUtils {
	// 1. Display all users(not admin) details born between specified dates.
	public static void dissplayBornBetween(Scanner sc) throws Exception {
		try (Connection cn = openConnection();
				PreparedStatement pst = cn.prepareStatement("select * from users where role <> ? and dob between ? and ?");) {
			System.out.println("enter date1 and date2");
			pst.setString(1, "admin");
			pst.setDate(2, Date.valueOf(sc.next()));
			pst.setDate(3, Date.valueOf(sc.next()));
			try (ResultSet res = pst.executeQuery()) {
				System.out.printf("Id  \t Name  \t Email  \t Passwd  \t DOB \t Status  \t Role \n");
				while (res.next()) {
					System.out.printf("%d \t %s %s \t %s \t %s \t%s \t%b \t%s \n", res.getInt(1), res.getString(2),
							res.getString(3), res.getString(4), res.getString(5), res.getDate(6), res.getBoolean(7),
							res.getString(8));
				}
			}

		}

	}

//2. Register new customer
	public static void addNewUser(Scanner sc) throws Exception {
		try(Connection cn = openConnection();
				//INSERT INTO `iacsd_mar24`.`users` (`first_name`, `last_name`, `email`, `password`, `dob`, `status`, `role`) VALUES ('shailesh', 'kale', 'sk@gmail.com', 'sk#123', '1996-04-01', '0', 'voter');
				PreparedStatement pst = cn.prepareStatement("insert into users(first_name, last_name, email, password, dob, status, role) values (?,?,?,?,?,?,?)")){
			System.out.println(" Enter first_name, last_name, email, password, dob, status, role:");
			pst.setString(1, sc.next());
			pst.setString(2, sc.next());
			pst.setString(3, sc.next());
			pst.setString(4, sc.next());
			pst.setDate(5, Date.valueOf(sc.next()));
			pst.setBoolean(6, sc.nextBoolean());
			pst.setString(7, sc.next());
			
			int i=pst.executeUpdate();
			System.out.println(i);
		}
	}
}
