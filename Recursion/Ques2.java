// reverse a string RE

import java.util.Collections;
import java.util.Scanner;

public class Ques2 {
    public static void reverseRE(StringBuilder str, int ind) {
        if(ind == str.length()/2) return;

        char temp = str.charAt(ind);
        str.setCharAt(ind, str.charAt(str.length()-ind-1));
        str.setCharAt(str.length()-ind-1, temp);

        reverseRE(str, ind+1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();
        StringBuilder str = new StringBuilder();

        str.append(input);

        reverseRE(str, 0);
        
        for(char ch: str.toString().toCharArray()) {
            System.out.print(ch);
        }
    }
}