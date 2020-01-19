/**
Given an array of meeting time intervals consisting of start and
end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2

Input: [[7,10],[2,4]]
Output: 1
**/
class Solution {
    public int minMeetingRooms(int[][] intervals) {

        if(intervals == null || intervals.length == 0)
            return 0;

        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)-> a[1]-b[1]);
        heap.add(intervals[0]);

        for(int i=1; i<intervals.length;i++){
            int[] current = intervals[i];
            int[] earliest = heap.remove();

            if(current[0] >= earliest[1]){
                earliest[1] = current[1];
            }
            else{
                heap.add(current);
            }
            heap.add(earliest);
        }
        return heap.size();
    }
}
