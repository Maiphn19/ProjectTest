/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package TextNormalizer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Mai
 */
public class ManagerIT {
    private Manager man;
    
    public ManagerIT() {
        man = new Manager();
    }

    @Test
    public void testFormatOneSpaceSpecial() {
        String line = "Hello,World";
        String character = ",";
        String expected = "Hello, World";

        String result = man.formatOneSpaceSpecial(line, character);

        assertEquals(expected, result);
    }

    @Test
    public void testFormatOneSpace() {
        String line = "Hello     World";
        String expected = "hello world";

        String result = man.formatOneSpace(line);

        assertEquals(expected, result);
    }

    @Test
    public void testFormatSpecialCharacters() {
        String line = "Hello , World . How : are you?";
        String expected = "Hello, World. How: are you?";

        String result = man.formatSpecialCharacters(line);

        assertEquals(expected, result);
    }

    @Test
    public void testAfterDotUpperCase() {
        String line = "hello. world. how. are. you?";
        String expected = "hello. World. How. Are. You?";

        String result = man.afterDotUpperCase(line);

        assertEquals(expected, result);
    }

    @Test
    public void testNoSpaceQuotes() {
        String line = "Hello \"World\" how are \"you\"?";
        String expected = "Hello\"World\"how are\"you\"?";

        String result = man.noSpaceQuotes(line);

        assertEquals(expected, result);
    }

    @Test
    public void testFirstUpercase() {
        String line = "123hello world";
        String expected = "Hello world";

        String result = man.firstUpercase(line);

        assertEquals(expected, result);
    }

    @Test
    public void testLastAddDot() {
        String line = "Hello world";
        String expected = "Hello world.";

        String result = man.lastAddDot(line);

        assertEquals(expected, result);
    }

    @Test
    public void testLastAddDotWithExistingDot() {
        String line = "Hello world.";
        String expected = "Hello world.";

        String result = man.lastAddDot(line);

        assertEquals(expected, result);
    }

    @Test
    public void testIsLineEmpty() {
        String emptyLine = "";
        String nonEmptyLine = "Hello, world";

        boolean isEmpty = man.isLineEmpty(emptyLine);
        boolean isNonEmpty = man.isLineEmpty(nonEmptyLine);

        assertEquals(true, isEmpty);
        assertEquals(false, isNonEmpty);
    }
    
}
