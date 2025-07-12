package DSA_06_Stack.Practice_06;

public class P_01_ImplementTwoStacksInArray {
    
    // m2
    class m2 {
        int n;
        int top1;
        int top2;
        int arr[];
        m2(int n) {
            this.n = n;
            top1 = -1;
            top2 = n;
            arr = new int[n];
        }
        // push
        void push1(int x) {
            if (top1 < top2-1) {
                top1++;
                arr[top1] = x;
            } else {
                System.out.println("overflow");
            }
        }
        void push2(int x) {
            if (top1 < top2-1) {
                top2--;
                arr[top2] = x;
            } else {
                System.out.println("overflow");
            }
        }
        // pop
        int pop1() {
            if (top1 > -1) {
                int x = arr[top1];
                top1--;
                return x;
            } else {
                System.out.println("underflow");
                return -1;
            }
        }
        int pop2() {
            if (top2 < n) {
                int x = arr[top2];
                top2--;
                return x;
            } else {
                System.out.println("underflow");
                return -1;
            }
        }
        
    }
    public static void main(String[] args) {
        
        // m1 divide array in two 
        // m2 start stack from start and end
    }
}
