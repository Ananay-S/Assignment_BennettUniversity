package DSA_07_Queue.Practice_07;

import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class P_6_RottenOranges {
    

    // m1 ripple bfs
    static boolean isValid(int x, int y, int n, int m) {
        if ((0<=x&&x<n)&&0<=y&&y<m) return true;
        return false;
    }

    static boolean isRotten(int grid[][]) {
        boolean bool = true;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]==1) {
                    bool = false;
                }
            }
        }
        return bool;
    }

    static int m1(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        
        Queue<ArrayList<Integer>> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]==2) {
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
            ArrayList<Integer> t = q.poll();
            int x = t.get(0);
            int y = t.get(1);
            for (int i = 0; i < 4; i++) {
                int cx = x+px[i];
                int cy = y+py[i];
                if ((isValid(cx,cy,n,m)&&(grid[cx][cy]==1))) {
                    grid[cx][cy] = (grid[x][y]+1);
                    System.out.println(grid[x][y] +" "+grid[cx][cy]);
                    count = Math.max(count, grid[cx][cy]);
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(cx);
                    temp.add(cy);
                    q.add(temp);
                }
            }
        }

        if (isRotten(grid)) {
            if (count == 0) return 0;
            return count-2;
        } else {
            return -1;
        }
    }

    // m2
    // Back-end Complete function Template for JAVA

class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        int ct = 0, res = -1;
        
        //queue to store cells which have rotten oranges.
        Queue<ArrayList<Integer>> q = new LinkedList<>(); 
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        //traversing over all the cells of the matrix.
        for(int i=0; i<grid.length; i++)
        {
            for(int j=0; j<grid[0].length; j++)
            {
                //if grid value is more than 0, we increment the counter.
                if(grid[i][j]>0) 
                    ct++;
                //if grid value is 2, we push the cell indexes into queue.
                if(grid[i][j]==2)
                {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    q.add(temp);
                }
            }
        }
        
        while(!q.isEmpty())
        {
            //incrementing result counter.
            res++;
            int size = q.size();
            for(int k=0; k<size; k++)
            {
                //popping the front element of queue and storing cell indexes.
                ArrayList<Integer> cur=q.poll();
                ct--;
                
                //traversing the adjacent vertices.
                for(int i=0; i<4; i++)
                {
                    int x=cur.get(0)+dx[i], y=cur.get(1)+dy[i];
                    
                    //if cell indexes are within matrix bounds and grid value
                    //is not 1, we continue the loop else we store 2 in current
                    //cell and push the cell indexes in the queue.
                    if(x>=grid.length || x<0 || y>=grid[0].length || y<0 || grid[x][y]!=1)
                        continue;
                    grid[x][y]=2;
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(x);
                    temp.add(y);
                    q.add(temp);
                }
            }
        }
        //returning the minimum time.
        if(ct==0)
            return Math.max(0, res);
        return -1;
    }
}


    public static void main(String[] args) {
        int arr[][] = {{0,2,2},{0,2,1},{2,0,0}};
        System.out.println(m1(arr));
    }
}
