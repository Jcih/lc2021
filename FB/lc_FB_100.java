//1498. Number of Subsequences That Satisfy the Given Sum Condition
class Solution {
    public int numSubseq(int[] nums, int target) {
        /*
        sort the araay to easilt find the max and min by left, and right

        **/

        Arrays.sort(nums);
        int res = 0;
        
        int left = 0, right = nums.length - 1;
        int mod = (int)1e9 + 7;
        int[] pow = new int[right + 1];
        pow[0] = 1; 
        
        //from 0 to i, the number of permutaions
        for (int i = 1; i <= right; i++) {
            pow[i] = 2 * pow[i - 1] % mod;
        }
        
        
        while (left <= right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else {
                res = (res + pow[right - left]) % mod;// from left to right, number of permutations
                left++;
            }
        }
        return res;
    }
}



// 616  Add Bold Tag in String
class Solution {
    public String addBoldTag(String s, String[] dict) {
        boolean[] bold = new boolean[s.length()];
        
        for (int start = 0; start < s.length(); start++) {
            int maxEnd = start - 1;
            for (String word : dict) {
                if (word.isEmpty()) continue;
                if (s.startsWith(word, start)) {
                    maxEnd = start + word.length() - 1;
                }
            }
            
            if (maxEnd < start) continue;
            for (int i = start; i <= maxEnd; i++) {
                bold[i] = true;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int start = 0; start < s.length(); start++) {
            if (!bold[start]) {
                sb.append(s.charAt(start));
                continue;
            }
            
            sb.append("<b>");
            int end = start;
            while (end < s.length() && bold[end]) {
                end++;
            }
            sb.append(s.substring(start, end));
            sb.append("</b>");
            start = end - 1;
        }
        return sb.toString();
    }
}



//78. Subsets .  backtrack

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, nums, 0, new ArrayList<>());
        return res;
    }
    
    public void helper(List<List<Integer>> res, int[] nums, int index, List<Integer> cur) {
        res.add(new ArrayList<>(cur));
        
        for (int i = index; i < nums.length; i++) {
            cur.add(nums[i]);
            helper(res, nums, i + 1, cur);
            cur.remove(cur.size() - 1);
        }
    }
}


//863. All Nodes Distance K in Binary Tree
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /*
    
    1. BFS starts from target, need to get the parent node for each node
    2. each loop (distance + 1), traverse the parent, left, right (using hashmap to store <node, parent>
    3. collect all nodes that are K steps from target using BFS
    
    **/
    
    HashMap<TreeNode, TreeNode> map = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        buildGraph(root, null);
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        
        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);
        int distance = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (distance == K) {
                    res.add(cur.val);
                }
                
                if (cur.left != null && !visited.contains(cur.left)) {
                    visited.add(cur.left);
                    queue.offer(cur.left);
                }
                if (cur.right != null && !visited.contains(cur.right)) {
                    visited.add(cur.right);
                    queue.offer(cur.right);
                }
                TreeNode parent = map.get(cur);
                
                if (parent != null && !visited.contains(parent)) {
                    visited.add(parent);
                    queue.offer(parent);
                }
                
            }
            
            if (distance > K) {
                break;
            }
            distance++;
        }
        return res;
    }
    
    //map the parent node for each node
    private void buildGraph(TreeNode node, TreeNode parent){
        if (node == null) return;
        
        if (parent != null) {
            map.put(node, parent);
        } 
        
        buildGraph(node.left, node);
        buildGraph(node.right, node);
        
    }
}


//339. Nested List Weight Sum
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
//BFS
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        
        int res = 0;
        int depth = 1;
        Queue<NestedInteger> queue = new LinkedList<>();
        
        queue.addAll(nestedList);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NestedInteger cur = queue.poll();
                if (cur.isInteger()) {
                    res += cur.getInteger() * depth;
                } else {
                    queue.addAll(cur.getList());
                }
            }
            depth++;
        }
        return res;
    }
}


//33 Search in Rotated Sorted Array
//https://www.programcreek.com/2014/06/leetcode-search-in-rotated-sorted-array-java/

//find the pivot position first. 

