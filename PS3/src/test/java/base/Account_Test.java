package base;


import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Account_Test {
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void AccountTest() {
		
		Account newAccount1 = new Account(1122,20000.0, Account.getDateMade());
		newAccount1.setAnnualInterestRate(4.5);
		try{
			newAccount1.withdraw(2500);
		} catch (InsufficientFundsException i){
			i.printStackTrace();
		}
		try{
			newAccount1.withdraw(30000);
		} catch(InsufficientFundsException i1){
			System.out.println("You can only withdraw an amount less than or equal to your current balance");
			i1.printStackTrace();
		}
		newAccount1.deposit(3000);
		
		System.out.println("Account ID" + newAccount1.getId() + "has: $" + newAccount1.getBalance() +
				"\nwith a monthly interest rate of" + newAccount1.getMonthlyInterestRate() + "%" + 
				"\nThe account was created" + newAccount1.getDateCreated());
	}
	

}
