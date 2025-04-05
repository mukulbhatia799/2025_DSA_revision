// minimum cost for tickets


public class Ques12 {
    public static int findAns(int[] days, int[] costs, int ind) {
        if(ind == days.length) return 0;

        int minCost = Integer.MAX_VALUE, temp = ind;
        for(int i = 0; i < 3; i++) {
            int endDay = days[ind]+((i==0)?1:(i==1)?7:30)-1;

            while(ind < days.length && days[ind] <= endDay) ind++;

            int currCost = costs[i] + findAns(days, costs, ind);
            minCost = Math.min(minCost, currCost);
            ind = temp;
        }

        return minCost;
    }
    public static void main(String[] args) {
        int[] days = {1,4,6,7,8,20};
        int[] costs = {2,7,15};

        int ans = findAns(days, costs, 0);

        System.out.println("Min cost for tickets: " + ans);
    }
}