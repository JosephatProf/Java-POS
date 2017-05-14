/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proffesor;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.Properties;
import java.sql.DriverManager;
import java.sql.Statement;
/**
 *
 * @author Jose
 */
public class Proffesor {

    /**
     * @param args the command line arguments
     */
    public Connection getConnection()
    {

        Connection conn;
        //connect to the mysql database java_db
        try{
            //Class.forName("org.h2.Driver");
            //DriverManager.registerDriver(new StudentData.mysql.jdbc.Driver ());
            Class.forName("com.mysql.jdbc.Driver"); 
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/moreen", "root", "");
            
            return conn;
        }catch(Exception e){
            //catches the exceptional error if failed to connect to the database
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        
        try{
                launch lau = new launch();
                lau.setVisible(true);
                for(int i = 0; i <= 100; i++){
                //set the sleep time of the loader
                    Thread.sleep(45);
                    lau.loadingnum.setText("Loading..."+Integer.toString(i) +" %");
                    lau.loadingbar.setValue(i);
                    //open grading panel if loading in the progress bar is over
                    if(i == 100){
                        
                        JOptionPane.showMessageDialog(null, "Welcome");
                        
                        LoginPanel log = new LoginPanel();
                        log.setVisible(true);
                        lau.setVisible(false);
                        

                    }else if(i == 45){
                        lau.guides_add.setText("Please wait while setting things in order");
                        Connection conn = null;
                        try {
                String databaseName = "moreen";
                String userName = "root";
                String password = "";

                String url = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
                Connection connection = DriverManager.getConnection(url,userName, password);

                String sql = "CREATE DATABASE IF NOT EXISTS " + databaseName;

                Statement statement = connection.createStatement();
                statement.executeUpdate(sql);
                statement.close();
                lau.guides_add.setText("Database created successfully");
//                JOptionPane.showMessageDialog(null, databaseName + " Database has been created successfully", "System Message", JOptionPane.INFORMATION_MESSAGE);
                

                        } catch (Exception e) {
                            e.printStackTrace();
                    }
                    }else if(i == 90){
                        try {
                    // create table
                    String que = "CREATE TABLE IF NOT EXISTS users( \n" +
                    "        id INT NOT NULL AUTO_INCREMENT, \n" +
                    "        username VARCHAR(32),\n" +
                    "        password VARCHAR(32),  \n" +
                    "        security_id INT(64),  \n" +
                    "       PRIMARY KEY (`id`))";
                        Connection conntable = DriverManager.getConnection("jdbc:mysql://localhost:3306/moreen", "root", "");
                        Statement Stmt = conntable.createStatement();
                        Stmt.executeUpdate(que);
                        Stmt.close();
                        //JOptionPane.showMessageDialog(null, " Table has been created successfully");
                        } catch (Exception e) {
                            e.printStackTrace();
                    }
                        lau.guides_add.setText("All tables created.");
                    }else if(i == 99){
                        lau.guides_add.setText("Enjoy out service now after log in!!");
                    }
            }
                }catch (Exception e){
                    
                }
    }
    
}
