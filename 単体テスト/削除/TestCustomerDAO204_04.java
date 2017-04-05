package test;

import java.sql.Connection;
import java.sql.SQLException;

import manager.ConnectionManager;

import common.SalesSystemException;

import dao.CustomerDAO;

public class TestCustomerDAO204_04 {

	private String custCode;
	private boolean flg = false;
	CustomerDAO customer = new CustomerDAO();

	Connection con = null;
	public static void main( String[] args ) throws SQLException, SalesSystemException {
		// TODO 自動生成されたメソッド・スタブ
		TestCustomerDAO204_04 test = new TestCustomerDAO204_04();
		test.initial();
		test.test();
	}
	public void initial() {
		custCode = "KA0002";
	}
	public void test() throws SQLException, SalesSystemException {
		System.out.println("----------SQL文が間違っているなどSQLExceptionテスト----------");
		try {
			con = ConnectionManager.getConnection();
			customer = new CustomerDAO(con);
			flg = customer.deleteCustomer( custCode );
		} catch( SQLException e ) {
			e.printStackTrace();
			System.out.println("OK");
		}
	}
}
