import java.util.HashMap;
import java.util.List;

public class MaxPath {
    public static int maxPathSum(int r, int c, List<List<Integer>> grid, HashMap<List<Integer>, Integer> memo) {
    if(r == grid.size() || c == grid.get(0).size()){
      return 0;
    }

    if(r == grid.size()-1 && c == grid.get(0).size() -1){
      return grid.get(r).get(c);
    }
    List<Integer> pos = List.of(r, c);
    if(memo.containsKey(pos)){
      return memo.get(pos);
    }
    
    int result =  grid.get(r).get(c) + Math.max(maxPathSum(r + 1, c, grid, memo), maxPathSum(r, c + 1, grid, memo));
    memo.put(pos, result);
    return result;
  }
  public static void main(String[] args) {
    System.out.println(maxPathSum(0, 0, List.of(
        List.of(1, 3, 12),
        List.of(5, 1, 1),
        List.of(3, 6, 1)
      ), new HashMap<>()));
  }
}
