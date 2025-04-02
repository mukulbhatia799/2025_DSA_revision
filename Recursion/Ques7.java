// 121. Best Time to Buy and Sell Stock
import java.util.Scanner;
public class Ques7 {
    public static int findAnsRE(int[] prices, int ind, int miniPrice, int maxProfit) {
        if(ind >= prices.length) return maxProfit;
        
        if(prices[ind] < miniPrice) miniPrice = prices[ind];

        maxProfit = Math.max(maxProfit, prices[ind]-miniPrice);
        return findAnsRE(prices, ind+1, miniPrice, maxProfit);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int prices[] = new int[size];

        for(int i = 0; i < size; i++) {
            prices[i] = sc.nextInt();
        }

        int miniPrice = prices[0], maxProfit = 0;

        int answer = findAnsRE(prices, 0, miniPrice, maxProfit);

        System.out.println("maxProfit: " + answer);
    }
}