class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) { // be careful about the =
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            
            if (nums[mid] >= nums[left]) {  // be careful about the = // 200717， missing "="
                //pivot is on right to mid
                
                if (nums[left] <= target && target < nums[mid]) { // be careful about the =
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
                
            } else {
                //pivot is on left to mid
                if (nums[mid] < target && nums[right] >= target) { // be careful about the =
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}


//695. Max Area of Island
//Time O(Row * Col), Space O(row * col)

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        //use dfs, when encounter 1, area = 1, dfs 4-dirs, change 1 to 0
        //dfs() return the sum of area,
        //int dfs(grid, i, j, visited)
        //res = Math.max(res, dfs());
        if (grid == null || grid.length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    res = Math.max(res, dfs(grid, i , j, visited));
                }
            }
        }
        return res;
    }
    
    public int dfs(int[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] ||
           grid[i][j] == 0) return 0;
        
        visited[i][j] = true;
        grid[i][j] = 0;

        return  1 + dfs(grid, i - 1, j, visited) +
                dfs(grid, i + 1, j, visited) +
                dfs(grid, i, j - 1, visited) +
                dfs(grid, i, j + 1, visited);
        
    }
}

//8. String to Integer (atoi) 
class Solution {
    public int myAtoi(String s) {
        
        /*
        1. trim the string
        2. get the sign
        3. if char not number, break
        4. if char is number, convert to int
        5. edge cases
        **/
        
        s = s.trim();
        if (s == null || s.length() == 0) return 0;
        
        boolean isNegtive = false;
        double res = 0;
        
        int start = 0;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') start++;
        if (s.charAt(0) == '-') isNegtive = true;
        
        for (int i = start; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur > '9' || cur < '0') break;
            
            int num = cur - '0';
            res = res * 10 + num;
        }
        
        if (isNegtive) {
            res = -res;
        }
        
        if (res > Integer.MAX_VALUE) {
            res = Integer.MAX_VALUE;
        }
        if (res < Integer.MIN_VALUE) {
            res = Integer.MIN_VALUE;
        }
        return (int)res;
        
        
    }
}


//1650. Lowest Common Ancestor of a Binary Tree III
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node a = p, b = q;
        
        while (a != b) {
            a = a == null ? q : a.parent;
            b = b == null ? p : b.parent;
        }
        return a;
    }
}


//498. Diagonal Traverse
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        
        int row = matrix.length, col = matrix[0].length;
        int[] res = new int[row * col];
        int r = 0, c = 0;
        
        for (int i = 0; i < row * col; i++) {
            res[i] = matrix[r][c];
            
            if ( (r + c) % 2 == 0) {
                //go up
                if (r - 1 >= 0 && c + 1 < col) {
                    r = r - 1;
                    c = c + 1;
                } else if (c + 1 < col) {
                    c = c + 1;
                } else {
                    r = r + 1;
                }
                
            } else {
                //go down
                if (r + 1 < row && c - 1 >= 0) {
                    r = r + 1;
                    c = c - 1;
                } else if (r + 1 < row) {
                    r = r + 1;
                } else {
                    c = c + 1;
                }                
            }
        }
        return res;
    }
}


//1213

class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> res = new ArrayList<>();
        int p1 = 0, p2 = 0, p3 = 0;
        
        while (p1 < arr1.length && p2 < arr2.length && p3 < arr3.length) {
            if (arr1[p1] == arr2[p2] && arr2[p2] == arr3[p3]) {
                res.add(arr1[p1]);
                p1++;
                p2++;
                p3++;
            } else {
                if (arr1[p1] < arr2[p2]) {
                    p1++;
                } else if (arr2[p2] < arr3[p3]) {
                    p2++;
                } else {
                    p3++;
                }
            }
        }
        return res;
    }
}

//1209


class Solution {
    
    class Node {
        char c;
        int count;
        public Node(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }
    
    public String removeDuplicates(String s, int k) {
        /*
        
        use stack store Node <char c , int count >

        **/
        
        
        Stack<Node> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && c == stack.peek().c) {
                stack.peek().count++;
            } else {
                stack.push(new Node(c, 1));
            }
            
            if (stack.peek().count == k) {
                stack.pop();
            }
  
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            int n = node.count;
            char tmp = node.c;
            for (int i = 0; i < n; i++) {
                sb.append(tmp);
            }
            
        }
        return sb.reverse().toString();
        
    }
    
}


//896. Monotonic Array
class Solution {
    public boolean isMonotonic(int[] A) {
        if (A == null || A.length <= 2) return true;
        
        boolean increase = false;
        boolean decrease = false;
        
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] > A[i])
                decrease = true;
            
            if (A[i - 1] < A[i])
                increase = true;
        }
        
        if (increase && decrease)
            return false;
        else 
            return true;
    }
}