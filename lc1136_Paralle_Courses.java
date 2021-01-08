//HARD, graph

/*
Construct a graph from input, using HashMap.
Key [Integer] = prerequisite;
Value [Set of Integer] = the courses which are dependent on the this prerequisite.
Construct a int[] inDegree, to keep track of how many dependencies each course has, representing bi inDegree[i]
value int semester represents how many course can be taken at each level.
For example, input [[1,3],[2,3]], course 1 and 2 have no dependencies, they are of the same level; can be taken in the same semester.
Loop through each level, if a course in this level will open up new course, whose inDegree[i] == 0, add the new course to the queue, to be executed in next semester.
Each time queue polls an course, we consider the course being taken: N--
If by the end, all the courses are finished (N == 0), return the total semesters.

**/

class Solution {
    public int minimumSemesters(int N, int[][] relations) {
        //fin dthe longest path in a directed acyclic graph
        //BFS
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[N + 1];
        for (int[] rel : relations) {
            graph.putIfAbsent(rel[0], new HashSet<Integer>());
            graph.get(rel[0]).add(rel[1]);
            
            inDegree[rel[1]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                //first semester taken, first level
                queue.add(i);
            }
        }
        
        int semester = 0;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                N--;
                
                if (!graph.containsKey(curr)) continue;
                
                
                for (int element : graph.get(curr)) {
                    inDegree[element]--;
                    if (inDegree[element] == 0)
                        queue.add(element);
                }
            }
            semester++;
        }
        
        return N == 0 ? semester : -1;
        
        
    }
}