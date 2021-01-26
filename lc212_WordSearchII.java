class Solution {
    // DFS + Trie
    //https://www.youtube.com/watch?v=rSDG7mlk5iQ
    //Space Complexity: O(N), where NN is the total number of letters in the dictionary.
    //Time complexity:O(M(4⋅3^(L−1)), 
    //where M is the number of cells in the board and L is the maximum length of words.
    
    //TrieNode definition
    class TrieNode {
        char val;
        TrieNode[] children;
        String word;
        
        public TrieNode(char x) {
            children = new TrieNode[26];
            word = null;
        }
    }
    
    //build trie
    public void buildTrie(TrieNode root, String[] words) {
        for (String s : words) {
            TrieNode cur = root;
            for (char c : s.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode(c);
                }
                cur = cur.children[c - 'a'];
            }
            cur.word = s;
        }
    }
    
    boolean[][] visited;
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (board == null || board.length == 0) return res;
        TrieNode root = new TrieNode(' ');
        buildTrie(root, words);
        visited = new boolean[board.length][board[0].length];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if (root.children[c - 'a'] != null) {
                    dfs(board, i, j, root, res);
                }
            }
        }
        return res;
    }
    
    public void dfs(char[][] board, int i, int j, TrieNode cur, List<String> res) {
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || visited[i][j]) return;
        
        char c = board[i][j];
        if (cur.children[c - 'a'] == null) return;
        
        cur = cur.children[c - 'a'];
        if (cur.word != null) {
            res.add(cur.word);
            cur.word = null;
        }
        
        visited[i][j] = true;
        dfs(board, i + 1, j, cur, res);
        dfs(board, i - 1, j, cur, res);
        dfs(board, i, j + 1, cur, res);
        dfs(board, i, j - 1, cur, res);
        visited[i][j] = false;
        
    }
}