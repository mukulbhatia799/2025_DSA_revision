// last occ of a char RE
import java.util.Scanner;
public class Ques1 {
    public static int findAnsRE(String str, char ch, int ind) {
        if(ind == -1) return -1;

        if(str.charAt(ind) == ch) return ind;

        return findAnsRE(str, ch, ind-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        char ch = sc.next().charAt(0);   
        
        int ind = findAnsRE(str, ch, str.length()-1);

        if(ind == -1) System.out.println("Not found!!"); 
        else System.out.println("found at " + ind);

        sc.close();
    }
}