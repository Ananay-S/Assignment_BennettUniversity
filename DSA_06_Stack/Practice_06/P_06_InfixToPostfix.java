package DSA_06_Stack.Practice_06;

import java.util.Stack;

public class P_06_InfixToPostfix {
    
    // precedence 
    static int p(char c) {
        if (c=='^') {
            return 3;   
        } else if (c=='*' || c=='/') {
            return 2;
        } else if (c=='+' || c=='-') {
            return 1;
        } else {
            return -1;
        }
    }
    // asscociativity
    static char a(char c) {
        if (c=='^') return 'R';
        return 'L';
    }

    // function
    static void infixToPostfix(char exp[]) {

        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>(); // operator stack
        
        for (char c : exp) {
            if (('a'<=c && c<='z')||('A'<=c && c<='Z')||('0'<=c && c<='9')) { // operand
                result.append(c);
            } else if (c=='(') { // opening
                stack.push(c);
            } else if (c==')') { // closing
                while ((!stack.isEmpty())&&(stack.peek()!='(')) {
                    result.append(stack.pop());
                }
                stack.pop(); // pop "(" opening
            } else { // operator
                while ((!stack.isEmpty()) && ( (p(c)<p(stack.peek())) || (p(c)==p(stack.peek())&&(a(c)=='L')) )) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        String str = "a+b*(c^d-e)^(f+g*h)-i";
        char charArr[] = str.toCharArray();
        infixToPostfix(charArr);
    }
}
