/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

import java.io.Serializable;


public class AlumniNetworkRegistration extends Registration implements Serializable{
    
    private String major, currentStatus, linkedIn;
      private int gradyear, phoneNo;
    
    
    public AlumniNetworkRegistration(String name, String id, String email, String dept,String m , String cs, String in ,
                                        int gy , int p) {
        super(name, id, email, dept);
        this.currentStatus =cs;
        this.gradyear = gy;
        this.linkedIn = in;
        this.major = m ;
        this.phoneNo = p;
        
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    public int getGradyear() {
        return gradyear;
    }

    public void setGradyear(int gradyear) {
        this.gradyear = gradyear;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }
          
    
    
    
}
