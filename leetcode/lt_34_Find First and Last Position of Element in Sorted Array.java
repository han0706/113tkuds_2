class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums == null || nums.length == 0) return result;

        result[0] = findLeft(nums, target);
        result[1] = findRight(nums, target);
        return result;
    }

    // 找左邊界
    private int findLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1, index = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= target) right = mid - 1;
            else left = mid + 1;

            if (nums[mid] == target) index = mid;
        }
        return index;
    }

    // 找右邊界
    private int findRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1, index = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] <= target) left = mid + 1;
            else right = mid - 1;

            if (nums[mid] == target) index = mid;
        }
        return index;
    }
}
