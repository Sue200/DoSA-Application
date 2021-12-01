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
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;

/**
 *
 * @author Farha
 */
public class Alumni extends UserClass implements Serializable,JobVacancies,Library {
    private String name , email;
    
    Alumni(String id, String name, String email, String pass){
         this.ID = id;
        this.password = pass;
        this.email = email;
        this.name = name;
    }

    Alumni() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     public void setAlumID(String id){
        this.ID = id;
        
    }
    public void setAlumName(String name){
        this.name = name;
        
    }
    public void setAlumEmail(String email){
        this.email = email;
        
    }
    
    public String getAlumID(){
       return ID;
       
    }
    public String getAlumName(){
        return name;
        
    }
    public String getAlumEmail(){
        return email ;
        
    }
    public String getAlumPassword(){
        return password;
    }
    
    public void alumniNetworkRegistration(String name,String id, String email, String dept, int year, String major,
            int phoneNo, String link , String text){
        
            File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("AlumniNetworkDatabase.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            AlumniNetworkRegistration c = new AlumniNetworkRegistration(name,id,email,dept,major, text, link, year , phoneNo
            );
            oos.writeObject(c);
            //j.display();
            System.out.println("Object done inserting into file");

        } catch (IOException ex) {
            Logger.getLogger(Alumni.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Alumni.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
            
    
    } 

    @Override
    public void addnewJobPost(String jobname, String orgname, String jobdescript, LocalDate deadline) {
       File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("JobCircularDatabase.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            Job j = new Job(jobname,orgname,jobdescript,deadline
            );
            oos.writeObject(j);
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

    @Override
    public void deleteJobPost(ObservableList<Job> allJobs) {
        File f = null;
          FileOutputStream fos = null;      
          ObjectOutputStream oos = null;
           File f2 = null;
          FileOutputStream fos2 = null;      
          ObjectOutputStream oos2 = null;
            try {
                    f = new File("JobCircularDatabase.bin");        
                    fos = new FileOutputStream(f);
                    oos = new ObjectOutputStream(fos);
                   
                    
                    for(Job j : allJobs){
                         oos.writeObject(j);
                        
                    }
             

            } catch (IOException ex) {
                Logger.getLogger(AddUserSceneController.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if(oos != null) oos.close();
                    
                } catch (IOException ex) {
                    Logger.getLogger(AddUserSceneController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
         }

    @Override
    public void applyForLibraryMembership(String name, String email, String address,String usertype ,int id, int phoneNo, int pin) {
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

      
        
    

