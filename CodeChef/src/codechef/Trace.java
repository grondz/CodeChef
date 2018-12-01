package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    https://www.codechef.com/problems/TRACE
*/
class Trace {
    
    public static int getMaxTrace(int [][] matrix) {
        int result = 0;
        int [] diagonalMaxims = new int[2 * matrix.length - 1];
        
        java.util.Arrays.fill(diagonalMaxims, 0);
        
        for(int row = 0; row < matrix.length; ++row) 
            for(int col = 0; col < matrix[row].length; ++col) {
                int diagonalIndex = row - col + matrix.length - 1;
                diagonalMaxims[diagonalIndex] += matrix[row][col];
                if (result < diagonalMaxims[diagonalIndex]) result = diagonalMaxims[diagonalIndex];
            }        
        return result;
    }
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer testCases = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < testCases; ++tc) {
            String[] line = br.readLine().split("\\s+");
            int matrixSize = java.lang.Integer.parseInt(line[0]);
            int [][] inputMatrix = new int[matrixSize][matrixSize];            
            for(int i = 0; i < matrixSize; ++i) {
                String [] row = br.readLine().split("\\s+");
                for(int j = 0; j < matrixSize; ++j)
                    inputMatrix[i][j] = java.lang.Integer.parseInt(row[j]);
            }
            System.out.println(getMaxTrace(inputMatrix));
        }
    }    
}
