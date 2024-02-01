/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package A;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Mai
 */
public class StringRelatedIT {
    private StringRelated str;
    
    public StringRelatedIT() {
        str = new StringRelated();
    }

    @Test
    public void testIsValid() {
        String s1 = "(){}[]";
        String s2 = "({[]})";
        String s3 = "([)]";
        String s4 = "{[}]";
        String s5 = "{{}";

        boolean isValid1 = str.isValid(s1);
        boolean isValid2 = str.isValid(s2);
        boolean isValid3 = str.isValid(s3);
        boolean isValid4 = str.isValid(s4);
        boolean isValid5 = str.isValid(s5);

        assertEquals(true, isValid1);
        assertEquals(true, isValid2);
        assertEquals(false, isValid3);
        assertEquals(false, isValid4);
        assertEquals(false, isValid5);
    }

    @Test
    public void testIsPalindrome() {
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "racecar";
        String s3 = "hello world";
        String s4 = "12321";
        String s5 = "Palindrome";

        boolean isPalindrome1 = str.isPalindrome(s1);
        boolean isPalindrome2 = str.isPalindrome(s2);
        boolean isPalindrome3 = str.isPalindrome(s3);
        boolean isPalindrome4 = str.isPalindrome(s4);
        boolean isPalindrome5 = str.isPalindrome(s5);

        assertEquals(true, isPalindrome1);
        assertEquals(true, isPalindrome2);
        assertEquals(false, isPalindrome3);
        assertEquals(true, isPalindrome4);
        assertEquals(false, isPalindrome5);
    }

    @Test
    public void testIsAnagram() {
        String s1 = "anagram";
        String t1 = "nagaram";
        String s2 = "listen";
        String t2 = "silent";
        String s3 = "hello";
        String t3 = "world";
        String s4 = "aab";
        String t4 = "aba";
        String s5 = "foo";
        String t5 = "bar";

        boolean isAnagram1 = str.isAnagram(s1, t1);
        boolean isAnagram2 = str.isAnagram(s2, t2);
        boolean isAnagram3 = str.isAnagram(s3, t3);
        boolean isAnagram4 = str.isAnagram(s4, t4);
        boolean isAnagram5 = str.isAnagram(s5, t5);

        assertEquals(true, isAnagram1);
        assertEquals(true, isAnagram2);
        assertEquals(false, isAnagram3);
        assertEquals(true, isAnagram4);
        assertEquals(false, isAnagram5);
    }

    @Test
    public void testIsAnagram2() {
        String s1 = "anagram";
        String t1 = "nagaram";
        String s2 = "listen";
        String t2 = "silent";
        String s3 = "hello";
        String t3 = "world";
        String s4 = "aab";
        String t4 = "aba";
        String s5 = "foo";
        String t5 = "bar";

        boolean isAnagram1 = str.isAnagram2(s1, t1);
        boolean isAnagram2 = str.isAnagram2(s2, t2);
        boolean isAnagram3 = str.isAnagram2(s3, t3);
        boolean isAnagram4 = str.isAnagram2(s4, t4);
        boolean isAnagram5 = str.isAnagram2(s5, t5);

        assertEquals(true, isAnagram1);
        assertEquals(true, isAnagram2);
        assertEquals(false, isAnagram3);
        assertEquals(true, isAnagram4);
        assertEquals(false, isAnagram5);
    }

    @Test
    public void testIsAnagram3() {
        String s1 = "anagram";
        String t1 = "nagaram";
        String s2 = "listen";
        String t2 = "silent";
        String s3 = "hello";
        String t3 = "world";
        String s4 = "aab";
        String t4 = "aba";
        String s5 = "foo";
        String t5 = "bar";

        boolean isAnagram1 = str.isAnagram3(s1, t1);
        boolean isAnagram2 = str.isAnagram3(s2, t2);
        boolean isAnagram3 = str.isAnagram3(s3, t3);
        boolean isAnagram4 = str.isAnagram3(s4, t4);
        boolean isAnagram5 = str.isAnagram3(s5, t5);

        assertEquals(true, isAnagram1);
        assertEquals(true, isAnagram2);
        assertEquals(false, isAnagram3);
        assertEquals(true, isAnagram4);
        assertEquals(false, isAnagram5);
    }

