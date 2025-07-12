package DSA_10_BackTracking.Practice_10;

import java.util.ArrayList;
import java.util.List;

public class P_03_CrosswordPuzzel {
    
    // m1
    static List<String> m1(List<String> crossword, String words) {
        String[] ListOfwords = words.split(";");

        ArrayList<Integer> row = new ArrayList<>();
        ArrayList<Integer> col = new ArrayList<>();
        for (int i = 0; i < 10; i++) { // crossword.size()
            for (int j = 0; j < 10; j++) { // crossword.get(i).length()
                char c = crossword.get(i).charAt(j);
                if (c=='-') {
                    row.add(i, row.get(i)+1);
                    col.add(j, col.get(j)+1);
                }
            }
        }

        int nohw = 0; // no of horizontal words
        int novw = 0; // no of vertical words
        int[] rowWord = new int[10];
        int[] colWord = new int[10];
        int[][] inter = new int[10][2];
        for (int i = 0; i < 10; i++) {
            if (row.get(i)>1) {
                nohw++;
                rowWord[i] = 1;
            }
            if (col.get(i)>1) {
                novw++;
                colWord[i] = 1;
            }


        }

        for (int i = 0; i < 10; i++) {
            f
        }

    }
    public static void main(String[] args) {
        
        // A  Crossword grid is provided to you, along with a set of words (or names of places) which need to be filled into the grid. Cells are marked either + or -. 
        //  Cells marked with a - are to be filled with the word list.


    }
}
