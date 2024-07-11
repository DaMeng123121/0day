package com.yhq.db;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;



public class DBConnetcion {
    private static  final  String NAME="root";
    private static  final  String PASSWORD="root";
    private static  final  String URL="jdbc:mysql://localhost:3306/test1?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
    private static  final  String DRIVER="com.mysql.cj.jdbc.Driver";
    private Connection conn=null;

    public Connection getConn(){
        return conn;
    }
    public DBConnetcion(){
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            conn=DriverManager.getConnection(URL,NAME,PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
