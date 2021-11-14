/*
 * UC2:- Ability for Employee_Payroll_Service to retrieve the EmployeePayroll from the database. 
 * 
 * @author : Navaya Shree
 * @since : 13-11-2021
 */
package com.BL.EmpServiceJdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDB {
	static Statement stmt;
	static Connection con;
	static ResultSet rs;

	public static void main(String[] args) throws Exception {

		String qry = "select * from employee_payroll.payroll_service";
		try {
			System.out.println("Driver Class Loaded");

			con = ConnectionDB.createCP();
			System.out.println("Connetion Establish with db server");

			stmt = con.createStatement();

			rs = stmt.executeQuery(qry);

			System.err.println("id-> " + "EmployeesName-> " + "mobileNumber-> " + "address-> " + "       department-> "
					+ "gender-> " + " basic_pay-> " + "deductions-> " + "taxable_pay-> " + "tax-> " + "met_pay-> "
					+ "start");

			while (rs.next()) {
				int id = rs.getInt("Id");
				String EmployeesName = rs.getString(2);
				long mobileNumber = rs.getLong(3);
				String address = rs.getString(4);
				String department = rs.getString(5);
				String gender = rs.getString(6);
				double basic_pay = rs.getDouble(7);
				double deductions = rs.getDouble(8);
				double taxable_pay = rs.getDouble(9);
				double tax = rs.getDouble(10);
				double met_pay = rs.getDouble(11);
				Date start = rs.getDate(12);

				System.out.println();

				System.out.println(id + "->" + EmployeesName + "->" + mobileNumber + "->" + address + "->" + department
						+ "->" + gender + "->" + basic_pay + "->" + deductions + "->" + taxable_pay + "->" + tax + "->"
						+ met_pay + "->" + start);
			}

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
			if (stmt != null) {
				try {
					stmt.close();

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
		}

	}

}