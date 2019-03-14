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
import java.io.RandomAccessFile;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thorbjørn Schultz Damkjær
 */
public class DataToServerMigration
{
    //klasser skal vælges random ud fra en list med 10?

    private static ServerConnect sc;

    /**
     * Example method. This is the code I used to create the users.txt files.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException
    {
        sc = new ServerConnect();
        //mitigateMovies();
        //mitigateUsers();
        //mitigateRatings();
    }

    public static void mitigateStudent() throws IOException
    {
        String userSauce = "";
        try (Connection con = sc.getConnection())
        {
            Statement statement = con.createStatement();
            statement.execute("DELETE FROM [User]");
            
            File file = new File(userSauce);

            try (BufferedReader reader = new BufferedReader(new FileReader(file)))
            {
                String line;
                while ((line = reader.readLine()) != null)
                {
                    try
                    {
                        statement.execute(line);
                    } catch (Exception ex)
                    {
                        //Do nothing
                    }
                }
                reader.close();
            }
            con.close();
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    
    public static void mitigateTeacher() throws IOException
    {
        String userSauce = "";
        try (Connection con = sc.getConnection())
        {
            Statement statement = con.createStatement();
            statement.execute("DELETE FROM [User]");
            
            File file = new File(userSauce);

            try (BufferedReader reader = new BufferedReader(new FileReader(file)))
            {
                String line;
                while ((line = reader.readLine()) != null)
                {
                    try
                    {
                        statement.execute(line);
                    } catch (Exception ex)
                    {
                        //Do nothing
                    }
                }
                reader.close();
            }
            con.close();
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    
    public static void mitigateLogin() throws IOException
    {
        String userSauce = "";
        try (Connection con = sc.getConnection())
        {
            Statement statement = con.createStatement();
            statement.execute("DELETE FROM [User]");
            
            File file = new File(userSauce);

            try (BufferedReader reader = new BufferedReader(new FileReader(file)))
            {
                String line;
                while ((line = reader.readLine()) != null)
                {
                    try
                    {
                        statement.execute(line);
                    } catch (Exception ex)
                    {
                        //Do nothing
                    }
                }
                reader.close();
            }
            con.close();
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    
    public static void mitigateAbsense() throws IOException
    {
        String userSauce = "";
        try (Connection con = sc.getConnection())
        {
            Statement statement = con.createStatement();
            statement.execute("DELETE FROM [User]");
            
            File file = new File(userSauce);

            try (BufferedReader reader = new BufferedReader(new FileReader(file)))
            {
                String line;
                while ((line = reader.readLine()) != null)
                {
                    try
                    {
                        statement.execute(line);
                    } catch (Exception ex)
                    {
                        //Do nothing
                    }
                }
                reader.close();
            }
            con.close();
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    
    public static void mitigateLektion() throws IOException
    {
        String userSauce = "";
        try (Connection con = sc.getConnection())
        {
            Statement statement = con.createStatement();
            statement.execute("DELETE FROM [User]");
            
            File file = new File(userSauce);

            try (BufferedReader reader = new BufferedReader(new FileReader(file)))
            {
                String line;
                while ((line = reader.readLine()) != null)
                {
                    try
                    {
                        statement.execute(line);
                    } catch (Exception ex)
                    {
                        //Do nothing
                    }
                }
                reader.close();
            }
            con.close();
        } catch (SQLException ex)
        {
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

}
