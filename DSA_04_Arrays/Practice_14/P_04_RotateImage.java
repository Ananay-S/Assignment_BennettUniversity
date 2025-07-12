package DSA_04_Arrays.Practice_14;

public class P_04_RotateImage {
    
    static void m1(int arr[][]) {
        int n = arr.length;
        boolean isEven = ((n&1) == 0) ? true : false;
        
        if (isEven) {
            for (int i = 0; i < n/2; i++) {
                for (int j = 0; j < n/2; j++) {
                    int temp = arr[j][i];
                    arr[j][i] = arr[j+(n-1-j)][i];
                    arr[j+(n-1-j)][i] = arr[j+(n-1-j)][i+(n-1-i)];
                    arr[j+(n-1-j)][i+(n-1-i)] = arr[j][i+(n-1-i)];
                    arr[j][i+(n-1-i)] = temp;
                }
            }
        }
    }

    class Solution {
        public:
            void rotate(vector<vector<int>>& matrix) {
                int row = matrix.size();
                for(int i=0;i<row; i++){
                    for(int j=0; j<=i;j++){
                        swap(matrix[i][j], matrix[j][i]);
                    }
                }
                for(int i=0;i<row;i++){
                    reverse(matrix[i].begin(), matrix[i].end());
                }
            }
        };

        class Solution {
            public void rotate(int[][] matrix) {
                int n = matrix.length;
                
                for(int i=0;i<n;i++){
                    for(int j=i;j<n;j++){
                        int temp = matrix[i][j];
                        matrix[i][j] = matrix[j][i];
                        matrix[j][i] = temp;
                    }
                }
                
                for(int i=0;i<n;i++){
                    int low =0;
                    int high = n-1;
                    while(low <high){
                        int temp = matrix[i][low];
                        matrix[i][low] = matrix[i][high];
                        matrix[i][high] = temp;
                        low++;
                        high--;
                    }
                }
                
            }
        }
    public static void main(String[] args) {
        
    }
}
