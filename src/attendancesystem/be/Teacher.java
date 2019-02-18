/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.be;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Nijas Hansen
 */
public class Teacher {

    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty teacherID = new SimpleStringProperty();
    private final StringProperty password = new SimpleStringProperty();

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String value) {
        password.set(value);
    }

    public StringProperty passwordProperty() {
        return password;
    }
    

    public String getTeacherID() {
        return teacherID.get();
    }

    public void setTeacherID(String value) {
        teacherID.set(value);
    }

    public StringProperty teacherIDProperty() {
        return teacherID;
    }
    
    
    public String getName() {
        return name.get();
    }

    public void setName(String value) {
        name.set(value);
    }

    public StringProperty nameProperty() {
        return name;
    }
    
}
