/*
 * UC8: Ability to also add to payroll details when a new Employee is added to the payroll.
 *      -Create payroll_details table in the database. 
 *      -All the payroll fields are derived fields from the salary. assumption is Deduction is 20% of salary, taxable pay is salary - deductions, tax is 10% of 
 *      taxable pay and net pay is salary - tax .
 * 
 * @author : Navaya Shree
 * @since : 19-11-2020
 */
package com.BL.EmpServiceJdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeAdd {
	static PreparedStatement pstmt;
	static Scanner sc = new Scanner(System.in);
	static Scanner sc2 = new Scanner(System.in);
	static Scanner sc3 = new Scanner(System.in);
	static ResultSet rs;
	static Connection con;

	public static void insertData() throws Exception {


        String qry = "insert into employee_payroll.employees_payrolls (name, salary, start, gender) values(?,?,?,? )";
		
		try {

			con = ConnectionDB.createCP();


			pstmt = con.prepareStatement(qry);
			System.out.println("Platform Created");

			System.out.println("Enter Name:");
			String name = sc.nextLine();
			pstmt.setString(1, name);
			
			System.out.println("Enter Your Salary:");
			Double salary = sc3.nextDouble();
			pstmt.setDouble(2, salary);
			
			System.out.println("Enter Your Joning Date:");
			String start = sc.nextLine();
			 pstmt.setDate(3, java.sql.Date.valueOf(start));

			System.out.println("Enter Your Gender:");
			String gender = sc.nextLine();
			pstmt.setString(4, gender);

			pstmt.executeUpdate();
			System.out.println("Congrats! Data Inserted Successfully!!!!");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		String qry1 = "insert into employee_payroll.payroll_details (id, basic_pay, deductions, taxable_pay, tax, net_pay) values (?,?,?,?,?,?)";

		try {

			con = ConnectionDB.createCP();

			pstmt = con.prepareStatement(qry1);
			System.out.println("Platform Created");

			System.out.println("Enter Employee ID:");
			int id = sc2.nextInt();
			pstmt.setInt(1, id);
			
			System.out.println("Enter Basic_pay:");
			Double basic_pay = sc3.nextDouble();
			pstmt.setDouble(2, basic_pay);
			
			 double deductions = basic_pay * 0.2;
			 pstmt.setDouble(3, deductions);
			 
	          double taxable_pay = basic_pay - deductions;
	          pstmt.setDouble(4, taxable_pay);
	          
	          double tax = taxable_pay * 0.1;
	          pstmt.setDouble(5, tax);
	          
	          double net_pay = basic_pay - tax;
	          pstmt.setDouble(6,net_pay);
	          
	          pstmt.executeUpdate();
				System.out.println("Congrats! Data Inserted Successfully!!!!");
						
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		 EmployeeAdd.insertData();
		
	}
}
