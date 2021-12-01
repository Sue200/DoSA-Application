/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

import java.time.LocalDate;

/**
 *
 * @author Farha
 */
public interface UpdateEvent {
    
    public void addnewEvent(String type, String ename , String etime , String evenue,LocalDate date);
    
    
}
