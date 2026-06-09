class Solution {
    public int findMiddleIndex(int[] nums) {
        //int total = Arrays.stream(nums).sum(); // this is causing more runtime
        int ls = 0, ts = 0;
        for (int i=0; i<nums.length; i++) ts = ts + nums[i]; // this is causing less runtime
        for (int i=0; i<nums.length; i++){
            if ((ts - ls - nums[i]) == ls) return i;
            ls = ls + nums[i]; 
        }
        return -1;
    }
}