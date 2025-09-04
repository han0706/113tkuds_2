class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0; // 指向下一個合法元素要放的位置
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k; // 返回剩下元素的數量
    }
}
