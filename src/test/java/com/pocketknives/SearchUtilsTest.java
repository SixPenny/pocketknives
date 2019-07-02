package com.pocketknives;

import org.junit.Assert;
import org.junit.Test;

public class SearchUtilsTest {

    @Test
    public void testBinarySearchInt() {
        for (int n = 2; n < 1000; n++) {
            int[] nums = new int[n];

            for (int i = 0; i < n; i++) {
                nums[i] = 10 * i;
            }
            Assert.assertTrue(SearchUtils.binarySearch(nums, (n / 2) * 10) != -1);
            Assert.assertEquals(SearchUtils.binarySearch(nums, (n / 2) * 10 - 5), -1);
            Assert.assertEquals(SearchUtils.binarySearch(nums, n * 10 - 5), -1);
            Assert.assertEquals(SearchUtils.binarySearch(nums, n * 10), -1);
        }
    }

    @Test
    public void testBinarySearchComparable() {
        for (int n = 2; n < 1000; n++) {
            TestClass[] testClasses = new TestClass[n];

            for (int i = 0; i < n; i++) {
                testClasses[i] = new TestClass(10 * i);
            }
            Assert.assertTrue(SearchUtils.binarySearch(testClasses, new TestClass((n / 2) * 10)) != -1);
            Assert.assertEquals(SearchUtils.binarySearch(testClasses, new TestClass((n / 2) * 10 - 5)), -1);
            Assert.assertEquals(SearchUtils.binarySearch(testClasses, new TestClass(n * 10 - 5)), -1);
            Assert.assertEquals(SearchUtils.binarySearch(testClasses, new TestClass(n * 10)), -1);
        }
    }
}

class TestClass implements Comparable<TestClass> {
    int n = 0;

    TestClass(int i) {
        this.n = i;
    }
    public int compareTo(TestClass o) {
        if (o == null) {
            return -1;
        }
        return n - o.n;
    }
}
