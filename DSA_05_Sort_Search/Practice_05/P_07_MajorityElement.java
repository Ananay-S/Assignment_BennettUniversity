package DSA_05_Sort_Search.Practice_05;

public class P_07_MajorityElement {
    
    // m3
    static boolean isMajority(int arr[], int m) {
        int count = 0;
        for (int i : arr) {
            if (i==m) count++;
        }
        return (count >= (arr.length)/2);
    }
    static int m3(int arr[]) {
        int count = 0;
        int j = -1;

    }
    public static void main(String[] args) {
        
        // m1 brute force n^2/1
        // m2 sorting nlog(n)/1
        // m3 hashing n/n
        // m4 moore's voting algorithm
        // only right format
                // int maj_index = 0, count = 1;
                // int i;
                // for (i = 1; i < size; i++) {
                //     if (a[maj_index] == a[i])
                //         count++;
                //     else
                //         count--;
                //     if (count == 0) {
                //         maj_index = i;
                //         count = 1;
                //     }
                // }
    }
}
