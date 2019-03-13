/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.gui.user.model;

import attendancesystem.be.UndocumentetModulAbsence;
import attendancesystem.be.User;
import attendancesystem.bll.BLLManager;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

/**
 *
 * @author Thorbjørn Schultz Damkjær
 */
public class UserModel {

    BLLManager bll;

    BLLManager bllMan;

    public UserModel() {
        bllMan = new BLLManager();
    }

//    public String calculateDate()
//    {
//
//        return date and time
//    }
    public PieChart buildPieChard() {
        return bllMan.buildPieChard();
    }

    public User handleLoginRequest(String username, String password) {
        return bllMan.handleLoginRequest(username, password);
    }

    public ArrayList<UndocumentetModulAbsence> getUndocumentetAbsence(User user) {
        return bllMan.getUndocumentetAbsence(user);
    }

}