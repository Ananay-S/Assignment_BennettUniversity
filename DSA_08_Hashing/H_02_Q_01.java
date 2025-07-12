package DSA_08_Hashing;

import java.util.Set;
import java.util.HashSet;

public class H_02_Q_01 {
    
    // A1
    static int countDistinct(int arr[]) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        return set.size();
    }
    // A2
    static int union(int a[], int b[]) {
        Set<Integer> set = new HashSet<>();
        for (int i : a) {
            set.add(i);
        }
        for (int i : b) {
            set.add(i);
        }
        return set.size();
    }
    // A3
    static int intersection(int a[], int b[]) {
        Set<Integer> set = new HashSet<>();
        int count=0;
        for (int i : a) {
            set.add(i);
        }
        for (int i : b) {
            if (set.contains(i)) {
                set.remove(i);
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        
        // Q1 count distinct elements
        // m1 brute force
        // time O(n^2)
        // space O(1)

        // m2 hashing 
        // time O(n)
        // space O(n)

        // Q2 size of union of two array
        // m1 brute force (sort and add)
        // time O(n^2)
        // space O(1)

        // m2 hashing 
        // time O(n)
        // space O(n)

        // Q3 size of intersection of two arrays
        // time O(n^2)
        // space O(1)

        // m2 hashing 
        // time O(n)
        // space O(n)

    }
}

