package DSA_08_Hashing;

import java.util.HashSet;

public class H_01_C_01 {

    public static void main(String[] args) {
        // Collection framework
        HashSet<Integer> set = new HashSet<>();
        set.add(10);
        set.add(20);
        System.out.println(set);
        if (set.contains(10)) {
            System.out.println("10 present.");
        } else {
            System.out.println("10 not present.");
        }
        set.remove(10);
        System.out.println(set.isEmpty());
        System.out.println(set.size());
        set.clear();

        // .add
        // .remove
        // .contains
        // .size
        // .isEmpty
        // .clear

    }
    // Advantages
    // insert search delete O(1)
}
