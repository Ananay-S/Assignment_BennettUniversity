package DSA_04_Arrays.Practice_04;

public class P_17_ContainerWithMostWater {
    
    // m1
    static int m(int arr[]) {
        int l = 0;
        int r = arr.length - 1;
        int max = 0;

        while (l<r) {
            max = Math.max(max, ((r-l)*Math.min(arr[l], arr[r])));
            if (arr[l] < arr[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    } 
    // m2
    static int m2(int arr[]) {
        int l = 0, r = arr.length-1, max = 0;
        while (l<r) {
            int min = Math.min(arr[l], arr[r]);
            max = Math.max(max, min*(r-l));
            while ((l<r) && (arr[l] <= min)) l++;
            while ((l<r) && (arr[r] <= min)) r--;
        }
        return max;
    }

    public static void main(String[] args) {
        
    }
}
