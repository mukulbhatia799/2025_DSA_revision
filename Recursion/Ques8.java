// house robber problem
public class Ques8 {
    public static int findAns(int[] nums, int ind) {
        if(ind >= nums.length) return 0;

        int pick = nums[ind] + findAns(nums, ind+2);
        int notPick = findAns(nums, ind+1);

        return Math.max(pick, notPick);
    }
    public static void main(String[] args) {
        // int nums[] = {1,2,3,1};
        int nums[] = {2,7,9,3,1};
        int ans = findAns(nums, 0);

        System.out.println("Max could be robbed: " + ans);
    }
}