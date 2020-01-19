class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int [][]out = new int[K][2];
        PriorityQueue <int[]> distance  = new PriorityQueue<>((a,b)->
            (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0]+a[1]*a[1]));
        
        for(int[] point: points){
            distance.add(point);
            if(distance.size() > K)
                distance.remove();
        }
        
        while(K-->0){
            out[K] = distance.remove();
        }
        return out;
    }
}