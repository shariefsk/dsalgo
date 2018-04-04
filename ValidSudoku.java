import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidSudoku {
    public static void main(String[] args){
        Solution solution = new Solution();
        List<String> board = new ArrayList<String>();
                        board.add("..5.....6");
                        board.add("....14...");
                        board.add(".........");
                        board.add(".....92..");
                        board.add("5....2...");
                        board.add(".......3.");
                        board.add("...54....");
                        board.add("3.....42.");
                        board.add("...27.6..");

        System.out.println (solution.isValidSudoku(board));
    }

    public static class Solution{
        // DO NOT MODIFY THE LIST. IT IS READ ONLY
        public int isValidSudoku(final List<String> A) {
            if (A == null || A.size() != 9) return 0;

            Set<Character> duplicates = new HashSet<Character>();

            // check row
            for (int i = 0; i < 9; i++){
                duplicates = new HashSet<Character>();
                for (int j = 0; j < 9; j++){
                    char val = A.get(i).charAt(j);
                    if(val == ".".charAt(0)) {
                        continue;
                    }
                    if(duplicates.contains(val)) return 0;
                    duplicates.add(val);
                }
            }

            // check column

            for (int i = 0; i < 9; i++){
                duplicates = new HashSet<Character>();
                for (int j = 0; j < 9; j++){
                    char val = A.get(j).charAt(i);
                    if(val == ".".charAt(0)) {
                        continue;
                    }
                    if(duplicates.contains(val)) return 0;
                    duplicates.add(val);
                }
            }

            // check sub squares
            for (int i = 0; i <= A.size() - 3; i = i + 3) {
                for (int j = 0; j <= A.size() - 3; j = j + 3) {
                    if (check(i, i + 3, j, j + 3, A) == 0) {
                        return 0;
                    }
                }
            }

            return 1;
        }

        private int check(int i, int i3, int j, int j3, final List<String> A) {
            Set duplicates = new HashSet<Character>();
            for (int r = i; r < i3; r++) {
                for (int c = j; c < j3; c++) {
                    char val = A.get(r).charAt(c);
                    if (val == ".".charAt(0)){
                        continue;
                    }
                    if(duplicates.contains(val)) {
                        return 0;
                    }
                    duplicates.add(val);
                }
            }
            return 1;
        }
    }
}
