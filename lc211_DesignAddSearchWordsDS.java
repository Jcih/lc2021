class WordDictionary {

    
    class TrieNode {
        
        TrieNode[] children;
        boolean isWord;
        
        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }
    
    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode cur = root;
        
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }
    
    public boolean search(String word) {
        return searchWord(word, 0, root);
    }
    public boolean searchWord(String word, int index, TrieNode cur) {
        if (cur == null) return false;
        if (index == word.length()) return cur.isWord;
    
        char c = word.charAt(index);
        if (c == '.') {
            for (TrieNode next : cur.children) {
                if (searchWord(word, index + 1, next))
                    return true;
            }
        } else {
            return searchWord(word, index + 1, cur.children[c - 'a'] );
        }
        
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */