class Solution {
    public int findKthLargest(int[] nums, int k) {
        
    // PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    // for (int num: nums){
    //     minHeap.add(num);
    //     if (minHeap.size() > k)
    //         minHeap.poll();
    // }
    // return minHeap.peek(); // 70 ms

    Arrays.sort(nums);
    return nums[nums.length - k]; //30 ms

    }
}
