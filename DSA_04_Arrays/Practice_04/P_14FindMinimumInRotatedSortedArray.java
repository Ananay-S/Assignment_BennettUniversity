package DSA_04_Arrays.Practice_04;

public class P_14FindMinimumInRotatedSortedArray {
    
    // m1
    static int m1(int arr[]) {
        
        int l = 0;
        int r = arr.length-1;
        int m ;
        
        while (l < r) {
            m = (l+r)/2;
            if (arr[m] < arr[r]) {
                r = m;
            } else {
                l = m+1;
            }
        }

        return arr[l];
    }        

    public static void main(String[] args) {
        
    }
}
