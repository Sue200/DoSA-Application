/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;

/**
 *
 * @author Farha
 */
public class AdministrativeStaff extends UserClass implements Serializable,UpdateEvent,UpdateNotice {
        private String name, email;
         private transient ObjectInputStream ois ;
         private Notice n;
    //private ContactInfo info;
    //private String Studepartment;
    
    AdministrativeStaff(String id, String name, String email, String pass) {
       this.ID = id;
       this.name = name;
       this.email = email;
       this.password = pass;
    }

    AdministrativeStaff() {}
   // public Student()
    public void setAdminID(String id){
        this.ID = id;
        
    }
    public void setAdminName(String name){
        this.name = name;
        
    }
    public void setAdminEmail(String email){
        this.email = email;
        
    }
    
    public String getAdminID(){
       return ID;
       
    }
    public String getAdminName(){
        return name;
        
    }
    public String getAdminEmail(){
        return email ;
        
    }
    public String getAdminPassword(){
        return password;
    }
   
     public ObservableList viewReportOfEvent(){
         int i,j,k,h;
        i=0;
        j=0;
        k=0;
        h =0;
        
        File f = null;
        FileInputStream fis = null;      
         ois = null;

        try {
             f = new File("EventRegistration.bin");
             fis = new FileInputStream(f);
             ois = new ObjectInputStream(fis);
            Eventregistration emp ;
             try{
                 
                 while(true){
                     System.out.println("checking objects.");
                     emp = (Eventregistration)ois.readObject();
                    System.out.println("I am here");
                     if(emp.getSelectedEvent().equals("Social")){
                          System.out.println("I am here");
                          i++;
                     }
                     else if(emp.getSelectedEvent().equals("Club")){
                         System.out.println("I am here");
                         j++;
                     }
                     else if(emp.getSelectedEvent().equals("Volunteer")){
                         System.out.println("I am here");
                         k++;
                     }
                     else{
                         System.out.println("I am here");
                         h++;
                     }
                         
                 }

             }//end of nested try
             catch(Exception e){
               //  e.printStackTrace();
             }//nested catch     

         } catch (IOException ex) {
             Logger.getLogger(AdministrativeStaff.class.getName()).log(Level.SEVERE, null, ex);
         } 
         finally {
             try {
                 if(ois != null) ois.close();
             } catch (IOException ex) { 
                 Logger.getLogger(AdministrativeStaff.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
        
         System.out.println(i);
         System.out.println(j);
         System.out.println(k);
         System.out.println(h);

        
        
          ObservableList <PieChart.Data> list = FXCollections.observableArrayList( new PieChart.Data("Social",i),
            new PieChart.Data("Club",j),
            new PieChart.Data("Volunteer",k),
            new PieChart.Data("university",h)
        );
         return list;
        
    }
     public ObservableList viewComplaints(String level) throws ClassNotFoundException{
         
         ObservableList<IncidentReport> list = FXCollections.observableArrayList();
         
         if(level == "High" ){
             File f = null;
            FileInputStream fis = null;      
            ObjectInputStream ois = null;
             try{
                 f = new File("IncidentReportLevel1database.bin");
                 fis = new FileInputStream(f);
                 ois = new ObjectInputStream(fis);
                IncidentReport ir ;
                     while(true){
                         System.out.println("checking objects.");
                         ir = (IncidentReport)ois.readObject();
                        System.out.println("I am here");
                        list.add(ir);
                             //listview.getItems().add(ir);
                     }

             } catch (IOException ex) { } 
             finally {
                 try {
                     if(ois != null) ois.close();
                 } catch (IOException ex) { }
             }
              return list;
         }
         else if(level == "Moderate"){
             File f = null;
            FileInputStream fis = null;      
            ObjectInputStream ois = null;
             try{
                 f = new File("IncidentReportLevel2database.bin");
                 fis = new FileInputStream(f);
                 ois = new ObjectInputStream(fis);
                IncidentReport ir ;
                     while(true){
                         System.out.println("checking objects.");
                         ir = (IncidentReport)ois.readObject();
                        System.out.println("I am here");
                        list.add(ir);
                             //listview.getItems().add(ir);
                     }

             } catch (IOException ex) { } 
             finally {
                 try {
                     if(ois != null) ois.close();
                 } catch (IOException ex) { }
             }
              return list;
         }
         else{
             File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
         try{
             f = new File("IncidentReportLevel3database.bin");
             fis = new FileInputStream(f);
             ois = new ObjectInputStream(fis);
            IncidentReport ir ;
                 while(true){
                     System.out.println("checking objects.");
                     ir = (IncidentReport)ois.readObject();
                    System.out.println("I am here");
                         //listview.getItems().add(ir);
                 }

         } catch (IOException ex) { } 
         finally {
             try {
                 if(ois != null) ois.close();
             } catch (IOException ex) { }
         }
         return list;
         }
     }
     public String uploadNewmeritList(String typeOfList){
         String list = "";
         if(typeOfList.equals("Dean's List")){
             FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files", "*.txt", "*.doc","*.docx",
                "*.TXT","*.DOC","*.DOCX" ));
        File f = fc.showOpenDialog(null);
        if(f != null){
            try {
                Scanner sc = new Scanner(f);
                String str="";
                while(sc.hasNextLine()){
                    str+=sc.nextLine()+"\n";
                }
                 File f1 = null;
                 FileWriter fw = null;

            try {
                    f1 = new File("DeanListDatabase.txt");
                    fw = new FileWriter(f1);
                    list = str;
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
         } catch (FileNotFoundException ex) {
                    Logger.getLogger(AdministrativeStaff.class.getName()).log(Level.SEVERE, null, ex);
                }

       
    }
         }
        else if(typeOfList.equals("Dean's Merit List")){
              FileChooser fc1 = new FileChooser();
        fc1.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files", "*.txt", "*.doc","*.docx",
                "*.TXT","*.DOC","*.DOCX" ));
        File f2 = fc1.showOpenDialog(null);
        if(f2 != null){
            try {
                Scanner sc = new Scanner(f2);
                String str="";
                while(sc.hasNextLine()){
                    str+=sc.nextLine()+"\n";
                }
                 File f1 = null;
                 FileWriter fw = null;

            try {
                   f1 = new File("DeansMeritDatabase.txt");
                    fw = new FileWriter(f1);
                    list = str;
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
         } catch (FileNotFoundException ex) {
                    Logger.getLogger(AdministrativeStaff.class.getName()).log(Level.SEVERE, null, ex);
                }

       
    }
        }
        else{
             FileChooser fc2 = new FileChooser();
        fc2.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files", "*.txt", "*.doc","*.docx",
                "*.TXT","*.DOC","*.DOCX" ));
        File f3 = fc2.showOpenDialog(null);
        if(f3 != null){
            try {
                Scanner sc = new Scanner(f3);
                String str="";
                while(sc.hasNextLine()){
                    str+=sc.nextLine()+"\n";
                }
                 File f1 = null;
                 FileWriter fw = null;

            try {
                   f1 = new File("VCMeritDatabase.txt");
                    fw = new FileWriter(f1);
                    list = str;
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
         } catch (FileNotFoundException ex) {
                    Logger.getLogger(AdministrativeStaff.class.getName()).log(Level.SEVERE, null, ex);
                }

       
        }
        
            
        }
          return list;  
     }

