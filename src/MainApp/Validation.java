/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Farha
 */
public class Validation {
    
    public boolean validateid(String id){
        Pattern p =  Pattern.compile("[0-9]+");
        Matcher m = p.matcher(id);
        if(m.find()&& m.group().equals(id)){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean validateEmail(String email){
        Pattern p =  Pattern.compile("[0-9][0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
        Matcher m = p.matcher(email);
        if(m.find()&& m.group().equals(email)){
            return true;
        }
        else{
            return false;
        }
        
    }
    public boolean validatePhoneNo(String phoneNo){
         Pattern p =  Pattern.compile("[0-9]+");
        Matcher m = p.matcher(phoneNo);
        if(m.find()&& m.group().equals(phoneNo)){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean validatetextfield(String s){
        Pattern p =  Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(s);
        if(m.find()&& m.group().equals(s)){
            return true;
        }
        else{
            return false;
        }
    }
}
