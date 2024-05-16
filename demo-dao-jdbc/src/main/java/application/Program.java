package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.dao.impl.DepartmentDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*
        SellerDao sellerDao = DaoFactory.createSellerDao();


        System.out.println("=== test 1: Seller findById ===");
        Seller seller = sellerDao.findById(2);
        System.out.println(seller);

        System.out.println("=== test 2: Seller findByDepartment ===");
        Department department = new Department(null, 1);
        List<Seller> sellerList = sellerDao.findByDepartment(department);
        for (Seller selle : sellerList){
            System.out.println(selle);
            System.out.println();
        }

        System.out.println("=== test 3: Seller findByDepartment ===");
        List<Seller> sellerAllList = sellerDao.findAll();
        for (Seller selle : sellerAllList){
            System.out.println(selle);
            System.out.println();
        }

        System.out.println("=== test 4: Seller Deleted ===");
        sellerDao.deleteById(14);
        System.out.println();

        System.out.println("=== test 5: Seller findByDepartment ===");
        Seller newSeller = new Seller(null, "Felipe", "felipe@gmail.com", new Date(), 2500.0, department);
        sellerDao.insert(newSeller);
        System.out.println(newSeller.getId());
        System.out.println();



        newSeller = new Seller(27, "Felipe Melo", "felipemelo@gmail.com", new Date(29/ 4 /2005), 2500.0, department);
        System.out.println("=== test 6: Seller UPDATE!! ===");
        sellerDao.update(newSeller);
        System.out.println();
        */
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();


        System.out.println("=== test 1: Department findById ===");
        Department department = departmentDao.findById(2);
        System.out.println(department);
        System.out.println();

        System.out.println("=== test 2: Department Insert ===");
        Department newDepartment = new Department("youtube", null);
        departmentDao.insert(newDepartment);
        System.out.println(newDepartment.getId());
        System.out.println();

        System.out.println("=== test 3: Department Update ===");
        Department dep = new Department("Tech", 1);
        departmentDao.update(dep);
        System.out.println();

        System.out.println("=== test 4: Department FindAll ===");
        List<Department> departmentList = departmentDao.findAll();
        for(Department d : departmentList){
            System.out.println(d);
            System.out.println();
        }

        System.out.println("=== test 5: Department Deleted ===");
        System.out.println("Enter the Id for delete department.");
        departmentDao.deleteById(sc.nextInt());
        System.out.println();

        sc.close();
    }
}
