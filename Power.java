import java.util.ArrayList;

public class Power {
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println (solution.pow(2, 3, 2));
    }

    static class Solution {
        public int pow(int x, int n, int d) {

            int result = pow(x, n) % d;
            System.out.println(result);
            return result;
        }

        public int pow(int x, int n){
            if(x == 0) return 0;
            if(n == 0) return 1;
            if(n == 1) return x;

            if(n % 2 == 1){
                int y = pow(x,n/2);
                return x*y*y;
            }else{
                int y = pow(x,n/2);
                return y*y;
            }
        }
    }
}
