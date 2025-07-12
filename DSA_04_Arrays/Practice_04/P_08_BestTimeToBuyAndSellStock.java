package DSA_04_Arrays.Practice_04;

/**
 * P_08_BestTimeToBuyAndSellStock
 */
public class P_08_BestTimeToBuyAndSellStock {

    static int m (int[] arr) {
        int min = arr[0];       // min buy price uptill now
        int max = 0;            // max of profits uptill now

        for (int i : arr) {
            min = Math.min(min, i);
            max = Math.max(max, (i-min));
        }

        return max;
    }

    public static void main(String[] args) {
        
        // m
        // time O(n)
        // space O(1)
    }
}