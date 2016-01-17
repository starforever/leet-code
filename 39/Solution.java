public class Solution
{
  public List<List<Integer>> combinationSum (int[] candidates, int target)
  {
    if (candidates == null)
      candidates = new int[0];
    int C = candidates.length, T = target;
    Arrays.sort(candidates);
    List<List<Integer>>[][] sumSol = new ArrayList[C + 1][T + 1];
    for (int t = 0; t <= T; ++t)
      sumSol[0][t] = new ArrayList<List<Integer>>();
    sumSol[0][0].add(new ArrayList<Integer>());
    for (int c = 1; c <= C; ++c)
    {
      for (int t = 0; t <= T; ++t)
      {
        sumSol[c][t] = new ArrayList<List<Integer>>();
        for (List<Integer> sol : sumSol[c - 1][t])
          sumSol[c][t].add(new ArrayList<Integer>(sol));
        if (t >= candidates[c - 1])
        {
          for (List<Integer> sol : sumSol[c][t - candidates[c - 1]])
          {
            ArrayList<Integer> tmp = new ArrayList<Integer>(sol);
            tmp.add(candidates[c - 1]);
            sumSol[c][t].add(tmp);
          }
        }
      }
    }
    return sumSol[C][T];
  }
}
