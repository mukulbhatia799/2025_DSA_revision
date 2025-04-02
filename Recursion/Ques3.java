
// add string RE

import java.util.Scanner;
public class Ques3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = sc.next();
        String num2 = sc.next();

        int n = num1.length()-1, m = num2.length()-1, carry = 0;

        StringBuilder newstr = new StringBuilder();
        while(n >= 0 && m >= 0) {
            int val1 = num1.charAt(n)-'0';
            int val2 = num2.charAt(m)-'0';
            
            newstr.append(val1+val2+carry);
            carry = (val1+val2)/10;
            n--; m--;
        }

        while(n >= 0) {
            int val = num1.charAt(n)-'0';
            newstr.append(val+carry);
            carry = 0;
            n--;
        }

        while(m >= 0) {
            int val = num2.charAt(m)-'0';
            newstr.append(val+carry);
            carry = 0;
            m--;
        }

        newstr.reverse();

        for(char ch: newstr.toString().toCharArray()) {
            System.out.print(ch);
        }
    }
}