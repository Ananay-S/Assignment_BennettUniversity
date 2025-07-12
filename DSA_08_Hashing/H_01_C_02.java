package DSA_08_Hashing;

class HashMap { // array of linked list as hash(0 to m-1) ki array then .next ki linked list. O(1+len) len=8
    // in newer version the linked list have been replaced by self balancing bst. O(1+log(len))
    int m; // random prime 
    Node[] hashtable = new Node[m];
    class Node<K, V> {
        K key;
        V value;
        int hash;
        Node next;
    }
}
public class H_01_C_02 {
    
    public static void main(String[] args) {
        
    }
}

// Internal working
// hashing hash function same input will have same output (collision: same output for different input are possible)
    // (larger value to smaller value)
    // (java specifically: to integers)

    // time complexity O(1) or 'O(n) in case of strings'

    // should uniformly distribute larger keys into hash table slots
    
    // Examples
        // large int: h(key) = key%m
        // strings: = Sigma(s[i]*x^i) % m (weighted sum) (x is prime) (i is ascii)
        // objects: weighted sum of elements 