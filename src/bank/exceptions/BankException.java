/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.exceptions;

import bank.Bank;

/**
 *
 * @author hallgato
 */
public class BankException extends Exception {

    Bank bank;
    public BankException(Bank bank, String message) {
        super(message);
        this.bank = bank;
    }
    
}
