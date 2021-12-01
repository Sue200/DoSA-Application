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
public  class Registration {
    
     private String name;
    private String id;
    private String email;
    private String dept;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
    

    public Registration(String name, String id, String email, String dept) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.dept = dept;
    }
    
    
    
    
}
