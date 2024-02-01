package A;


import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Calculate {

    //BASIC CALCULATOR
    public static int calculateInteger(int num1, int num2, String op) throws IllegalArgumentException {
        if (!isValidOperator(op)) {
            throw new IllegalArgumentException("Invalid operator. Please provide one of the following: +, -, *, /, ^");
        }

        if (op.equals("/") && num2 == 0) {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }

        switch (op) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            case "^":
                return (int) Math.pow(num1, num2);
            default:
                throw new IllegalArgumentException("Invalid operator. Please provide one of the following: +, -, *, /, ^");
        }
    }

    private static boolean isValidOperator(String op) {
        return op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/") || op.equals("^");
    }

    public static double calculateAverage(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return (double) sum / array.length;
    }

    public static int findMaxValue(int[] array) {
        int max = array[0]; // Assume the first element is the maximum
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i]; // Update the maximum value
            }
        }
        return max;
    }

    public static int findMinValue(int[] array) {
        int min = array[0]; // Assume the first element is the maximum
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i]; // Update the maximum value
            }
        }
        return min;
    }

    //FIND FIBONACCI
    //OUT PUT: 0 1 1 2 3 5 8 13 21 34 FOR 10 INPUT
    public int[] generateFibonacci(int count) {
        int[] fibonacci = new int[count];
        fibonacci[0] = 0;
        if (count > 1) {
            fibonacci[1] = 1;
        }

        for (int i = 2; i < count; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }

        return fibonacci;
    }

    //Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    //Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{}; // No solution found
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;

        // Build the hash table
        for (int i = 0; i < n; i++) {
            numMap.put(nums[i], i);
        }

        // Find the complement
        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement) && numMap.get(complement) != i) {
                return new int[]{i, numMap.get(complement)};
            }
        }

        return new int[]{}; // No solution found
    }

    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(nums[i], i);
        }

        return new int[]{}; // No solution found
    }

//    You are given an array prices where prices[i] is the price of a given stock on the ith day.
//
//You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
//
//Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0
//    Input: prices = [7,1,5,3,6,4]
//Output: 5
//Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
    public int maxProfit(int[] prices) {
        int lsf = Integer.MAX_VALUE;
        int op = 0;
        int pist = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < lsf) {
                lsf = prices[i];
            }
            pist = prices[i] - lsf;
            if (op < pist) {
                op = pist;
            }
        }
        return op;
    }

//    Given an integer array nums, find the subarray
// with the largest sum, and return its sum.
//    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//Output: 6
//Explanation: The subarray [4,-1,2,1] has the largest sum 6.
    public int maxSubArray1(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            if (currentSum > maxSum) {
                maxSum = currentSum;
            }

            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }

    public int maxSubArray2(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

//    You are climbing a staircase. It takes n steps to reach the top.
//
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//    Input: n = 3
//Output: 3
//Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int[] a = new int[n];
        a[0] = 1;
        a[1] = 2;

        for (int i = 2; i < n; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[n - 1];
    }

//    Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
//
//Each letter in magazine can only be used once in ransomNote.
//    Input: ransomNote = "a", magazine = "b"
//Output: false
//    Input: ransomNote = "aa", magazine = "aab"
//Output: true
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            if (map.containsKey(magazine.charAt(i))) {
                map.put(magazine.charAt(i), map.get(magazine.charAt(i)) + 1);
            } else {
                map.put(magazine.charAt(i), 1);
            }
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (map.containsKey(ransomNote.charAt(i)) && map.get(ransomNote.charAt(i)) > 0) {
                map.put(ransomNote.charAt(i), map.get(ransomNote.charAt(i)) - 1);
            } else {
                return false;
            }
        }

        return true;
    }

//    Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
//    Input: nums = [1,2,3,1]
//Output: true
    public boolean containsDuplicate(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

//    Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
//    Input: n = 2
//Output: [0,1,1]
//Explanation:
//0 --> 0
//1 --> 1
//2 --> 10
    public int[] countBits(int n) {
        int bits[] = new int[n + 1];
        int bits_per_digit = 0;

        for (int i = 0; i <= n; i++) {
            int j = i;
            while (j != 0) {
                int d = j % 2;
                bits_per_digit += d;
                j = j / 2;
            }
            bits[i] = bits_per_digit;
            bits_per_digit = 0;
        }

        return bits;
    }

//    Write a function that takes the binary representation of an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
//    Input: n = 00000000000000000000000000001011
//Output: 3
//Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
    public int hammingWeight(int n) {
        int count = 0;

        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }

//Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
//You must implement a solution with a linear runtime complexity and use only constant extra space.  
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }

