class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        //label 1: red
        //lable 2: green
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] != 0) {
                continue;
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            visited[i] = 1;//mark as red
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                int curLable = visited[cur];
                int neighbourLable = curLable == 1 ? 2 : 1;
                for (int nei : graph[cur]) {
                    if (visited[nei] == 0) {
                        visited[nei] = neighbourLable;
                        queue.add(nei);
                    } else if (visited[nei] != neighbourLable) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}