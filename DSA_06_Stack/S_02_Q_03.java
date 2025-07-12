package DSA_06_Stack;

import java.util.Stack;

public class S_02_Q_03 {
    
    // 
    static int[] psi(int arr[]) {
        Stack<Integer> s = new Stack<>();
        int arr_ps[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while ((!s.isEmpty())&&(arr[s.peek()] >= arr[i])) {
                s.pop();
            }
            if (s.isEmpty()) { 
                arr_ps[i] = -1;
            } else {
                arr_ps[i] = s.peek();    
            }
            s.push(i);
        }
        return arr_ps;
    }
    static int[] nsi(int arr[]) {
        Stack<Integer> s = new Stack<>();
        int arr_ns[] = new int[arr.length];
        for (int i = arr.length-1; i >= 0; i--) {
            while ((!s.isEmpty())&&(arr[s.peek()] >= arr[i])) {
                s.pop();
            }
            if (s.isEmpty()) {
                arr_ns[i] = arr.length;
            } else {
                arr_ns[i] = s.peek();    
            }
            s.push(i);
        }
        return arr_ns;
    }

    static int maxAreainHistogram(int arr[]) {
        int max = 0;
        int ps[] = psi(arr);
        int ns[] = nsi(arr);
        // printArray(arr);
        // printArray(ps);
        // printArray(ns);
        for (int i = 0; i < arr.length; i++) {
            int current = (ns[i]-ps[i]-1)*arr[i];
            max = Math.max(max, current);
        }
        return max;
    }
    static void printArray(int arr[]) {
        for (int i : arr) {
            System.out.print(i+" ");
        } System.out.println();
    }

    // 
    static int maxAreainMatrix(int arr[][]) {
        int currentRow[] = arr[0];
        int max = maxAreainHistogram(currentRow);
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j]==1) {
                    currentRow[j]++;
                } else {
                    currentRow[j] = 0;
                }
            }
            max = Math.max(max, maxAreainHistogram(currentRow));
        }
        return max;
    }

    public static void main(String[] args) {
    
        // largest rectangle in histogram
        int arr[] = {3,1,2,4};
        System.out.println(maxAreainHistogram(arr));

        // largest rectangle in binary matrix
        int arr_[][] = {{0,1,1,1,1,0}, {1,1,1,1,0,1}, {1,1,0,1,1,1}, {1,1,1,1,1,0}};
        System.out.println(maxAreainMatrix(arr_));
    }
}
