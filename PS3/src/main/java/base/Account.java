package base;

import java.util.Calendar;
import java.util.Date;

/**
 * Account Class for PS3
 * @author Matt Billone
 *
 */

public class Account {
	private int id = 0;
	private double balance = 0;
	private double annualInterestRate = 0;
	private Date dateCreated;
	
	/**
	 * No argument constructor
	 */
	public Account(){
		
	}
	/**
	 * Constructor that has parameters of id, beginning balance and the date created
	 */
	public Account(int id, double balance, Date dateCreated){
		this.id = id;
		balance *= 100;
		balance = Math.round(balance);
		balance /= 100;
		this.dateCreated = dateCreated;
		this.balance = balance;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	public double getMonthlyInterestRate(){
		double MonthlyInterestRate = getAnnualInterestRate() / 12;
		return MonthlyInterestRate;
	}
	/**
	 * returns the remaining balance to two decimals. If the amount exceeds the balance
	 * then the funds needed is given to withdraw that amount
	 * @param amount
	 * @throws InsufficientFundsException
	 */
	public double withdraw(double amountOut) throws InsufficientFundsException{
		double newBalance = balance;
		if(balance >= amountOut){
			newBalance = balance - amountOut;
		}
		else{
			double neededFunds = amountOut - balance;
			throw new InsufficientFundsException(neededFunds);
		}
		newBalance *= 100;
		newBalance = Math.round(balance);
		newBalance /= 100;
		return newBalance;
	}
	/**
	 * adds deposit amount to the current balance and then the
	 * new balance is rounded to two decimal places
	 * @param amountIn
	 * @return
	 */
	public double deposit(double amountIn){
		double newBalance = balance + amountIn;
		newBalance *= 100;
		newBalance = Math.round(newBalance);
		newBalance /= 100;
		return newBalance;
		
	}
	public static Date getDateMade(){
		Calendar currentDateAndTime = Calendar.getInstance();
		Date currentDate = currentDateAndTime.getTime();
		return currentDate;
	}
   }