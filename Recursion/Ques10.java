// Number of dice roll with target sum.

public class Ques10 {
    public static void findAns(int n, int k, int target, int sum, int[] count) {
        final int MOD = 1000000007;
        if(n == 0) {
            if(sum == target) {
                count[0] = (count[0]+1)%MOD;
            }
            return ;
        }

        for(int i = 1; i <= k; i++) {
            if(sum+i <= target) 
                findAns(n-1, k, target, sum+i, count);
            else break;
        }
    }
    public static void main(String[] args) {
        int n = 5, k = 6, target = 15;
        // using recursion
        int[] count = new int[1];
        findAns(n, k, target, 0, count);
        
        System.out.println("count: " + count[0]);
    }
}