/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;


public class  UserClass implements Serializable {
   
     String ID;
     String password;
     private static String Username;
    private static String userId;
     private static String email;
     //private static AdministrativeStaff as;
     //private static CITS c;
     //private static Alumni a;
   
     //private static ArrayList<Student> list ;
    
    
    
    public static boolean verifylogin(String id, String pass, String typeUser){
        
       File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        boolean found = false;
     // System.out.println(typeUser);
       
       if(typeUser.equals("Student")){
        
        try {
             f = new File("StudentDatabase.bin");
             fis = new FileInputStream(f);
             ois = new ObjectInputStream(fis);
            Student emp ;
             UserClass s = new Student();
             try{
                 //boolean result = false;
                 while(true){
                     System.out.println("checking objects.");
                     emp = (Student)ois.readObject();
                    System.out.println("I am here");
                     if(emp.getstudID().equals(id) && emp.getstudPassword().equals(pass)){
                          System.out.println("I am here");
                         found = true;
                         //list.add(emp);
                         Username = emp.getstudName();
                         userId = emp.getstudID();
                         email = emp.getstudEmail();
                         
                     }
                 }
                  


             }//end of nested try
             catch(Exception e){
                 //
             }//nested catch     

         } catch (IOException ex) { } 
         finally {
             try {
                 if(ois != null) ois.close();
             } catch (IOException ex) { }
         }
         System.out.println(found);
         // Username = name;
         return found;
     }
       else if(typeUser.equals("Faculty")){
        try {
             f = new File("FacultyDatabase.bin");
             fis = new FileInputStream(f);
             ois = new ObjectInputStream(fis);
            Faculty emp ;
           
             try{
                 //boolean result = false;
                 while(true){
                     System.out.println("checking objects.");
                     emp = (Faculty)ois.readObject();
                      System.out.println("I am here");
                     if(emp.getfacID().equals(id) && emp.getfacPassword().equals(pass)){
                          System.out.println("I am here");
                         found = true;
                          Username = emp.getfacName();
                          userId = emp.getfacID();
                          email = emp.getfacEmail();
                     }
                 }


             }//end of nested try
             catch(Exception e){
                 //
             }//nested catch     

         } catch (IOException ex) { } 
         finally {
             try {
                 if(ois != null) ois.close();
             } catch (IOException ex) { }
         }
         System.out.println(found);
         return found;
     }
       else if(typeUser.equals("Alumni")){
        try {
             f = new File("AlumniDatabase.bin");
             fis = new FileInputStream(f);
             ois = new ObjectInputStream(fis);
            Alumni emp ;
           
             try{
                 //boolean result = false;
                 while(true){
                     System.out.println("checking objects.");
                     emp = (Alumni)ois.readObject();
                      System.out.println("I am here");
                     if(emp.getAlumID().equals(id) && emp.getAlumPassword().equals(pass)){
                          System.out.println("I am here");
                         found = true;
                          Username = emp.getAlumName();
                          userId = emp.getAlumID();
                            email = emp.getAlumEmail();
                     }
                 }


             }//end of nested try
             catch(Exception e){
                 //
             }//nested catch     

         } catch (IOException ex) { } 
         finally {
             try {
                 if(ois != null) ois.close();
             } catch (IOException ex) { }
         }
         System.out.println(found);
         return found;
     }
     else if(typeUser.equals("Administrative Staff")){
        try {
             f = new File("AdministrativeDatabase.bin");
             fis = new FileInputStream(f);
             ois = new ObjectInputStream(fis);
             AdministrativeStaff emp ;
              UserClass s = new AdministrativeStaff();
             try{
                 //boolean result = false;
                 while(true){
                     System.out.println("checking objects.");
                     emp = (AdministrativeStaff)ois.readObject();
                      System.out.println("I am here");
                     if(emp.getAdminID().equals(id) && emp.getAdminPassword().equals(pass)){
                          System.out.println("I am here");
                         found = true;
                          Username = emp.getAdminName();
                          userId = emp.getAdminID();
                         email = emp.getAdminEmail();
                     }
                 }


             }//end of nested try
             catch(Exception e){
                 //
             }//nested catch     

         } catch (IOException ex) { } 
         finally {
             try {
                 if(ois != null) ois.close();
             } catch (IOException ex) { }
         }
         System.out.println(found);
         return found;
     }
     else{
        try {
             f = new File("CITsDatabase.bin");
             fis = new FileInputStream(f);
             ois = new ObjectInputStream(fis);
            CITS emp ;
            UserClass s = new CITS();
             try{
                 //boolean result = false;
                 while(true){
                     System.out.println("checking objects.");
                     emp = (CITS)ois.readObject();
                      System.out.println("I am here");
                     if(emp.getID().equals(id) && emp.getPassword().equals(pass)){
                          System.out.println("I am here");
                         found = true;
                          Username = emp.getName();
                          userId = emp.getID();
                         email = emp.getEmail();
                     }
                 }


             }//end of nested try
             catch(Exception e){
                 //
             }//nested catch     

         } catch (IOException ex) { } 
         finally {
             try {
                 if(ois != null) ois.close();
             } catch (IOException ex) { }
         }
         System.out.println(found);
         return found;
       
     }
       
         
    }
    
    public static String getUsername(){
        return Username;
    }
    public static String getuserId(){
        return userId;
    }
    public static String getemail(){
        return email;
    }
   
}



 
   
      
      
      
   
       

   


