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
public class Student {

    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty schoolClass = new SimpleStringProperty();
    private final StringProperty eMail = new SimpleStringProperty();

    public Student() {
    }
    

    public String geteMail() {
        return eMail.get();
    }

    public void seteMail(String value) {
        eMail.set(value);
    }

    public StringProperty eMailProperty() {
        return eMail;
    }
    

    public String getSchoolClass() {
        return schoolClass.get();
    }

    public void setSchoolClass(String value) {
        schoolClass.set(value);
    }

    public StringProperty schoolClassProperty() {
        return schoolClass;
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
