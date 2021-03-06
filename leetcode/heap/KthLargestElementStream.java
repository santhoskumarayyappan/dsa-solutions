//27-02-2022
//https://leetcode.com/problems/kth-largest-element-in-a-stream/



class KthLargestElementStream {

    public PriorityQueue<Integer> minHeap;
    public int k;
    
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        this.k = k;
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
