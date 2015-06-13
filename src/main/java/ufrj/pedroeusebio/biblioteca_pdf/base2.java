/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufrj.pedroeusebio.biblioteca_pdf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author pedroeusebio
 */
public class base2 {

    public static void connect()  {
        try{
        DbInfo database = new DbInfo();

        Class.forName("org.postgresql.Driver");

        Connection con;

        con = DriverManager.getConnection(database.getUrl(), database.getUsuario(),database.getSenha());
        //con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
