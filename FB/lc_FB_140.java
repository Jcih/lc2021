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

//253. Meeting Rooms II
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        /**
        1. examples
        2. data structure, algo 
            sort according to the first element (start time), compare the start time with
            the smallest end time in the priorityqueue (),if overlapping, room + 1;
            else, poll the room and update the current time to priorityqueue.
            use PriorityQueue to record the rooms that can be released and allocated (end time)
        3. logics
        4. result
        5. analysis
        ==========================
        [0, 30], [5, 10], [15, 20]
        1        1
        
        [2, 4]. [7, 10]
        1
        =======================
        
        */
        if (intervals == null || intervals.length == 0)
            return 0;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(intervals[0][1]);//add end time
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < pq.peek()) {
                pq.offer(intervals[i][1]);
            } else {
                pq.poll();
                pq.offer(intervals[i][1]);
            }
        }
        return pq.size();
    }
}


//283. Move Zeroes
class Solution {
    public void moveZeroes(int[] nums) {
        
        /*
        use a pointer index i to keep start from 0
        another pointer j loop through the array
        if j not 0, swap num[i] and num[j]
        update i
        **/
        
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
                i++;
            }
        }
    }
}




//200. Number of Islands
//Time: O(M * N)
class Solution {
    public int numIslands(char[][] grid) {
        /*
        DFS:
        2 for loop, when find "1", res + 1, and DFS update all connected '1's to 0
        */
        
        int res = 0;
        if (grid == null || grid.length == 0) return res;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }
    
    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') return;
        
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}


//92. Reverse Linked List II
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        if (head == null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        //get prev to node 1
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        
        //head of to be reversed : node 2
        ListNode head_r = prev.next;
        
        ListNode tail = dummy;
        //get tail to node 4, end of to be reversed
        for (int i = 0; i < right; i++) {
            tail = tail.next;
        }
        
        //end will be the null for the regular reverse function
        ListNode end = tail.next;
        tail.next = null;
        
        prev.next = reverse(head_r, end);
        return dummy.next;
        
    }
    
    private ListNode reverse(ListNode head, ListNode end) {
        ListNode prev = end;
        ListNode cur = head;
        
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    
}



//19

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /*
        Solution 1. count the numbe of nodes t
                    remove the t - n th node
        Solution 2. slow and fast pointers
        **/
        
        ListNode slow = head;
        ListNode fast = head;
        
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        
        if (fast == null) return head.next;
        
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}


//463

class Solution {
    
    
    int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, - 1}, {0, 1}};
    
    public int islandPerimeter(int[][] grid) {
        /*
        DFS when ever meet a boundary (grid[i][j] == 0) edge++;
        
        **/
        
        if (grid == null || grid.length == 0) return 0;
        
        for (int i = 0; i < grid.length; i++) {
            for ( int j = 0; j< grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(i, j, grid);
                }
            }
        }
        return 0;
    }
    
    private int dfs(int i, int j, int[][] grid) {
        
        grid[i][j] = -1;
        
        int count = 0;
        for (int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0){
                count++;
            } else {
                if (grid[x][y] == 1) {
                    count += dfs(x, y, grid);
                }
            }
        }
        return count;
    }
    
}




//463 BFS

class Solution {
    
    
    int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, - 1}, {0, 1}};
    
    public int islandPerimeter(int[][] grid) {
        /*
        BFS when ever meet a boundary (grid[i][j] == 0) edge++;
        
        **/
        int res = 0;
        
        if (grid == null || grid.length == 0) return 0;
        
        for (int i = 0; i < grid.length; i++) {
            for ( int j = 0; j< grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    
                    for (int[] dir : directions) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x < 0 || x == grid.length || y < 0 || y == grid[0].length || grid[x][y] == 0)
                            res++;
                    }
   
                }
            }
        }
        return res;
    }
}




//129   Sum Root to Leaf Numbers
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
    int res = 0;
    public int sumNumbers(TreeNode root) {
        /*
        
        DFS until the node has no child, we can add the number to result;
        each level, last * 10 + cur
        
        
        */
        
        if (root == null) return 0;
        helper(root, 0);
        return res;
    }
    
    private void helper(TreeNode root, int last) {
        if (root == null) return;
        
        last = last * 10 + root.val;
        if (root.left == null && root.right == null)
            res += last;
        
        helper(root.left, last);
        helper(root.right, last);
    }
}

//766. Toeplitz Matrix
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        
        for (int i = 0; i < row - 1; i++) {
            for (int j = 0; j < col - 1; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1])
                    return false;
            }
        }
        return true;
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