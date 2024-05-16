package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;


public class Program {
    public static void main(String[] args) {
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

        System.out.println("=== test 3: Seller findByDepartment ===");
        sellerDao.deleteById(13);
        System.out.println();

        System.out.println("=== test 4: Seller findByDepartment ===");
        Seller newSeller = new Seller(null, "Felipe", "felipe@gmail.com", new Date(), 2500.0, department);
        sellerDao.insert(newSeller);
        System.out.println(newSeller.getId());
    }
}
