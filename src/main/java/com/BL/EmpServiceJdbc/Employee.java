package com.BL.EmpServiceJdbc;

import java.sql.Date;

public class Employee {    

	int id;
     String name, address, gender,start, department;
	double  basic_pay, deductions, taxable_pay, tax, met_pay;   
	long phone_number;
	//Date start;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getBasic_pay() {
		return basic_pay;
	}
	public void setBasic_pay(double basic_pay) {
		this.basic_pay = basic_pay;
	}
	public double getDeductions() {
		return deductions;
	}
	public void setDeductions(double deductions) {
		this.deductions = deductions;
	}
	public double getTaxable_pay() {
		return taxable_pay;
	}
	public void setTaxable_pay(double taxable_pay) {
		this.taxable_pay = taxable_pay;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	public double getMet_pay() {
		return met_pay;
	}
	public void setMet_pay(double met_pay) {
		this.met_pay = met_pay;
	}
	public long getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}
	
	
	
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + ", start=" + start + ", gender="
				+ gender + ", department=" + department + ", basic_pay=" + basic_pay + ", deductions=" + deductions
				+ ", taxable_pay=" + taxable_pay + ", tax=" + tax + ", met_pay=" + met_pay + ", phone_number="
				+ phone_number + "]";
	}
	
	
	
//	public Employee(int id, String name, String address, String start, double phone_number, double basic_pay) {
//		this.id = id;
//		this.name = name;
//		this.address = address;
//		this.start = start;
//		this.phone_number = phone_number;
//		this.basic_pay = basic_pay;
//	}

	
	
	}
     	
