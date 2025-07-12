package DSA_07_Queue.Practice_07;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class P_02_ReverseFirstKElementsOfQueue {
    
    static Queue<Integer> m1(Queue<Integer> q, int k) {
        Queue<Integer> nq = new ArrayDeque<>();
        Stack<Integer> s = new Stack<>();
        int count = 0;
        while (count<k) {
            s.push(q.remove());
            count++;
        }
        while (!s.isEmpty()) {
            nq.add(s.pop());
        }
        while (!q.isEmpty()) {
            nq.add(q.remove());
        }
        return nq;
    }


    public static void main(String[] args) {
        
    }
}
