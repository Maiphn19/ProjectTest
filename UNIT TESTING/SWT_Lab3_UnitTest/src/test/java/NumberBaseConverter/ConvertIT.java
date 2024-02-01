/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package NumberBaseConverter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Mai
 */
public class ConvertIT {
    private Convert con;
    
    public ConvertIT() {
        con = new Convert();
    }
    
    @Test
    public void testConvertValue_DecimalToBinary() {
        String valueInput = "255";
        int baseInput = 10;
        int baseOutput = 2;
        String expected = "11111111";

        String result = con.convertValue(valueInput, baseInput, baseOutput);

        assertEquals(expected, result);
    }

    @Test
    public void testConvertValue_BinaryToDecimal() {
        String valueInput = "11111111";
        int baseInput = 2;
        int baseOutput = 10;
        String expected = "255";

        String result = con.convertValue(valueInput, baseInput, baseOutput);

        assertEquals(expected, result);
    }
    
    @Test
    public void testConvertValue_DecimalToHex() {
        String valueInput = "255";
        int baseInput = 10;
        int baseOutput = 16;
        String expected = "FF";

        String result = con.convertValue(valueInput, baseInput, baseOutput);

        assertEquals(expected, result);
    }

    @Test
    public void testConvertValue_HexToDecimal() {
        String valueInput = "FF";
        int baseInput = 16;
        int baseOutput = 10;
        String expected = "255";

        String result = con.convertValue(valueInput, baseInput, baseOutput);

        assertEquals(expected, result);
    }

    @Test
    public void testConvertValue_BinaryToHex() {
        String valueInput = "11111111";
        int baseInput = 2;
        int baseOutput = 16;
        String expected = "FF";

        String result = con.convertValue(valueInput, baseInput, baseOutput);

        assertEquals(expected, result);
    }

    @Test
    public void testConvertValue_HexToBinary() {
        String valueInput = "FF";
        int baseInput = 16;
        int baseOutput = 2;
        String expected = "11111111";

        String result = con.convertValue(valueInput, baseInput, baseOutput);

        assertEquals(expected, result);
    }

    @Test
    public void testConvertValue_HexToHex() {
        String valueInput = "FF";
        int baseInput = 16;
        int baseOutput = 16;
        String expected = "FF";

        String result = con.convertValue(valueInput, baseInput, baseOutput);

        assertEquals(expected, result);
    }

    @Test
    public void testConvertValue_DecimalToDecimal() {
        String valueInput = "255";
        int baseInput = 10;
        int baseOutput = 10;
        String expected = "255";

        String result = con.convertValue(valueInput, baseInput, baseOutput);

        assertEquals(expected, result);
    }

    @Test
    public void testConvertValue_BinaryToBinary() {
        String valueInput = "11111111";
        int baseInput = 2;
        int baseOutput = 2;
        String expected = "11111111";

        String result = con.convertValue(valueInput, baseInput, baseOutput);

        assertEquals(expected, result);
    }
}
