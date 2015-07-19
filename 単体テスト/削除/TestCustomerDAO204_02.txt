package test;

import java.sql.Connection;
import java.sql.SQLException;

import common.SalesSystemException;

import dao.CustomerDAO;

public class TestCustomerDAO204_02 {

	private String custCode;
	private boolean flg = false;
	CustomerDAO customer = new CustomerDAO();

	Connection con = null;
	public static void main( String[] args ) throws SQLException, SalesSystemException {
		// TODO 自動生成されたメソッド・スタブ
		TestCustomerDAO204_02 test = new TestCustomerDAO204_02();
		test.initial();
		test.test();
	}
	public void initial() {
		custCode = "KA0001";
	}
	public void test() throws SQLException, SalesSystemException {
		System.out.println("----------conがnull状態でのテスト----------");
		try {
			flg = customer.deleteCustomer( custCode );
			if( flg ) {
				System.out.println("NG");
			} else {
				System.out.println("NG" );
			}
		} catch( NullPointerException e ) {
			System.out.println("con = " + con );
			System.out.println("OK");
		}
	}

}
