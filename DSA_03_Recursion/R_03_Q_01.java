package DSA_03_Recursion;

// Recursion_03_Questions_02
public class R_03_Q_01 {
    
    // A1) 
    static int noOfPaths(int n, int m) {
        if (n==1 || m==1) {
            return 1;
        }
        return noOfPaths(n-1, m) + noOfPaths(n, m-1);
    }

    // A2) 
    static int jos(int n, int k) {
        if (n==1) {
            return 0;
        }
        return (jos(n-1, k)+k)%n;
    }


    public static void main(String[] args) {
        // Q1) In a nxm matrix find no. of paths from top left to bottom right
        System.out.println(noOfPaths(4, 5));
        System.out.println();

        // Q2) Josephus Problem

    }
}
