package DSA_04_Arrays.Practice_04;

public class P_11_TrappingRainWater {
    
    // m1
    static int m1(int arr[]) {
        int n = arr.length;

        // not optimsed approach can use constant space

        // pre-processing auxilary array
        int left[] = new int[n];
        int right[] = new int[n];

        left[0] = arr[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i-1], arr[i]);
        }

        right[n-1] = arr[n-1];
        for (int i = n-2; i >= 0; i--) {
            right[i] = Math.max(right[i+1], arr[i]);
        }

        // final
        int water = 0;
        for (int i = 0; i < n; i++) {
            water += Math.min(left[i], right[i]) - arr[i];
        }

        return water;
    }

    public int m2(int arr[]) {
        int water = 0;

        // left right index
        int li = 0;
        int ri = arr.length - 1;

        // max height
        int lh = arr[li];
        int rh = arr[ri];

        // loop
        while (li < ri) {
            if (arr[li] < arr[ri]) {
                water += lh - arr[li];
                li++;
                lh = Math.max(lh, arr[li]);
            } else {
                water += rh - arr[ri];
                ri++;
                rh = Math.max(rh, arr[ri]);
            }
        }

        return water;
    }

    public static void main(String[] args) {
        
        // rain water trapping problem

        // m1
        // time O(3n)
        // space O(2n)

        // m2
        // time O(n)
        // space O(1)

    }
}
