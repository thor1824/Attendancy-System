/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.dal;

import attendancesystem.bll.PasswordEncryptor;
import attendancesystem.dal.db.Server.ServerConnect;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

/**
 *
 * @author Thorbjørn Schultz Damkjær
 */
public class DataToServerMigration {

    private static ServerConnect sc;
    private static String[] classes = {"CSa2018", "CSb2018", "EEa2018", "EEb2018", "MEa2018", "MEb2018", "MDa2018", "MDb2018", "EZa2018", "EZb2018"};
    private static String[] Zip = {"6760", "6700", "6715", "6705", "6630"};
    private static String[][] startEND = {{"09:00", "11:30"}, {"12:00", "13:30"}};

    public static void main(String[] args) throws IOException, SQLException {
        sc = new ServerConnect();
        //System.out.println(PasswordEncryptor.encryptPassword("testelev"));
        ////mitigateClasses();
        ////mitigateUsers();
        ////mitigateStudent();
        ////mitigateTeacher();
        ////mitigateSubjects();
        daysOfClass();

    }

    public static void mitigateStudent() throws IOException {
        String userSauce = "src/MockData/TeacherMockDATA.txt";
        try (Connection con = sc.getConnection()) {
            Statement statement = con.createStatement();
            statement.execute("DELETE FROM [Atendens].[dbo].[Student]");

            File file = new File(userSauce);

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                int i = 400;
                Random rng = new Random();
                while ((line = reader.readLine()) != null) {
                    try {
                        String[] arrTemp = line.split(",");

                        String UserID = String.valueOf(i);
                        i++;
                        String lName = arrTemp[0];
                        String fName = arrTemp[1];
                        String classid = String.valueOf(rng.nextInt((10 - 1) + 1) + 1);
                        String phone = arrTemp[2];
                        String email = arrTemp[3];
                        String adresse = arrTemp[4];
                        String zipCode = Zip[rng.nextInt((4 - 0) + 1) + 0];
                        String cpr = genrateCpr();
                        String picURL = arrTemp[5];

                        statement.execute("INSERT INTO [Atendens].[dbo].[Student] "
                                + "(UserID, StuLName, StuFName, ClassID, Phone, Email, Adress, ZipCode, Cpr, StuPicUrl) "
                                + "VALUES (" + UserID + ", '" + lName + "', '" + fName + "', " + classid + ", '" + phone + "', '" + email + "', '" + adresse + "', '" + zipCode + "', '" + cpr + "', '" + picURL + "');");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                reader.close();
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void mitigateTeacher() throws IOException {
        String userSauce = "src/MockData/TeacherMockData.txt";
        try (Connection con = sc.getConnection()) {
            Statement statement = con.createStatement();
            statement.execute("DELETE FROM [Atendens].[dbo].[Teacher]");

            File file = new File(userSauce);

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                int i = 401;
                Random rng = new Random();
                while ((line = reader.readLine()) != null) {
                    try {
                        String[] arrTemp = line.split(",");

                        String UserID = String.valueOf(i);
                        i++;
                        String lName = arrTemp[0];
                        String fName = arrTemp[1];
                        String phone = String.valueOf(rng.nextInt((99999999 - 10000000) + 1) + 10000000);
                        String email = arrTemp[2];
                        String adresse = arrTemp[3];
                        String zipCode = Zip[rng.nextInt((4 - 0) + 1) + 0];
                        String cpr = genrateCpr();
                        String picURL = arrTemp[4];

                        statement.execute("INSERT INTO [Atendens].[dbo].[Teacher] "
                                + "(UserID, TeachLName, TeachFName, Phone, Email, Adress, ZipCode, Cpr, TeachPicUrl, AccesLvl) "
                                + "VALUES (" + UserID + ", '" + lName + "', '" + fName + "', '" + phone + "', '" + email + "', '" + adresse + "', '" + zipCode + "', '" + cpr + "', '" + picURL + "', " + "2" + ");");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                reader.close();
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void mitigateUsers() throws IOException {
        String userSauce = "src/MockData/UserMockDATA.txt";
        try (Connection con = sc.getConnection()) {
            Statement statement = con.createStatement();
            statement.execute("DELETE FROM [Atendens].[dbo].[Login]");

            File file = new File(userSauce);

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                int i = 50;
                Random rng = new Random();
                while ((line = reader.readLine()) != null) {
                    try {
                        String[] arrUser = line.split(",");

                        String userName = arrUser[0];
                        String Password = arrUser[1];
                        String encryptedPassword = PasswordEncryptor.encryptPassword(Password);

                        statement.execute("INSERT INTO [Atendens].[dbo].[Login] "
                                + "(Username, Password) "
                                + "VALUES ('" + userName + "', '" + encryptedPassword + "');");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                reader.close();
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void daysOfClass() throws SQLException, SQLServerException, IOException {

        for (int i = 0; i < 348; i++) {
            Connection con = sc.getConnection();
            String Sql = "Update [Atendens].[dbo].[Student] "
                    + "set Days_of_classes = 100 "
                    + "WHERE Student.StuID = ?;";
            PreparedStatement ps = con.prepareStatement(Sql);
            ps.setInt(1, i);
            ps.execute();
        }
        
    }

    public static void mitigateSubjects() throws IOException {
        String userSauce = "src/MockData/SubjectMockData.txt";
        try (Connection con = sc.getConnection()) {
            Statement statement = con.createStatement();
            statement.execute("DELETE FROM [Atendens].[dbo].[Subject]");

            File file = new File(userSauce);

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                int i = 50;
                Random rng = new Random();
                while ((line = reader.readLine()) != null) {
                    try {
                        String[] arrUser = line.split(",");

                        String teachID = arrUser[0];
                        String name = arrUser[1];
                        String classID = arrUser[2];

                        statement.execute("INSERT INTO [Atendens].[dbo].[Subject] "
                                + "(TeachID, Name, ClassID) "
                                + "VALUES (" + teachID + ", '" + name + "', " + classID + ");");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                reader.close();
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void mitigateClasses() throws IOException {
        try (Connection con = sc.getConnection()) {
            Statement sm = con.createStatement();
            for (int i = 0; i < 10; i++) {

                sm.execute("INSERT INTO [Atendens].[dbo].[Class] (ClassName) VALUES ('" + classes[i] + "');");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void mitigateAbsense() throws IOException {
        String userSauce = "";
        try (Connection con = sc.getConnection()) {
            Statement statement = con.createStatement();
            statement.execute("DELETE FROM [User]");

            File file = new File(userSauce);

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    try {
                        statement.execute(line);
                    } catch (Exception ex) {
                        //Do nothing
                    }
                }
                reader.close();
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void mitigateModul() throws IOException {
        String userSauce = "";
        try (Connection con = sc.getConnection()) {
            Statement statement = con.createStatement();
            statement.execute("DELETE FROM [User]");

            File file = new File(userSauce);

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    try {
                        statement.execute(line);
                    } catch (Exception ex) {
                        //Do nothing
                    }
                }
                reader.close();
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static String genrateCpr() {
        String cpr = "";
        Random rng = new Random();
        for (int i = 0; i < 2; i++) {
            int tmp = rng.nextInt((12 - 1) + 1) + 1;
            if (tmp <= 9) {
                String tmp_String = String.valueOf(tmp);
                tmp_String = "0" + tmp_String;
                cpr += tmp_String;
            } else {
                String tmp_String = String.valueOf(tmp);
                cpr += tmp_String;
            }
        }

        cpr += String.valueOf(rng.nextInt((90 - 40) + 1) + 40);
        cpr += "-" + String.valueOf(rng.nextInt((9999 - 1000) + 1) + 1000);
        return cpr;
    }
}
