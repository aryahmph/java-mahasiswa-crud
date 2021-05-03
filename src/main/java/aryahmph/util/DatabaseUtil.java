package aryahmph.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DatabaseUtil {
  private static HikariDataSource dataSource;

  static {
    HikariConfig config = new HikariConfig();
    config.setDriverClassName("com.mysql.cj.jdbc.Driver");
    config.setJdbcUrl("jdbc:mysql://localhost:3306/crud_mahasiswa_java");
    config.setUsername("root");
    config.setPassword("");

    config.setMaximumPoolSize(5);
    config.setMinimumIdle(3);
    config.setIdleTimeout(60_000);
    config.setMaxLifetime(60 * 60 * 60_000);

    dataSource = new HikariDataSource(config);
  }

  public static HikariDataSource getDataSource() {
    return dataSource;
  }
}
