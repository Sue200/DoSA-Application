/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;


public  class StudentNetworkRegistration extends Registration implements Serializable{
    
    private String linkedIn, goals;
    private int phoneNo;
    public StudentNetworkRegistration(String name, String id, String email, String dept,String in ,String g, int pn) {
        super(name, id, email, dept);
        
        this.linkedIn = in;
        this.goals =g;
        this.phoneNo = pn;
        
        
    }

   
   
}
