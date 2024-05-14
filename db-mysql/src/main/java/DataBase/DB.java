package DataBase;

import java.sql.*;


public class DB {
    private static final String URL = "jdbc:mysql://localhost:3306/coursejdbc";
    private static final String USUARIO = "felipe";
    private static final String SENHA = "@Felipe132#Dev";
    private static Connection conn;


    public static Connection getConnection() {
        try {
            if (conn == null) {
                return DriverManager.getConnection(URL, USUARIO, SENHA);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
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
