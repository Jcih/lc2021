class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        /*
        1. examples
        2. data structure, BFS, indgree array
        3. logic
        4. result
        5. analysis
        ===========================
        0, []
        1, [0]
        2, [0]
        3, [1, 2]
        ===========================
        
        */
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
            if (graph.containsKey(prerequisites[i][1])) {
                graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(prerequisites[i][0]);
                graph.put(prerequisites[i][1], list);
            }
        }
        
        int[] res = new int[numCourses];
        int l = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            res[l++] = cur;
            
            List<Integer> tmp = graph.get(cur);
            for (int j = 0; tmp != null && j < tmp.size(); j++) {
                inDegree[tmp.get(j)]--;
                if (inDegree[tmp.get(j)] == 0) queue.offer(tmp.get(j));
            }
        }
        if (l != numCourses) return new int[0];
        
        return res;
    }
}