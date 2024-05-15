package model.dao.impl;

import DataBase.DB;
import DataBase.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SellerDaoJDBC implements SellerDao {
    private final Connection conn;

    public SellerDaoJDBC(Connection conn){
        this.conn = conn;
    }




    @Override
    public void insert(Seller obj) {

    }

    @Override
    public void update(Seller obj) {

    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement statement = null;
        int rowsUpdate;

            try {
                statement = conn.prepareStatement(
                        "DELETE FROM seller WHERE Id = ?"
                );
                statement.setInt(1, id);
                rowsUpdate = statement.executeUpdate();
                if(rowsUpdate > 0){
                    System.out.println("Deleted!");
                }else {
                    System.out.println("ID NOT FOUND.");
                }
            }catch (SQLException e){
                throw  new DbException(e.getMessage());
            }finally {
                DB.closeStatement(statement);
            }
    }

    @Override
    public Seller findById(Integer id) {

        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
            statement = conn.prepareStatement(
                    "SELECT seller.*, department.Name as DepName "
                    + "FROM seller INNER JOIN department "
                    + "ON seller.DepartmentId = department.Id "
                    + "WHERE seller.Id = ?");

            statement.setInt(1, id);
            rs = statement.executeQuery();
            if(rs.next()){
                Department dep = instantiateDepartment(rs);
                return instantiateSeller(dep, rs);
            }
            return null;
        }catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(statement);
            DB.closeResultSet(rs);
        }
    }

    public List<Seller>  findByDepartment(Department department) {


        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
            statement = conn.prepareStatement(
                    "SELECT seller.*, department.Name as DepName" +
                            " FROM seller" +
                            " INNER JOIN department ON seller.DepartmentId = department.Id" +
                            " WHERE DepartmentId = ?" +
                            " ORDER BY Name");

            statement.setInt(1, department.getId());
            rs = statement.executeQuery();
            List<Seller> sellerList = new ArrayList<>();
            Map<Integer, Department> map = new HashMap<>();

            while (rs.next()) {
                Department dep = map.get(rs.getInt("DepartmentId"));
                if(dep == null){
                    dep = instantiateDepartment(rs);
                    map.put(rs.getInt("DepartmentId"), dep);
                }
                Seller obj = instantiateSeller(dep, rs);
                sellerList.add(obj);
            }
            return sellerList;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(statement);
            DB.closeResultSet(rs);

        }

    }

    private Seller instantiateSeller( Department dep, ResultSet rs) throws SQLException{
        Seller obj = new Seller();
        obj.setId(rs.getInt("Id"));
        obj.setName(rs.getString("Name"));
        obj.setEmail(rs.getString("Email"));
        obj.setBaseSalary(rs.getDouble("BaseSalary"));
        obj.setBirthDate(rs.getDate("BirthDate"));
        obj.setDepartment(dep);
        return obj;
    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException{
        Department dep = new Department();
        dep.setId(rs.getInt("DepartmentId"));
        dep.setName(rs.getString("DepName"));
        return dep;
    }

    @Override
    public List<Seller> findAll() {
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {

            statement = conn.prepareStatement(
                    "SELECT seller.*,department.Name as DepName "
                    + "From seller INNER JOIN department "
                    + "ON seller.DepartmentId = department.Id "
                    + "ORDER BY Name"
            );

            rs = statement.executeQuery();

            List<Seller> sellerList = new ArrayList<>();
            Map<Integer, Department> map = new HashMap<>();

            while (rs.next()) {

                Department dep = map.get(rs.getInt("DepartmentId"));
                if(dep == null){
                    dep = instantiateDepartment(rs);
                    map.put(rs.getInt("DepartmentId"), dep);
                }
                Seller obj = instantiateSeller(dep, rs);
                sellerList.add(obj);
            }
            return  sellerList;
        } catch (SQLException e ){
            throw new DbException(e.getMessage());
        }

    }
}
