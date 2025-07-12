package DSA_01_Bit_Manipulation;

import java.util.ArrayList;

public class BM_03_Q_01 {
    
    // A1
    static boolean isPowerTwo(int n) {
        if (n == 0) {                   // not 0
            return false;
        } else if ((n&(n-1)) == 0) {    // clear lsb (lowest set bit)
            return true;
        } else {                        // more than one set bit
            return false;
        }
    }

    // A2
    static int noOfSetBits(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n&(n-1);
        }
        return count;
    }

    // A3
    static int position(int n) {
        if (n == 0) {
            return -1;
        } else if ((n&(n-1)) == 0) {
            return (int)(Math.log10(n)/Math.log10(2)+1);
        } else {
            return -1;
        }
    }

    // A4
    static int noOfFlippedBits(int a, int b) {
        a = a^b;    // xor
        b = 0;      // count
        while (a != 0) {
            b++;
            a = a&(a-1);
        }
        return b;
    }

    // A5
    static int[] nonRepeatingElements(int[] arr) {
        int[] num = new int[2];
        int xor = 0;

        for (int i : arr) { // a^b
            xor ^= i;
        }
        
        xor = xor & -xor;   // lssb 

        for (int i : arr) { // divinding into two array 
            if ((xor & i) == 0) {
                num[0] ^= i;
            } else {
                num[1] ^= i;
            }
        }

        if (num[0] > num[1]) {
            num[0] ^= num[1];
            num[1] ^= num[0];
            num[0] ^= num[1];
        }

        System.out.println("numbers are: "+ num[0]+ ", "+ num[1]);
        return num;
    }

    // A6
    static int copySetBits(int x, int y, int l, int r) {
        // mask
        int m = 1;
            // s1
            m = (m << (l)) - 1;   

            // s2
            m = m & ~((1 << (r)) - 1);
        
        // y and mask
        y = y & m;

        // update x
        x = x | y;

        return x;
    }

    // A7
    static int countTotalBits(int og) { // original number
        
        // position of msb O(1)
        int n = og;

        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;
        n = n + 1;
        n = n >> 1;

        n = (int)(Math.log10(n)/Math.log10(2)+1);

        // bitwise count
        int count = 0;
            // mask 1 (1<<i) or 2^i
            int m1 = 0;
            // inital zeros
            int iz = og;
            // initail zeros quotient
            int izq = iz;
            // complete pattern count
            int cp = 0;
            // incomplete pattern count
            int ip = 0;
            // remainder
            int r = 0;

        for (int i = 0; i < n; i++) {   // position: 1-n and index: 0-(n-1)
            
            // mask
            // m1 = 1 << i;

            // initail zeros
            iz = og - ((1<<i)-1);
            izq = iz >> (i+1); 
            // System.out.println(" i: "+ i+ " iz: "+ iz+ " izq: "+ izq);
            // pattern 
                // complete
                cp = izq << i;
                // incomplete 
                    r = iz - (izq << (i+1));    
                    // if (r < (1<<i)) {
                    //     ip = r;
                    // } else {
                    //     ip = (1<<i);
                    // }
                    // optimazation
                ip = Math.min(r, (1<<i));

            // count 
            count += cp + ip;
            // System.out.println(" cp: "+ cp+ " ip: "+ ip+ " count: "+ count);
        }

        return count;
    }

    // A8
    static int divide(int dividend, int divisor) {
        if (divisor == 0) {
            System.out.println("division by 0.");
            return Integer.MAX_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }

        boolean sign = (dividend<0) ^ (divisor<0);

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        if (divisor == 1) {
            return ((sign == false) ? dividend : -dividend);
        }

        // long dr = divisor, dd = dividend;
        // long temp = 0, quotient = 0;
        // for (int i = 30; i >= 0; i--) {
        //     if (temp + (dr<<i) <= dd) {
        //         temp += (dr<<i);
        //         quotient |= 1L<<i;
        //     }
        // }System.out.println("bit divide: "+quotient );

        int ans = (int) (Math.exp(Math.log(dividend)-Math.log(divisor) + 0.0000000001));

        return ((sign == false) ? ans : -ans);
    }

    // A9
    static int multiply(int a, int b) { // n * (n in form of pwers of two)
        int p = 0;
        for (int i = 0; b > 0; i++) {
            if ((b&1) == 1) {
                p += a<<(i);
            }
            b = b>>1;
        }
        return p;
    }

    static int square(int n) {
        /** If n is even, it can be written as
            n = 2*x 
            n2 = (2*x)2 = 4*x2
            If n is odd, it can be written as 
            n = 2*x + 1
            n2 = (2*x + 1)2 = 4*x2 + 4*x + 1    */

        // Base case
        if (n == 0)
            return 0;
 
        // Handle negative number
        if (n < 0)
            n = -n;
 
        // Get floor(n/2) using
        // right shift
        int x = n >> 1;
 
        
        if (n % 2 != 0) // If n is odd
            return ((square(x) << 2) + (x << 2) + 1);
        else // If n is even
            return (square(x) << 2);

    }
    
    // A10
    static ArrayList<ArrayList<Integer>> powerSet(int arr[]) {

        ArrayList<ArrayList<Integer>> powerSet = new ArrayList<>();
        int n = arr.length;

        for (int i = 0; i < (1 << n); i++) {
            ArrayList<Integer> subSet = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subSet.add(arr[j]);
                }
            }
            powerSet.add(subSet);
        }
        return powerSet;
    }
    public static void main(String[] args) {
        
        int n = 0;

        // easy

        // Q1) check if power of two 
        // (https://practice.geeksforgeeks.org/problems/power-of-2/0)
        n = 2;
        System.out.println("power of two: "+ isPowerTwo(n));
        System.out.println();

        // Q2) count no. of set bits
        // (https://practice.geeksforgeeks.org/problems/set-bits0143/1)
        n = 15;
        System.out.println("no. of set bits: "+ noOfSetBits(n));
        System.out.println();

        // Q3) position of only set bit
        // (https://practice.geeksforgeeks.org/problems/find-position-of-set-bit3706/1)
        n = 8;
        System.out.println("position: "+ position(n));
        System.out.println();

        // Q4) counts no. of bits to be flipped to convert a to b
        // (https://practice.geeksforgeeks.org/problems/bit-difference/0)
        System.out.println("no. of flipped bits: "+ noOfFlippedBits(7, 6));
        System.out.println();

        // Q5) two non repeating elements in array
        // (https://practice.geeksforgeeks.org/problems/finding-the-numbers0215/1)
        int arr[] = {1,2,3,6,3,2,1,4};
        nonRepeatingElements(arr);
        System.out.println();

        // Q6) copy set bits in range
        // (https://www.geeksforgeeks.org/copy-set-bits-in-a-range/)
        System.out.println("resultant: "+ copySetBits(10, 13, 3, 2));
        System.out.println();

        // Q7) count total set bits in all numbers from 1 to n
        // (https://practice.geeksforgeeks.org/problems/count-total-set-bits/0)
        n = 17;
        System.out.println("count total bits: "+ countTotalBits(n));
        System.out.println();

        // Q8) divide two integer whithout using *, / and %
        // (https://www.geeksforgeeks.org/divide-two-integers-without-using-multiplication-division-mod-operator/) 
        System.out.println("divide: "+ divide(20, 10));
        System.out.println();

        // Q9) calculate square of a number without using *, / and pow()
        // (https://www.geeksforgeeks.org/calculate-square-of-a-number-without-using-and-pow/#:~:text=Given%20an%20integer%20n%2C%20calculate,*%2C%20%2F%20and%20pow().&text=A%20Simple%20Solution%20is%20to%20repeatedly%20add%20n%20to%20result.)
        System.out.println("multiply: "+ multiply(7, 9));
        System.out.println("square: "+ square(6));
        System.out.println();

        // Q10) power set
        // (https://practice.geeksforgeeks.org/problems/power-set4302/1)
        int arr_[] = {1,2,3};
        System.out.println("power set: "+ powerSet(arr_));
        System.out.println();


        // leet code questions
        
        // Q1 getsum
        // class Solution {
        //     public int getSum(int a, int b) {
        //         return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
        //     }
        // }

        // Q2
        // duplaicate number missing number

        // Q3 no. of set bits

        // Q4 subset or the power set

        // Q5 reverse bits
        // public class Solution {
        //     // you need treat n as an unsigned value
        //     public int reverseBits(int n) {
        //         int ans=0;
        //         for(int i=0;i<32;i++){
        //             int a=(n>>i)&1;
        //                 ans|=(a<<(31-i));
        //         }
        //         return ans;
        //     }
        // }

        // divide numbers
        // class Solution {
        //     public int divide(int dividend, int divisor) {
        //         int n = 0;
        //         long c = 0;
        //         long sign = 1;
        //         if (divisor == 1) return dividend;
        //         if ((dividend < 0 && divisor >= 0) || (dividend >= 0 && divisor < 0)) sign = -1;
        //         long dd = Math.abs((long) dividend);
        //         long dr = Math.abs((long) divisor);
        //         for (int i = 30; i >= 0; i--) {
        //             if (dd >= (dr << i)) {
        //                 c += (1 << i);
        //                 dd -= (dr << i);
        //             }
        //         }
        //         return (int) (c * sign);
        //     }
        // }
        
        
        
        
        

    }
}
