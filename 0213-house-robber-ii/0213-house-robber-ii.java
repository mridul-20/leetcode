class Solution {
    public int rob1(int[] nums) {
        int prev = nums[0];
        int prev2 = 0;

        for(int i = 1; i < nums.length ; i++){
            int take = nums[i];
            if(i>1) take += prev2;
            int notTake = prev;
            int curr = Math.max(take , notTake);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] arr1 = Arrays.copyOfRange(nums, 1, n); 
        int[] arr2 = Arrays.copyOfRange(nums, 0, n - 1);
        int temp1 = rob1(arr1);
        int temp2 = rob1(arr2);
        return Math.max(temp1,temp2);
    }
}