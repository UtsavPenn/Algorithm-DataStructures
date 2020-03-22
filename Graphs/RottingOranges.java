/**
In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.

**/
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Integer> rottenQueue = new ArrayDeque();
        int minutes = 0;
        int rowCount = grid.length;
        int colCount = grid[0].length;
        Set <Integer> freshSet = new HashSet<>();
        for(int i = 0 ; i< rowCount; i++){
            for(int j = 0 ; j< colCount; j++){
                int code = i*colCount+j;
                 if(grid[i][j]==2){
                    rottenQueue.add(code);
                }
                else if(grid[i][j]==1){
                    freshSet.add(code);

                }
            }
        }

        int [][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!freshSet.isEmpty() && !rottenQueue.isEmpty()){
            int size = rottenQueue.size();
            for (int i = 0; i < size; i++) {
                int decoded = rottenQueue.remove();
                for(int k = 0 ; k < directions.length; k++){
                    int row = directions[k][0] + decoded/colCount;
                    int col = directions[k][1] + decoded%colCount;
                    if(row>=rowCount || col>=colCount || row<0 || col<0)
                    	continue;
                    int code = row*colCount+col;
                    if(freshSet.contains(code)){
                        rottenQueue.add(code);
                        freshSet.remove(code);
                    }
                }
            }
            minutes++;
        }
        return freshSet.isEmpty()? minutes:-1;
    }
}
