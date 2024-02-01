/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mai
 */
public class tinhtoanTest {
     private tinhtoan CongTru;
       
    
    public tinhtoanTest() {
        CongTru = new tinhtoan();
    }

    @Test
    public void testAdd() {
        int result = CongTru.add(4, 5);
        int expected = 9;
        assertEquals(expected, result);
    }
    @Test
    public void testSub() {
        int result = CongTru.sub(4, 5);
        int expected  = -1;
        assertEquals(expected, result);
    }
}
