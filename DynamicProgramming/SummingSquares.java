import java.util.HashMap;

public class SummingSquares {
    public static int summingSquares(int n, HashMap<Integer, Integer> memo) {
    if(n == 0) return 0;

    if(memo.containsKey(n)) return memo.get(n);

    int minSquare = Integer.MAX_VALUE;
    for(int i = 1; i <= Math.sqrt(n); i++){
      int square = i * i;
      int numSquares = 1 + summingSquares(n - square, memo);
      if(numSquares < minSquare) minSquare = numSquares;
    }
    memo.put(n, minSquare);
    return minSquare;
    }
    public static void main(String[] args) {
        System.out.println(summingSquares(12, new HashMap<>()));
    }
}