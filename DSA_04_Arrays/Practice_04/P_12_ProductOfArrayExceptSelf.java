package DSA_04_Arrays.Practice_04;

/**
 * P_12_ProductOfArrayExceptSelf
 */
public class P_12_ProductOfArrayExceptSelf {

    // m1
    static int[] m1(int arr[]) {
        int n = arr.length; 

        int l[] = new int[n];
        int r[] = new int[n];

        l[0] = arr[0];
        for (int i = 1; i < n; i++) {
            l[i] = l[i-1] * arr[i]; 
            System.out.println(l[i]);
        }
        r[n-1] = arr[n-1];
        for (int i = n-2; i <= 0; i--) {
            r[i] = r[i+1] * arr[i];
            System.out.println(r[i]); 
        }

        arr[0] = r[1];
        arr[n-1] = l[n-2];
        for (int i = 1; i < n-1; i++) {
            arr[i] = l[i-1] * r[i+1];
        }

        return arr;
    }

    // m2
    static int[] m2(int[] arr) {
        int n = arr.length;
        int num[] = new int[n];

        num[0] = 1;
        int temp = 1;
        for (int i = 1; i < n; i++) {
            // peffix product
            temp *= arr[i-1];
            num[i] = temp;
        }
        temp = 1;
        for (int i = n-2; i >= 0 ; i--) {
            // suffix product
            temp *= arr[i+1]; 
            num[i] *= temp;
        }
        return num;
    }

    // m3
    static int[] m3(int arr[]) {
        int n = arr.length;
        int p = 1;
        int z = 0;
        for (int i : arr) {
            // if (i == 0) {
            //     z+=1;
            // } else {
            //     p*=i;
            // }
            z += (i == 0) ? 1 : 0;
            p *= (i == 0) ? 1 : i;
        }

        if (z > 1) {
            // for (int i = 0; i < n; i++) {
            //     arr[i] = 0;
            // } return arr;
            int[] num = new int[n];
            return num;
        }
        if (z == 1) {
            for (int i = 0; i < n; i++) {
                arr[i] = (arr[i] == 0) ? p : 0;
            }
            return arr;
        }
        for (int i = 0; i < n; i++) {
            arr[i] = p / arr[i];
        }
        return arr;
        // for (int i = 0; i < arr.length; i++) {
        //     // if (((i==0)&(countZero>1))|((i!=0)&(countZero>0))) {
                
        //     // }
        //     if ((arr[i]==0)) {
        //         if ((countZero>1)) {
        //             arr[i] = 0;
        //         } else {
        //             arr[i] = product;
        //         }
        //     } else {
        //         if ((countZero>0)) {
        //             arr[i] = 0;
        //         } else {
        //             arr[i] = product / arr[i];
        //         }
        //     }
        // }
        // return arr;
    }
    public static void main(String[] args) {
        
        // m1 (auxilary arrays) (prefix suffix)
        // time O(n)
        // space O(n)

        // m2 (two traversal)
        // time O(n)
        // space O(1)



    }
}