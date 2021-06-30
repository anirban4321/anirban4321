package com.anirban.basicconectionpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.CopyOnWriteArrayList;

public class BasicConnectionPool implements ConnectionPool {
  private CopyOnWriteArrayList<Connection> availableConnections = new CopyOnWriteArrayList<Connection>();
  private CopyOnWriteArrayList<Connection>usedConnections = new CopyOnWriteArrayList<Connection>();
  /* private List<Connection> availableConnections = Collections.synchronizedList(new ArrayList<Connection>());
  private List<Connection>usedConnections = Collections.synchronizedList(new ArrayList<Connection>());
  */
  private final int MAX_CONNECTIONS = 5;

  private String URL;
  private String USERID;
  private String PASSWORD;

  public BasicConnectionPool(String Url, String UserId, String password)
      throws SQLException {
    this.URL = Url;
    this.USERID = UserId;
    this.PASSWORD = password;

    for (int count = 0; count <MAX_CONNECTIONS; count++) {
      availableConnections.add(this.createConnection());
    }
  }

  private  Connection createConnection() throws SQLException {
    return DriverManager.getConnection(URL,USERID,PASSWORD);
  }

  @Override
  public Connection getConnection() {
    if(availableConnections.size()==0){
      System.out.println("All connections are used !!!");
      return null;
    }else {
     Connection connection = availableConnections.remove(availableConnections.size()-1);
     usedConnections.add(connection);
     return connection;
    }
  }

  @Override
  public boolean releaseConnection(Connection connection) {
    if(null!=connection){
      usedConnections.remove(connection);
      availableConnections.add(connection);
      return true;
    }
    return false;
  }

  public int getFreeConnectionCount() {
    return availableConnections.size();
  }

  @Override
  public String getUtl() {
    return null;
  }

  @Override
  public String getUsername() {
    return null;
  }

  @Override
  public String getPassword() {
    return null;
  }
}
