class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap <Integer,Integer> map = new HashMap<Integer,Integer>();           List<Integer> out = new ArrayList<Integer>();
        for(int i = 0 ; i <nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i1, i2) -> map.get(i1)-map.get(i2));  
        
        for(int key:map.keySet()){
            maxHeap.add(key);
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }
        while(!maxHeap.isEmpty()){
            out.add(maxHeap.poll());
        }
        Collections.reverse(out);
        return out;
    }
}