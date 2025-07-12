package DSA_03_Recursion;

// Recursion_03_Questions_02
public class R_03_Q_02 {
    
    // A1)
    static boolean isPalindrome(String s, int l, int r) {
        if (l>=r) 
            return true;
        
        if (s.charAt(l) != s.charAt(r))
            return false;

        return isPalindrome(s, l+1, r-1);
    }

    // A2
    static void printPowerset(String s, String current, int length) {
        if (length == s.length()) {
            System.out.println(current);
            return;
        }
        printPowerset(s, current, length+1);
        printPowerset(s, current+s.charAt(length), length+1);
    }

    // A3



    public static void main(String[] args) {
        // Q1) palindrome string
        System.out.println(isPalindrome("aza", 0, 2));
        System.out.println();

        // Q2) print subsequences or the power set of a string
        printPowerset("abc", "", 0);
        System.out.println();

        // Q3) print all permutations of a given string
        
    }
}
