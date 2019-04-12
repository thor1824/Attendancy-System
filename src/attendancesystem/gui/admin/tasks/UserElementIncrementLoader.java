/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.gui.admin.tasks;

import attendancesystem.be.Student;
import attendancesystem.gui.admin.model.AdminModel;
import attendancesystem.gui.elements.UserElement;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.scene.image.ImageView;

/**
 *
 * @author Thorbjørn Schultz Damkjær
 */
public class UserElementIncrementLoader extends Task<ObservableList<UserElement>>
{

    private ImageView iv;
    private ObservableList<Student> students;
    private int threadsDone = 0;
    private AdminModel model;
    private int begin;
    private int end;
    private ExecutorService exe;

    public UserElementIncrementLoader(ObservableList<Student> students, AdminModel model, int begin, int end, ExecutorService exe)
    {
        this.exe = exe;
        this.students = students;
        this.model = model;
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected ObservableList<UserElement> call() throws Exception
    {
        ObservableList<UserElement> elements = FXCollections.observableArrayList();
        try
        {
            ExecutorService executor = Executors.newFixedThreadPool(10);
            CountDownLatch latch = new CountDownLatch(end);
            for (int i = begin; i < end; i++)
            {
                UserElementLoader ueLoader = new UserElementLoader(students.get(i), model);
                executor.submit(ueLoader);

                ueLoader.valueProperty().addListener((obv, oldV, newV) ->
                {
                    elements.add(newV);
                    latch.countDown();
                });

                
            }
            latch.await();
            updateValue(elements);
        } catch (InterruptedException interruptedException)
        {
            interruptedException.printStackTrace();
        }
        System.out.println("");
        return elements;
    }

}
