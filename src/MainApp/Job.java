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
public class Job implements Serializable {
    
    private String jobname, jobOrg, jobDescription;
    private LocalDate date;

    public Job(String jobname, String jobOrg, String jobDescription, LocalDate date) {
        this.jobname = jobname;
        this.jobOrg = jobOrg;
        this.jobDescription = jobDescription;
        this.date = date;
    }

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jn) {
        this.jobname = jn;
    }

    public String getJobOrg() {
        return jobOrg;
    }

    public void setJobOrg(String jOrg) {
        this.jobOrg = jOrg;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jDescription) {
        this.jobDescription = jDescription;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate d) {
        this.date = d;
    }
    
    
    
}
