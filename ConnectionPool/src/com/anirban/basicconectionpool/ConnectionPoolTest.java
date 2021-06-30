package com.anirban.basicconectionpool;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPoolTest {

  public static void main(String[] args) throws SQLException {
    BasicConnectionPool pool =new BasicConnectionPool("jdbc:mysql://localhost/mydb","root","Ani#Tani25");
    Connection con1 = pool.getConnection();
    Connection con2 = pool.getConnection();
    System.out.println(pool.getFreeConnectionCount());
    Connection con3 = pool.getConnection();
    Connection con4 = pool.getConnection();
    Connection con5 = pool.getConnection();
    Connection con6 = pool.getConnection();
    System.out.println(pool.getFreeConnectionCount());
    pool.releaseConnection(con1);
    pool.releaseConnection(con2);
    pool.releaseConnection(con4);
    System.out.println(pool.getFreeConnectionCount());
  }
}
