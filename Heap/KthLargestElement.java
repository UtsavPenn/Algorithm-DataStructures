/**
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5
Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
**/
class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> heap = new PriorityQueue<>((i1,i2)->i1-i2);
        for(int i =0 ;i<nums.length; i++){
            heap.add(nums[i]);
            if(heap.size()>k)
                heap.poll();
        }

        return heap.poll();
    }
}

/**
The time complexity of adding an element in a heap of size k is O(logk), and we do it N times that means O(Nlogk) time complexity for the algorithm.
The space complexity here is O(k)
If we used sorting on an array then the time complexity would have been O(N log N) and space complexity would have been O(1)

**/
