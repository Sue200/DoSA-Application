/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Farha
 */
public class Student extends UserClass implements Serializable,ReportIncident,Library{
    private String name, email;
  
    //private ContactInfo info;
    private String Studepartment;
    private StudentNetworkRegistration snr;
    
    
    public Student(String id, String name , String mail, String pass){
        
        this.name = name;
        this.email = mail;
        this.ID = id;
        this.password = pass;
    }

    Student() {
       
    }
   // public Student()
    public void setstudID(String id){
        this.ID = id;
        
    }
    public void setstudName(String name){
        this.name = name;
        
    }
    public void setstudEmail(String email){
        this.email = email;
        
    }
    
    public String getstudID(){
       return ID;
       
    }
    public String getstudName(){
        return name;
        
    }
    public String getstudEmail(){
        return email ;
        
    }
    public String getstudPassword(){
        return password;
    }
    
    public void bookAppointment(String name, String id, String age, String email, String 
             gender, String p, LocalDate date, String time) throws IOException{
        
         File f = null;
        FileWriter fw = null;
        String str = null;
        str = "Name:"+name +"\n"+"ID: "+id+"\n"+"Age:"+age+"\n"+"Email: "+email+"\n"+"Gender: "+gender+"\n"+
                "Has previously attended any session: "+p+"\n"+"Date of appointment: "+ date+ "\n"+ "Preferred Time: "+time+"\n";
        try {
                f = new File("BookAppointmentDatabase.txt");
                if(f.exists()){
                    fw = new FileWriter(f,true);
                }
                else{
                    fw = new FileWriter(f);
                }
           
           
            fw.write(str +"\n" );           
            
        } catch (IOException ex) {
            Logger.getLogger(UpdateMeritListController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(fw != null) fw.close();
            } catch (IOException ex) {
                Logger.getLogger(UpdateMeritListController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    }
        
        
    }
    public void scholarshipApplication(String scholarType, String anyotherScholarship,String reason){
          File f = null;
        FileOutputStream fos = null;      
         ObjectOutputStream oos = null;
        
        try {
            f = new File("ScholarshipApplicationDatabase.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            //Studname.getText(),studID.getText(), studEmail.getText(),
            Scholarship s = new Scholarship(scholarType, anyotherScholarship,reason);
            oos.writeObject(s);
            s.display();
            System.out.println("Object done inserting into file");

        } catch (IOException ex) {
            Logger.getLogger(EventRegistrationSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(EventRegistrationSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } 
    }
     
    public void clubregister(String name , String id, String email,String clubDescription, String dept, String club) {
        
        File f = null;
        FileWriter fw = null;
         try{
                    f = new File("ClubRegisterDatabase.txt");
                    if(f.exists()){
                        fw = new FileWriter(f,true);   
                    }
                    else{
                        fw = new FileWriter(f);
                    }
                      fw.write("Student Name:" + name + "\n"+
                                   "ID:" + id +"\n" + "Email: " + email+ "\n"+
                                    "Department: "+ dept+"\n" +
                                    "Club : "+ club + "\n"+
                                    "Why the student wants to join the club:"+"\n" + clubDescription+ "\n"+"\n");
                    
                    
                }catch (IOException ex) {
                    Logger.getLogger(Student.class.getName()).log(Level.SEVERE,null,ex);
        } finally {
            try {
                if(fw != null) fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void eventRegistration(String name , String id , String email, String dept, String event, String textArea,int phoneNo, String sem, String venue, String time, LocalDate date ){
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("EventRegistration.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            Eventregistration er = new Eventregistration(name,id, email,dept,
                    event, textArea, phoneNo , sem, venue, time, date);
            oos.writeObject(er);
            System.out.println("Object done inserting into file");

        } catch (IOException ex) {
            Logger.getLogger(EventRegistrationSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(EventRegistrationSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
    }

    @Override
    public void incidentReportApplication(String level, String name, String desig, String address, String incident, int id, int phoneNo) {
        if(level.equals("High")){
         File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        System.out.println("I am here0");
        
        try {
          f = new File("IncidentreportLevel1Database.bin");
           System.out.println("I am here1");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);  
                 System.out.println("I am here2");
            }
            else{
                 System.out.println("I am here3");
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
           
          IncidentReport n = new  IncidentReport( name,desig, address,incident,
                                id,phoneNo);
         
            oos.writeObject(n);
           
           
            System.out.println("Object done inserting into file");

        } catch (IOException ex) {
            Logger.getLogger(IncidentReportFormController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(NoticeSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
        }
        else if(level.equals("Moderate")){
            File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        System.out.println("I am here0");
        
        try {
          f = new File("IncidentreportLevel2Database.bin");
           System.out.println("I am here1");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);  
                 System.out.println("I am here2");
            }
            else{
                 System.out.println("I am here3");
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
           
         
          IncidentReport n = new  IncidentReport( name,desig, address,incident,
                                id, phoneNo);
         
            oos.writeObject(n);
           
           
            System.out.println("Object done inserting into file");

        } catch (IOException ex) {
            Logger.getLogger(IncidentReportFormController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(NoticeSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        }
        else{
            File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        System.out.println("I am here0");
        
        try {
          f = new File("IncidentreportLevel3Database.bin");
           System.out.println("I am here1");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);  
                 System.out.println("I am here2");
            }
            else{
                 System.out.println("I am here3");
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
           
          
          IncidentReport n = new  IncidentReport( name,desig, address,incident,
                                id, phoneNo);
         
            oos.writeObject(n);
           
           
            System.out.println("Object done inserting into file");

        } catch (IOException ex) {
            Logger.getLogger(IncidentReportFormController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(NoticeSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        }
    }
    public void inquiryApplication(String name, int id,String email, String dept, int phoneNo, String address,String inquiry){
                File f = null;
                 FileWriter fw = null;
                try{
                    f = new File("InquiryApplication.txt");
                    if(f.exists()){
                        fw = new FileWriter(f,true);
                        
                    }
                    else{
                        fw = new FileWriter(f);
                      
                    }
                     fw.write("User Name:" + name+ "\n"+
                                   "User ID:" + id +"\n" + "Email: " + email+ "\n"+
                                    "Semester: "+ dept +"\n" +
                                    "PhoneNo"+ phoneNo + "\n"+
                                    "Address" + address+ "\n"+ 
                                     "Inquiry" + inquiry+"\n"+"\n");
                    
                    
                }catch (IOException ex) {
                    Logger.getLogger(InquiryFormController.class.getName()).log(Level.SEVERE,null,ex);
        } finally {
            try {
                if(fw != null) fw.close();
            } catch (IOException ex) {
                Logger.getLogger(InquiryFormController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
           
                JOptionPane.showMessageDialog(null, "Your form has been submitted");
            }

    public void studentnetworkRegister(String name, String id, String email, String dept, String linkedIn , String goals, int phoneNo) {
          File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("StudentnetworkDatabase.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            StudentNetworkRegistration snr = new StudentNetworkRegistration(name,id,email,
                    dept,linkedIn,goals,phoneNo
            );
            oos.writeObject(snr);
            //j.display();
            System.out.println("Object done inserting into file");

        } catch (IOException ex) {
            Logger.getLogger(NewJobPostSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(NewJobPostSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    }

    void display() {
        System.out.println("name: "+name+"\n");
    }

    @Override
    public void applyForLibraryMembership(String name, String email, String address, String usertype, int id, int phoneNo, int pin) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        System.out.println("I am here0");
        LibraryMembership m = new LibraryMembership(name,email, address,usertype , id, phoneNo, pin);
       
        try {
          f = new File("LibraryMembershipDatabase.bin");
           System.out.println("I am here1");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);  
                 System.out.println("I am here2");
            }
            else{
                 System.out.println("I am here3");
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
           
            
           
            oos.writeObject(m);
           
            System.out.println("Object done inserting into file");

        } catch (IOException ex) {
            Logger.getLogger(NoticeSceneController.class.getName()).log(Level.SEVERE, null, ex);
           // ex.printStackTrace();
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(NoticeSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
             
        } 
    }
           
            
}


    
    
    




