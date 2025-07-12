package DSA_06_Stack.Practice_06;

import java.util.Stack;

public class P_07_DesignandImplementSpecialStack {

    // 
    // static class SpecialStack extends Stack<Integer> {
    //     Stack<Integer> min = new Stack<>();
    //     void push(int x) {
    //         super.push(x);
    //         if (min.isEmpty()) {
    //             min.push(x);
    //         } else {
    //             if (x<=min.peek()) {
    //                 min.push(x);
    //             }
    //         }
    //     }
    //     public Integer pop() {
    //         int x = super.pop();
    //         if (x==min.peek()) min.pop();
    //         return x;
    //     }
    //     int getMin() {
    //         return min.peek();
    //     }
    // }

    // 
    static class SpecialStack {
        int min = -1;
        int wrapper = 9999;
        Stack<Integer> s = new Stack<>();

        void push(int x) {
            if (s.isEmpty() || (x<min)) min=x;
            s.push((x*wrapper + min));
        }
        int pop() {
            if (s.isEmpty()) return -1;
            int x = s.pop();
            if (s.isEmpty()) {
                min=-1;
            } else {
                min=(s.peek() - s.peek()/wrapper);
            }
            return x/wrapper;
        }
        int peek() {
            return s.peek()/wrapper;
        }
        int getMin() {
            return min;
        }
    }
    public static void main(String[] args) {
        // SpecialStack s = new SpecialStack(); 
        // s.push(10); 
        // s.push(20); 
        // s.push(30); 
        // System.out.println(s.getMin()); 
        // s.push(5); 
        // System.out.println(s.getMin()); 
        
    }
}