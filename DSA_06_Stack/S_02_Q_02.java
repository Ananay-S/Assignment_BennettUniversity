package DSA_06_Stack;

import java.util.Stack;

public class S_02_Q_02 {
    
    // 
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
    public static void main(String[] args) {
        
        // parenthisis matching problem

    }
}
