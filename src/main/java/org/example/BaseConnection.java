package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseConnection {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/Invoice Management System";
    static final String USER = "postgres";
    static final String PASS = "root";
    Connection conn= null;
    public BaseConnection() {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