    @Override
    public void addnewEvent(String type, String ename, String etime, String evenue, LocalDate edate) {
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
    
    public void requestForEquipments(ArrayList<Product> list){
        File fx = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
  
            try {
                fx = new File("EquipmentsOrderDatabase.bin");
           
                fos = new FileOutputStream(fx);
                oos = new ObjectOutputStream(fos);               
            
                for(Product i: list){
                    oos.writeObject(i);
                }
            
           // s.display();
            System.out.println("Object done inserting into file");
            
        } catch (IOException ex) {
            Logger.getLogger(RequestForEquipmentsSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(RequestForEquipmentsSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
     
        try{
           
            FileChooser fc = new FileChooser();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF files", "*.pdf"));
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image files", "*.jpg", "*.bmp", "*.png"));
            File f = fc.showSaveDialog(null);
            if(f!=null){              
                PdfWriter pw = new PdfWriter(new FileOutputStream(f));
                //PdfWriter pw = new PdfWriter(new FileOutputStream("testPDF.pdf"));
                PdfDocument pdf =  new PdfDocument(pw);
                pdf.addNewPage();
                Document doc = new Document(pdf);
                doc.setLeftMargin(70);
               //-----------------------------------------------------
               //add image 
                  /*  File imageFile = new File("download.jpg");//fc.showOpenDialog(null);
                     String imagePath = imageFile.getAbsolutePath();
                    ImageData data = ImageDataFactory.create(imagePath);
                    Image image = new Image(data);  
                    image.setAutoScale(true);
                    
                    doc.add(image);*/
                   // 
                //----------------------------------------------------
                //adding paragrapg to the pdf
                String newline = "\n";
                Paragraph lineSpace = new Paragraph(newline);
                lineSpace.setHeight(8);
                
                String paraText1 
                        = "Below is the copy of your order for specific requirements.\n"
                       ;
                Paragraph para1 = new Paragraph(paraText1);
                para1.setTextAlignment(TextAlignment.CENTER);
                Text titleText = new Text("Summary of Order");
                titleText.setFontSize(18f);
                //titleText.setTextAlignment(TextAlignment.CENTER);
                Paragraph pageTitle = new Paragraph(titleText);
                pageTitle.setBold();    //OR titleText.setBold();
                pageTitle.setTextAlignment(TextAlignment.CENTER);
                PdfFont font2 = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
                PdfFont fontBold = PdfFontFactory.createFont(FontConstants.TIMES_BOLD);
                Text name = new Text("Name: "+UserClass.getUsername()).setFont(fontBold);
                Text id  = new Text("ID: "+ UserClass.getuserId()).setFont(fontBold);
                //author.setFontColor(Color.RED);
                Paragraph userInfo = new Paragraph().add(name).add("/n").add(id);
                doc.add(lineSpace);
                doc.add(pageTitle);
                doc.add(lineSpace);
                doc.add(para1);
                doc.add(lineSpace);
                doc.add(userInfo);
                doc.add(lineSpace);
                
                
                //----------------------------------------------------
                //adding an image
               /* Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                a.setContentText("Do you want to add an Image?");
                Optional<ButtonType> result = a.showAndWait();
                if(result.get() == ButtonType.OK){ 
                    
                    
                    a = new Alert(Alert.AlertType.INFORMATION);
                    a.setContentText("The image is added successfully.");
                    a.showAndWait();
                }*/
                //----------------------------------------------------
                
                //adding table in pdf
                float colWidthArr[] = {200f, 200f};
                Table pdfTable = new Table(colWidthArr); 
                
                //adding header row
                Cell cell_00 = new Cell(); 
                cell_00.add("Product name");
                cell_00.setBackgroundColor(Color.YELLOW);
                pdfTable.addCell(cell_00);
                Cell cell_01 = new Cell(); 
                cell_01.add("Quantity");
                cell_01.setBackgroundColor(Color.YELLOW);
                pdfTable.addCell(cell_01);
                //pdfTable.addCell(new Cell().setBackgroundColor(Color.YELLOW).add("Product Name"));
               // pdfTable.addCell(new Cell().setBackgroundColor(Color.YELLOW).add("Quantity"));
                pdfTable.setPageNumber(1);
               
                //adding content row
                File fo = null;
                FileInputStream fis = null;      
                ObjectInputStream ois = null;

            try {
                 fo = new File("EquipmentsOrderDatabase.bin");
                 fis = new FileInputStream(fo);
                 ois = new ObjectInputStream(fis);

                Product p;
                 try{
                     while(true){
                         System.out.println("checking objects.");
                         p = (Product)ois.readObject();
                         System.out.println(p.getProductName());
                         System.out.println(p.getProductQuantity());
                        System.out.println("I am here");
                         pdfTable.addCell(new Cell().add(p.getProductName()));
                         pdfTable.addCell(new Cell().add(Integer.toString((p.getProductQuantity()))));
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
               
                
                //adding content row
                //pdfTable.addCell(new Cell().add("222"));
                //pdfTable.addCell(new Cell().add("Aarong Yougart"));
                //pdfTable.addCell(new Cell().add("75.0"));
                
                //adding content row
               // pdfTable.addCell(new Cell().add("333"));
                //pdfTable.addCell(new Cell().add("Brown Bread"));
                //pdfTable.addCell(new Cell().add("85.0"));

                doc.add(pdfTable);
                
                //String newline = "\n";
                Paragraph lineSpace1 = new Paragraph(newline);
                lineSpace.setHeight(8);
                String paraText2
                        = "Please refer to IUB financial office for further informations or confusion.\n" ;
                       ;
                Paragraph para2 = new Paragraph(paraText2);
                para2.setTextAlignment(TextAlignment.CENTER);
                doc.add(lineSpace1);
                
                doc.add(para2);
               
               // doc.add(bookInfo);
                doc.add(lineSpace);
                
                doc.close();
                
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("The PDF is saved successfully.");
                a.showAndWait();  
            }
            else{
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("Saving as PDF: cancelled!");
                a.showAndWait();               
            }
        }
        catch(Exception e){
          
        }  
    }
        
    }

    
    
         
     
