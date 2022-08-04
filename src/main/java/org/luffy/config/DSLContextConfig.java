package org.luffy.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.enterprise.context.ApplicationScoped;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

@ApplicationScoped
public class DSLContextConfig {
  protected Connection conn;
  protected DSLContext context;

  public DSLContextConfig() throws SQLException {
    this.conn = (Connection) DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/manage_hotel?autoReconnect=true",
        "root",
        "17102001abc!");
    this.context = DSL.using(conn, SQLDialect.MYSQL);
  }
}