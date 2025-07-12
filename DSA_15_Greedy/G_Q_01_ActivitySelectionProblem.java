package DSA_15_Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class G_Q_01_ActivitySelectionProblem {
    
    // maximum disjoint intervals
    // greedy
    // sort by ending time 
    // proof by contadiction 
        // assume two activity
        // first activity that ends before second
        // second activity that ends after first
        // so no. of activity in first can never be less than second
        // 1st case can always have the rest of activities of the 2nd case

    static ArrayList<Integer> m2(int[] start, int[] end, int n) {
        ArrayList<Integer> result = new ArrayList<>();
        
        int[][] data = new int[n][3];
        for (int i = 0; i < n; i++) {
            data[i][0] = i+1;
            data[i][1] = start[i];
            data[i][2] = end[i];
        }
        Arrays.sort(data, Comparator.comparingInt(di -> di[2]));

        result.add(data[0][0]);
        int end_ = data[0][2];
        for (int[] d : data) {
            if (d[1] > end_) {
                result.add(d[0]);
                end_ = d[2];
            }
        }

        Collections.sort(result);
        return result;
    }
}
