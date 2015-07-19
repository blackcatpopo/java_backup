package test;

import java.sql.Connection;
import java.sql.SQLException;

import manager.ConnectionManager;

import common.SalesSystemException;

import dao.CustomerDAO;

public class TestCustomerDAO203_03 {

	private String custCode;
	private String custName;
	private String custTelNo;
	private String custPostal;
	private String custAddress;
	private boolean flg = false;
	CustomerDAO customer = new CustomerDAO();

	Connection con = null;
	public static void main( String[] args ) throws SQLException, SalesSystemException {
		// TODO 自動生成されたメソッド・スタブ
		TestCustomerDAO203_03 test = new TestCustomerDAO203_03();
		test.initial();
		test.test();
	}
	public void initial() {
		custCode = "KA0001";
		custName = "Sストア";
		custTelNo = "045-150-3596";
		custPostal = "220-0016";
		custAddress = "横浜市西区みなとみらい２－６";
	}
	public void test() throws SQLException, SalesSystemException {
		System.out.println("----------すでにある得意先コードを登録しようとした場合のテスト----------");
		try {
			con = ConnectionManager.getConnection();
			customer = new CustomerDAO(con);
			flg = customer.addCustomer( custCode, custName, custTelNo, custPostal, custAddress );
		} catch( SQLException e ) {
			System.out.println("OK");
			e.printStackTrace();
		}
	}
}
