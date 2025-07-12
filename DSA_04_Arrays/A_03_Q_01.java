package DSA_04_Arrays;

public class A_03_Q_01 {
    
    public static void main(String[] args) {
        
        // majority element (Boyer-moore majority voting algorithm) both depend on each other
        int[] a = {4,4,4,4,3,3,3,2,2,1};
        int size = a.length;
        // S-1 find candidate
        // int candidate=-1;
        // int count=0;
        // for (int i = 0; i < arr.length; i++) { //wrong
        //     if (count==0) {
        //         candidate = arr[i];
        //         count++;
        //     } else if (arr[i]==candidate) {
        //             count++;
        //     } else {
        //         count--;
        //     }
        // }
        int maj_index = 0, count = 1;
        int i;
        for (i = 1; i < size; i++) {
            if (a[maj_index] == a[i])
                count++;
            else
                count--;
            if (count == 0) {
                maj_index = i;
                count = 1;
            }
        }

        // S-2 verify candidate
        count=0;
        int majorityElement = -1;
        for (int i = 0; i < size; i++) {
            if (arr[i]==candidate) {
                count++;
            }
        }
        if (count>(arr.length/2)) {
            majorityElement = candidate;
        }

        // final result
        System.out.println("Candidate: "+candidate);
        System.out.println("Majority Element: "+majorityElement);
    }
}
