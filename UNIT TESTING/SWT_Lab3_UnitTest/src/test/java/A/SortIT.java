/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package A;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SortIT {
    private Sort sort;
    
    public SortIT() {
        sort = new Sort();
    }

    @Test
    public void testSelectionSortAsc() {
        int[] array = {5, 2, 7, 1, 3};
        int[] expected = {1, 2, 3, 5, 7};

        sort.selectionSortAsc(array);

        assertArrayEquals(expected, array);
    }

    @Test
    public void testSelectionSortDesc() {
        int[] array = {5, 2, 7, 1, 3};
        int[] expected = {7, 5, 3, 2, 1};

        sort.selectionSortDesc(array);

        assertArrayEquals(expected, array);
    }

    @Test
    public void testBubbleSortAsc() {
        int[] array = {5, 2, 7, 1, 3};
        int[] expected = {1, 2, 3, 5, 7};

        sort.bubbleSortAsc(array);

        assertArrayEquals(expected, array);
    }

    @Test
    public void testBubbleSortDesc() {
        int[] array = {5, 2, 7, 1, 3};
        int[] expected = {7, 5, 3, 2, 1};

        sort.bubbleSortDesc(array);

        assertArrayEquals(expected, array);
    }

    @Test
    public void testInsertionSortAsc() {
        int[] array = {5, 2, 7, 1, 3};
        int[] expected = {1, 2, 3, 5, 7};

        sort.insertionSortAsc(array);

        assertArrayEquals(expected, array);
    }

    @Test
    public void testInsertionSortDesc() {
        int[] array = {5, 2, 7, 1, 3};
        int[] expected = {7, 5, 3, 2, 1};

        sort.insertionSortDesc(array);

        assertArrayEquals(expected, array);
    }

    @Test
    public void testMergeSortAsc() {
        int[] array = {5, 2, 7, 1, 3};
        int[] expected = {1, 2, 3, 5, 7};

        sort.mergeSortAsc(array);

        assertArrayEquals(expected, array);
    }

    @Test
    public void testMergeAsc() {
        int[] left = {1, 3, 5};
        int[] right = {2, 4, 6};
        int[] result = new int[left.length + right.length];
        int[] expected = {1, 2, 3, 4, 5, 6};

        sort.mergeAsc(left, right, result);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testMergeSortDesc() {
        int[] array = {5, 2, 7, 1, 3};
        int[] expected = {7, 5, 3, 2, 1};

        sort.mergeSortDesc(array);

        assertArrayEquals(expected, array);
    }

    @Test
    public void testMergeDesc() {
        int[] left = {1, 3, 5};
        int[] right = {2, 4, 6};
        int[] result = new int[left.length + right.length];
        int[] expected = {2, 1, 4, 3, 6, 5};

        sort.mergeDesc(left, right, result);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testQuickSort() {
        int[] array = {5, 2, 8, 3, 1, 7};
        int[] expected = {1, 2, 3, 5, 7, 8};

        sort.quickSort(array, 0, array.length - 1);

        assertArrayEquals(expected, array);
    }

    @Test
    public void testPartition() {
        int[] array = {5, 2, 8, 3, 1, 7};
        int pivotIndex = sort.partition(array, 0, array.length - 1);
        int[] expected = {2, 3, 1, 5, 8, 7};

        assertEquals(3, pivotIndex);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testHeapSort() {
        int[] array = {5, 2, 8, 3, 1, 7};
        int[] expectedArray = {1, 2, 3, 5, 7, 8};

        sort.heapSort(array);

        assertArrayEquals(expectedArray, array);
    }

    @Test
    public void testHeapify() {
        int[] array = {4, 10, 3, 5, 1};
        int n = array.length;

        sort.heapify(array, n, 0);

        int[] expectedArray = {10, 5, 3, 4, 1};
        assertArrayEquals(expectedArray, array);
    }

    @Test
    public void testCountingSort() {
        int[] array = {4, 2, 2, 8, 3, 3, 1};
        
        sort.countingSort(array);
        
        int[] expectedArray = {1, 2, 2, 3, 3, 4, 8};
        assertArrayEquals(expectedArray, array);
    }

    @Test
    public void testFindMax() {
        int[] array = {4, 2, 8, 3, 1};
        
        int max = sort.findMax(array);
        
        assertEquals(8, max);
    }

    @Test
    public void testBucketSort() {
        double[] array = {0.4, 0.2, 0.8, 0.3, 0.1};
        double[] expected = {0.1, 0.2, 0.3, 0.4, 0.8};

        sort.bucketSort(array);

        assertArrayEquals(expected, array, 0.0001);
    }

}
