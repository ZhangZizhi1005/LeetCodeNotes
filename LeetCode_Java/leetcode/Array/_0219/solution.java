package Array._0219;

class solution{
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k < nums.length) {
            for (int i = 0; i < nums.length - k; i++) {
                int index = 1;
                while (index <= k) {
                    if (nums[i] == nums[i + index]) {
                        return true;
                    }
                    index++;
                }
            }
            for (int i = nums.length - k; i <= nums.length - 2; i++) {
                for (int j = i + 1; j <= nums.length - 1; j++) {
                    if (nums[i] == nums[j]) {
                        return true;
                    }
                }
            }
            return false;
        }
        else{
            for(int i = 0; i <= nums.length -2 ;i++){
                for (int j = i+1 ; j<= nums.length - 1 ; j++){
                    if (nums[i] == nums[j]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
