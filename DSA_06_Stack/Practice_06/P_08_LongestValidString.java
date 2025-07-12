package DSA_06_Stack.Practice_06;

import java.util.Stack;

public class P_08_LongestValidString {
    
    // m
    static boolean isOpening(char c) {
        return ((c=='(')||(c=='[')||(c=='{'));
    }
    static boolean isMatching(char a, char b) {
        return (((a=='(')&&(b==')'))||((a=='[')&&(b==']'))||((a=='{')&&(b=='}')));
    }
    static boolean isParenthesisMatching(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (isOpening(c)) {
                s.push(c);
            } else {
                if (s.isEmpty()) {
                    return false;
                } else if (!isMatching(s.peek(), c)) {
                    return false;
                } else {
                    s.pop();
                }
            }
        }
        return s.isEmpty();
    }

    // m1
    static int m1(String str) {
        int n = str.length();
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        int max = 0;
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if (c=='(') {
                s.push(i);
            } else {
                if (!s.isEmpty()) {
                    s.pop();
                }
                if (!s.isEmpty()) { // closing more than opening
                    max = Math.max(max, (i-s.peek()));
                } else {
                    s.push(i);
                }
            }
        }
        return max;
    }

    // m2
    static int m2(String str) {
        int n = str.length();
        int l = 0, r = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '(') {
                l++;
            } else {
                r++;
            }
            if (l==r) {
                max = Math.max(max, l+r);
            } else if (l<r) {
                l = r = 0;
            }
        }

        return max;
    }


    public static void main(String[] args) {
        
        String str = "()(()))))";
        // m1 
        System.out.println(m1(str));
        System.out.println(m2(str));
    }
}
