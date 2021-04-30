/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import bank.Account;
import bank.Person;
import bank.exceptions.InsufficientFoundsException;
import java.io.Console;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hallgato
 */
public class AccountTest {
    
    
    public AccountTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testDeposit(){
        Person person = new Person("Joe");
        Account instance = new Account(person);
        Assert.assertEquals(0, instance.getBalance(), 0);
        try {
            instance.deposit(10);
        } /*catch (InsufficientFoundsException e) {
           System.out.println(e.toString()+ " " + e.getMessage());
        }*/ catch (Exception e) {
           System.out.println(e.getMessage());
        }
        Assert.assertEquals(10, instance.getBalance(), 0);
    }
}
