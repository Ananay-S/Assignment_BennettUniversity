package DSA_14_DynamicProgramming.DP.DP_Q_03;

public class DP_Q_01_4Variations {

    // lcs = l
    
    // min number of operations (insertion and deletion) to convert from s1 to s2.
        // (m-l) + (n-l) = m + n -2l
    // min length of supersequence of s1 and s2.
        // l + (m-l) + (n-l) = m + n -l 
    // longest repeating subsequence.
        // lcs with itself
        // additional condition i!=j do not +1
    // longest palandromic subsequence.
        // lcs with reverse of itself
}