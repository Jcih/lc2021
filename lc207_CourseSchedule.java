class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        /*
        1. examples
        2. data structure
        3. logic
        4. result
        5. analysis
        ==================
        [1, 0]
        0 -> 1
        
        ==================
        build a graph using hashmap
        key: pre, value: courses
        build an indegree array for each course
        int[n]
        ===================
        logic:
           add each 0 indegree course to queue
              get each course's list, loop the list, minus the indegree
              if the indegree == 0 , add to queue
        =====================
        test:
        [1, 0],[0, 1]
        indegree : {1, 1}
        map {0 : 1,
             1: 0}
        no courses that indegree has 0, so return false;
        
        **/
        
        int[] indegree = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
            if (map.containsKey(prerequisites[i][1])) {
                map.get(prerequisites[i][1]).add(prerequisites[i][0]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(prerequisites[i][0]);
                map.put(prerequisites[i][1], list);
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            List<Integer> tmp = map.get(cur);
            for (int i = 0; tmp != null && i < tmp.size(); i++) {
                indegree[tmp.get(i)]--;
                if (indegree[tmp.get(i)] == 0) queue.add(tmp.get(i));
            }   
        }
        
        for (int k : indegree) {
            if (k != 0) return false;
        }
        return true;
        
    }
}