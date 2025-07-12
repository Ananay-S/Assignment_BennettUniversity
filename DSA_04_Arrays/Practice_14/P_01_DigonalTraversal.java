package DSA_04_Arrays.Practice_14;

import java.util.ArrayList;

public class P_01_DigonalTraversal {
    
    // m
    static void m(int[][] arr, int i, int j) {
        // System.out.println(arr.length);
        // int i=0,j=0;
        int psx = 0, psy = 0;
        int px = 0, py = 0;     
        while (true) {
            // System.out.println(px+" "+py+" "+psx+" "+psy);
            System.out.print(arr[py][px]+" ");
            
            if ((psx==i-1)&&(psy==j-1)) {
                break;
            }
            
            if ((py==0)||(px==i-1)) {
                System.out.println();
                if (psy<j-1) {
                    psy++;
                    px = 0;
                    py = psy;
                } else {
                    psx++;
                    px = psx;
                    py = j-1;
                }
            } else {
                px++;
                py--;
            }
        }
    }

    // i+j = constant
    public static void diagonalOrder(int[][] arr, int n, int m) { 

        // we will use a 2D vector to  
        // store the diagonals of our array 
        // the 2D vector will have (n+m-1)  
        // rows that is equal to the number of 
        // diagonals 
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>(n+m-1); 
        for(int i = 0; i < n + m - 1; i++) { 
            ans.add(new ArrayList<Integer>()); 
        } 

        for (int i = 0; i < n; i++) { 
            for (int j = 0; j < m; j++) { 
                (ans.get(i+j)).add(arr[i][j]); 
            } 
        } 

        for (int i = 0; i < ans.size(); i++) { 
            for (int j = ans.get(i).size() - 1; j >= 0; j--) {
                System.out.print(ans.get(i).get(j)+ " "); 
            }    
            System.out.println(); 
        } 
    } 
    
    public static void main(String[] args) {
        int arr[][] = { 
            { 1, 2, 3, 4 },      
            { 5, 6, 7, 8 }, 
            { 9, 10, 11, 12 },   
            { 13, 14, 15, 16 }, 
            { 17, 18, 19, 20 }, 
        }; 
        int i = arr[0].length;
        int j = arr.length;
        m(arr, i, j);
    }
}
