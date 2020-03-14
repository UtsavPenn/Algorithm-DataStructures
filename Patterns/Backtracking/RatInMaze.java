/**
A Maze is given as N*N binary matrix of blocks where source
block is the upper left most block i.e., maze[0][0] and destination
block is lower rightmost block i.e., maze[N-1][N-1]. A rat starts
from source and has to reach the destination. The rat can move only
in two directions: forward and down.
In the maze matrix, 0 means the block is a dead end and 1 means the
block can be used in the path from source to destination.
**/


public class RatMaze {
  // Size of the maze
  static int N;

  void printSolution(int sol[][]) {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++)
        System.out.print(" " + sol[i][j] + " ");
        System.out.println();
      }
  }

  boolean isSafe(int maze[][], int x, int y){
    return (x >= 0 && y>=0 && x <=N && y<=N && maze[x][y]==1);
  }

  boolean solveMaze(int maze[][]){
    int sol[][] = new int[N][N];
    if(solveMazeUtil(maze,0,0,sol)==false)
      return false;
    printSolution(sol);
    return true;
  }

  boolean solveMazeUtil(int maze[][], int x, int y,int sol[][]){
     // if (x, y is goal) return true
    if(x==N-1 && y == N-1){
      sol[x][y] = 1;
      return true;
    }
     // Check if maze[x][y] is valid
    if(isSafe(maze,x,y)==true)
      sol[x][y] = 1;
    /* Move forward in x direction */
    if(solveMazeUtil(maze,x+1,y,sol)==true)
      return true;
    /* If moving in x direction doesn't give solution then
            Move down in y direction  */
    if(solveMazeUtil(maze,x,y+1,sol)==true)
      return true;
    /* If none of the above movements work then BACKTRACK:
              unmark x, y as part of solution path */
    sol[x][y] = 0;
  }

}
