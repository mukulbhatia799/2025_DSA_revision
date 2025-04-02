
// add string RE

import java.util.Scanner;
public class Ques3 {
    public static void findAnsRE(String num1, String num2, StringBuilder ans, int i, int j, int carry) {
        if(i < 0 && j < 0) {
            if(carry > 0) ans.append(carry);
            return;
        }

        if(i >= 0 && j >= 0) {
            int sum = ((num1.charAt(i)-'0') + (num2.charAt(j)-'0') + carry);
            carry = sum / 10;
            ans.append(sum%10);
        }
        else if(i >= 0) {
            int sum = ((num1.charAt(i)-'0') + carry);
            carry = sum / 10;
            ans.append(sum%10);
        }
        else if(j >= 0) {
            int sum = ((num2.charAt(j)-'0') + carry);
            carry = sum / 10;
            ans.append(sum%10);
        }

        findAnsRE(num1, num2, ans, i-1, j-1, carry);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String num1 = sc.next();
        String num2 = sc.next();

        int i = num1.length()-1, j = num2.length()-1, carry = 0;

        StringBuilder ans = new StringBuilder();
        
        findAnsRE(num1, num2, ans, i, j, carry);

        ans.reverse();
        System.out.println(ans);

        sc.close();
    }
}