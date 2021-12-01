/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

/**
 *
 * @author Farha
 */
public class ClubMembers extends Club{
    
  private String president;
  private String vpresident;
  private String Secretary;
  private String treasurer;
  private String generalSecretary;
  private String facultyAdvisor;

    public ClubMembers(String d, String cn,String p, String gs,String vp) {
        super(d, cn);
        this.president = p;
        //this.Secretary= s;
        this.generalSecretary =gs;
        this.vpresident = vp;
        //this.treasurer = t;
        //this.facultyAdvisor = fa;
    }

    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    public String getVpresident() {
        return vpresident;
    }

    public void setVpresident(String vpresident) {
        this.vpresident = vpresident;
    }

    public String getSecretary() {
        return Secretary;
    }

    public void setSecretary(String Secretary) {
        this.Secretary = Secretary;
    }

    public String getTreasurer() {
        return treasurer;
    }

    public void setTreasurer(String treasurer) {
        this.treasurer = treasurer;
    }

    public String getGeneralSecretary() {
        return generalSecretary;
    }

    public void setGeneralSecretary(String generalSecretary) {
        this.generalSecretary = generalSecretary;
    }

    public String getFacultyAdvisor() {
        return facultyAdvisor;
    }

    public void setFacultyAdvisor(String facultyAdvisor) {
        this.facultyAdvisor = facultyAdvisor;
    }
    
  
    
    
}
