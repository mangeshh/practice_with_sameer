package greedy;

public class BuySellStock {

    public static void main(String[] args) {
        int prices[] = new int[]{6, 9, 1, 5, 7};
        int min_price = 6;
        int max_profit = 0;

        for(int day = 1; day < prices.length; ++day){

            max_profit = Math.max(max_profit, prices[day] - min_price);
            min_price = Math.min(min_price, prices[day]);

        }

        System.out.println("Mx profit " + max_profit);
    }
}
