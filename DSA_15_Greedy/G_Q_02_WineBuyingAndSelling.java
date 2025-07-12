package DSA_15_Greedy;

public class G_Q_02_WineBuyingAndSelling {
    
    // minimised
    // = no. of wine * distance b/w buy and sell
    // given 
    // array with sum 0
    // +ve indicate buy
    // -ve indicate sell

    static int m2(int[] arr) {
        int b=0;
        int s=0;
        int n=arr.length;

        int result = 0;
        while (b<n && s<n) {
            while (!(arr[b]>0)) {
                b++;
                if (b==n) return result;
            }
            while (!(arr[s]<0)) {
                s++;
                if (s==n) return result;
            }
            if (Math.abs(arr[b])>Math.abs(arr[s])) {
                result += Math.abs(b-s) * Math.abs(arr[s]);
                arr[b] += arr[s];
                arr[s] = 0;
            } else {
                result += Math.abs(b-s) * arr[b];
                arr[s] += arr[b];
                arr[b] = 0;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int arr[] = {5,-4,1,-3,1};
        System.out.println(m2(arr));
    }
}
