package DSA_04_Arrays.Practice_04;

/**
 * P_09_RepeatAndMissingNumberArray
 */
public class P_09_RepeatAndMissingNumberArray {

    // m
    static int[] m2(int arr[]) {
        
        int n = arr.length;
        int ab[] = new int[2];
        int xor = 0;

        for (int i = 1; i <= n; i++) {
            xor ^= i;
            xor ^= arr[i-1];
        }
        // System.out.println(xor);
        
        // lssb
        int lssb = xor & (-xor);

        // two numbers
        ab[0] = xor;
        ab[1] = xor;

        for (int i = 1; i <= n; i++) {
            if ((i & lssb) == 0) {
                ab[0] ^= i;
            } else {
                ab[1] ^= i;
            } 
        }
        for (int i : arr) {
            if ((i & lssb) == 0) {
                ab[0] ^= i;
            } else {
                ab[1] ^= i;
            }
        }
        
        // differentiate between the two
        for (int i : arr) {
            if (ab[1] == i) {
                int temp = ab[0];
                ab[0] = ab[1];
                ab[1] = temp;
                break; 
            }
        }

        return ab;
    }
    public static void main(String[] args) {
        
        int arr[] = {3,4,2,5,4};

        // m1 count array or map
        // time O(n)
        // space O(n)

        // m2 bit manuplation 
        // time O(3n-5n) = O(n)
        // space O(1)
        int num[] = m2(arr);
        System.out.println(" repeating no. : "+ num[0]+ " missing no. : "+ num[1]);

        // m3 (m1 without space) (requires modifying array)
        // time O(n)
        // space O(1)
            // Use elements as Index and mark the visited places
            // use negative sign as flag
            // use abs to get number
    }
}