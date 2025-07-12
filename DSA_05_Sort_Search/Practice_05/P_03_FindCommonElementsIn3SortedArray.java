package DSA_05_Sort_Search.Practice_05;

public class P_03_FindCommonElementsIn3SortedArray {
    
    // m1 
    static int[] findintersection(int a[], int b[]) {
        int al = a.length;
        int bl = b.length;

        int idx = 0;
        int ans[] = new int[Math.max(al, bl)];

        int i = 0;
        int j = 0;

        while ((i<al)&&(j<bl)) {
            if (a[i]<b[j]) {
                i++;
            } else if (b[j] < a[i]) {
                j++;
            } else {
                ans[idx] = a[i];
                i++;
                j++;
                idx++;
            }
        }

        return ans;
    }

    // m2
    static int[] m2(int a[], int b[], int c[]) {
        int al = a.length;
        int bl = b.length;
        int cl = c.length;

        int idx = 0;
        int ans[] = new int[Math.max(Math.max(al, bl), cl)];

        int i = 0;
        int j = 0;
        int k = 0;

        while ((i<al)&&(j<bl)) {
            if (a[i]==b[j] && b[j]==c[k]) {
                ans[idx] = b[j];
                idx++;
                i++;
                j++;
                k++;
            } else if (a[i]<b[j]) {
                i++;
            } else if (b[j]<c[k]) {
                j++;
            }else {
                k++;
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        
        // m1
        int[] arr1 = { 1, 5, 10, 20, 40, 80 };
        int[] arr2 = { 6, 7, 20, 80, 100 };
        int[] arr3 = { 3, 4, 15, 20, 30, 70, 80, 120 };

        int[] arr12 = findintersection(arr1, arr2);
        int[] arr123 = findintersection(arr3, arr12);

        for (int i : arr123) {
            if (i!=0) System.out.print(i+" ");
        }System.out.println();

        
        // time O(a1+a2+a3)
        // space O(1)

        // m2
        

    }
}
