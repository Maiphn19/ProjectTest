/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package EmployeeManagement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

/**
 *
 * @author Mai
 */
public class EmployeeManagementIT {
    private EmployeeManagement emp;
    
    public EmployeeManagementIT() {
        emp = new EmployeeManagement();
    }

    @Test
    public void testCheckIdExist() {
        int id = 12345;

        // Create a list of employees
        ArrayList<Employee> employeeList = new ArrayList<>();
        Employee employee1 = new Employee(123, "John", "Doe");
        Employee employee2 = new Employee(456, "Jane", "Smith");
        employeeList.add(employee1);
        employeeList.add(employee2);

        boolean isIdExist = emp.checkIdExist(id, employeeList);

        assertEquals(false, isIdExist);
    }

    @Test
    public void testSearchbyID() {
        int id = 222;
        
        // Create a list of employees
        ArrayList<Employee> employeeList = new ArrayList<>();
        Employee employee1 = new Employee(123, "John", "Doe");
        Employee employee2 = new Employee(456, "Jane", "Smith");
        Employee employee3 = new Employee(789, "Taylor", "Swift");
        Employee employee4 = new Employee(111, "Justin", "Smith");
        Employee employee5 = new Employee(222, "John", "Wick");
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        employeeList.add(employee4);
        employeeList.add(employee5);

        int position = emp.SearchbyID(employeeList, id);

        assertEquals(4, position);
    }

}
