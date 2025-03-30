import java.util.HashMap;
import java.util.List;

public class CountingChange {
    public static int countingChange(int amount, int coinIndex, List<Integer> coins, HashMap<List<Integer>, Integer> memo) {
    if(amount == 0) return 1;
    if(coinIndex >= coins.size()) return 0;

    List<Integer> key = List.of(amount, coinIndex);
    if(memo.containsKey(key)) return memo.get(key);
    
    int value = coins.get(coinIndex);
    int totalWays = 0;

    
    
    for (int quantity = 0; (quantity * value) <= amount; quantity++) {
      int subAmount = amount - (quantity * value); 
      totalWays += countingChange(subAmount, coinIndex + 1, coins, memo);
    }
    memo.put(key, totalWays);
    return totalWays;
    }
    public static void main(String[] args) {
        System.out.println(countingChange(4, 0, List.of(1,2,3), new HashMap<>()));
    }   
}
