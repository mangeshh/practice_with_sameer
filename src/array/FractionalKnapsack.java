package array;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * PROBLEM - https://www.geeksforgeeks.org/fractional-knapsack-problem/
 *
 * Input: arr[] = {{60, 10}, {100, 20}, {120, 30}}, W = 50
 * Output: 240
 * Explanation: By taking items of weight 10 and 20 kg and 2/3 fraction of 30 kg.
 * hence total price will be 60+100+(2/3)(120) = 240
 *
 * Input:  arr[] = {{500, 30}}, W = 10
 * Output: 166.667
 *
 */
public class FractionalKnapsack {

    static class Item {

        int value;
        int weight;

        public Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }


    }

    static double fractionalKnapsack(int W, Item arr[], int n) {
        double result = 0.0;

        Arrays.sort(arr, new Comparator<Item>() {
            public int compare(Item a, Item b) {
                Double ratioA = (a.value * 1.0 / a.weight);
                Double ratioB = (b.value * 1.0 / b.weight);
                return Double.compare(ratioB, ratioA);
            }
        });

        int count = 0;
        int currenrWeight = arr[count].weight;
        int prevWeight = 0;

        while (currenrWeight <= W && count < n) {
            prevWeight = currenrWeight;
            result += arr[count].value;
            if (++count < n) {
                currenrWeight += arr[count].weight;
            }

        }

        if (currenrWeight > W && count < n) {
            double diff = W - prevWeight;
            double fraction = diff * arr[count].value / arr[count].weight;
            result = result + fraction;
        }

        return result;

    }

    public static void main(String[] args) {
        Item[] items = new Item[]{new Item(20, 10), new Item(10, 20),
                new Item(30, 40), new Item(40, 80),  new Item(50, 75)};
        System.out.println(fractionalKnapsack(60, items, 3));
    }
}
