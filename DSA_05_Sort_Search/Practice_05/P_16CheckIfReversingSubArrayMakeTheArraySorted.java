package DSA_05_Sort_Search.Practice_05;

public class P_16CheckIfReversingSubArrayMakeTheArraySorted {

    // m1
    static boolean m1(int[] arr) {
        int n = arr.length;
        // find decreasing subarray and the count
        int si=0,ei=0;
        int scount=0,ecount=0;
        boolean flag = false;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]<arr[i-1]) {
                if (!flag) {
                    flag = true;
                    si = i-1;
                    scount++;
                }
            } else {
                if (flag) {
                    flag = false;
                    ei = i-1;
                    ecount++;
                }
            }
        }
        // if count more than 1 tha false
        if ((Math.abs(scount-ecount))>1) return false;
        if ((scount-ecount)==0) return true;

        int i=0;
        while (i!=n) {
            // move to ei
            // traverse back
            // move to ei+1
            int current=i;
            int next;
            if (i+1==si) {
                next = ei;
            } else if (i == si) {
                next = ei+1;
            } else {
                next = i+1;
            }
            if (arr[current]>arr[next]) return false;
            if (i==si) {
                i = ei+1;
            } else {
                i++;
            }
        }

        return true;
    }
    // m1_
    static boolean m1_(int[] arr) {
        int n = arr.length;
        // find decreasing subarray and the count
        int sidx=0, eidx=0;
        int scount=0,ecount=0;
        boolean flag = false;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]<arr[i-1]) {
                if (!flag) {
                    flag = true;
                    sidx = i-1;
                    scount++;
                }
            } else {
                if (flag) {
                    flag = false;
                    eidx = i-1;
                    ecount++;
                }
            }
        }
        // if count more than 1 tha false
        if (scount==0 && ecount==0) { // already sorted
            return true;
        } else if (scount>1 || ecount>1) { // more than one subarray
            return false;
        } else { // try and check in three parts
            if (si) {
                
            }
            
        }{
            
        }
        if ((Math.abs(scount-ecount))>1) return false;
        if () return true;

        int i=0;
        while (i!=n) {
            // move to ei
            // traverse back
            // move to ei+1
            int current=i;
            int next;
            if (i+1==si) {
                next = ei;
            } else if (i == si) {
                next = ei+1;
            } else {
                next = i+1;
            }
            if (arr[current]>arr[next]) return false;
            if (i==si) {
                i = ei+1;
            } else {
                i++;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        
    }    
}