package DSA_04_Arrays;

public class A_03_Q_04 {
    
    public static void main(String[] args) {
        
        // rain water trapping problem

        int arr[] = {};
        int n = arr.length;

        // not optimsed approach can use constant space

        // pre-processing auxilary array
        int left[] = new int[n];
        int right[] = new int[n];

        left[0] = arr[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i-1], arr[i]);
        }

        right[0] = arr[0];
        for (int i = 1; i < n; i++) {
            right[i] = Math.max(right[i-1], arr[i]);
        }

        // final
        int water = 0;
        for (int i = 0; i < n; i++) {
            water += Math.min(left[i], right[i]) - arr[i];
        }

        System.out.println("water: "+water);
    }
}















