// https://leetcode.com/problems/max-consecutive-ones-iii
// runtime - 4ms
class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int left = 0, right = 0, count = 0, res = 0;

        while (right < nums.length){

            if (nums[right] == 0 ) count++;

            if (count > k){
                while(count > k){
                    if(nums[left] == 0) count--;
                    left++;
                }
            }

            res = Math.max(res, right-left+1);

            right++;
        }

        return res;
    }
}
