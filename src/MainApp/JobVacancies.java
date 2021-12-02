/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

import java.time.LocalDate;
import javafx.collections.ObservableList;


public interface JobVacancies{
    
    public void addnewJobPost(String jobname,String orgname, String jobdescript,LocalDate deadline);
    public void deleteJobPost( ObservableList<Job> jobs);
}
