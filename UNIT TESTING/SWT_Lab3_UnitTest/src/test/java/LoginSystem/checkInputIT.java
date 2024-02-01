/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package LoginSystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Mai
 */
public class checkInputIT {
    private checkInput check;
    
    public checkInputIT() {
        check = new checkInput();
    }

    @Test
    public void testCheckAccount() {
        String accountNumber = "1234567890";

        boolean isAccountExist = check.checkAccount(accountNumber);

        assertEquals(false, isAccountExist);
    }
    
    @Test
    public void testCheckAccountExist() {
        String accountNumber = "8888888888";

        boolean isAccountExist = check.checkAccount(accountNumber);

        assertEquals(true, isAccountExist);
    }

    @Test
    public void testCheckPassword() {
        String accountNumber = "1234567890";
        String password = "password123";

        boolean isValidPassword = check.checkPassword(accountNumber, password);

        assertEquals(false, isValidPassword);
    }

    @Test
    public void testCheckPasswordValid() {
        String accountNumber = "0123456789";
        String password = "123456ab";

        boolean isValidPassword = check.checkPassword(accountNumber, password);

        assertEquals(true, isValidPassword);
    }
    
}
