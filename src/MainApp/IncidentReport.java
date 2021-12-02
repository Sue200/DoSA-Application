/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

import java.io.Serializable;


public class IncidentReport implements Serializable{
    
        private String name, position , address, incidentDescript;
        private int id, phone;

    public IncidentReport(String name, String position, String address, String incidentDescript, int id, int phone) {
        this.name = name;
        this.position = position;
        this.address = address;
        this.incidentDescript = incidentDescript;
        this.id = id;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIncidentDescript() {
        return incidentDescript;
    }

    public void setIncidentDescript(String incidentDescript) {
        this.incidentDescript = incidentDescript;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
        
        

  
        
        
}
