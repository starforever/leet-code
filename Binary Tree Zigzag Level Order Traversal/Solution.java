/**
 * Definition for binary tree
 * public class TreeNode {
 *   int val;
 *   TreeNode left;
 *   TreeNode right;
 *   TreeNode(int x) { val = x; }
 * }
 */

public class Solution
{
  public ArrayList<ArrayList<Integer>> zigzagLevelOrder (TreeNode root)
  {
    ArrayList<ArrayList<Integer>> levelList = new ArrayList<ArrayList<Integer>>();
    if (root == null)
      return levelList;
    LinkedList<TreeNode> curLevel = new LinkedList<TreeNode>();
    curLevel.add(root);
    boolean straight = true;
    while (!curLevel.isEmpty())
    {
      ArrayList<Integer> row = new ArrayList<Integer>();
      Iterator<TreeNode> it = straight ? curLevel.iterator() : curLevel.descendingIterator();
      while (it.hasNext())
        row.add(it.next().val);
      levelList.add(row);
      LinkedList<TreeNode> nextLevel = new LinkedList<TreeNode>();
      while (!curLevel.isEmpty())
      {
        TreeNode p = curLevel.remove();
        if (p.left != null)
          nextLevel.add(p.left);
        if (p.right != null)
          nextLevel.add(p.right);
      }
      curLevel = nextLevel;
      straight = !straight;
    }
    return levelList;
  }
}
