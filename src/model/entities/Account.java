package model.entities;

import model.exception.DomainException;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	public void deposit (Double deposit) {
		balance += deposit;
	}
	
	public void withdraw (Double withdraw) {
		if (withdraw > this.balance) {
			throw new DomainException ("Withdraw error: Not enough balance.");
		}
		if (withdraw > this.withdrawLimit) {
			throw new DomainException ("Withdraw error: The amount exceeds withdraw limit.");
		}
		balance -= withdraw;
	}
}
