package Stack;

public class Ques1 {
    public int findAns(String s, int ind, int open) {
        if(ind >= s.length()) return open;

        int count = 0;
        if(s.charAt(ind) == '(') open++;
        else {
            if(open != 0) open--;
            else count++;
        }

        count += findAns(s, ind+1, open);

        return count;
    }
    public int minAddToMakeValid(String s) {
        // recursive solution -> without using stack

        return findAns(s, 0, 0);
    }
}
