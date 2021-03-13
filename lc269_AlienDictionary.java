class Solution {
    public String alienOrder(String[] words) {
        int[] inDegree = new int[26];
        Map<Character, List<Character>> graph = new HashMap<>();
        
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.put(c, new ArrayList<>());
            }
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            String start = words[i];
            String end = words[i + 1];
            if (start.length() > end.length() && start.startsWith(end)) return "";
            
            int len = Math.min(start.length(), end.length());
            for (int j = 0; j < len; j++) {
                
                char out = start.charAt(j);
                char  in = end.charAt(j);
                if (out != in) {
                    graph.get(out).add(in);
                    inDegree[in - 'a']++;
                    break; 
                }
            }
        }
        
        StringBuilder sb =  new StringBuilder();
        Queue<Character> q = new LinkedList<>();
        for (char c : graph.keySet()) {
            if (inDegree[c - 'a'] == 0) {
                q.offer(c);
            }
        }
        
        while (!q.isEmpty()) {
            char out = q.poll();
            sb.append(out);
            for (char in : graph.get(out)) {
                inDegree[in - 'a']--;
                if (inDegree[in - 'a'] == 0) {
                    q.offer(in);
                }
            }
        }
        return sb.length() == graph.size() ? sb.toString() : "";
    }
}