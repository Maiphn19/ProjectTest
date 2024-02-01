/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Model;

import java.util.List;
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
public class OrderDAOTest {
    
    public OrderDAOTest() {
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
     * Test of addOrder method, of class OrderDAO.
     */
    @Test
    public void testAddOrder_int_List() {
        System.out.println("addOrder");
        int aid = 0;
        List<Cart> carts = null;
        OrderDAO instance = new OrderDAO();
        boolean expResult = false;
        boolean result = instance.addOrder(aid, carts);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addOrder method, of class OrderDAO.
     */
    @Test
    public void testAddOrder_int_Cart() {
        System.out.println("addOrder");
        int aid = 0;
        Cart c = null;
        OrderDAO instance = new OrderDAO();
        boolean expResult = false;
        boolean result = instance.addOrder(aid, c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNewestOrderId method, of class OrderDAO.
     */
    @Test
    public void testGetNewestOrderId() {
        System.out.println("getNewestOrderId");
        OrderDAO instance = new OrderDAO();
        int expResult = 0;
        int result = instance.getNewestOrderId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
