// Given a 2D board and a word, find if the word exists in the grid.

// The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

// For example,
// Given board =

// [
//   ['A','B','C','E'],
//   ['S','F','C','S'],
//   ['A','D','E','E']
// ]
// word = "ABCCED", -> returns true,
// word = "SEE", -> returns true,
// word = "ABCB", -> returns false.
class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0 ; i < board.length; i++){
            for(int j = 0 ; j <board[i].length; j++){
                if(board[i][j] == word.charAt(0) && dfs(i,j,board,word,0)){
                        return true;
                }
            }
        }
        return false;
    }

    private boolean  dfs(int i, int j, char[][] board, String word, int count){
        if(count == word.length())
            return true;
        if(i<0|| j<0 || i >= board.length || j >=board[i].length ||   board[i][j]!= word.charAt(count))
            return false;
        char temp = board[i][j];
        board[i][j] = ' ';
        boolean found = dfs(i+1, j , board, word, count +1 )|| dfs(i-1,j , board, word, count+1) || dfs(i, j+1 , board, word, count+1) || dfs(i,j-1 , board, word, count+1);
        board[i][j] = temp;
        return found;
    }
}

// time complexity : O(n)  going through all cells on the board before calling dfs
// Space Complexity : 0(n) Worst case all the cells are used in the recursive calls.
