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
public class TrainingRegistration extends Registration{
    private String reason,desig,choice;
    private int phoneNo; 
    public TrainingRegistration(String name, String id, String email, String dept, String r,String d, String c, int p){ 
        super(name, id, email, dept);
        this.reason = r;
        this.desig = d;
        this.choice = c;
        this.phoneNo =p;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDesig() {
        return desig;
    }

    public void setDesig(String desig) {
        this.desig = desig;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }
    public void display(){
        System.out.println();
    }
    
    
}
