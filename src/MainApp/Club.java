/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

import java.io.Serializable;


public class Club implements Serializable{
    
    private String description;
    
    private String clubName;

    public Club(String d, String cn) {
        this.description = cn;
        this.clubName = d;
       
    }
    public String getDescription() {
        return description;
    }

    public String getClubName() {
        return clubName;
    }
    
    
    
    
}
