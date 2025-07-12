package DSA_01_Bit_Manipulation;

// Bit Manuplation 01 Concept 01
public class BM_01_C_01 {
    // Bit Masking
    
    // Find
    public static int find(int n, int p) {
        return n & (1<<p);                          // (1<<p) mask
    }
    // Set
    public static int set(int n, int p) {
        return n | (1<<p);                          // (1<<p) mask 
    }
    // Clear
    public static int clear(int n, int p) {
        return n & ~(1<<p);                         // ~(1<<p) mask
    }
    // Toggle
    public static int toggle(int n, int p) {
        return n ^ (1<<p);                          // (1<<p) mask
    }

    public static void main(String[] args) {
        // Bit Masking
        int n_ = 7;                                 // number
        int p_ = 2;                                 // position
                
        System.out.println("Find: " + find(n_, p_));

        System.out.println("Set: " + set(n_, p_));

        System.out.println("Clear: " + clear(n_, p_));

        System.out.println("Toggle: " + toggle(n_, p_));
    }
}