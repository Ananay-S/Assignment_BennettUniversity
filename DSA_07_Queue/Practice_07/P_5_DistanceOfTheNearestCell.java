package DSA_07_Queue.Practice_07;

import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class P_5_DistanceOfTheNearestCell {
    
    // m1
    static int minDis(int[][] arr, int i, int j) {
        int klen = arr.length;
        int llen = arr[0].length;
        int min = klen+llen;
        for (int k = 0; k < klen; k++) {
            for (int l = 0; l < llen; l++) {
                if (arr[k][l]==1) {
                    min = Math.min(min, (Math.abs(i-k)+Math.abs(j-l)));
                }
                if (min==1) return 1;
            }
        }
        return min;
    }
    static int[][] m1(int[][] grid) {
        int n = grid[0].length;
        int m = grid.length;
        int[][] min = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]==1) {
                    min[i][j] = 0;
                } else {
                    min[i][j] = minDis(min, i, j);
                }
            }
        }
        return min;
    }


    // m2
    static boolean isValid(int x, int y, int n, int m) {
        if ((0<=x&&x<n)&&0<=y&&y<m) return true;
        return false;
    }

    static int[][] m2(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int out[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                out[i][j] = -1;
            }
        }

        Queue<ArrayList<Integer>> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]==1) {
                    out[i][j] = 0;
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    q.add(temp);
                }
            }    
        }

        int px[] = {1,-1,0,0};
        int py[] = {0,0,1,-1};
        while (!q.isEmpty()) {
            ArrayList<Integer> temp_ = q.poll();
            int x = temp_.get(0);
            int y = temp_.get(1);
            for (int i = 0; i < 4; i++) {
                int cx = x+px[i];
                int cy = y+py[i];
                if (isValid(cx,cy,n,m)&&(out[cx][cy]==-1)) {
                    out[cx][cy] = out[x][y]+1;
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(cx);
                    temp.add(cy);
                    q.add(temp);
                }
            }
        }

        return out;
    }
    public static void main(String[] args) {
        
    }
}
