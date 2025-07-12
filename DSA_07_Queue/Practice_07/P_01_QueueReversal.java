package DSA_07_Queue.Practice_07;

import java.util.Queue;
import java.util.Stack;

public class P_01_QueueReversal {

    // m
    static Queue<Integer> m(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        while (!q.isEmpty()) {
            s.push(q.remove());
        }
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
        return q;
    }
    public static void main(String[] args) {
        
    }
}