//    Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[i] = num;
                i++;
            }
        }
        while (i < nums.length) {
            nums[i] = 0;
            i++;
        }
    }

//    Given an array nums of size n, return the majority element.
//The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
//    Input: nums = [2,2,1,1,1,2,2]
//Output: 2
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n / 2];
    }

    public int majorityElement2(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        n = n / 2;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n) {
                return entry.getKey();
            }
        }

        return 0;
    }

//    Given two binary strings a and b, return their sum as a binary string.
//    Input: a = "1010", b = "1011"
//Output: "10101"
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || carry == 1) {
            if (i >= 0) {
                carry += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                carry += b.charAt(j--) - '0';
            }
            sb.append(carry % 2);
            carry /= 2;
        }
        return sb.reverse().toString();
    }

//    Reverse bits of a given 32 bits unsigned integer.
//    Input: n = 00000010100101000001111010011100
//Output:    964176192 (00111001011110000010100101000000)
//Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
    public int reverseBits(int num) {
        num = ((num & 0xffff0000) >>> 16) | ((num & 0x0000ffff) << 16);
        num = ((num & 0xff00ff00) >>> 8) | ((num & 0x00ff00ff) << 8);
        num = ((num & 0xf0f0f0f0) >>> 4) | ((num & 0x0f0f0f0f) << 4);
        num = ((num & 0xcccccccc) >>> 2) | ((num & 0x33333333) << 2);
        num = ((num & 0xaaaaaaaa) >>> 1) | ((num & 0x55555555) << 1);
        return num;
    }

//    You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
//Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
//    Input: coins = [1,2,5], amount = 11
//Output: 3
//Explanation: 11 = 5 + 5 + 1
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        int ans = helper(coins, coins.length - 1, amount, dp);
        return ans == (int) 1e9 ? -1 : ans;
    }

    private int helper(int[] coins, int index, int amount, int[][] dp) {
        if (index == 0) {
            if (amount % coins[index] == 0) {
                return amount / coins[index];
            } else {
                return (int) 1e9;
            }
        }

        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }

        int take = Integer.MAX_VALUE;
        if (coins[index] <= amount) {
            take = 1 + helper(coins, index, amount - coins[index], dp);
        }
        int notTake = helper(coins, index - 1, amount, dp);

        return dp[index][amount] = Math.min(take, notTake);
    }
    
//    You are given an m x n grid where each cell can have one of three values:
//
//0 representing an empty cell,
//1 representing a fresh orange, or
//2 representing a rotten orange.
//Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
//
//Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
//    Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
//Output: 4
    static class Edge{
        int s,d,t;
        Edge(int src,int dest,int time){
            this.s = src;
            this.d = dest;
            this.t = time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int min=0,totalO=0,rottenO=0;
        Queue<Edge> q = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new Edge(i,j,min));
                    rottenO++;
                }
                if(grid[i][j]==1 || grid[i][j]==2){
                    totalO++;
                }
            }
        }
        System.out.println("Rotten "+rottenO);
        System.out.println("Total "+totalO);
        while(!q.isEmpty()){
            Edge e = q.poll();
            int i = e.s;
            int j = e.d;
            // left
            if(i>0){
                if(grid[i-1][j]==1){
                    q.add(new Edge(i-1,j,e.t+1));
                    grid[i-1][j] = 2;
                    rottenO++;
                }
            }
            // top
            if(j>0){
                if(grid[i][j-1]==1){
                    q.add(new Edge(i,j-1,e.t+1));
                    grid[i][j-1]=2;
                    rottenO++;
                }
            }
            // right
            if(i<grid.length-1 && i+1>=0){
                if(grid[i+1][j]==1){
                    q.add(new Edge(i+1,j,e.t+1));
                    grid[i+1][j]=2;
                    rottenO++;
                }
            }
            // bottom
            if(j<grid[0].length-1 && j+1>=0){
                if(grid[i][j+1]==1){
                    q.add(new Edge(i,j+1,e.t+1));
                    grid[i][j+1]=2;
                    rottenO++;
                }
            }
            min = e.t;
            System.out.println(min);
        }
        if(totalO!=rottenO){
            return -1;
        }
        return min;
    }
    
    


}
