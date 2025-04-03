public class Ques9 {
    public static boolean findAns(String s, String p, int si, int pi) {
        if(si == s.length() && pi == p.length()) return true;
        else if(si >= s.length() || pi >= p.length()) return false;

        if(s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?') {
            return findAns(s, p, si+1, pi+1);
        }
        else if(p.charAt(pi) == '*') {  // else is for '*'
            boolean asNull = findAns(s, p, si, pi+1);        // let * as null;

            boolean pickChar = findAns(s, p, si+1, pi);        // let * equals s[si] but still it can take others.

            return asNull || pickChar;
        }
        else return false;  // when p[pi] != s[si] and p[pi] is an alphabet.
    }
    public static void main(String[] args) {
        String s = "abcdefg";
        // String p = "ab*???fg";
        String p = "ab*fg";
        // String p = "ab*????fg";

        boolean ans = findAns(s, p, 0, 0);

        if(ans == true) System.out.println("p string matches the entire s string.");
        else System.out.println("doesn't matches");
    }
}
