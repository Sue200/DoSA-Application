/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;

/**
 *
 * @author Farha
 */
public class CITS extends UserClass implements Serializable,UpdateEvent,JobVacancies,UpdateNotice{
     
    private String name, email;
    private Notice n;
    
    CITS(String id ,String name , String mail, String pass){
        
        this.ID = id;
        this.name = name;
        this.email = mail;
        this.password = pass;
    }

    CITS() {
    }

   
    public void setCITsID(String id){
        this.ID = id;
        
    }
    public void setCITsName(String name){
        this.name = name;
        
    }
    public void setCITsEmail(String email){
        this.email = email;
        
    }
    
    public String getID(){
       return ID;
       
    }
    public String getName(){
        return name;
        
    }
    public String getEmail(){
        return email ;
        
    }
    public String getPassword(){
        return password;
    }
    
    
    public void addNewUsers(String id ,String name , String email, String password,String type){
        if(type.equals("Student")){
         File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("StudentDatabase.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            Student stud = new Student(id,name,email,password);
            oos.writeObject(stud);
            System.out.println("Object done inserting into file");

        } catch (IOException ex) {
            Logger.getLogger(CITS.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(CITS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
            
            
    
    }
        else if(type.equals("Faculty")){
         File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("FacultyDatabase.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            Faculty fac = new Faculty(
                id,
                name,
                email,
                    password
            );
            oos.writeObject(fac);
            System.out.println("Object done inserting into file");

        } catch (IOException ex) {
            Logger.getLogger(CITS.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(CITS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
            
            
    
    }
        else if(type.equals("Alumni")){
         File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("AlumniDatabase.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            Alumni alum = new Alumni(
                id,
                name,
                email,
                    password
            );
            oos.writeObject(alum);
            System.out.println("Object done inserting into file");

        } catch (IOException ex) {
            Logger.getLogger(CITS.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(CITS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
            
            
    
    }
     else if(type.equals("Administrative Staff")){
         File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("AdminstaffDatabase.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            AdministrativeStaff staff= new AdministrativeStaff(
                id,
                name,
                email,
                    password
            );
            oos.writeObject(staff);
            System.out.println("Object done inserting into file");

        } catch (IOException ex) {
            Logger.getLogger(CITS.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(CITS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
            
            
    
    }
     else{
         File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("CITsDatabase.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            CITS cits = new CITS(
                id,
                name,
                email,
                    password
            );
            oos.writeObject(cits);
            System.out.println("Object done inserting into file");

        } catch (IOException ex) {
            Logger.getLogger(CITS.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(CITS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
            
            
    
    }
    }
    public void deleteUser(){


    }
    
    @Override
    public void addnewEvent(String type, String ename , String etime , String evenue, LocalDate edate) {
        Eventpicker e = new Eventpicker(ename,evenue,etime,edate);
        
        
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
                 f2 = new File("UpcomingEvent.bin");
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
                 f = new File("VolunteerEventDatabase.bin");
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

   public int[] viewTotalUsersReport(){
       ArrayList<UserClass> list = new ArrayList<UserClass>();
       int[] x = new int[5];
       int i,j,k,h,m;
        i=j=k=h=m=0;
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
      
        try {
             f = new File("CITsDatabase.bin");
             fis = new FileInputStream(f);
             ois = new ObjectInputStream(fis);
            
            CITS emp;
             try{
                 while(true){
                     System.out.println("checking objects.");
                     emp = (CITS)ois.readObject();
                    System.out.println("I am here");
                    i++;
                    list.add(emp);
                     }
             }//end of nested try
             catch(Exception e){
                // e.printStackTrace();
                
                 //
             }//nested catch     

         } catch (IOException ex) { } 
         finally {
             try {
                 if(ois != null) ois.close();
             } catch (IOException ex) { }
         }
        x[0] = i;
        
            File f1 = null;
            FileInputStream fis1 = null;      
            ObjectInputStream ois1 = null;
      
        try {
             f1 = new File("StudentDatabase.bin");
             fis1 = new FileInputStream(f1);
             ois1 = new ObjectInputStream(fis);
            Student stud;
             try{
                 while(true){
                     System.out.println("checking objects.");
                     stud = (Student)ois.readObject();
                    System.out.println("I am here");
                    j++;
                    //list.add(stud);
                     }
             }//end of nested try
             catch(Exception e){
                // e.printStackTrace();
                 //
             }//nested catch     

         } catch (IOException ex) { } 
         finally {
             try {
                 if(ois != null) ois.close();
             } catch (IOException ex) { }
         }
        x[1] = j;
        File f2 = null;
        FileInputStream fis2 = null;      
        ObjectInputStream ois2 = null;
      
        try {
             f2 = new File("FacultyDatabase.bin");
             fis2 = new FileInputStream(f2);
             ois2 = new ObjectInputStream(fis2);
             Faculty fac;
             try{
                 while(true){
                     System.out.println("checking objects.");
                     fac = (Faculty)ois.readObject();
                    System.out.println("I am here");
                    k++;
                    //list.add(fac);
                     }
             }//end of nested try
             catch(Exception e){
                // e.printStackTrace();
                 //
             }//nested catch     

         } catch (IOException ex) { } 
         finally {
             try {
                 if(ois != null) ois.close();
             } catch (IOException ex) { }
         }
        x[2] = k;
        File f3 = null;
        FileInputStream fis3 = null;      
        ObjectInputStream ois3 = null;
      
        try {
             f3 = new File("AlumniDatabase.bin");
             fis3 = new FileInputStream(f3);
             ois3 = new ObjectInputStream(fis3);
            
            Alumni alum;
             try{
                 while(true){
                     System.out.println("checking objects.");
                     alum = (Alumni)ois.readObject();
                    System.out.println("I am here");
                    h++;
                    //list.add(alum);
                     }
             }//end of nested try
             catch(Exception e){
                // e.printStackTrace();
                 //
             }//nested catch     

         } catch (IOException ex) { } 
         finally {
             try {
                 if(ois != null) ois.close();
             } catch (IOException ex) { }
         }
        x[3] = h;
        File f4 = null;
        FileInputStream fis4 = null;      
        ObjectInputStream ois4 = null;
      
        try {
             f4 = new File("AdministrationDatabase.bin");
             fis4 = new FileInputStream(f4);
             ois4 = new ObjectInputStream(fis4);
            AdministrativeStaff as;
            
             try{
                 while(true){
                     System.out.println("checking objects.");
                     as = (AdministrativeStaff)ois.readObject();
                    System.out.println("I am here");
                    m++;
                    //list.add(as);
                     }
             }//end of nested try
             catch(Exception e){
                // e.printStackTrace();
                 //
             }//nested catch     

         } catch (IOException ex) { } 
         finally {
             try {
                 if(ois != null) ois.close();
             } catch (IOException ex) { }
         }
        x[4] = m;
        
        
       
    return x;
   }

   /* @Override
    public Notice addnewNotice(String s , LocalDate d ) {
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
    public void deleteNotice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
*/


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

    
    /*public ObservableList deleteUser(String type){
        ObservableList <UserClass> list = FXCollections.observableArrayList();
        //ObservableList<UserClass> p = FX
        if(type.equals("Student")){
           
            
        
    }
   */

    public void deleteEvents(String type, ObservableList<Eventpicker> allevents) {
        
        if(type.equals("Social")){
             
          File f = null;
          FileOutputStream fos = null;      
          ObjectOutputStream oos = null;
           File f2 = null;
          FileOutputStream fos2 = null;      
          ObjectOutputStream oos2 = null;
            try {
                    f = new File("SocialDatabase.bin");        
                    fos = new FileOutputStream(f);
                    oos = new ObjectOutputStream(fos);
                    f2= new File("UpcomingEvent.bin");        
                    fos2 = new FileOutputStream(f2);
                    oos2 = new ObjectOutputStream(fos2);
                    
                    for(Eventpicker j : allevents){
                         oos.writeObject(j);
                         oos2.writeObject(j);
                    }
             

            } catch (IOException ex) {
                Logger.getLogger(AddUserSceneController.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if(oos != null) oos.close();
                     if(oos2!= null) oos2.close();
                } catch (IOException ex) {
                    Logger.getLogger(AddUserSceneController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
         }
         else if(type.equals("Club")){
             
          File f = null;
          FileOutputStream fos = null;      
          ObjectOutputStream oos = null;
           File f2 = null;
          FileOutputStream fos2 = null;      
          ObjectOutputStream oos2 = null;
            try {
                    f = new File("ClubEventDatabase.bin");        
                    fos = new FileOutputStream(f);
                    oos = new ObjectOutputStream(fos);
                    f2= new File("UpcomingEvent.bin");        
                    fos2 = new FileOutputStream(f2);
                    oos2 = new ObjectOutputStream(fos2);
                    
                    for(Eventpicker j : allevents){
                         oos.writeObject(j);
                         oos2.writeObject(j);
                    }
             

            } catch (IOException ex) {
                Logger.getLogger(AddUserSceneController.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if(oos != null) oos.close();
                     if(oos2!= null) oos2.close();
                } catch (IOException ex) {
                    Logger.getLogger(AddUserSceneController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
         }
        else if(type.equals("Volunteer")){
             
          File f = null;
          FileOutputStream fos = null;      
          ObjectOutputStream oos = null;
           File f2 = null;
          FileOutputStream fos2 = null;      
          ObjectOutputStream oos2 = null;
            try {
                    f = new File("VolunteerDatabase.bin");        
                    fos = new FileOutputStream(f);
                    oos = new ObjectOutputStream(fos);
                    f2= new File("UpcomingEvent.bin");        
                    fos2 = new FileOutputStream(f2);
                    oos2 = new ObjectOutputStream(fos2);
                    
                    for(Eventpicker j : allevents){
                         oos.writeObject(j);
                         oos2.writeObject(j);
                    }
             

            } catch (IOException ex) {
                Logger.getLogger(AddUserSceneController.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if(oos != null) oos.close();
                     if(oos2!= null) oos2.close();
                } catch (IOException ex) {
                    Logger.getLogger(AddUserSceneController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
         }
        else{
             
          File f = null;
          FileOutputStream fos = null;      
          ObjectOutputStream oos = null;
           File f2 = null;
          FileOutputStream fos2 = null;      
          ObjectOutputStream oos2 = null;
            try {
                    f = new File("UniversityDatabase.bin");        
                    fos = new FileOutputStream(f);
                    oos = new ObjectOutputStream(fos);
                    f2= new File("UpcomingEvent.bin");        
                    fos2 = new FileOutputStream(f2);
                    oos2 = new ObjectOutputStream(fos2);
                    
                    for(Eventpicker j : allevents){
                         oos.writeObject(j);
                         oos2.writeObject(j);
                    }
             

            } catch (IOException ex) {
                Logger.getLogger(AddUserSceneController.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if(oos != null) oos.close();
                    if(oos2!= null) oos2.close();
                } catch (IOException ex) {
                    Logger.getLogger(AddUserSceneController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
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
    public Notice addnewnotice(String s, LocalDate d) {
        
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
        
    
    
   
    
}
