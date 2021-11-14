/*
 * UC4:- Ability to update the salary i.e. the base pay for 
 *       Employee Terisa to 3000000 Database using JDBC PreparedStatement. 
 * 
 * @author : Navaya Shree
 * @since : 13-11-2021
 */
package com.BL.EmpServiceJdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeTableUpdate {
	static PreparedStatement pstmt;
	static Connection con;
	static ResultSet rs;

	public static void main(String[] args) throws Exception {
		String qry = "update employee_payroll.payroll_service set basic_pay=3000000.00 where name='Terisa'";
		try {
			System.out.println("Driver Class Loaded");

			con = ConnectionDB.createCP();

			System.out.println("Connetion Establish with db server");

			pstmt = con.prepareStatement(qry);
			System.out.println("Data Update");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
			if (pstmt != null) {
				try {
					pstmt.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
			System.out.println("Closed All Resources");
		}

	}
}