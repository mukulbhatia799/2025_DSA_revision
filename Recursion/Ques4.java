
// palindrome check RE

import java.util.Scanner;

public class Ques4 {
    public static boolean findAnsRE(String str, int i, int j) {
        if(i >= j) return true;
        if(str.charAt(i) != str.charAt(j)) return false;

        return findAnsRE(str, i+1, j-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        boolean check = findAnsRE(str, 0, str.length()-1);

        if(check == true) {
            System.out.println("palindrome");
        }
        else {
            System.out.println("not a palindrome");
        }

        sc.close();
    }
}