    @Test
    public void testIsValidPassword() {
        String password1 = "Password123";
        String password2 = "abc123";
        String password3 = "PASSWORD";
        String password4 = "12345678";
        String password5 = "pass";
        String password6 = "Password1234567891111111111111111111";

        boolean isValid1 = str.isValidPassword(password1);
        boolean isValid2 = str.isValidPassword(password2);
        boolean isValid3 = str.isValidPassword(password3);
        boolean isValid4 = str.isValidPassword(password4);
        boolean isValid5 = str.isValidPassword(password5);
        boolean isValid6 = str.isValidPassword(password5);

        assertEquals(true, isValid1);
        assertEquals(false, isValid2);
        assertEquals(false, isValid3);
        assertEquals(false, isValid4);
        assertEquals(false, isValid5);
        assertEquals(false, isValid6);
    }

    @Test
    public void testRomanToInt() {
        // Test valid Roman numerals
        assertEquals(1, str.romanToInt("I"));
        assertEquals(5, str.romanToInt("V"));
        assertEquals(10, str.romanToInt("X"));
        assertEquals(50, str.romanToInt("L"));
        assertEquals(100, str.romanToInt("C"));
        assertEquals(500, str.romanToInt("D"));
        assertEquals(1000, str.romanToInt("M"));
        assertEquals(3, str.romanToInt("III"));
        assertEquals(4, str.romanToInt("IV"));
        assertEquals(9, str.romanToInt("IX"));
        assertEquals(58, str.romanToInt("LVIII"));
        assertEquals(1994, str.romanToInt("MCMXCIV"));

        // Test invalid Roman numerals
        assertThrows(IllegalArgumentException.class, () -> str.romanToInt("ABC"));
    }

    @Test
    public void testBackspaceCompare() {
        String s1 = "ab#c";
        String t1 = "ad#c";
        boolean result1 = str.backspaceCompare(s1, t1);
        assertEquals(true, result1);

        String s2 = "ab##";
        String t2 = "c#d#";
        boolean result2 = str.backspaceCompare(s2, t2);
        assertEquals(true, result2);

        String s4 = "a#c";
        String t4 = "b";
        boolean result4 = str.backspaceCompare(s4, t4);
        assertEquals(false, result4);
    }

    @Test
    public void testLongestCommonPrefix() {
        String[] strs1 = {"flower", "flow", "flight"};
        String result1 = str.longestCommonPrefix(strs1);
        assertEquals("fl", result1);

        String[] strs2 = {"dog", "racecar", "car"};
        String result2 = str.longestCommonPrefix(strs2);
        assertEquals("", result2);

        String[] strs3 = {"apple", "ape", "apricot"};
        String result3 = str.longestCommonPrefix(strs3);
        assertEquals("ap", result3);
    }

    @Test
    public void testLengthOfLongestSubstring() {
        String s1 = "abcabcbb";
        int result1 = str.lengthOfLongestSubstring(s1);
        assertEquals(3, result1);

        String s2 = "bbbbb";
        int result2 = str.lengthOfLongestSubstring(s2);
        assertEquals(1, result2);

        String s3 = "pwwkew";
        int result3 = str.lengthOfLongestSubstring(s3);
        assertEquals(3, result3);
    }

    @Test
    public void testLengthOfLongestSubstring2() {
        String s1 = "abcabcbb";
        int result1 = str.lengthOfLongestSubstring2(s1);
        assertEquals(3, result1);

        String s2 = "bbbbb";
        int result2 = str.lengthOfLongestSubstring2(s2);
        assertEquals(1, result2);

        String s3 = "pwwkew";
        int result3 = str.lengthOfLongestSubstring2(s3);
        assertEquals(3, result3);
    }

    @Test
    public void testLengthOfLongestSubstring3() {
        String s1 = "abcabcbb";
        int result1 = str.lengthOfLongestSubstring3(s1);
        assertEquals(3, result1);

        String s2 = "bbbbb";
        int result2 = str.lengthOfLongestSubstring3(s2);
        assertEquals(1, result2);

        String s3 = "pwwkew";
        int result3 = str.lengthOfLongestSubstring3(s3);
        assertEquals(3, result3);
    }
    
}
