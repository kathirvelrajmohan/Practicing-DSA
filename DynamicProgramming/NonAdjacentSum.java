import java.util.HashMap;
import java.util.List;

public class NonAdjacentSum {
    public static int nonAdjacentSum(List<Integer> nums, int i, HashMap<Integer, Integer> memo) {
    if(i >= nums.size()) return 0;

    if(memo.containsKey(i)) return memo.get(i);
    
    int result =  Math.max(
      nums.get(i) + nonAdjacentSum(nums, i + 2, memo),
      nonAdjacentSum(nums, i + 1, memo));
    memo.put(i, result);
    return result;
    }
    public static void main(String[] args) {
        System.out.println(nonAdjacentSum(List.of(2, 4, 5, 12, 7), 0, new HashMap<>()));    
    }
}
