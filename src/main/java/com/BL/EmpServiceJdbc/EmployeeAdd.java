/*
 * UC7: Ability to add a new Employee to the Payroll .
 *     - Ensure DB Operation is successful then only add EmployeePayroll Data
 *       to the List.
 * 
 * @author : Navaya Shree
 * @since : 18-11-2020
 */
package com.BL.EmpServiceJdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeAdd {
	static PreparedStatement pstmt;
	static Scanner sc = new Scanner(System.in);
	static Scanner sc2 = new Scanner(System.in);
	static Scanner sc3 = new Scanner(System.in);
	static ResultSet rs;
	static Connection con;

	public static void insertData() throws Exception {

		String qry = "insert into employee_payroll.payroll_service(id,name, phone_number, address, department, gender, basic_pay, deductions, taxable_pay, tax, met_pay, start) values(?,?,?,?,?,?,?,?,?,?,?,?)";

		try {

			con = ConnectionDB.createCP();


			pstmt = con.prepareStatement(qry);
			System.out.println("Platform Created");

			System.out.println("Enter id:");

			int id = sc2.nextInt();
			pstmt.setInt(1, id);

			System.out.println("Enter Name:");
			String name = sc.nextLine();
			pstmt.setString(2, name);

			System.out.println("Enter Phone Number:");
			long ph = sc2.nextLong();
			pstmt.setLong(3, ph);

			System.out.println("Enter Current Address:");
			String department = sc.nextLine();
			pstmt.setString(4, department);

			System.out.println("Enter Department:");
			String address = sc.nextLine();
			pstmt.setString(5, address);

			System.out.println("Enter Your Gender:");
			String gender = sc.nextLine();
			pstmt.setString(6, gender);

			System.out.println("Enter Your Basic Pay:");
			Double basic_pay = sc3.nextDouble();
			pstmt.setDouble(7, basic_pay);

			System.out.println("Enter Your Deductions:");
			Double deductions = sc3.nextDouble();
			pstmt.setDouble(8, deductions);

			System.out.println("Enter Your Tax pay:");
			Double taxable_pay = sc3.nextDouble();
			pstmt.setDouble(9, taxable_pay);

			System.out.println("Enter Your Tax:");
			Double tax = sc3.nextDouble();
			pstmt.setDouble(10, tax);

			System.out.println("Enter Your met_pay:");
			Double met_pay = sc3.nextDouble();
			pstmt.setDouble(11, met_pay);

			System.out.println("Enter Your Joning Date:");
			String start = sc.nextLine();
			////pstmt.setString(12, null);
			 pstmt.setDate(12, java.sql.Date.valueOf(start));

			pstmt.executeUpdate();
			System.out.println("Congrats! Data Inserted Successfully!!!!");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<Employee> fetchDataList() throws Exception {

		List<Employee> details = new ArrayList<>();
		String qry = "select * from employee_payroll.payroll_service";

		try {

			con = ConnectionDB.createCP();

			pstmt = con.prepareStatement(qry);

			rs = pstmt.executeQuery();

			System.err.println("id-> " + "EmployeesName-> " + "mobileNumber-> " + "address-> " + "       department-> "
					+ "gender-> " + " basic_pay-> " + "deductions-> " + "taxable_pay-> " + "tax-> " + "met_pay-> "
					+ "start");

			while (rs.next()) {
				Employee info = new Employee();

				int id = rs.getInt(1);
				info.setId(id);

				String EmployeesName = rs.getString(2);
				info.setName(EmployeesName);

				long mobileNumber = rs.getLong(3);
				info.setPhone_number(mobileNumber);

				String address = rs.getString(4);
				info.setAddress(address);

				String department = rs.getString(5);
				info.setDepartment(department);

				String gender = rs.getString(6);
				info.setGender(gender);

				double basic_pay = rs.getDouble(7);
				info.setBasic_pay(basic_pay);

				double deductions = rs.getDouble(8);
				info.setDeductions(deductions);

				double taxable_pay = rs.getDouble(9);
				info.setTaxable_pay(taxable_pay);

				double tax = rs.getDouble(10);
				info.setTax(tax);

				double met_pay = rs.getDouble(11);
				info.setMet_pay(met_pay);

			   String start = rs.getString(12);
				info.setStart(start);

				details.add(info);
				
				//System.out.println("All Data " + info);
				System.out.println(info.toString());

				System.out.println();

//				System.out.println(id + "->" + EmployeesName + "->" + mobileNumber + "->" + address + "->" + department
//						+ "->" + gender + "->" + basic_pay + "->" + deductions + "->" + taxable_pay + "->" + tax + "->"
//						+ met_pay + "->" + start);

			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return details;
	}

	public static void main(String[] args) throws Exception {

		int i=0;
		while (i == 0) {
			System.out.println("Do you would like to continue?: ");
            System.out.println("Press 1 to Insert Data\nPress 2 to Reterive data");

			int choice = sc2.nextInt();

			switch (choice) {
			case 1:
				insertData();
				break;
			case 2:
				fetchDataList(); 
				break;
			default:
				i = 1;
				System.out.println(" Enter a valid choice");
				break;
			}
		}

	}
}
