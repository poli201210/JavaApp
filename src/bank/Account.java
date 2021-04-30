/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import bank.exceptions.InsufficientFoundsException;

/**
 *
 * @author hallgato
 */
public class Account {

    public Account(Person person) {
        this.owner = person.getName();
        this.balance = 0;
        String formatted = String.format("%05d", accountNumberCounter++);
        this.accountNumber = formatted;
    }
    
    private String owner;
    private String accountNumber;
    private Integer balance = 20;
    public static int accountNumberCounter = 1;

    Account() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String getOwner() {
        return owner;
    }

    private void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    private void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
    
    public void deposit(int toAdd) throws Exception {
        if(toAdd < 0) {
            throw new Exception("deposit value must be positive");
        }
        this.balance += toAdd;
    }
    
    public void withdrawal(int toTake) throws InsufficientFoundsException, Exception {
        if (toTake < 0) {
            throw new Exception("withdrawal value must be positive!");
        }
        if (toTake > this.balance) {
            throw new InsufficientFoundsException();
        }
        this.balance -= toTake;
    }
}
