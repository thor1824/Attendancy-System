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

    private StringProperty name;
    private StringProperty schoolClass;
    private StringProperty eMail;

    
    
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
