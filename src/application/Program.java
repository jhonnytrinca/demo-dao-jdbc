package application;

import models.entities.Department;
import models.entities.Seller;

import java.util.Date;

public class Program {
    public static void main(String[] args) {
        Department obj = new Department(1, "Livros");
        Seller seller = new Seller(19, "João", "joao@gmail.com", new Date(), 5000.0, obj);;
        System.out.println(seller);
    }
}
