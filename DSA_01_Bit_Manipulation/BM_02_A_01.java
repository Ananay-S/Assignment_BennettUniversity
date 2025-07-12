package DSA_01_Bit_Manipulation;

// Bit Manuplation 02 Application 01
public class BM_02_A_01 {
    public static void main(String[] args) {
        
        
        int n = 7;
        int m = 4;
        int i = 1;

        // multiply or divide by powers of 2 
        System.out.println("multiply with 4: "+(n<<2));
        System.out.println("divide by 2: "+(n>>1)); 
        System.out.println();

        // swap two numbers
        // n ^= m;
        // m ^= n;
        // n ^= m;
        System.out.println("swap n m : "+n+" "+m);
        System.out.println();

        // check if all bits are set
        System.out.println("all set bits: "+((m&(m+1)) == 0));
        System.out.println();

        // find position of only set bit
        System.out.println("position: "+((int)(Math.log10(m)/Math.log10(2)+1)));
        System.out.println();
        
        // 1's complement
        System.out.println("1's complement: "+(~n));
        // 2's complement
        System.out.println("2's complement: "+(~n+1));
        System.out.println("2's complement: "+(-n));
        System.out.println();

        // check if lsb (least significant bit) is set ?
        System.out.println("lsb: "+(n&1));
            // Use-1 (even or odd)
            System.out.println("number is: "+(((n&1)==0) ? "even" : "odd"));
        System.out.println();

        // find lssb (least significant set bit) (lowest or rightmost)
        System.out.println("find lssb: "+(n&-n));
        System.out.println("find lssb: "+(n&~(n-1))); 
        System.out.println("position lssb: "+((Math.log10(n&-n)/Math.log10(2)+1)));

        // clear lssb 
        System.out.println("clear lssb: "+(n&(n-1))); 

        // clear all bits of n from lsb to ith bit
        System.out.println("clear left: "+(n & ~((1<<i+1)-1)));
        System.out.println();

        // check if msb is set (always set)
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;
        n = n + 1;
        n = n >> 1;
        System.out.println("msb: "+n);
        System.out.println("position: "+((Math.log10(n)/Math.log10(2)+1)));

        // find mssb (always msb)
        // clear mssb

        // clear all bits of n from msb to ith bit
        System.out.println("clear left: "+(n & ((1<<i)-1)));
        System.out.println();


        // direct xor of all numbers from 1 to n
        int x;
        if (n%4 == 0) {
            x=n;
        } else if (n%4 == 0) {
            x=1;
        } else if (n%4 == 0) {
            x=n+1;
        }  else {
            x=0;
        } System.out.println("xor: "+x);
        System.out.println();

        



        

    }
}
