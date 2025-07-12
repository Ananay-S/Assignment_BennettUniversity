package DSA_07_Queue.Practice_07;

public class P_04_TheCelebrityProblem {
    
    static int m1(int m[][], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(m[j][i]==1) {
                    j=0;
                    i++;
                }
                if ((j+1)==i) j++;
                if (j==(n-1)) {
                    return i;
                }
            }
        }
        return -1;


        int celebrity(int M[][], int n)
    {
        //initializing two pointers for two corners.
        int a = 0;
        int b = n-1;
        
        //we keep moving till the a<b.
        while(a<b)
        {
            if(M[a][b] == 1)
                a++;
            else
                b--;
        }
        
        //checking if a is actually a celebrity or not.
        for(int i=0; i<n; i++)
        {
            //if any person doesn't know a or a knows any person, we return -1.
            if((i != a) && (M[a][i]==1 || M[i][a] == 0))
                return -1;
        }
        //if we reach here a is celebrity so we return a.       
        return a;
    }
    }
}
