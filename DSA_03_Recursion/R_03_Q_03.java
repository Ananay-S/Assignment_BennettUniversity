package DSA_03_Recursion;

// Recursion_03_Questions_02
public class R_03_Q_03 {
    
    // A1
    static void printBoard(int board[][]) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]+" ");
            } System.out.println();
        }
    }

    static boolean isSafe(int[][] board, int r, int c) {
        // vertical
        for (int i = 0; i < board.length; i++) {
            if (board[i][c] == 1) {
                return false;
            }
        }
        // horizontal
        for (int j = 0; j < board.length; j++) {
            if (board[r][j] == 1) {
                return false;
            }
        }
        // digonal
            // upper left
            for (int i=r, j=c; i>=0 && j>=0; i--, j--) {
                if (board[i][j] == 1) {
                    return false;
                }
            }
            // upper right
            for (int i=r, j=c; i>=0 && j>c; i--, j++) {
                if (board[i][j] == 1) {
                    return false;
                }
            }
            // lower right 
            for (int i=r, j=c; i>r && j>c; i++, j++) {
                if (board[i][j] == 1) {
                    return false;
                }
            }
            // lower left
            for (int i=r, j=c; i>r && j>=0; i++, j--) {
                if (board[i][j] == 1) {
                    return false;
                }
            }
        // base case
        return true;
    }
    
    static boolean nQueen(int board[][], int row) {
        int N = board.length;

        if (row == N) {
            printBoard(board);
            return true;
        }
        
        for (int column = 0; column < N; column++) {
            if (isSafe(board, row, column)) {
                board[row][column] = 1;
                if (nQueen(board, row+1)) {
                    return true;
                } board[row][column] = 0;
            }    
        }

        return false;
    }


    // A2


    public static void main(String[] args) {
        // adding bit masking
        // Q1) n Queens
        int[][] nq = new int[4][4];
        nQueen(nq, 0);

        // Q2 Sudoku solver

        

    }
}
