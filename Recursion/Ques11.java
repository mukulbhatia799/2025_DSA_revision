// perfect squares

public class Ques11 {
    public static int findAns(int n) {
        if(n == 0) return 0;

        int curr = 0, ans = Integer.MAX_VALUE;
        for(int i = 1; i <= Math.sqrt(n); i++) {
            int numsq = i*i;
            curr = 1 + findAns(n-numsq);
            ans = Math.min(ans, curr);
        }

        return ans;
    }
    public static void main(String[] args) {
        int n = 12;

        int ans = findAns(n);

        System.out.println("Least number of perfect square required to make n: " + ans);
    }
}
