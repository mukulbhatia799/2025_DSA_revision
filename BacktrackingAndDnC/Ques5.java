// combination sum II

import java.util.*;

public class Ques5 {
    public static void findAns(int[] cand, int tar, int ind, Set<List<Integer>> ans, List<Integer> curr) {
        // base
        if(tar == 0) {
            List<Integer> temp = new ArrayList<>(curr);
            Collections.sort(temp);
            ans.add(new ArrayList<>(temp));
            return ;
        }

        if(tar < 0 || ind >= cand.length) return ;

        curr.add(cand[ind]);
        findAns(cand, tar-cand[ind], ind+1, ans, curr);

        curr.remove(curr.size()-1);
        findAns(cand, tar, ind+1, ans, curr);
    }
    
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> list = new HashSet<>();
        List<Integer> curr = new ArrayList<>();
        findAns(candidates, target, 0, list, curr);

        List<List<Integer>> ans = new ArrayList<>();

        for(List<Integer> ls: list) {
            ans.add(ls);
        }
        
        return ans;
    }
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;

        List<List<Integer>> ans = combinationSum2(candidates, target);

        System.out.println(ans);
    }
}