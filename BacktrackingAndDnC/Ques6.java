
// Permutations II - duplicates elements in array. Just take set to take unique ones.

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Ques6 {
    public static void findAns(int[] nums, Set<List<Integer>> ans, int start) {
        if(start >= nums.length) {
            List<Integer> temp = new ArrayList<>();
            for(int val: nums) temp.add(val);
            ans.add(temp);

            return ;
        }

        for(int i = start; i < nums.length; i++) {
            int temp = nums[start];
            nums[start] = nums[i];
            nums[i] = temp;

            findAns(nums, ans, start+1);

            temp = nums[start];
            nums[start] = nums[i];
            nums[i] = temp;
        }
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> list = new LinkedHashSet<>();

        findAns(nums, list, 0);

        List<List<Integer>> ans = new ArrayList<>();

        for(List<Integer> ls: list) {
            ans.add(ls);
        }

        return ans;
    }
    public static void main(String[] args) {
        // int[] nums = {1, 1, 2};
        int[] nums = {1, 2, 3};

        List<List<Integer>> ans = permuteUnique(nums);
        
        System.out.println(ans);

    }
}
