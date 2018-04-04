import java.util.ArrayList;

public class RootToLeafSum {
    public static void main(String[] args) {

        TreeNode A = new TreeNode(1);
        int B = 22;

        Solution solution = new Solution();
        System.out.println (solution.pathSum(A, B));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
            left=null;
            right=null;
        }
    }

    static class Solution {
        public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {

            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            ArrayList<Integer> path = new ArrayList<>();

            calculatePath(A, B, result, path);

            return result;
        }

        public void calculatePath(TreeNode A, int B, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path){

            if (A == null) return;

            int value = A.val;
            path.add(value);

            // leaf condition
            if(A.left == null && A.right == null && B == value){
                result.add(new ArrayList<Integer> (path));
            }

            // left subtree lookup
            calculatePath(A.left, B-A.val, result, path);
            // right subtree lookup
            calculatePath(A.right, B-A.val, result, path);

            path.remove(path.size() - 1);
        }
    }
}
