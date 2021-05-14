/*
36. Valid Sudoku
Brute force. I check every single row, column and sub-square for any duplicates or invalid digits.
Before I used a HashSet to check for duplicates, but I was made aware that you can do the same thing
with a boolean array, which is super efficient and fast. This optimization sped up the algorithm twice as fast
and uses much less memory.
*/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        return validRows(board) && validColumns(board) && validSquares(board);
    }
    
    public boolean validSquares(char[][] board){
        for(int rowOffset = 0; rowOffset < 9; rowOffset = rowOffset+3){
            for(int colOffset = 0; colOffset < 9; colOffset = colOffset + 3){
                boolean[] visitedNum = new boolean[9];
                for(int i = 0; i < 3; i++){
                    for(int j = 0; j < 3; j++){
                        char c = board[i+rowOffset][j+colOffset];
                        if(c == '.') continue;
                        int num = c - '1';
                        if(visitedNum[num]) return false;
                        visitedNum[num] = true;
                    }
                }
        }
    }
        return true;
    }
    
    public boolean validRows(char[][] board){
        for(int i = 0; i < 9; i++){
            boolean[] visitedNum = new boolean[9];
            for(int j = 0; j < 9; j++){
                char c = board[i][j];
                if(c == '.') continue;
                int num = c - '1';
                if(visitedNum[num]) return false;
                visitedNum[num] = true;
            }
        }
        return true;
    }
    
    public boolean validColumns(char[][] board){
        for(int i = 0; i < 9; i++){
            boolean[] visitedNum = new boolean[9];
            for(int j = 0; j < 9; j++){
                char c = board[j][i];
                if(c == '.') continue;
                int num = c - '1';
                if(visitedNum[num]) return false;
                visitedNum[num] = true;
            }
        }
        return true;
    }
}