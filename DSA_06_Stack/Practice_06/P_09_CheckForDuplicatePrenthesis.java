package DSA_06_Stack.Practice_06;

import java.util.Stack;

public class P_09_CheckForDuplicatePrenthesis {

    // m1
    static boolean m1(String str) {
        Stack<Character> s = new Stack<>();
        char ch[] = str.toCharArray();
        for (char c : ch) {
            if (c==')') {
                int count = 0;
                while (s.peek()!='(') {
                    count++;
                    s.pop();
                } s.pop();
                if (count<1) {
                    return true;
                }
            } else {
                s.push(c);
            }            
        }
        return false;
    }

    public static void main(String[] args) {
        // m1
        System.out.println(m1("((a+(b))+(c+d))"));
    }
}
