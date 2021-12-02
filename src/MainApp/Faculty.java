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
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;


public class Faculty extends UserClass implements Serializable,ReportIncident,JobVacancies,UpdateEvent,UpdateNotice,Library{
     private String name, email;

    Faculty(String id, String name, String email, String pass) {
        this.ID = id;
        this.password = pass;
        this.email = email;
        this.name = name;
    }

    Faculty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void setfacID(String id){
        this.ID = id;
        
    }
    public void setafacName(String name){
        this.name = name;
        
    }
    public void setfacEmail(String email){
        this.email = email;
        
    }
    
    public String getfacID(){
       return ID;
       
    }
    public String getfacName(){
        return name;
        
    }
    public String getfacEmail(){
        return email ;
        
    }
    public String getfacPassword(){
        return password;
    }

    public void registerForTraining(String name , String id, String email, String reason,String desig, String dept,int phoneNo, String choice){
        
        File f = null;
        FileOutputStream fos = null;      
         ObjectOutputStream oos = null;
        
        try {
            f = new File("TrainingApplicationDatabase.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            //Studname.getText(),studID.getText(), studEmail.getText(),
           TrainingRegistration s = new TrainingRegistration(name,id,email,dept, reason, desig, choice, phoneNo);
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
        public void leaveApplication(String name, int id , int noOfcourses, String cn, String reason, String ld, LocalDate leaveDate, LocalDate jd,String dept){
             File f = null;
                 FileWriter fw = null;
                try{
                    f = new File("leaveApplication.txt");
                    if(f.exists()){
                        fw = new FileWriter(f,true);
                        
                    }
                    else{
                        fw = new FileWriter(f);
                      
                    }
                     fw.write("User Name:" + name+ "\n"+
                                   "User ID:" + id+"\n" + "Number of courses taken: " + noOfcourses+ "\n"+
                                    "name of the Courses: "+ cn+"\n" +
                                    "Reason for leave: "+  reason + "\n"+
                                    "Leave duration" + ld+ "\n"+ 
                                     "Leave date" + leaveDate+"\n"+
                                      "Join date:" + jd + "\n" +"Department: "+dept+"\n"+"\n");
                                       
                }catch (IOException ex) {
                    Logger.getLogger(Faculty.class.getName()).log(Level.SEVERE,null,ex);
        } finally {
            try {
                if(fw != null) fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Faculty.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
           
               
        }
   /* @Override
    public void deleteNotice() {
        
    }

    @Override
    public Notice addnewNotice(String s, LocalDate d) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        System.out.println("I am here0");
         Notice note = new Notice(s, d);
          //
        try {
          f = new File("NoticeDatabase.bin");
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
           
            
           
            oos.writeObject(note);
           
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
        return note;
        
       
        
    }*/

    @Override
    public void incidentReportApplication(String level, String name,String desig, String address, String incident,int id, int phoneNo ) {
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

    

    void requestEduChange(String name, String id , String email, String tc, String desig, String box,String dept ) {
      
        
        File f = null;
                 FileWriter fw = null;
                try{
                    f = new File("RequestsForEducationalChange.txt");
                    if(f.exists()){
                        fw = new FileWriter(f,true);
                        
                    }
                    else{
                        fw = new FileWriter(f);
                      
                    }
                     fw.write("User Name:" + name+ "\n"+
                                   "User ID:" + id +"\n" + "Email: " + email+ "\n"+
                                    "Department: "+ dept +"\n" +
                                    "Type of change:"+ tc + "\n"+
                                    "Designation" + desig + "\n"+ 
                                     "Brief details regarding the change" + box+"\n"+"\n");
                    
                    
                }catch (IOException ex) {
                    Logger.getLogger(Faculty.class.getName()).log(Level.SEVERE,null,ex);
        } finally {
            try {
                if(fw != null) fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Faculty.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
           
                JOptionPane.showMessageDialog(null, "Your form has been submitted."+"\n"+" You will receive an email for further insrtuctions");
            }

    @Override
    public void addnewEvent(String type, String ename, String etime, String evenue, LocalDate date) {
        Eventpicker e = new Eventpicker(ename,evenue,etime,date);
        
      System.out.println(type);
        if(type.equals("Social")){
            File f = null;
            File f2 = null;
            FileOutputStream fw = null;
            FileOutputStream fw2 = null;
            ObjectOutputStream oos = null;
             ObjectOutputStream oos2 = null;
            try{
                 f = new File("SocialDatabase.bin");
                // f2 = new File("UpcomingEvent.bin");
                    if(f.exists()){
                        fw = new FileOutputStream(f,true);
                        oos = new AppendableObjectOutputStream(fw);
                        System.out.println("Iam here");
                    }
                    else{
                        fw = new FileOutputStream(f);
                        oos = new ObjectOutputStream(fw);  
                        System.out.println("Iam here");
                        
                    }
                    System.out.println("Iam here");
                     oos.writeObject(e);
                     e.display();
                     

                   if(f2.exists()){
                        fw2 = new FileOutputStream(f2,true);
                        oos2= new AppendableObjectOutputStream(fw2);
                                              
                    }
                    else{
                       fw2 = new FileOutputStream(f2);
                        oos2 = new ObjectOutputStream(fw2); 
                    }
                     oos2.writeObject(e);

                    
            }catch (IOException ex) {
                    Logger.getLogger(CITS.class.getName()).log(Level.SEVERE,null,ex);
        } finally {
            try {
                 if(oos != null) oos.close();
                if(oos2 != null) oos2.close();
            } catch (IOException ex) {
                Logger.getLogger(CITS.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
            System.out.println("File writing done");
            
    }
        else if(type.equals("Volunteer")){
            File f = null;
            File f2 = null;
            FileOutputStream fw = null;
            FileOutputStream fw2 = null;
            ObjectOutputStream oos = null;
             ObjectOutputStream oos2 = null;
            try{
                 f = new File("VolunterEventDatabase.bin");
                 f2 = new File("UpcomingEvent.bin");
                    if(f.exists()){
                        fw = new FileOutputStream(f,true);
                        
                        System.out.println("1.reach is here");
                    }
                    else{
                        fw = new FileOutputStream(f);
                          System.out.println("2.reach is here");
                        
                    }
                    oos = new AppendableObjectOutputStream(fw);
                     System.out.println("3.reach is here");
                     oos.writeObject(e);
                     System.out.println("Object is here");

                    if(f2.exists()){
                         fw2 = new FileOutputStream(f2,true);
                        oos2 = new AppendableObjectOutputStream(fw2);
                        
                    }
                    else{
                         fw2 = new FileOutputStream(f2);
                          oos2 = new ObjectOutputStream(fw2);   
                        
                    }
                     oos2.writeObject(e);
                      System.out.println("Object is here");

                    
                    
            }catch (IOException ex) {
                    Logger.getLogger(EventViewController.class.getName()).log(Level.SEVERE,null,ex);
        } finally {
            try {
                 if(oos != null) oos.close();
                if(oos2 != null) oos2.close();
            } catch (IOException ex) {
                Logger.getLogger(EventViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
             System.out.println("object done inserting");
        }
        else if(type.equals("Club")){
            File f = null;
            File f2 = null;
            FileOutputStream fw = null;
             FileOutputStream fw2 = null;
             ObjectOutputStream oos = null;
             ObjectOutputStream oos2 = null;
            try{
                 f = new File("ClubEventDatabase.bin");
                 f2 = new File("UpcomingEvent.bin");
                    if(f.exists()){
                        fw = new FileOutputStream(f,true);
                         oos = new AppendableObjectOutputStream(fw);
                        
                    }
                    else{
                        fw = new FileOutputStream(f);
                        oos = new ObjectOutputStream(fw);
                        
                    }
                     oos.writeObject(e);

                    if(f2.exists()){
                        fw2 = new FileOutputStream(f2,true);
                         oos2 = new AppendableObjectOutputStream(fw2);
                        
                    }
                    else{
                        fw2 = new FileOutputStream(f2);
                        oos2 = new ObjectOutputStream(fw2);
                        
                    }
                     oos2.writeObject(e);

                    System.out.println("object done inserting part 1");
                    
            }catch (IOException ex) {
                    Logger.getLogger(EventViewController.class.getName()).log(Level.SEVERE,null,ex);
        } finally {
            try {
                if(oos != null) oos.close();
                if(oos2 != null) oos2.close();
            } catch (IOException ex) {
                Logger.getLogger(EventViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
             System.out.println("object done inserting");
    }
        else{
            File f = null;
            File f2 = null;
             FileOutputStream fw = null;
             FileOutputStream fw2 = null;
             ObjectOutputStream oos = null;
             ObjectOutputStream oos2 = null;
            try{
                 f = new File("UniversityEvent.bin");
                 f2 = new File("UpcomingEvent.bin");
                    if(f.exists()){
                       fw = new FileOutputStream(f,true);
                         oos = new AppendableObjectOutputStream(fw);
                        
                    }
                     else{
                        fw = new FileOutputStream(f);
                        oos = new ObjectOutputStream(fw);
                        
                    }
                     oos.writeObject(e);

                    if(f2.exists()){
                        fw2 = new FileOutputStream(f2,true);
                         oos2 = new AppendableObjectOutputStream(fw2);
                        
                    }
                    else{
                        fw2 = new FileOutputStream(f2);
                        oos2 = new ObjectOutputStream(fw2);
                        
                    }
                     oos2.writeObject(e);

                    
                    
            }catch (IOException ex) {
                    Logger.getLogger(CITS.class.getName()).log(Level.SEVERE,null,ex);
        } finally {
            try {
                 if(oos != null) oos.close();
                if(oos2 != null) oos2.close();
            } catch (IOException ex) {
                Logger.getLogger(CITS.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
            System.out.println("object done inserting");
        }
       
    }

    @Override
    public void deleteJobPost(ObservableList<Job> allJobs) {
        File f = null;
          FileOutputStream fos = null;      
          ObjectOutputStream oos = null;
          
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
    public Notice addnewnotice(String s ,LocalDate d) {
       File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        System.out.println("I am here0");
         Notice note = new Notice(s, d);
          //
        try {
          f = new File("NoticeDatabase.bin");
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
           
            
           
            oos.writeObject(note);
           
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
        return note; 
    }

    @Override
    public void deleteNotice(ObservableList<Notice> n) {
        File f = null;
          FileOutputStream fos = null;      
          ObjectOutputStream oos = null;
             
            try {
                    f = new File("NoticeDatabase.bin");        
                    fos = new FileOutputStream(f);
                    oos = new ObjectOutputStream(fos);   
                    
                    for(Notice j : n){
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
    
    

   
   

