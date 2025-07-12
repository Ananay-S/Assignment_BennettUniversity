package DSA_06_Stack.Practice_06;

import java.util.Stack;

public class P_11_CountNaturalNumberWhosePermutationGreaterNumber {
    
    // Q means all numbers with increasing order of digits form l to r
    // m1
    static int m1(int n) {
        int count = 0;

        Stack<Integer> s = new Stack<>();
        for (int i = 1; i <= 9; i++) {
            // add 1-9 as no permutations possible
            if (i<=n) { 
                s.push(i);
                count++;
            }

            while (!s.empty()) {
                int top = s.pop();
                for (int j = top%10; j <= 9; j++) {
                    int x = top*10 + j;
                    if (x<=n) {
                        s.push(x);
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(m1(100));
    }
    
}