package DSA_04_Arrays.Practice_04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class P_25_MOsAlgorithm {
    
    // brute force
    // class Query{ 
    //     int L; 
    //     int R; 
    //     Query(int L, int R){
    //         this.L = L;
    //         this.R = R;
    //     }
    // } 
 
    // // Prints sum of all query ranges. m is number of queries
    // // n is the size of the array.
    // static void printQuerySums(int a[], int n, ArrayList<Query> q, int m)
    // {
    //     // One by one compute sum of all queries
    //     for (int i=0; i<m; i++)
    //     {
    //         // Left and right boundaries of current range
    //         int L = q.get(i).L, R = q.get(i).R;
     
    //         // Compute sum of current query range
    //         int sum = 0;
    //         for (int j=L; j<=R; j++)
    //             sum += a[j];
     
    //         // Print sum of current query range
    //         System.out.println("Sum of [" + L +
    //                        ", " + R + "] is "  + sum);
    //     }
    // }

    // MO's
    class Query{ 
        int L; 
        int R; 
        Query(int L, int R){
            this.L = L;
            this.R = R;
        }
    } 
 
    class MO{
    
        // Prints sum of all query ranges. m is number of queries 
        // n is size of array a[]. 
        static void queryResults(int a[], int n, ArrayList<Query> q, int m){
            
            // Find block size 
            int block = (int) Math.sqrt(n); 
        
            // Sort all queries so that queries of same blocks 
            // are arranged together.
            Collections.sort(q, new Comparator<Query>(){
                
                // Function used to sort all queries so that all queries  
                // of the same block are arranged together and within a block, 
                // queries are sorted in increasing order of R values. 
                public int compare(Query x, Query y){
    
                    // Different blocks, sort by block. 
                    if (x.L/block != y.L/block) 
                        return (x.L < y.L ? -1 : 1); 
    
                    // Same block, sort by R value 
                    return (x.R < y.R ? -1 : 1);
                }
            });
    
            // Initialize current L, current R and current sum 
            int currL = 0, currR = 0; 
            int currSum = 0; 
        
            // Traverse through all queries 
            for (int i=0; i<m; i++) 
            { 
                // L and R values of current range
                int L = q.get(i).L, R = q.get(i).R; 
    
                // Remove extra elements of previous range. For 
                // example if previous range is [0, 3] and current 
                // range is [2, 5], then a[0] and a[1] are subtracted 
                while (currL < L) 
                { 
                    currSum -= a[currL]; 
                    currL++; 
                } 
    
                // Add Elements of current Range 
                while (currL > L) 
                { 
                    currSum += a[currL-1]; 
                    currL--; 
                } 
                while (currR <= R) 
                { 
                    currSum += a[currR]; 
                    currR++; 
                } 
    
                // Remove elements of previous range.  For example 
                // when previous range is [0, 10] and current range 
                // is [3, 8], then a[9] and a[10] are subtracted 
                while (currR > R+1) 
                { 
                    currSum -= a[currR-1]; 
                    currR--; 
                } 
    
                // Print sum of current range 
                System.out.println("Sum of [" + L +
                            ", " + R + "] is "  + currSum); 
            } 
        }

    public static void main(String[] args) {
        // MO’s Algorithm (Query Square Root Decomposition)
        // Input:  arr[]   = {1, 1, 2, 1, 3, 4, 5, 2, 8};   (len = n)
        //         query[] = [0, 4], [1, 3] [2, 4]          (len = m)
        // Output: Sum of arr[] elements in range [0, 4] is 8
        //         Sum of arr[] elements in range [1, 3] is 4  
        //         Sum of arr[] elements in range [2, 4] is 6

        // brute force
        // time O(mn)
        // space O(1)

        // optimised preprocessed 
        // time O(1)
        // space O(n)

    }
}
