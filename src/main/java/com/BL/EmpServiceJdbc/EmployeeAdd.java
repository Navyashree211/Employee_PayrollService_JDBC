/*
 * Refactor UC8: Ability to also add to payroll details when a new Employee is added to the payroll.
 *               -Enable Cascading Delete in payroll_details table so when employee is 
 *                deleted the payroll entry is also automatically deleted.
 * 
 * @author : Navaya Shree
 * @since : 19-11-2020
 */
package com.BL.EmpServiceJdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeAdd {
	static PreparedStatement pstmt;
	static ResultSet rs;
	static Connection con;    
	
	 //Initializing queries for both tables
    public static final String INSERT_EMPLOYEE_QUERY = "insert into employee_payroll.employees_payrolls (name, salary, start, gender) values(?,?,?,? )";

    public static final String INSERT_PAYROLL_QUERY = "insert into employee_payroll.payroll_details (id, basic_pay, deductions, taxable_pay, tax, net_pay) values (?,?,?,?,?,?)";


    public static void main(String[] args) throws Exception {

        try {

            con = ConnectionDB.createCP();
            //setting AutoCommit false
            con.setAutoCommit(false);

            //adding new employee details using transaction
            insertEmployeeDetail(con,"Joya",1325460,"2020-07-10","F");
            insertPayrollData(con,19, 4839992, 70983,18839,38322,13737);

            //now commit transaction
            con.commit();

        }catch (SQLException e) {
            e.printStackTrace();
            try {
                con.rollback();
                System.out.println("JDBC Transaction rolled back successfully");
            } catch (SQLException e1) {
                System.out.println("SQLException in rollback"+e.getMessage());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


    private static void insertPayrollData(Connection connection,  int id, double basic_pay, double deductions, double taxable_pay, double tax, double net_pay) throws SQLException {
        pstmt = con.prepareStatement(INSERT_PAYROLL_QUERY);
        pstmt.setInt(1, id);
        pstmt.setDouble(2, basic_pay);
        pstmt.setDouble(3, deductions);
        pstmt.setDouble(4, taxable_pay);
        pstmt.setDouble(5, tax);
        pstmt.setDouble(6, net_pay);


        pstmt.executeUpdate();

        System.out.println("Payroll Data inserted successfully for Basic_Pay=" + basic_pay);
        pstmt.close();

    }


    private static void insertEmployeeDetail( Connection con2, String name, double salary,
                                             String start, String gender) throws SQLException {
        pstmt = con.prepareStatement(INSERT_EMPLOYEE_QUERY);
        pstmt.setString(1, name);
        pstmt.setDouble(2, salary);
        pstmt.setDate(3, java.sql.Date.valueOf(start));
        pstmt.setString(4, gender);

        pstmt.executeUpdate();

        System.out.println("Employee Data inserted successfully for Salary =" + salary);
        pstmt.close();
        //cascadingdelete();
    }

    public static void cascadingdelete() throws SQLException {

        try {

            String query = "Delete from employee_payroll.payroll_details where Id =15";

            con = ConnectionDB.createCP();
            
            pstmt= con.prepareStatement(query);
            pstmt.executeUpdate();
            System.out.println(" Record deleted!");
        }catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(con != null) {
                con.close();
            }
            if(pstmt != null) {
                pstmt.close();
            }
        }

    }

	
}
