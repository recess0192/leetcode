import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class Leetcode001Twosum {

    // 暴力法很简单。遍历每个元素 x，并查找是否存在一个值与 target - x 相等的目标元素。
    public static int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    indices[0] = i;
                    indices[1] = j;
                    return indices;
                }
            }
        }

        return indices;
    }

    /**
     * 先排序，再查找，只需一次遍历
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum_sort(int[] nums, int target) {
        int[] indices = new int[2];
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        int i = 0;
        int j = copy.length - 1;
        while (j >= i) {
            if (copy[i] + copy[j] > target) {
                j--;
            } else if (copy[i] + copy[j] < target) {
                i++;
            } else {
                indices[0] = Arrays.binarySearch(nums, copy[i]);
                indices[1] = Arrays.binarySearch(nums, copy[j]);
                return indices;
            }
        }

        return indices;
    }


    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] twoSum4(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void printArray(int[] inputArray) {
        for (Integer element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        int[] nums = {2, 7, 11, 15};
//        int target = 9;
//        printArray(twoSum(nums, target));
//        printArray(twoSum_sort(nums, target));
//
//        target = 13;
//        printArray(twoSum(nums, target));
//        printArray(twoSum_sort(nums, target));

        int[] nums2 = {3, 2, 4};
        int target = 6;
        printArray(twoSum(nums2, target));
        printArray(twoSum_sort(nums2, target));
    }
}
