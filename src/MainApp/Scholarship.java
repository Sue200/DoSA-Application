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
public class Scholarship extends Student{
    
    private String name, id, email, previousWaiver, reasonForApp, typeofwaiver;

    public Scholarship(String typeofwaiver, String previousWaiver, String reasonForApp) {
        
        this.name = Student.getUsername();
        this.id = Student.getuserId();
        this.email = Student.getemail();
        this.previousWaiver = previousWaiver;
        this.reasonForApp = reasonForApp;
        this.typeofwaiver = typeofwaiver;
    }

   

    public String getPreviousWaiver() {
        return previousWaiver;
    }

    public void setPreviousWaiver(String previousWaiver) {
        this.previousWaiver = previousWaiver;
    }

    public String getReasonForApp() {
        return reasonForApp;
    }

    public void setReasonForApp(String reasonForApp) {
        this.reasonForApp = reasonForApp;
    }

    public String getTypeofwaiver() {
        return typeofwaiver;
    }

    public void setTypeofwaiver(String typeofwaiver) {
        this.typeofwaiver = typeofwaiver;
    }
    //@Override 
    public void display(){
        Student s = new Student();
        System.out.println("Name:"+ name +"\n"+"ID: "+id +"\n"+"Email:"+email+"\n"+"Waiver:"+typeofwaiver
                            + "\n"+ "Any other waiver exisits:"+previousWaiver+"\n"+"Reason for applying:"+ reasonForApp+"\n");
    }
    
    
    
    
}
