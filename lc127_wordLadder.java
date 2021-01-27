class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        /*
        1. examples
        2. data structures: BFS
        3. logic
        4. result
        5. analysis
        ========================
        hit  -> cog
        
        hit  hot  dot  dog 
        hot  dot  dog  cog
        =========================
        add beginWord to queue
        each layer, store the words that have one char difference 
        loop the queue size 
        
        for each word in queue, replace a - z for each character and check the 
        new word if in wordList set
         if in, add to queue, remove from set
        
        */
        
        int level = 1;
        HashSet<String> set = new HashSet<>();
        for (String word : wordList) {
            set.add(word);
        }
        
        if (!set.contains(endWord)) return 0;
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur_word = queue.poll();
                char[] cur_arr = cur_word.toCharArray();
                for (int j = 0; j < cur_word.length(); j++) {
                    char ori_c = cur_arr[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        cur_arr[j] = c;
                        String new_word = String.valueOf(cur_arr);
                        if (new_word.equals(endWord)) return level + 1;
                        if (set.contains(new_word)) {
                            queue.offer(new_word);
                            set.remove(new_word);
                        }
                    }
                    cur_arr[j] = ori_c;
                }
            }
            level++;
        }
        return 0;
    }
}