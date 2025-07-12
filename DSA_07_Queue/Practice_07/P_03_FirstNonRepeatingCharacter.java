package DSA_07_Queue.Practice_07;

import java.util.Queue;
import java.util.LinkedList;

public class P_03_FirstNonRepeatingCharacter {
    

    // 
    static void m1(String str) {
        int charCount[] = new int[26];
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            q.add(c);
            charCount[c-'a']++;
            while (!q.isEmpty()) {
                if (charCount[q.peek()-'a'] > 1) {
                    q.remove();
                } else {
                    System.out.println(q.peek()+" ");
                }
            }
            if (q.isEmpty()) {
                System.out.println(-1+" ");
            }
        }
    }

    public static void main(String[] args) {
        
    }
}
