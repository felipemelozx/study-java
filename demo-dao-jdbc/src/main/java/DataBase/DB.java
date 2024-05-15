package DataBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
///home/felipe/Desktop/IdeaProjects/java-udemy/demo-dao-jdbc/src/

public  class DB {
    private static final Properties properties = new Properties();
    private static Connection conn;
    private  static final String ARQUIVO_PROPRIEDADES = "db.properties";



    public static Connection getConnection() {

        try(InputStream ent = new FileInputStream(ARQUIVO_PROPRIEDADES);){
            if (conn == null) {
                properties.load(ent);

                String url = properties.getProperty("url");
                String user = properties.getProperty("user");
                String password = properties.getProperty("password");

                Class.forName("com.mysql.cj.jdbc.Driver");
                return DriverManager.getConnection(url, user, password);

            }
            return conn;
        }
        catch (IOException | ClassNotFoundException | SQLException e) {
            throw new DbException(e.getMessage());
        }

    }



    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new DbException("Erro ao fechar a conexão com o banco de dados: " + e.getMessage());
            }
        }
    }

    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }



}
