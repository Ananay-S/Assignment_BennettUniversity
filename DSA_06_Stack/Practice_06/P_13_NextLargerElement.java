package DSA_06_Stack.Practice_06;

import java.util.Stack;

public class P_13_NextLargerElement {
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        // Your code here
        long a[] = new long[arr.length];
        
        Stack<Long> s = new Stack<>();
            for (int i = arr.length-1; i >=0; i--) {
                while ((!s.isEmpty())&&(s.peek() <= arr[i])) {
                    s.pop();
                }
                if (s.isEmpty()) {
                    a[i] = -1;
                    // System.out.println("-1");
                } else {
                    a[i] = s.peek();
                    // System.out.println(s.peek());
                }
                s.push(arr[i]);
            }
        return a;
    } 

    public static void main(String[] args) {
        
    }
}
