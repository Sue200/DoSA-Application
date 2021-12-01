/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Farha
 */
public class Eventpicker  implements Serializable {
   // private static final long serialVersionUID = 6424129408819760362L;
   // private static final long serialVersionUID = 6529685098267757690L;
   // private static final long serialVersionUID = 1L;
    private String eventname;
    private String eventTime;
    private String eventVenue;
    private LocalDate eventDate;

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String name) {
        this.eventname = name;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String time) {
        this.eventTime = time;
    }

    public Eventpicker(String eventname, String eventTime, String eventVenue, LocalDate eventDate) {
        this.eventname = eventname;
        this.eventTime = eventTime;
        this.eventVenue = eventVenue;
        this.eventDate = eventDate;
    }

    public String getEventVenue() {
        return eventVenue;
    }

    public void setEventVenue(String venue) {
        this.eventVenue = venue;
    }
    
    public void display(){
         System.out.println("name: " + eventname + "\n"+ "time: "+eventTime + "\n" + "venue: "+eventVenue + "\n");
    }

    /*private SimpleStringProperty eventname;
    
    private SimpleStringProperty eventVenue;
    //private DatepickerlocalDate;
    private SimpleStringProperty eventTime;
    //private DatepickerlocalDate;
    
    
    Eventpicker(String n, String v,  String t){
        this.eventTime = new SimpleStringProperty( t);
        this.eventVenue =new SimpleStringProperty( v);
        this.eventname = new SimpleStringProperty(n);
        
    }

   

    public String getEventname() {
        return eventname.get();
    }

    public void setEventname(String name) {
         this.eventname = new SimpleStringProperty(name);
    }

    public String getEventVenue() {
        return eventVenue.get();
    }

    public void setEventVenue(String venue) {
        this.eventVenue = new SimpleStringProperty(venue);
    }

    public String getEventTime() {
        return eventTime.get();
    }

    public void setEventTime(String time) {
        this.eventTime =new SimpleStringProperty( time);
    }
    
  
  
     public void display(){
         System.out.println("name: " + eventname.get() + "\n"+ "time: "+eventTime.get() + "\n" + "venue: "+eventVenue.get() + "\n");
     }*/

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

   

    
}
