import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) return res;

        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue; // 去重
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j-1]) continue; // 去重

                int left = j + 1, right = n - 1;
                while (left < right) {
                    long sum = (long)nums[i] + nums[j] + nums[left] + nums[right]; // 用 long 防溢位

                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) left++;  // 去重
                        while (left < right && nums[right] == nums[right - 1]) right--; // 去重
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {1,0,-1,0,-2,2};
        int target1 = 0;
        System.out.println(sol.fourSum(nums1, target1));
        // [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

        int[] nums2 = {2,2,2,2,2};
        int target2 = 8;
        System.out.println(sol.fourSum(nums2, target2));
        // [[2,2,2,2]]
    }
}
