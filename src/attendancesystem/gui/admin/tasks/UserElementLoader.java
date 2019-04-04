/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.gui.admin.tasks;

import attendancesystem.be.Student;
import attendancesystem.gui.admin.model.AdminModel;
import attendancesystem.gui.elements.UserElement;
import java.time.Duration;
import java.time.Instant;
import javafx.concurrent.Task;
import javafx.scene.image.ImageView;

/**
 *
 * @author Thorbjørn Schultz Damkjær
 */
public class UserElementLoader extends Task<UserElement> {

    private ImageView iv;
    private Student student;
    
    private AdminModel model;

    public UserElementLoader(Student student, AdminModel model) {

        this.student = student;
        this.model = model;
    }

    @Override
    protected UserElement call() throws Exception {
        Instant begin = Instant.now();
        
        UserElement ue = new UserElement(student, model);
        updateValue(ue);
        Instant finish = Instant.now();
        long elapsedTime = Duration.between(begin, finish).toMillis();
        System.out.println(elapsedTime + " ms");
        
        return ue;
    }

}
