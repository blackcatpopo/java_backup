package test;

import java.sql.Connection;
import java.sql.SQLException;

import manager.ConnectionManager;

import common.SalesBusinessException;
import common.SalesSystemException;

import dao.CustomerDAO;

public class TestCustomerDAO204_03 {

	private String custCode;
	private boolean flg = false;
	CustomerDAO customer = new CustomerDAO();

	Connection con = null;
	public static void main( String[] args ) throws SQLException, SalesSystemException, SalesBusinessException {
		// TODO 自動生成されたメソッド・スタブ
		TestCustomerDAO204_03 test = new TestCustomerDAO204_03();
		test.initial();
		test.test();
	}
	public void initial() {
		custCode = "KA0001";
	}
	public void test() throws SQLException, SalesSystemException, SalesBusinessException {
		System.out.println("----------存在しない得意先コードを削除しようとした場合のテスト----------");
		try {
			con = ConnectionManager.getConnection();
			customer = new CustomerDAO(con);
			flg = customer.deleteCustomer( custCode );
			if( flg ) {
				System.out.println( "NG" );
			} else {
				System.out.println( "OK" );
			}
		} catch( SQLException e ) {
			System.out.println("NG");
		}
	}
}
