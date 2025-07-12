package DSA_06_Stack;

import java.util.Stack;

public class S_02_Q_01 {
    
    // A1
    static void pse(int arr[]) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while ((!s.isEmpty())&&(s.peek() >= arr[i])) {
                s.pop();
            }
            if (s.isEmpty()) {
                System.out.println("-1");
            } else {
                System.out.println(s.peek());
            }
            s.push(arr[i]);
        }
    }
        // ple (previous larger element)
        void ple(int arr[]) {
            Stack<Integer> s = new Stack<>();
            for (int i = 0; i < arr.length; i++) {
                while ((!s.isEmpty())&&(s.peek() <= arr[i])) {
                    s.pop();
                }
                if (s.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(s.peek());
                }
                s.push(arr[i]);
            }
        }
    // Q2
    static void nse(int arr[]) {
        Stack<Integer> s = new Stack<>();
            for (int i = arr.length-1; i >=0; i--) {
                while ((!s.isEmpty())&&(s.peek() >= arr[i])) {
                    s.pop();
                }
                if (s.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(s.peek());
                }
                s.push(arr[i]);
            }
    }

    public static void main(String[] args) {
        
        // Q1 previous smaller element
        int a1[] = {4,10,5,18,3,12,7};
        pse(a1);
        // Q2 next smaller element
    }
}
