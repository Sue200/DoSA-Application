/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

/**
 *
 * @author Farha
 */
public class LibraryMembership {
    
    private String name, email, address, usertype;
    private int id, phoneNo, pin;

    public LibraryMembership(String name, String email, String address, String usertype, int id, int phoneNo, int pin) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.usertype = usertype;
        this.id = id;
        this.phoneNo = phoneNo;
        this.pin = pin;
    }
    
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
    
   
    
}
