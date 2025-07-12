package DSA_04_Arrays.Practice_04;

public class P_21_ArrangeGivenNumbers {
    
    // m (coparator function)
    static int m(int x, int y) {
        int tempx = x;
        int tempy = y;
        
        int countx = 0;
        int county = 0;

        // count number of digits
        while (tempx>0) {
            tempx = tempx/10;
            countx++;
        } tempx = x;
        while (tempy>0) {
            tempy = tempy/10;
            county++;
        } tempy = y;
        
        // add zeros to the end alternately
        tempx *= Math.pow(10, county);
        tempy *= Math.pow(10, countx);
        
        // add temp and no. alternately
        tempx += y;
        tempy += x;

        return tempy - tempx;
    }
    public static void main(String[] args) {

        // Arrange given numbers to form the biggest number
        System.out.println(m(984, 9));
        
    }
}
