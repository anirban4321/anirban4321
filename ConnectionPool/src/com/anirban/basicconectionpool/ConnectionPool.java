package com.anirban.basicconectionpool;

import java.sql.Connection;

public interface ConnectionPool {
  Connection getConnection();
  boolean releaseConnection(Connection connection);
  String getUtl();
  String getUsername();
  String getPassword();
}
