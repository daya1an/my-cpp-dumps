class Solution {
    public int findPeakElement(int[] nums) {
        
        // int n = nums.length;
        // int start = 0;
        // int end = n-1;

        // while (start < end){
            
        //     int mid = start + (end - start)/2;

        //     if (nums[mid] < nums[mid+1]) {
        //         start = mid + 1;
        //     } else {
        //         end = mid;
        //     }
            
        //     if ( start == end ) return start;
        // }

        // return start;

        int max=Integer.MIN_VALUE;
        int j=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>max)
            {
                max=nums[i];
                j=i;
            }
        }
        return j;
    }
}
