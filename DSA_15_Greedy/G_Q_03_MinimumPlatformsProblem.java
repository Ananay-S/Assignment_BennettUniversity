package DSA_15_Greedy;

import java.util.Arrays;

public class G_Q_03_MinimumPlatformsProblem {
    
    // minimum number of platform requirement
    // arrival 
    // departure

    static int m2(int[] a, int[] d, int n) {
        Arrays.sort(a);
        Arrays.sort(d);
        int i=0, j=0; 
        int time=0, count=0, max=Integer.MIN_VALUE;
        while (i<n && j<n) {
            
            if (a[i]<d[j]) {
                i++;
                count++;
                max = Math.max(max, count);
            }else if (a[i]==d[j]) {
                i++;
                j++;
            } else {
                j++;
                count--;
                max = Math.max(max, count);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        
        int a[] = {900,940,950,1100,1500,1800};
        int d[] = {910,1200,1120,1130,1900,2000};
        int n = a.length;

        System.out.println(m2(a, d, n));
    }
}
