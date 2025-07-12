package DSA_14_DynamicProgramming.DP.DP_Q_01;

public class DP_Q_03_ClimbingStairs2StepsWeighted {

    // relation 
    // f(n) = g(n) + min(f(n-1),f(n-2))

    // m-4
    // iteration
    static int m4(int n, int[] wt) {
        if (n==0) return wt[0];
        if (n==1) return Math.min(wt[0], wt[1]);
        int previous2 = wt[0];
        int previous1 = wt[1];
        int current = 0;
        for (int i = 2; i < n; i++) {
            current = wt[i] + Math.min(previous1, previous2);
            previous2 = previous1;
            previous1 = current;
        }
        return Math.min(previous1, previous2);
    }
    public static void main(String[] args) {
        int[] wt = {16,19,10,12,18};
        int n = wt.length;
        System.out.println(n+": "+m4(n, wt));
    }
}