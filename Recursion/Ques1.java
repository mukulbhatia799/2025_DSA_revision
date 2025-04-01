// last occ of a char
import java.util.Scanner;
public class Ques1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        char ch = sc.next().charAt(0);

        for(int i = str.length()-1; i >= 0; i--) {
            if(str.charAt(i) == ch) {
                System.out.println("Last Occ index is " + i);
                return;
            }
        }

        System.out.println("Not found!!");
    }
}