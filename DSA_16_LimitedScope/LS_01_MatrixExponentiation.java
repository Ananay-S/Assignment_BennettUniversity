package DSA_16_LimitedScope;

public class LS_01_MatrixExponentiation {

    // GENERALISED ORDER
    // mostlt 2 order
    static int[][] matrixExponentiate(int[][] matrix, int len, int n) {        
        int[][] result = new int[len][len];
        for (int i = 0; i < len; i++) {
            result[i][i] = 1;
        }
        // base cases
        if (n==0) { // identity                                      
            return result;
        }
        if (n==1) {                                             
            return matrix;
        }
        // printMatrix(result, len);
        // System.out.println();
        // iterative
        while (n>0) {
            if ((n&1)==1) matrixMultiply(result, matrix, len);
            matrixMultiply(matrix, matrix, len);
            n>>=1;
            // printMatrix(result, len);
            // System.out.println();
        }

        return result;
    }

    static void matrixMultiply(int[][] a, int[][] b, int len) {
        int[][] temp = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int k = 0; k < len; k++) {
                    temp[i][j] += a[i][k]*b[k][j];
                }
            }
        }
        // copy temp to a(result)
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                a[i][j] = temp[i][j];
            }
        } 
    } 

    static void printMatrix (int[][] matrix, int len) {
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                System.out.print(matrix[i][j]+" ");
            }System.out.println();
        }
    }

    public static void main(String[] args) {
        
        // matrixExponentiate (matrix of order len raised to power n)

        // use case 
            // nth fibonacci number
            // 1 1
            // 1 0
            int[][] fn = {{1,1},{1,0}};
            int len = 2;
            int nth = 5;
            int[][] result = matrixExponentiate(fn, len, nth-1);
            System.out.println(nth+"th fibonacci : "+result[0][0]);
    }
}