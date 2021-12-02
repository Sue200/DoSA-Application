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
import javafx.beans.property.SimpleStringProperty;


public class Notice implements Serializable {
    
  private String announcement;
  private LocalDate date;
  
  Notice(String s , LocalDate d){
      //announcement = new SimpleStringProperty(s);
      this.announcement =s;
      this.date= d ;
  }

    Notice() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getAnnouncement() {
        //return announcement.get();
        return announcement;
    }

    public void setAnnouncement(String a) {
       // announcement = new SimpleStringProperty(a);
        this.announcement =a;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate d) {
         this.date= d;
    }
   

   
    
    
    
}
