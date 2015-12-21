class TrieNode
{
  boolean finish = false;
  HashMap<Character, TrieNode> next = new HashMap<Character, TrieNode>();
}

public class WordDictionary
{
  private TrieNode root = new TrieNode();

  public void addWord (String word)
  {
    if (word == null)
      throw new IllegalArgumentException();
    TrieNode p = root;
    for (int i = 0; i < word.length(); ++i)
    {
      char c = word.charAt(i);
      if (p.next.get(c) == null)
        p.next.put(c, new TrieNode());
      p = p.next.get(c);
    }
    p.finish = true;
  }

  private boolean match (TrieNode cur, int idx, String word)
  {
    if (idx == word.length())
      return cur.finish;
    while (idx < word.length() && word.charAt(idx) != '.')
    {
      cur = cur.next.get(word.charAt(idx++));
      if (cur == null)
        return false;
    }
    if (idx == word.length())
      return cur.finish;
    for (TrieNode r : cur.next.values())
    {
      if (match(r, idx + 1, word))
        return true;
    }
    return false;
  }

  public boolean search (String word)
  {
    if (word == null)
      throw new IllegalArgumentException();
    return match(root, 0, word);
  }
}