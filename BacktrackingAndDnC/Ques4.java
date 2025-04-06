// combination sum

import java.util.ArrayList;
import java.util.List;

public class Ques4 {
    public static void findAns(int[] cand, int tar, int ind, List<List<Integer>> ans, List<Integer> curr) {
        if(tar == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        if(ind >= cand.length || tar < 0) return ;

        curr.add(cand[ind]);
        findAns(cand, tar-cand[ind], ind, ans, curr);

        curr.remove(curr.size()-1);
        findAns(cand, tar, ind+1, ans, curr);
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        findAns(candidates, target, 0, ans, curr);

        return ans;
    }
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;

        List<List<Integer>> ans = combinationSum(candidates, target); 
        
        for(List<Integer> list: ans) {
            System.out.println(list);
        }
    }
}
