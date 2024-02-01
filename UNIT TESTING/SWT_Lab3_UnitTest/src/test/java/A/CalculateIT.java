/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package A;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculateIT {
    private Calculate cal;
    
    public CalculateIT() {
        cal = new Calculate();
    }

    @Test
    public void testValidAddition() {
        int num1 = 10;
        int num2 = 2;
        String op = "+";
        int expected = 12;

        int result = cal.calculateInteger(num1, num2, op);

        assertEquals(expected, result);
    }

    @Test
    public void testValidSubtraction() {
        int num1 = 10;
        int num2 = 2;
        String op = "-";
        int expected = 8;

        int result = cal.calculateInteger(num1, num2, op);

        assertEquals(expected, result);
    }

    @Test
    public void testValidMultiplication() {
        int num1 = 10;
        int num2 = 2;
        String op = "*";
        int expected = 20;

        int result = cal.calculateInteger(num1, num2, op);

        assertEquals(expected, result);
    }

    @Test
    public void testValidDivision() {
        int num1 = 10;
        int num2 = 2;
        String op = "/";
        int expected = 5;

        int result = cal.calculateInteger(num1, num2, op);

        assertEquals(expected, result);
    }

    @Test
    public void testValidExponentiation() {
        int num1 = 10;
        int num2 = 2;
        String op = "^";
        int expected = 100;

        int result = cal.calculateInteger(num1, num2, op);

        assertEquals(expected, result);
    }

    @Test
    public void testInvalidOperator() {
        int num1 = 10;
        int num2 = 2;
        String op = "#";

        assertThrows(IllegalArgumentException.class, () -> {
            cal.calculateInteger(num1, num2, op);
        });
    }

    @Test
    public void testDivideByZero() {
        int num1 = 10;
        int num2 = 0;
        String op = "/";

        assertThrows(IllegalArgumentException.class, () -> {
            cal.calculateInteger(num1, num2, op);
        });
    }

    @Test
    public void testCalculateAverage() {
        // Arrange
        int[] array = {5, 10, 15, 20, 25};
        double expectedAverage = 15.0;
        // Act
        double actualAverage = cal.calculateAverage(array);
        // Assert
        assertEquals(expectedAverage, actualAverage, 0.001);
    }

    @Test
    public void testFindMaxValue() {
        // Arrange
        int[] array = {5, 10, 3, 8, 2};
        int expectedMaxValue = 10;
        // Act
        int actualMaxValue = cal.findMaxValue(array);
        // Assert
        assertEquals(expectedMaxValue, actualMaxValue);
    }

    @Test
    public void testFindMinValue() {
        // Arrange
        int[] array = {5, 10, 3, 8, 2};
        int expectedMinValue = 2;
        // Act
        int actualMinValue = cal.findMinValue(array);
        // Assert
        assertEquals(expectedMinValue, actualMinValue);
    }

    @Test
    public void testGenerateFibonacci() {
        // Arrange
        int count = 10;
        int[] expectedSequence = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34};
        // Act
        int[] actualSequence = cal.generateFibonacci(count);
        // Assert
        assertArrayEquals(expectedSequence, actualSequence);
    }

    @Test
    public void testTwoSum() {
        // Arrange
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] expectedIndices = {0, 1};
        // Act
        int[] actualIndices = cal.twoSum(nums, target);
        // Assert
        assertArrayEquals(expectedIndices, actualIndices);
    }

    @Test
    public void testTwoSum2() {
        // Arrange
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] expectedIndices = {0, 1};
        // Act
        int[] actualIndices = cal.twoSum2(nums, target);
        // Assert
        assertArrayEquals(expectedIndices, actualIndices);
    }

    @Test
    public void testTwoSum3() {
        // Arrange
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] expectedIndices = {0, 1};
        // Act
        int[] actualIndices = cal.twoSum3(nums, target);
        // Assert
        assertArrayEquals(expectedIndices, actualIndices);
    }

    @Test
    public void testMaxProfit() {
        // Arrange
        int[] prices = {7, 1, 5, 3, 6, 4};
        int expectedMaxProfit = 5;
        // Act
        int actualMaxProfit = cal.maxProfit(prices);
        // Assert
        assertEquals(expectedMaxProfit, actualMaxProfit);
    }

    @Test
    public void testMaxSubArray1() {
        // Arrange
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int expectedMaxSum = 6;
        // Act
        int actualMaxSub = cal.maxSubArray1(nums);
        // Assert
        assertEquals(expectedMaxSum, actualMaxSub);
    }

    @Test
    public void testMaxSubArray2() {
        // Arrange
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int expectedMaxSum = 6;
        // Act
        int actualMaxSub = cal.maxSubArray2(nums);
        // Assert
        assertEquals(expectedMaxSum, actualMaxSub);
    }

    @Test
    public void testClimbStairs() {
        // Arrange
        int n = 3;
        int expectedDistinctWays = 3;
        // Act
        int actualDistinctWays = cal.climbStairs(n);
        // Assert
        assertEquals(expectedDistinctWays, actualDistinctWays);
    }

    @Test
    public void testCanConstruct() {
        // Arrange
        String ransomNote1 = "a";
        String magazine1 = "b";
        boolean expected1 = false;

        String ransomNote2 = "aa";
        String magazine2 = "aab";
        boolean expected2 = true;
        
        // Act
        boolean actual1 = cal.canConstruct(ransomNote1, magazine1);
        boolean actual2 = cal.canConstruct(ransomNote2, magazine2);
        
        // Assert
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
    }

    @Test
    public void testContainsDuplicate() {
        // Arrange
        int[] nums1 = {1, 2, 3, 4, 5};
        boolean expected1 = false;

        int[] nums2 = {1, 2, 3, 1};
        boolean expected2 = true;

        // Act
        boolean actual1 = cal.containsDuplicate(nums1);
        boolean actual2 = cal.containsDuplicate(nums2);

        // Assert
        assertFalse(actual1);
        assertTrue(actual2);
    }

    @Test
    public void testCountBits() {
        // Arrange
        int n = 2;
        int[] expected = {0, 1, 1};
        // Act
        int[] actual = cal.countBits(n);
        // Assert
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testHammingWeight() {
        // Arrange
        int n = 11;
        int expected = 3;
        // Act
        int actual = cal.hammingWeight(n);
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testSingleNumber() {
        // Arrange
        int[] nums1 = {2, 2, 1};
        int expected1 = 1;

        int[] nums2 = {4, 1, 2, 1, 2};
        int expected2 = 4;

        // Act
        int actual1 = cal.singleNumber(nums1);
        int actual2 = cal.singleNumber(nums2);

        // Assert
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
    }

    @Test
    public void testMoveZeroes() {
        // Arrange
        int[] nums1 = {0, 1, 0, 3, 12};
        int[] expected1 = {1, 3, 12, 0, 0};

        int[] nums2 = {0, 0, 0, 0, 0};
        int[] expected2 = {0, 0, 0, 0, 0};

        int[] nums3 = {1, 2, 3, 4, 5};
        int[] expected3 = {1, 2, 3, 4, 5};

        // Act
        cal.moveZeroes(nums1);
        cal.moveZeroes(nums2);
        cal.moveZeroes(nums3);

        // Assert
        assertArrayEquals(expected1, nums1);
        assertArrayEquals(expected2, nums2);
        assertArrayEquals(expected3, nums3);
    }

    @Test
    public void testMajorityElement() {
        // Arrange
        int[] nums1 = {2, 2, 1, 1, 1, 2, 2};
        int expected1 = 2;

        int[] nums2 = {3, 3, 4, 2, 4, 4, 4};
        int expected2 = 4;

        // Act
        int actual1 = cal.majorityElement(nums1);
        int actual2 = cal.majorityElement(nums2);

        // Assert
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
    }

    @Test
    public void testMajorityElement2() {
        // Arrange
        int[] nums1 = {2, 2, 1, 1, 1, 2, 2};
        int expected1 = 2;

        int[] nums2 = {3, 3, 4, 2, 4, 4, 4};
        int expected2 = 4;

        // Act
        int actual1 = cal.majorityElement2(nums1);
        int actual2 = cal.majorityElement2(nums2);

        // Assert
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
    }

    @Test
    public void testAddBinary() {
        // Arrange
        String a1 = "11";
        String b1 = "1";
        String expected1 = "100";

        String a2 = "1010";
        String b2 = "1011";
        String expected2 = "10101";

        // Act
        String actual1 = cal.addBinary(a1, b1);
        String actual2 = cal.addBinary(a2, b2);

        // Assert
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
    }

    @Test
    public void testReverseBits() {
        // Arrange
        int num1 = 43261596;
        int expected1 = 964176192;

        int num2 = -3;
        int expected2 = -1073741825;

        // Act
        int actual1 = cal.reverseBits(num1);
        int actual2 = cal.reverseBits(num2);

        // Assert
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
    }

    @Test
    public void testCoinChange1() {
        // Arrange
        int[] coins = {1, 2, 5};
        int amount = 11;
        int expected = 3;
        // Act
        int actual = cal.coinChange(coins, amount);
        // Assert
        assertEquals(expected, actual);
    }
    @Test
    public void testCoinChange2() {
        // Arrange
        int[] coins = {1, 2, 5};
        int amount = 5;
        int expected = 1;
        // Act
        int actual = cal.coinChange(coins, amount);
        // Assert
        assertEquals(expected, actual);
    }
    @Test
    public void testCoinChange3() {
        // Arrange
        int[] coins = {1, 2, 5};
        int amount = 4;
        int expected = 2;
        // Act
        int actual = cal.coinChange(coins, amount);
        // Assert
        assertEquals(expected, actual);
    }
    @Test
    public void testCoinChange4() {
        // Arrange
        int[] coins = {1, 2, 5};
        int amount = 0;
        int expected = 0;
        // Act
        int actual = cal.coinChange(coins, amount);
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testOrangesRotting() {
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        int expected = 4;
        int result = cal.orangesRotting(grid);
        assertEquals(expected, result);
    }
    
}
