//236. Lowest Common Ancestor of a Binary Tree
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }   
}


//215.  Kth Largest Element in an Array
class Solution {
    public int findKthLargest(int[] nums, int k) {
        /** O(nlogn)
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            k--;
            if (k == 0) return nums[i];
        }
        return -1;
        */
        
        //O(nlogk)
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b); 
        for (int i : nums) {
            pq.offer(i);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }
}

//88. Merge Sorted Array
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // k = m + n - 1
        
        int k = m + n - 1;
        m = m - 1;
        n = n - 1;
        while (m >= 0 && n >= 0) {
            if (nums1[m] >= nums2[n]) {
                nums1[k] = nums1[m];
                m--;
                k--;
            } else {
                nums1[k] = nums2[n];
                k--;
                n--;
            }
        }
        
        while (n >= 0) {
            nums1[k] = nums2[n];
            n--;
            k--;
        }
        
    }
}



//785. Is Graph Bipartite?
//https://www.youtube.com/watch?v=670Gn4e89B8&t=2s
//BFS  Time : O(n + m), n is nodes, m is edges
// Space: O(n), array and queue
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


//133. Clone Graph
//https://www.youtube.com/watch?v=dlYe6DkzxXg&t=338s
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Node newNode = new Node(node.val, new ArrayList<>());
        map.put(node, newNode);
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node nei : cur.neighbors) {
                if (!map.containsKey(nei)) {
                    map.put(nei, new Node(nei.val, new ArrayList<>()));
                    queue.add(nei);
                }
                map.get(cur).neighbors.add(map.get(nei));
            }
        }
        return newNode;
    }
}






//227. Basic Calculator II
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        
        int num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            
            if (c != ' ' && !Character.isDigit(c) || i == s.length() -1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = c;
                num = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}





//398. Random Pick Index
import java.util.Random;
class Solution {

    int[] nums;
    Random rand;
    
    public Solution(int[] nums) {
        this.nums = nums;
        rand = new Random();
    }
    
    public int pick(int target) {
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                list.add(i);
            }
        }
        int size = list.size();
        
        return list.get(rand.nextInt(size));
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */

//Reservior sampling
class Solution {
    Random rand;
    int[] num;

    public Solution(int[] nums) {
        this.num = nums;
        rand = new Random();
    }
    
    public int pick(int target) {
        int count = 0;
        int res = -1;;
        for (int i = 0; i < num.length; i++) {
            if (num[i] == target) {
                count++;
                
                if (rand.nextInt(count) == 0)
                    res = i;
            }
            
            
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */




//34. Find First and Last Position of Element in Sorted Array
class Solution {
    public int[] searchRange(int[] nums, int target) {
        //thoughts: binary search to find the target
        //when find the target, move left and right to get the first and last index
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        int l = 0, r = nums.length - 1;
        int index = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int cur = nums[m];
            
            if (cur == target) {
                index = m;
                break;
            } else if (cur < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        
        if (index == -1) {
            res[0] = -1;
            res[1] = -1;
        } else {
            
            int first = index;
            int last = index;
            while (first >= 0 && nums[first] == target) first--;
            while (last < nums.length && nums[last] == target) last++;
            res[0] = first + 1;
            res[1] = last - 1;
        }
        return res;
    }
}


//1026. Maximum Difference Between Node and Ancestor
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
    public int maxAncestorDiff(TreeNode root) {
        /*
         dfs to get max and min
         root, root.val, root.val
         
         dfs()
        */
        return helper(root, root.val, root.val);
    }
    public int helper(TreeNode root, int max, int min) {
        
        if (root == null) return max - min;
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        return Math.max(helper(root.left, max, min), helper(root.right, max, min));
    }
}

//1004  Max Consecutive Ones III
//sliding window
class Solution {
    public int longestOnes(int[] A, int K) {
        
        int start = 0;
        int end = 0;
        while (end < A.length) {
            if (A[end] == 0) {
                K--;
            }
            if (K < 0) {
                if (A[start] ==  0) {
                    K++;
                }
                start++;
            }
   
            end++;
        }
        return end - start;
    }
}



//825. Friends Of Appropriate Ages
class Solution {
    public int numFriendRequests(int[] ages) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int age : ages) {
            map.put(age, map.getOrDefault(age, 0) + 1);
        }
        
        int res = 0;
        for (int a : map.keySet()) {
            for (int b : map.keySet()) {
                if (request(a, b)) {
                    res += map.get(a) * (map.get(b) - (a == b ? 1 : 0));
                }
            }
        }
        return res;
    }
    
    private boolean request(int a, int b) {
        return !(b <= 0.5 * a + 7 || b > a || (b > 100 && a < 100));
    }
    
}

//139. Word Break
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
            
        }
        return dp[s.length()];
    }
}