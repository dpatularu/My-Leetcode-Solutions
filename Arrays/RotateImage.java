/*
48. Rotate Image
By applying some Linear Algebra facts, we realize that the rotated image is simply the matrix transposed and rows reversed.
*/

class Solution {
    public void rotate(int[][] matrix) {

        //Transpose the matrix
        for(int i = 0; i < matrix.length; i++){
            for(int j = i; j < matrix.length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //Reverse the rows
        for(int i = 0; i < matrix.length; i++){
            reverse(matrix[i]);
        }
    }
    
    public void reverse(int[] row){
        for(int i = 0; i < row.length/2; i++){
            int temp = row[i];
            row[i] = row[row.length - 1 - i];
            row[row.length - 1 - i] = temp;
        }
    }
}