// beautiful arrangement

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// ====== using permutation method gives tle - t.c -> O(n!) ====== 

// public class Ques7 {
//     public static void findAllPerm(List<Integer> list, int ind, int[] count) {
//         if(ind >= list.size()) {
//             boolean check = true;
//             for(int i = 0; i < list.size(); i++) {
//                 if(list.get(i)%(i+1) != 0 && (i+1)%list.get(i) != 0) {
//                     check = false;
//                     break;
//                 }
//             }

//             if(check == true) {
//                 count[0]++;
//             }

//             return;
//         }

//         for(int i = ind; i < list.size(); i++) {
//             Collections.swap(list, i, ind);

//             findAllPerm(list, ind+1, count);

//             Collections.swap(list, i, ind);
//         }
//     }
//     public static int countArrangement(int n) {
//         List<Integer> list = new ArrayList<>();
//         for(int i = 1; i <= n; i++) {
//             list.add(i);
//         }

//         int[] count = new int[1];
//         findAllPerm(list, 0, count);
//         return count[0];
//     }
//     public static void main(String[] args) {
//         int n = 3;

//         int count = countArrangement(n);

//         System.out.println("count: " + count);
//     }
// }




//  ============ using backtracking method ============ 
// time complexity in worst case is still O(n!) but because we are doing pruning means cutting off the branches. So, it is not exack O(n!) but less than O(n!).

// Pruning means cutting off branches in a decision tree that don't need to be explored because they cannot lead to a valid solution.


public class Ques7 {
    public static void findAns(int[] vis, int n, int[] count, int currValue) {
        if(currValue == n+1) {
            count[0]++;
            return ;
        }

        for(int i = 1; i <= n; i++) {
            if(vis[i] == 0 && (currValue % i == 0 || i % currValue == 0)) {
                vis[i] = currValue;
                findAns(vis, n, count, currValue+1);
                vis[i] = 0;
            }
        }
    }
    public static int countArrangement(int n) {
        int[] vis = new int[n+1];

        int[] count = new int[1];
        int currValue = 1;
        findAns(vis, n, count, currValue);

        return count[0];
    }
    public static void main(String[] args) {
        int n = 15;

        int count = countArrangement(n);

        System.out.println("count: " + count);
    }
}