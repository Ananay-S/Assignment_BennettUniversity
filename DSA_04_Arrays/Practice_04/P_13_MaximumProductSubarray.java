package DSA_04_Arrays.Practice_04;

/**
 * P_13_MaximumProductSubarray
 */
public class P_13_MaximumProductSubarray {
    
    
    // m1
    static int m1(int arr[]) {
        int n = arr.length;
        double mp = arr[0];
        
        double p = 1;        
        for (int i = 0; i < n; i++) {
            p *= arr[i];
            mp = Math.max(mp, p);
            if(p==0) p=1;
            // System.out.println(mp);
        }

        p = 1;
        for (int i = n-1; i >= 0; i--) {
            p *= arr[i];
            mp = Math.max(mp, p);
            if(p==0) p=1;
            // System.out.println(mp);
        }

        return (int)mp;
    }
    
    
    // int n = nums.length;
    // double l=1,r=1;
    // double ans=nums[0];
    
    // for(int i=0;i<n;i++){
        
    //     //if any of l or r become 0 then update it to 1
    //     l = l==0 ? 1 : l;
    //     r = r==0 ? 1 : r;
        
    //     l *= nums[i];   //prefix product
    //     r *= nums[n-1-i];    //suffix product
        
    //     ans = Math.max(ans,Math.max(l,r));
        
    // }
    
    // return (int)ans;
    
    public static void main(String[] args) {
        
    }
}