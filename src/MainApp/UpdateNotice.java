/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

import java.time.LocalDate;
import javafx.collections.ObservableList;


public interface UpdateNotice {
    
    public Notice addnewnotice(String announcement, LocalDate date);
    public void deleteNotice(ObservableList<Notice> n);
}
