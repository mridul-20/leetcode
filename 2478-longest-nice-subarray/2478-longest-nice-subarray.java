class Solution {
    public int longestNiceSubarray(int[] nums) {
        int l =0;
        int usedbit = 0;
        int maxLength = 0;
         for(int i =0; i< nums.length ; i++){
            while((usedbit & nums[i]) != 0){
                usedbit ^= nums[l];
                l++;
            }
            usedbit |= nums[i];
            maxLength = Math.max(maxLength , i - l + 1);
         }
         return maxLength;
    }
}