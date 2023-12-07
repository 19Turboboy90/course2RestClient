package com.zaurtregulov.spring.rest;

import com.zaurtregulov.spring.rest.configuration.MyConfig;
import com.zaurtregulov.spring.rest.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean("communication", Communication.class);

////Получение всех работников
//        List<Employee> allEmployee = communication.getAllEmployee();
//        System.out.println(allEmployee);
//// Получение работника по ID
//        Employee employee = communication.getEmployee(1);
//        System.out.println(employee);
//// Добавление нового работника
//        Employee employee = new Employee("Sveta", "Sokolova", "HR", 900);
//        communication.saveEmployee(employee);
//// Обновление работника
//        Employee employee = new Employee("Sveta", "new Sokolova", "IT", 1900);
//        employee.setId(11);
//        communication.saveEmployee(employee);
//// Удаление работника
//        communication.deleteEmployee(11);
    }
}
