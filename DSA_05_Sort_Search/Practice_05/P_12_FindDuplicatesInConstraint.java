package DSA_05_Sort_Search.Practice_05;


public class P_12_FindDuplicatesInConstraint {

    public static void main(String[] args) {
        
        // time O(n)
        // space O(1)

        // m1 hashmap 
        // poblems: space used and elements repeated

        // m2
        // problems: elements should be in the range of 0-arr.lrngth-1
        // trick modify array for constant space
            // s1 arr[j]+=n for j = arr[i]%n 
            // s2 traverse again then arr[i]/n>=2 
            // then i is repeated 

        // m3 modified m2
        // sonthing with checking 
        // arr[i]/n>=1 and arr[i]/n <2
    }
    
}