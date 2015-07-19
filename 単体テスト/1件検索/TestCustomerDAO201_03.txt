package test;

import java.sql.Connection;
import java.sql.SQLException;

import common.SalesSystemException;

import dao.CustomerDAO;
import entity.Customer;

public class TestCustomerDAO201_03 {


	private String custCode;
	Connection con = null;
	Customer customer = null;
	CustomerDAO customerdao = null;

	public static void main( String[] args ) throws SQLException, SalesSystemException {
		TestCustomerDAO201_03 test = new TestCustomerDAO201_03();
		test.initial();
		test.test();
	}
	public void initial() {
		custCode = "KA9999";
	}

	public void test() throws SQLException, SalesSystemException {

		con = null;

		System.out.println("----------findCustomerテスト----------");

		try {
			customerdao = new CustomerDAO(con);
			customer = customerdao.findCustomer( custCode );
			if( customer != null ) {
				System.out.println("得意先コード = " + customer.getCustCode());
				System.out.println("得意先名 = " + customer.getCustName());
				System.out.println("電話番号 = " + customer.getTelNo());
				System.out.println("郵便番号 = " + customer.getPostalCode());
				System.out.println("住所 = " + customer.getAddress());
				System.out.println("NG");
			} else {
				System.out.println("customer = " + customer);
				System.out.println("NG");
			}
		} catch (NullPointerException e) {
			System.out.println("con = " + con );
			System.out.println("OK");
		} catch ( SQLException e ) {
			System.out.println("NG");
		}
	}
}
