package com.pocketknives;

public final class SearchUtils {
    /**
     * 查找排序数组中的元素下标
     * 不存在则返回 -1
     * @param nums 查找的数组
     * @param target 待查找的元素
     * @return 元素所在下标，不存在返回 -1
     */
    public static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        return doBsInt(nums, target, 0, nums.length);
    }

    /**
     * 执行二分查找
     * @param nums 查找数组
     * @param target 目标元素
     * @param left 数组左边界
     * @param right 数组右边界
     * @return 目标元素所在数组下标，不存在返回 -1
     */
    private static int doBsInt(int[] nums, int target, int left, int right) {
        if (left >= right) {
            return -1;
        }

        int middle = computeMiddle(left, right);
        if (nums[middle] == target) {
            return middle;
        }
        if (nums[middle] > target) {
            return doBsInt(nums, target, left, middle);
        }

        return doBsInt(nums, target, middle + 1, right);
    }

    /**
     * 查找已排序数组中的元素下标
     * @param comparables 可比较大小的元素数组
     * @param target 要查找的元素
     * @param <T> 范型类型
     * @return 元素所在下标，不存在则返回 -1
     */
    public static <T extends Comparable<T>> int binarySearch(T[] comparables, T target) {
        if (comparables == null || comparables.length == 0 || target == null) {
            return -1;
        }

        return doBsComparable(comparables, target, 0, comparables.length);
    }

    /**
     * 执行二分查找
     * @param comparables 可比较大小的元素数组
     * @param target 要查找的元素
     * @param left 数组左边界
     * @param right 数组右边界
     * @param <T> 数据类型
     * @return 目标元素所在数组下标，不存在返回 -1
     */
    public static <T extends Comparable<T>> int doBsComparable(T[] comparables, T target, int left, int right) {
        if (left >= right) {
            return -1;
        }

        int middle = computeMiddle(left, right);
        int compareResult = target.compareTo(comparables[middle]);
        if (compareResult == 0) {
            return middle;
        }
        if (compareResult < 0) {
            return doBsComparable(comparables, target, left, middle);
        }

        return doBsComparable(comparables, target, middle + 1, right);
    }

    private static int computeMiddle(int left, int right) {
        return left + ((right - left) >> 1);
    }
}
