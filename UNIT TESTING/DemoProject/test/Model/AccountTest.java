/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Model;

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
public class AccountTest {
    
    public AccountTest() {
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
    public void tea    /**
     * Test of getAcname method, of class Account.
     */
    @Test
    public void testGetAcname() {
        System.out.println("getAcname");
        Account instance = new Account();
        String expResult = "";
        String result = instance.getAcname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAcname method, of class Account.
     */
    @Test
    public void testSetAcname() {
        System.out.println("setAcname");
        String acname = "";
        Account instance = new Account();
        instance.setAcname(acname);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPass method, of class Account.
     */
    @Test
    public void testGetPass() {
        System.out.println("getPass");
        Account instance = new Account();
        String expResult = "";
        String result = instance.getPass();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPass method, of class Account.
     */
    @Test
    public void testSetPass() {
        System.out.println("setPass");
        String pass = "";
        Account instance = new Account();
        instance.setPass(pass);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPer method, of class Account.
     */
    @Test
    public void testGetPer() {
        System.out.println("getPer");
        Account instance = new Account();
        String expResult = "";
        String result = instance.getPer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPer method, of class Account.
     */
    @Test
    public void testSetPer() {
        System.out.println("setPer");
        String per = "";
        Account instance = new Account();
        instance.setPer(per);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFname method, of class Account.
     */
    @Test
    public void testGetFname() {
        System.out.println("getFname");
        Account instance = new Account();
        String expResult = "";
        String result = instance.getFname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFname method, of class Account.
     */
    @Test
    public void testSetFname() {
        System.out.println("setFname");
        String fname = "";
        Account instance = new Account();
        instance.setFname(fname);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLname method, of class Account.
     */
    @Test
    public void testGetLname() {
        System.out.println("getLname");
        Account instance = new Account();
        String expResult = "";
        String result = instance.getLname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLname method, of class Account.
     */
    @Test
    public void testSetLname() {
        System.out.println("setLname");
        String lname = "";
        Account instance = new Account();
        instance.setLname(lname);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class Account.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Account instance = new Account();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class Account.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        Account instance = new Account();
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAcId method, of class Account.
     */
    @Test
    public void testGetAcId() {
        System.out.println("getAcId");
        Account instance = new Account();
        int expResult = 0;
        int result = instance.getAcId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAcId method, of class Account.
     */
    @Test
    public void testSetAcId() {
        System.out.println("setAcId");
        int acId = 0;
        Account instance = new Account();
        instance.setAcId(acId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkAccount method, of class Account.
     */
    @Test
    public void testCheckAccount() {
        System.out.println("checkAccount");
        String username = "";
        String password = "";
        Account instance = new Account();
        Account expResult = null;
        Account result = instance.checkAccount(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class Account.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        String fnamee = "";
        String lnamee = "";
        String emaill = "";
        String per = "";
        String acnamee = "";
        String passs = "";
        Account instance = new Account();
        instance.add(fnamee, lnamee, emaill, per, acnamee, passs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changePass method, of class Account.
     */
    @Test
    public void testChangePass() {
        System.out.println("changePass");
        String passs = "";
        String acnamee = "";
        Account instance = new Account();
        instance.changePass(passs, acnamee);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkPermisson method, of class Account.
     */
    @Test
    public void testCheckPermisson() {
        System.out.println("checkPermisson");
        String username = "";
        String password = "";
        String per = "";
        Account instance = new Account();
        Account expResult = null;
        Account result = instance.checkPermisson(username, password, per);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkEmail method, of class Account.
     */
    @Test
    public void testCheckEmail() {
        System.out.println("checkEmail");
        String emaill = "";
        Account instance = new Account();
        Account expResult = null;
        Account result = instance.checkEmail(emaill);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listAccount method, of class Account.
     */
    @Test
    public void testListAccount() {
        System.out.println("listAccount");
        String username = "";
        Account instance = new Account();
        Account expResult = null;
        Account result = instance.listAccount(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

rDown() {
    }
    
}
