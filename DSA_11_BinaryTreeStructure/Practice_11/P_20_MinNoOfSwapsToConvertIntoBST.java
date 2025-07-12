package DSA_11_BinaryTreeStructure.Practice_11;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class P_20_MinNoOfSwapsToConvertIntoBST {
    

    static class Pair {
        int data, idx;
        Pair(int data, int idx) {
            this.data = data;
            this.idx = idx;
        }
    }

    static void inorder(int[] tree, ArrayList<Integer> trav, int n, int index) {
        if (index>=n) return;
        inorder(tree, trav, n, 2*index+1);
        trav.add(tree[index]);
        inorder(tree, trav, n, 2*index+2);
    }
    
	public static int minSwap(ArrayList<Integer> trav) {

        int n = trav.size();
        ArrayList<Pair> travPos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            travPos.add(new Pair(trav.get(i), i));
        } 
        travPos.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return p1.data-p2.data;
            }
        });

        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        int ans=0;
        for (int i = 0; i < n; i++) {
            if (visited[i] || travPos.get(i).idx==i) continue; //already visited or already in correct position

            int j=i;
            int cycles=0;
            while (!visited[j]) {
                visited[j] = true;
                j = travPos.get(j).idx;
                cycles++;
            }

            if (cycles>0) {
                ans+=(cycles-1);
            }
        }

        return ans;
    }
	
    public static void main(String[] args) {
        int[] tree = {5, 6, 7, 8, 9, 10, 11 };
        ArrayList<Integer> trav = new ArrayList<>();
        inorder(tree, trav, tree.length, 0);
        System.out.println(minSwap(trav));
    }

	
}

