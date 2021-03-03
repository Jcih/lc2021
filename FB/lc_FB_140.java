//295. Find Median from Data Stream

class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    /** initialize your data structure here. */
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>((a, b) -> a - b);
    }
    
    public void addNum(int num) {
        //add to queue
        if (maxHeap.isEmpty() || num < maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }
        
        //manage size for get median: maxheap.size() == minHeap.size() || 
        //             maxHeap.size() == minHeap.size() + 1
        if (maxHeap.size() == minHeap.size() + 2) {
            minHeap.offer(maxHeap.poll());
        }
        
        if (minHeap.size() == maxHeap.size() + 1) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */


//1233. Remove Sub-Folders from the Filesystem

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        
        /*
        /a
        /a/b
        /a/b/c
        /b
        /b/c
        /b/d
        
        string start with "/a/" can be ignored.
        **/
        List<String> res = new ArrayList<>();
        if (folder == null || folder.length == 0) return res;
        Arrays.sort(folder);
        
        for (String s : folder) {
            if (res.isEmpty() || !s.startsWith(res.get(res.size() - 1) + "/")) {
                res.add(s);
            }
        }
        return res;
    }
}


// 286. Walls and Gates
class Solution {
    public void wallsAndGates(int[][] rooms) {
        /*
        BFS
        start from gate, push the gate position to queue
        BFS all neibours and update their value by add 1 each loop
        
        O(MN)
        **/
        int[][] directions =  new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int row = rooms.length, col = rooms[0].length; 
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int[] gate = queue.poll();
            int cur_r = gate[0], cur_c = gate[1];
            
            //BFS 4 directions
            for (int[] dir : directions) {
                int next_r = cur_r + dir[0];
                int next_c = cur_c + dir[1];
                if (next_r < 0 || next_r >= row || next_c < 0 || next_c >= col ||
                    rooms[next_r][next_c] != Integer.MAX_VALUE) {
                    continue;
                }
                rooms[next_r][next_c] = Math.min(rooms[cur_r][cur_c] + 1, rooms[next_r][next_c]);
                queue.offer(new int[] {next_r, next_c});
                
            }
        }
        
        
    }
}


//114. Flatten Binary Tree to Linked List
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        /*
        use a stack 
        push right first 
        push left,
        so it will pop left first
        update root.right = stack.peek()
        root.left = null
        
        
        **/
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            
            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
            
            if (!stack.isEmpty()) cur.right = stack.peek();
            cur.left = null;
        }
    }
}