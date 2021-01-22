package Array._0665;

class Solution{
    public boolean checkPossibility(int[] nums) {
        int n = nums.length;
        if (n <= 1) return true;
        int down = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                down++;
                if (down > 1) {
                    return false;
                }
                if (i > 1 && i < n - 1 && nums[i - 1] > nums[i + 1] && nums[i - 2] > nums[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
