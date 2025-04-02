
// add string RE

import java.util.Scanner;
public class Ques3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String num1 = sc.next();
        String num2 = sc.next();

        int i = num1.length()-1, j = num2.length()-1, carry = 0;

        StringBuilder ans = new StringBuilder();
        while(i >= 0 && j >= 0) {
            int val1 = num1.charAt(i)-'0';
            int val2 = num2.charAt(j)-'0';

            int sum = val1+val2+carry;
            carry = sum / 10;
            ans.append(sum%10);

            i--; j--;
        }
        System.out.println("before: " + i + " " + j);
        while(i >= 0) {
            int sum = (num1.charAt(i)-'0') + carry;
            carry = sum/10;
            ans.append(sum%10);
            i--;
        }

        while(j >= 0) {
            int sum = (num2.charAt(j)-'0') + carry;
            carry = sum/10;
            ans.append(sum%10);
            j--;
        }

        if(carry > 0) ans.append(carry);

        ans.reverse();

        System.out.println(ans);
        
    }
}