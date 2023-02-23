package com.example.subsidieradar.sqlTool;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.ibatis.jdbc.ScriptRunner;

public class scriptRunner {
    public static void RunScript() throws Exception {
        //Registering the Driver
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        //Getting the connection
        String mysqlUrl = "jdbc:postgresql://wl-db:5432/subsidie-radar";
        Connection con = DriverManager.getConnection(mysqlUrl, "subsidie-radar", "subsidie-radar");
        System.out.println("Connection established......");
        //Initialize the script runner
        ScriptRunner sr = new ScriptRunner(con);
        //Creating a reader object
        System.out.println("Running script......");
        Reader reader = new BufferedReader(new FileReader("/data/fill-Database-Citydeals.sql"));
        //Running the script
        sr.runScript(reader);
    }
}
