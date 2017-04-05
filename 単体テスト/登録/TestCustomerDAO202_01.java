package test;

import java.sql.Connection;
import java.sql.SQLException;

import manager.ConnectionManager;

import common.SalesSystemException;

import dao.CustomerDAO;

public class TestCustomerDAO202_01{

	CustomerDAO customer = new CustomerDAO();

	private String custCode;
	private String custName;
	private String custTelNo;
	private String custPostal;
	private String custAddress;
	private boolean flg = false;
	Connection con = null;

	public static void main( String[] args ) throws SQLException, SalesSystemException {

		TestCustomerDAO202_01 test = new TestCustomerDAO202_01();
		test.initial();
		test.test();
	}
	public void initial() {
		custCode = "KA0099";
		custName = "Sストア";
		custTelNo = "045-150-3596";
		custPostal = "220-0016";
		custAddress = "横浜市西区みなとみらい２－６";
	}

	public void test() throws SQLException, SalesSystemException {

		con = null;

		System.out.println("----------5項目全部INSERTテスト----------");

		try {
			con = ConnectionManager.getConnection();
			customer = new CustomerDAO(con);
			flg = customer.addCustomer( custCode, custName, custTelNo, custPostal, custAddress );
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
