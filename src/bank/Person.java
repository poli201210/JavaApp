/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

/**
 *
 * @author hallgato
 */
public class Person {

    public Person(String name) {
        this.name = name;
    }
    private String name;

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }
    
}
