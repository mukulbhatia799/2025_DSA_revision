public class Ques9 {
    public static boolean findAns(String s, String p, int si, int pi) {
        if(si == s.length() && pi == p.length()) return true;
        else if(si == s.length()) {
            while(pi < p.length() && p.charAt(pi) == '*') pi++;

            if(pi == p.length()) return true;
            return false;
        }
        else if(pi == p.length()) return false;

        if(s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?') {
            return findAns(s, p, si+1, pi+1);
        }
        else if(p.charAt(pi) == '*') {
            while(pi < p.length()-1 && p.charAt(pi+1) == '*') pi++;
            // let * as null;
            boolean letNull = findAns(s, p, si, pi+1);

            // let * equals s[si] but don't move pi as * could be matched others too.
            boolean matchChar = findAns(s, p, si+1, pi);

            return letNull || matchChar;
        }
        else {  // when s[si] != p[si] and neither p[si] is '?' nor '*'
            return false;
        }
    }
    public static void main(String[] args) {
        String s = "abcdefg";
        // String p = "ab*???fg";
        String p = "ab*fg";
        // String p = "ab*????fg";
        // String p = "ab*****";
        // String p = "ab*****pq";

        boolean ans = findAns(s, p, 0, 0);

        if(ans == true) System.out.println("p string matches the entire s string.");
        else System.out.println("doesn't matches");
    }
}
