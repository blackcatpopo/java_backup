package test;

import java.sql.Connection;
import java.sql.SQLException;

import manager.ConnectionManager;

import common.SalesSystemException;

import dao.CustomerDAO;

public class TestCustomerDAO204_01{

	CustomerDAO customer = new CustomerDAO();

	private String custCode;
	private String custName;
	private String custTelNo;
	private String custPostal;
	private String custAddress;
	private boolean flg = false;
	Connection con = null;

	public static void main( String[] args ) throws SQLException, SalesSystemException {

		TestCustomerDAO204_01 test = new TestCustomerDAO204_01();
		test.initial();
		test.test();
	}
	public void initial() {
		custCode = "KA0001";
	}

	public void test() throws SQLException, SalesSystemException {

		con = null;

		System.out.println("----------DELETEテスト----------");

		try {
			con = ConnectionManager.getConnection();
			customer = new CustomerDAO(con);
			flg = customer.deleteCustomer( custCode );
			if( flg ) {
				System.out.println("flg = " + flg );
				System.out.println("OK");
			} else {
				System.out.println("NG");
			}
		} catch ( SQLException e ) {
			System.out.println("NG");
		}
	}
}
