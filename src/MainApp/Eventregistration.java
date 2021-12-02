/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

import java.io.Serializable;
import java.time.LocalDate;


public  class Eventregistration extends Registration implements Serializable{
    
    private String selectedEvent, eventname,eventvenue, eventTime, sem;
    private LocalDate date;
    private int phoneNo;
  

    public Eventregistration(String name, String id, String email, String dept,String evtype, String en, int phoneNo, String sem) {
        super(name, id, email, dept);
        
       this.selectedEvent = evtype;
       this.eventname = en;
       this.phoneNo = phoneNo;
       this.sem = sem;
        
    }

    public Eventregistration(String name, String id, String email, String dept,String selectedEvent, String eventname,int phoneNo, String sem, String eventvenue, String eventTime, LocalDate date) {
        super(name, id, email, dept);
        this.selectedEvent = selectedEvent;
        this.eventname = eventname;
        this.eventvenue = eventvenue;
        this.eventTime = eventTime;
        this.sem = sem;
        this.date = date;
        this.phoneNo = phoneNo;
    }

    public String getSelectedEvent() {
        return selectedEvent;
    }

    public void setSelectedEvent(String selectedEvent) {
        this.selectedEvent = selectedEvent;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }
}
