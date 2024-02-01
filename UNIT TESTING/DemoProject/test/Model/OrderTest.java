/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Model;

import java.sql.Date;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Mai
 */
public class OrderTest {
    
    public OrderTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getOrderId method, of class Order.
     */
    @Test
    public void testGetOrderId() {
        System.out.println("getOrderId");
        Order instance = new Order();
        int expResult = 0;
        int result = instance.getOrderId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOrderId method, of class Order.
     */
    @Test
    public void testSetOrderId() {
        System.out.println("setOrderId");
        int OrderId = 0;
        Order instance = new Order();
        instance.setOrderId(OrderId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrderDate method, of class Order.
     */
    @Test
    public void testGetOrderDate() {
        System.out.println("getOrderDate");
        Order instance = new Order();
        Date expResult = null;
        Date result = instance.getOrderDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOrderDate method, of class Order.
     */
    @Test
    public void testSetOrderDate() {
        System.out.println("setOrderDate");
        Date OrderDate = null;
        Order instance = new Order();
        instance.setOrderDate(OrderDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomerId method, of class Order.
     */
    @Test
    public void testGetCustomerId() {
        System.out.println("getCustomerId");
        Order instance = new Order();
        int expResult = 0;
        int result = instance.getCustomerId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCustomerId method, of class Order.
     */
    @Test
    public void testSetCustomerId() {
        System.out.println("setCustomerId");
        int CustomerId = 0;
        Order instance = new Order();
        instance.setCustomerId(CustomerId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotal method, of class Order.
     */
    @Test
    public void testGetTotal() {
        System.out.println("getTotal");
        Order instance = new Order();
        double expResult = 0.0;
        double result = instance.getTotal();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTotal method, of class Order.
     */
    @Test
    public void testSetTotal() {
        System.out.println("setTotal");
        double Total = 0.0;
        Order instance = new Order();
        instance.setTotal(Total);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
