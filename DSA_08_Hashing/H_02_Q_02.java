package DSA_08_Hashing;

import java.util.HashMap;
import java.util.Map;

public class H_02_Q_02 {
    
    // A1
    static void subArraySum(int arr[], int sum) {
        int currentSum = 0;
        int start=0;
        int end=-1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if (currentSum-sum == 0) {
                start=0;
                end=i;
                break;
            }
            if (map.containsKey(currentSum-sum)) {
                start = map.get(currentSum-sum)+1;
                end = i;
                break;
            }
            map.put(currentSum, i);
            if (end==-1) {
                System.out.println("not found");
            } else {
                System.out.println(start+" "+end);
            }
        }
    }

    // A2
    static void subArraySum01(int arr[], int sum) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==0)  arr[i]=-1;
        }
        subArraySum(arr, sum);
    }

    // A3
    static void countDistinctElements(int arr[], int k) {
        Map<Integer,Integer> map = new HashMap<>();
        // first window
        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        System.out.println(map.size());
        // rest windows
        for (int i = k; i < arr.length; i++) {
            // remove left side
            if (map.get(arr[i-k])==1) {
                map.remove(arr[i-k]);
            } else {
                map.put(arr[i-k],map.get(arr[i-k])-1);
            }
            // add right side
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
            // size
            System.out.println(map.size());
        }
    }
    public static void main(String[] args) {
        
        // Subarray based problems (sliding window)
        // m1 brute force n^2 to get start and end then check for conditions
        // time O(n^2)
        // space O(1)

        // m2 hash map
        // time O(n)
        // space O(n)

        // Q1 find given subarray sum

        // Q2 largest subarray with equal number of 0s and 1s only contains 0s and 1s.
        // step 1 relace zero with -1 then take sum = 0

        // Q3 count the distinct elements
        // hash map
        // time O(n^2 -> n)
        // space O(1 -> n)
        
        // https://www.youtube.com/redirect?event=video_description&redir_token=QUFFLUhqa0VreHpWUmIzbzkyaW44bXA0T0Q1SnRWeUFrUXxBQ3Jtc0tsUW5fWjRVME5NSUM3SmpPbnlhNGpNdllpMDlLV0U4OUNQUm4zOGhBOER0amlRNVNuYXN2NGVoSURBWlRHeEdBOXp5b2VMX1ZzTFRLcksxZWhyREozSEFtazEwVzZlLTJJMTdXQkdHd3FVT0tLU1dhVQ&q=https%3A%2F%2Fpractice.geeksforgeeks.org%2Fproblems%2Fcount-distinct-elements-in-every-window%2F1&v=j48e8ac7r20
        // https://www.youtube.com/redirect?event=video_description&redir_token=QUFFLUhqa0phSjRDVEJYbEhvUGI2RFZLQzlNbUExOXNZZ3xBQ3Jtc0tsVUJXaGpKS2VSZ2JjdFBfR3BISi0wSkc4ejE0MUVVUDlHUXlrbkhhakRqSEloZEQtbFRHVFFYek12X0VXYjcxRmt6VEEyUENmdTl0WWhMZ3FQT1daTC00TFNTMUZJMTl3N2VWZFJmakVmYnVfUjNjUQ&q=https%3A%2F%2Fwww.geeksforgeeks.org%2Flongest-sub-array-sum-k%2F&v=j48e8ac7r20
        // https://www.youtube.com/redirect?event=video_description&redir_token=QUFFLUhqbUc1azk5cEx4eERBTkFzc25Tc01RWHhWeVJNZ3xBQ3Jtc0ttLVFiTWpCcW9JRU5XMGFISzlEbGhWR3dadTBCRUJ3eXF3Q21pRTlBQVU2UjMtV0FrSS1qX2ljRS1Pb012N1lfdERqcjRpVU1yTW9CU1YtcEhTSENIZGQtZU5MVkxTZnBqQkJONW9QblhUanNCc2hySQ&q=https%3A%2F%2Fwww.geeksforgeeks.org%2Ffind-missing-elements-of-a-range%2F&v=j48e8ac7r20
        // https://www.youtube.com/redirect?event=video_description&redir_token=QUFFLUhqbVVUdlVrYWNUY2c2VGl2T2lscDlJOW9tTlpid3xBQ3Jtc0tuaWRnRXFld0VUeGFiS1ctUVRUNmFfZGE4NFRqZngxMmkwTGtVSUdOc2o3MXM3ekUzaGdDMWZjUzkwazVycEJQT2Jua3dHSTFTRjZwa2VwSV9acURQZjBIN041UGtmTHZMbTRjZ1dFS3R0d1BKY0NyMA&q=https%3A%2F%2Fwww.geeksforgeeks.org%2Flongest-consecutive-subsequence%2F&v=j48e8ac7r20
        // https://www.youtube.com/redirect?event=video_description&redir_token=QUFFLUhqbEJwd0tPRVU3aERUbV9tUHJ2OXU4UE51RG84UXxBQ3Jtc0trclNuTXRYbFZkTWcwejdIM29kZlNwUFR2T0tHbFZiRmdkSDdMd0t0MjJ1ZmtfSnVrQjRTdlhjT0R3aWY5Q0RQWjBKVUI2YVR1ZnVyZFZMak1tUVJKaWZPQWUxMF9tRlc1LTYxSkI4QzVjeC12VnRtTQ&q=https%3A%2F%2Fwww.geeksforgeeks.org%2Fcheck-if-an-array-can-be-divided-into-pairs-whose-sum-is-divisible-by-k%2F&v=j48e8ac7r20
        // https://www.youtube.com/redirect?event=video_description&redir_token=QUFFLUhqbXF5RDJDdndJUmRwQUJpZHYweXJmYk5jNGhWQXxBQ3Jtc0ttcEhJSGVmQTlVZEpNbE1NY2gxbWRCR2I2cGwzZW1CVkFTTlhTVENNMjdzZm9DbTJvX3ZaZHZPV1BxVHJzX2J5N1N1aTVwMGZwdGxiN0VWTi1TbkhjbDRGc083bG81dWJ6UGhrekFCMEYwNjJmX1N5SQ&q=https%3A%2F%2Fwww.geeksforgeeks.org%2Fpalindrome-substring-queries%2F&v=j48e8ac7r20
        // https://www.youtube.com/redirect?event=video_description&redir_token=QUFFLUhqa3NfUDBKTkhMMGhzUUFzZnAzdjRfYmlYUm92QXxBQ3Jtc0ttblp4WkRzU2V1cUstcVpKV3J6Z2xRajlqMnR2aWN5S0hTOVM5TXpRS2U3OHRUWXJyOFpUZDFmZTIyQ2wzRHlzMUZYTFRBR3ItOWFwMzRNemJFRGFBOENaRUo0cWRTcUs5bmI5WmpLS1IwUnRzaG5iMA&q=https%3A%2F%2Fwww.interviewbit.com%2Fcourses%2Fprogramming%2Ftopics%2Fhashing%2F&v=j48e8ac7r20
    }
}
