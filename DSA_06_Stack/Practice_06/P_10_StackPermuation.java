package DSA_06_Stack.Practice_06;

import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class P_10_StackPermuation {
    
    // m1
    static boolean m1(int in[], int out[], int n) {
        Queue<Integer> input = new LinkedList<>();
        Queue<Integer> output = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            input .add(in[i]);
            output.add(out[i]);
        }

        Stack<Integer> temp = new Stack<>();
        while (!input.isEmpty()) {
            int i = input.poll();
            if (i==output.peek()) {
                output.poll();
                while (!temp.isEmpty()) {
                    if (temp.peek()==output.peek()) {
                        temp.pop();
                        output.poll();
                    }
                    else {
                        break;
                    }
                }
            } else {
                temp.push(i);
            }
        }
        
    }
}
