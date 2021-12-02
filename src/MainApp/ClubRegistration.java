/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

import java.io.Serializable;


public class ClubRegistration extends Registration implements Serializable {
    
    private String clubName, reasonForJoin;
    
    public ClubRegistration(String name, String id, String email, String dept,String cn ,String rfj) {
        super(name, id, email, dept);
        this.clubName = cn;
        this.reasonForJoin = rfj;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getReasonForJoin() {
        return reasonForJoin;
    }

    public void setReasonForJoin(String reasonForJoin) {
        this.reasonForJoin = reasonForJoin;
    }
    
}
