package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== TEST 1: Department findById ===");
        Department dep = departmentDao.findById(1);
        System.out.println(dep);

        System.out.println("=== TEST 2: Department findAll ===");
        List<Department> list = departmentDao.findAll();
        for(Department obj:list) {
            System.out.println(obj);
        }

        System.out.println("=== TEST 3: Department insert ===");
        Department newDepartment = new Department(null, "Arts");
        departmentDao.insert(newDepartment);
        System.out.println("Inserido! Novo id = " + newDepartment.getId());

        System.out.println("=== TEST 5: Department update ===");
        dep = departmentDao.findById(1);
        dep.setName("Music");
        departmentDao.update(dep);
        System.out.println("Update realizado");

        System.out.println("=== TEST 6: Department delete ===");
        System.out.println("Insira o ID para deletar");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Deletou corretamente");
    }
}
