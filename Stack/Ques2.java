// Remove all adjacent duplicates in string

package Stack;

import java.util.Stack;

public class Ques2 {
    public String findAns(String s, int ind, Stack<Character> st) {
        if(ind >= s.length()) {
            StringBuilder sb = new StringBuilder();
            while(!st.isEmpty()) {
                sb.append(st.pop());
            }
            sb.reverse();
            return sb.toString();
        }

        if(!st.isEmpty() && st.peek() == s.charAt(ind)) {
            st.pop();
        }
        else st.push(s.charAt(ind));
        
        return findAns(s, ind+1, st);
    }
    public String removeDuplicates(String s) {
        // recursive solution
        Stack<Character> st = new Stack<>();

        return findAns(s, 0, st);
    }


    // using StringBuilder:
    // public void findAns(String s, int ind, StringBuilder sb) {
    //     if(ind >= s.length()) return ;

    //     if(!sb.isEmpty() && sb.charAt(sb.length()-1) == s.charAt(ind)) {
    //         sb.deleteCharAt(sb.length()-1);
    //     }
    //     else sb.append(s.charAt(ind));
        
    //     findAns(s, ind+1, sb);
    // }
    // public String removeDuplicates(String s) {
    //     // recursive solution
    //     StringBuilder sb = new StringBuilder();

    //     findAns(s, 0, sb);
    //     return sb.toString();
    // }
}
