package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== TEST 1: Seller findById ===");
        Seller seller = sellerDao.findById(1);
        System.out.println(seller);

        System.out.println("=== TEST 2: Seller findByDepartment ===");
        Department dep = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(dep);
        for(Seller obj:list) {
            System.out.println(obj);
        }

        System.out.println("=== TEST 3: Seller findAll ===");
        list = sellerDao.findAll();
        for(Seller obj:list) {
            System.out.println(obj);
        }

        System.out.println("=== TEST 4: Seller insert ===");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, dep);
        sellerDao.insert(newSeller);
        System.out.println("Inserido! Novo id = " + newSeller.getId());

        System.out.println("=== TEST 5: Seller update ===");
        seller = sellerDao.findById(1);
        seller.setName("Martha Waine");
        sellerDao.update(seller);
        System.out.println("Update realizado");

        System.out.println("=== TEST 6: Seller delete ===");
        System.out.println("Insira o ID para deletar");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Deletou corretamente");
    }
}
