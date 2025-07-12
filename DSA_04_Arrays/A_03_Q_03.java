package DSA_04_Arrays;

public class A_03_Q_03 {
    
    public static void main(String[] args) {

        // stocks buy and sell

        // 1 trade
        int[] arr = {5,2,6,1,4};

        int min = arr[0];
        int profit = 0;
        int maxProfit = 0;

        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            profit = arr[i] - min;
            maxProfit = Math.max(maxProfit, profit);
        }

        System.out.println("maximum profit: "+ maxProfit);

        // multiple trade
        int arr_[]  = {5,2,6,1,4,7,3,6};
        profit = 0;

        for (int i = 1; i < arr_.length; i++) {
            if (arr_[i] > arr_[i-1]) {
                profit += arr_[i] - arr_[i-1];
            }
        }

        System.out.println("profit: "+ profit);

    }
}
