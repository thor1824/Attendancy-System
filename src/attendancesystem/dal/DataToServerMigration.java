/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.dal;

import attendancesystem.dal.db.Server.ServerConnect;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

/**
 *
 * @author Thorbjørn Schultz Damkjær
 */
public class DataToServerMigration {
    //klasser skal vælges random ud fra en list med 10?

    private static ServerConnect sc;
    private static String[] classes = {"CSa2018", "CSb2018", "EEa2018", "EEb2018", "MEa2018", "MEb2018", "MDa2018", "MDb2018", "EZa2018", "EZb2018"};
    private static String[] Zip = {"6760", "6700", "6715", "6705", "6630"};

    /**
     * Example method. This is the code I used to create the users.txt files.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        sc = new ServerConnect();
//        for (int i = 0; i < 100; i++) {
//         System.out.println(genrateCpr());   
//        }
//        
        ////mitigateClasses();
        mitigateStudent();
    }

    public static void mitigateStudent() throws IOException {
        String userSauce = "src/MockData/StudentMockDATA.txt";
        try (Connection con = sc.getConnection()) {
            Statement statement = con.createStatement();
            statement.execute("DELETE FROM [Atendens].[dbo].[Student]");

            File file = new File(userSauce);

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                int i = 50;
                Random rng = new Random();
                while ((line = reader.readLine()) != null) {
                    try {
                        String[] arrUser = line.split(",");

                        String UserID = String.valueOf(i);
                        i++;
                        String lName = arrUser[0];
                        String fName = arrUser[1];
                        String classid = String.valueOf(rng.nextInt((10 - 1) + 1) + 1);
                        String phone = arrUser[2];
                        String email = arrUser[3];
                        String adresse = arrUser[4];
                        String zipCode = Zip[rng.nextInt((4 - 0) + 1) + 0];
                        String cpr = genrateCpr();
                        String picURL = arrUser[5];

                        statement.execute("INSERT INTO [Atendens].[dbo].[Student] (UserID,StuLName,StuFName,ClassID,Phone,Email,Adress,ZipCode, Cpr, StuPicUrl) "
                                + "VALUES ('" + UserID + "', '" + lName + "', '" + fName + "', '" + classid + "', '" + phone + "', '" + email + "', '" + adresse+ "', '" + zipCode + "', '"+ cpr + "', '" +picURL +"');");
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

    public static void mitigateTeacher() throws IOException {
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

    public static void mitigateLogin() throws IOException {
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

    public static void mitigateLektion() throws IOException {
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

//    public static void createRafFriendlyRatingsFile() throws IOException
//    {
//        String target = "data/user_ratings";
//        RatingDAO ratingDao = new RatingDAO();
//        List<Rating> all = ratingDao.getAllRatings();
//
//        try (RandomAccessFile raf = new RandomAccessFile(target, "rw"))
//        {
//            for (Rating rating : all)
//            {
//                raf.writeInt(rating.getMovie());
//                raf.writeInt(rating.getUser());
//                raf.writeInt(rating.getRating());
//            }
//        } catch (IOException ex)
//        {
//            ex.printStackTrace();
//        }
//    }
    private static String genrateCpr() {
        String cpr = "";
        Random rng = new Random();
        for (int i = 0; i < 3; i++) {
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
        cpr += "-" + String.valueOf(rng.nextInt((9999 - 1000) + 1) + 1000);
        return cpr;
    }
}
