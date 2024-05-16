package model.dao.impl;

import DataBase.DB;
import DataBase.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.sql.*;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {
    private final Connection conn;

    public DepartmentDaoJDBC(Connection conn){
        this.conn = conn;
    }
    @Override
    public void insert(Department obj) {
        PreparedStatement statement = null;

        try {
            statement = conn.prepareStatement(
                    "INSERT INTO department (Name) VALUES(?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            statement.setString(1, obj.getName());

            int rowsAffected = statement.executeUpdate();
            if(rowsAffected > 0){
                ResultSet rs = statement.getGeneratedKeys();
                if(rs.next()){
                    int id = rs.getInt(1);
                    obj.setId(id);
                    DB.closeResultSet(rs);
                }
                System.out.println("Department inserted.");
            }else {
                throw new DbException("UNEXPECTED ERROR! Department not inserted.");
            }
        }catch (SQLException e ){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(statement);
        }
    }

    @Override
    public void update(Department obj) {
        PreparedStatement statement = null;

        try {
            statement = conn.prepareStatement(
                    "UPDATE department SET Name=? WHERE Id=?");
            statement.setString(1, obj.getName());
            statement.setInt(2, obj.getId());

            int rowsAffected = statement.executeUpdate();
            if(rowsAffected > 0){
                System.out.println("Department Updated.");
            }else {
                throw new DbException("UNEXPECTED ERROR! Department not updated.");
            }
        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(statement);
        }
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Department findById(Integer id) {
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            statement = conn.prepareStatement(
                    "SELECT Id, Name FROM department " +
                            "WHERE id = ?"
            );
            statement.setInt(1, id);
            result = statement.executeQuery();
            if(result.next()){
                return new Department(result.getString("Name"), result.getInt("Id"));
            }
            return null;
        }catch (SQLException e){
            throw new DbException(e.getMessage());
    }finally {
            DB.closeStatement(statement);
            DB.closeResultSet(result);
        }
    }


    @Override
    public List<Department> findAll() {
        return List.of();
    }
}
