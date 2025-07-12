package DSA_04_Arrays.Practice_14;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P_03_SpiralMatrix {
    
    // m1
    static void m1(int arr[][]) {
        int n = arr[0].length;
        int m = arr.length;

        int t=0, b=m-1, l=0, r=n-1;
        System.out.println(t+" "+b+" "+l+" "+r);
        List<Integer> ll = new ArrayList<Integer>();
        ll.add(arr[py][px]);
        System.out.println("1");
        int px=0, py=0;
        while((t<b)&&(l<r)) {
            System.out.println(arr[py][px]);
            System.out.println(px+" "+py);
            if ((l==r)&&(t==b)) {
                break;
            }
            if (px==l && py==t+1) {
                t++;
                b--;
                l++;
                r--;
                px++;
            } else if ((py==t)&&(px<r)) {
                px++;
            } else if ((px==r)&&(py<b)) {
                py++;
            } else if ((py==b)&&(px>l)) {
                px--;
            } else if ((px==l)&&(py<t+1)) {
                py--;
            } 

            
        }
    }

    // class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        LinkedList<Integer> obj=new LinkedList<>();
        int a=matrix.length;
        int b=matrix[0].length;
        int max=Math.max(a,b);
        int s=(max+1)/2;
        int i,j,k;
        max=a*b;
        for(i=0;i<s;i++)
        {
            if(max==0)
            break;
            for(j=i;j<=b-i-1;j++)
            {
                obj.add(matrix[i][j]);
                max--;
            }
            if(max==0)
            break;
            for(k=i+1;k<=a-1-i;k++)
            {
                obj.add(matrix[k][b-i-1]);
                max--;
            }
            if(max==0)
            break;
            for(j=b-i-2;j>=i;j--)
            {
                obj.add(matrix[a-i-1][j]);
                max--;
            }
            if(max==0)
            break;
            for(k=a-i-2;k>i;k--)
            {
                obj.add(matrix[k][i]);
                max--;
            }
            if(max==0)
            break;
        }
        return obj;
    }
}
// 
    public static void main(String[] args) {
        
    }
}
