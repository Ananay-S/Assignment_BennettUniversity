package DSA_06_Stack.Practice_06;

import java.util.Stack;

public class P_02_EvaluationofPostfixExpression {

    // m1
    static int m1(String exp) { // expression
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (Character.isDigit(c)) {
                s.push(c-'0');
            } else {
                int val2 = s.pop();
                int val1 = s.pop();
                int res ;
                switch (c) {
                    case '+':
                        res = (val1 + val2);
                        break;
                    case '-':
                        res = (val1 - val2);
                        break;
                    case '*':
                        res = (val1 * val2);
                        break;
                    case '/':
                        res = (val1 / val2);
                        break;
                    default:
                        System.out.println("invalid inp");
                        res = 0;
                        break;
                }
                s.push(res);
            }
        }
        return s.pop();
    }
    public static void main(String[] args) {
        
    }    
}