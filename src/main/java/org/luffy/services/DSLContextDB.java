package org.luffy.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

public class DSLContextDB {

  protected Connection conn;
  protected DSLContext context;

  public DSLContextDB() throws SQLException {
    this.conn = (Connection) DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/manage_hotel?autoReconnect=true",
        "root",
        "17102001abc!");
    this.context = DSL.using(conn, SQLDialect.MYSQL);
  }
}
