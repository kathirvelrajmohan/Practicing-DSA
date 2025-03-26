import java.util.HashMap;
public class SumOfPossible {
    public static boolean findSumOfPossible(int amount, int[] numbers, HashMap<Integer, Boolean> memo){
        if(amount == 0) return true;
    
        if(amount < 0) return false;
        if(memo.containsKey(amount)) return memo.get(amount);
        for(int n: numbers){
          if(findSumOfPossible(amount - n, numbers, memo)){
            memo.put(amount, true);
            return true;
          }
        }
        memo.put(amount, false);
        return false;
    }
    public static void main(String args[]){
        System.out.println(findSumOfPossible(15, new int[]{1,2,3}, new HashMap<>()));
    }    
}
