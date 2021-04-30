/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import bank.exceptions.InsufficientFoundsException;
import bank.exceptions.TransferException;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author hallgato
 */
public class Bank {

    Map<String,Account> accounts = new TreeMap<>();   

    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Map<String, Account> accounts) {
        this.accounts = accounts;
    }
    
    public String createAccount(Person person){
        Account newAccount = new Account(person);
        this.accounts.put(newAccount.getAccountNumber(), newAccount);
        return newAccount.getAccountNumber();
    }
    
    public void transfer(Person person, String sourceAccountNumber, String destinationAccountNumber, int amount) throws TransferException {
        if (accounts.get(sourceAccountNumber) == null) {
            throw new TransferException(this, "source account number does not exist");
        }
        if (accounts.get(destinationAccountNumber) == null) {
            throw new TransferException(this, "destination account number does not exist");
        }
        
        Account sourceAccount = (Account)accounts.get(sourceAccountNumber);
        if (!person.getName().equals(sourceAccount.getOwner())) {
            throw new TransferException(this, "only person owning account can start transfer");
        }
        Account destinationAccount = (Account)accounts.get(destinationAccountNumber);
        try {
            sourceAccount.withdrawal(amount);
            // after
            destinationAccount.deposit(amount);
        } catch (InsufficientFoundsException e) {
            System.err.println("not enough founds on source account");
            System.out.println(e.getMessage());
            // throw new Exception("Transfer failed");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }       
        
    }
    
    public static void main(String[] args) {
        Bank OTP = new Bank();
        Person dori = new Person("Dori");
        String acc1 = OTP.createAccount(dori);
        System.out.println(OTP.getAccounts());
        System.out.println(Account.accountNumberCounter);
        String acc2 = OTP.createAccount(dori);
        System.out.println(OTP.getAccounts());
        System.out.println(Account.accountNumberCounter);
        
        try {
            OTP.transfer(dori, acc1, acc2, 10);
        } catch (Exception e) {
        }
        
        System.out.println(OTP.getAccounts());
        
        
    }
    
    
    
}
