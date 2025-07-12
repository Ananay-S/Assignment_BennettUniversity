package DSA_04_Arrays.Practice_04;

/**
 * P_02_ReverseTheArray
 */
public class P_02_ReverseTheArray {

    static void printArray(int arr[]) {
        for (int i : arr) {
            System.out.print(" "+i);
        } System.out.println();
    }

    // m1 non in place
    static int[] m1(int arr[]) {
        int rev[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            rev[i] = arr[arr.length - 1 - i];
        }
        return rev;
    }

    // m2 in place
    static int[] m2(int arr[]) {
        int start = 0;
        int end = arr.length - 1;
        int temp;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
        return arr;
    }

    public static void main(String[] args) {
        
        int arr[] = {1,3,5,7};

        // m1 non in place
        // time: O(n)
        // space: O(n)
        printArray(arr);
        System.out.println("reverse array: ");
        printArray(m1(arr));
        System.out.println();

        // m2 in place (two pointers)
        // time: O(n)
        // space: O(1)
        printArray(arr);
        System.out.println("reverse array: ");
        printArray(m2(arr));
        System.out.println();


    }
}