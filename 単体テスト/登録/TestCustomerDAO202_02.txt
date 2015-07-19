package test;

import java.sql.Connection;
import java.sql.SQLException;

import common.SalesSystemException;

import dao.CustomerDAO;

public class TestCustomerDAO202_02 {

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
		TestCustomerDAO202_02 test = new TestCustomerDAO202_02();
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
		System.out.println("----------conがnull状態でのテスト----------");
		try {
			flg = customer.addCustomer( custCode, custName, custTelNo, custPostal, custAddress );
			if( flg ) {
				System.out.println("NG");
			} else {
				System.out.println("NG" );
			}
		} catch( SQLException e ) {
			System.out.println("NG");
		} catch( NullPointerException e ) {
			System.out.println("con = " + con );
			System.out.println("OK");
		}
	}

}
