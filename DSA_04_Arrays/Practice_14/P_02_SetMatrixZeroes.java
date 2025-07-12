package DSA_04_Arrays.Practice_14;

/**
 * P_02_SetMatrixZeroes
 */
public class P_02_SetMatrixZeroes {

    // m
    static void setZero(int arr[][], int x, int y) {
        int n = arr[0].length;
        int m = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i==x) & (j==y)) {
                    if (arr[i][j] == 0) {
                        setZero(arr, i, j);
                    } else {
                        arr[i][j] = 0;
                    }    
                }
            }
        }
    }
    static void m0(int arr[][]) {
        int n = arr[0].length;
        int m = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    setZero(arr, i, j);
                }
            }
        }
    }

    // m
    static void m(int arr[][]) {
        int n = arr[0].length;
        int m = arr.length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    arr[i][0] = 0;
                    arr[0][j] = 0;
                }
            }
        }

        if (arr[0][0] != 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if ((arr[i][0] == 0)||(arr[0][j] == 0)) {
                        arr[i][j] = 0;
                    }
                }
            }
        } else {
            
        }
        int mz[] = new int[m];
        for (int i = 0, j = 0; j < m; j++) {
            mz[j] = arr[i][j];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][0] == 0) {
                    arr[i][0] = 0;
                    arr[0][j] = 0;
                }
            }
        }
    }

    // m1 O(4n + 2n^2)
    static void m1(int arr[][]) {
        int n = arr[0].length;
        int m = arr.length;

        boolean nf = false, mf = false;

        for (int i = 0; i < n; i++) {
            if (arr[0][i] == 0) {
                nf = true;
                break;
            }
        }
        for (int j = 0; j < m; j++) {
            if (arr[j][0] == 0) {
                mf = true;
                break;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (arr[j][i] == 0) {
                    arr[0][i] = 0;
                    arr[j][0] = 0;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if ((arr[0][i]==0)||(arr[j][0]==0)) {
                    arr[j][i] = 0;
                }
            }
        }

        if (nf) {
            for (int i = 0; i < n; i++) {
                arr[0][i] = 0;
            }
        }

        if (mf) {
            for (int j = 0; j < m; j++) {
                arr[j][0] = 0;
            }
        }
    }

    // m2
    static void m2(int arr[][]) {
        int n = arr[0].length;
        int m = arr.length;

        boolean nf[] = new boolean[n];
        boolean mf[] = new boolean[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[j][i]==0) {
                    nf[i]=true;
                    mf[j]=true;
                }    
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((nf[i])||(mf[j])) {
                    arr[j][i] = 0;
                }
            }
        }

    }
    public static void main(String[] args) {
        
    }
}