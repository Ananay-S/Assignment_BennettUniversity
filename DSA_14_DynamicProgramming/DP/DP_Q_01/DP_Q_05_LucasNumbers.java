package DSA_14_DynamicProgramming.DP.DP_Q_01;

public class DP_Q_05_LucasNumbers {
    
    // same as fibonacci numbers
    // start from 2 1 instead of 0 1
    static int m4(int n) {
        if (n<1) return 2;
        if (n==1) return 1;
        int previous2 = 2;
        int previous1 = 1;
        int current = 0 ;
        for (int i = 2; i <= n; i++) {
            current = previous1+previous2;
            previous2 = previous1;
            previous1 = current;
        }
        return current;
    }

    public static void main(String[] args) {
        int n=7;
        System.out.println("lucas number "+n+" : "+m4(n));
    }
}
