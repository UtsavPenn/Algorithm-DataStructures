class Solution {
     public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i1, i2) -> i2 - i1);
        for (int i = 0; i < stones.length; i++) {
            maxHeap.add(stones[i]);
        }
        while (maxHeap.size() > 1) {
            int first = maxHeap.poll();
            int second = maxHeap.poll();
            int delta = first - second;
            
            if (delta > 0) {
                maxHeap.add(delta);
            }
        }
        if (maxHeap.isEmpty()) {
            return 0;
        }
        return maxHeap.peek();
    }
}