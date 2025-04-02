// remove all occurences of a substring
import java.util.Scanner;
public class Ques6 {
    public static void removePart(StringBuilder s, StringBuilder part, int i) {
        if(i > s.length()-part.length()) return;

        if(s.charAt(i) == part.charAt(0)) {
            // System.out.println("s sub: " + s.substring(i, i+part.length()));
            // System.out.println("part" + part);
            // System.out.println("sub: " + s.substring(i, i+part.length()).equals(part));
            if(s.substring(i, i+part.length()).toString().equals(part.toString())) {    // required to convert both StringBuilder into string because the default equals in StringBuilder compares the (reference equality) not the value.
                System.out.println("deleted from " + i + " to " + (i+part.length()));
                s.delete(i, i+part.length());
                i = -1;
            }
        }

        removePart(s, part, i+1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String part = sc.next();

        StringBuilder s_sb = new StringBuilder(s);
        StringBuilder part_sb = new StringBuilder(part);
        
        removePart(s_sb, part_sb, 0);

        System.out.println(s_sb);

        sc.close();
    }
}
