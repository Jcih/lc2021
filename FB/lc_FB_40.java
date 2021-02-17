//938. Range Sum of BST


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
    public int rangeSumBST(TreeNode root, int low, int high) {
        //BFS level order
        int res = 0;
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode cur = queue.poll();
                if (cur.val <= high && cur.val >= low) {
                    res += cur.val;
                }
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
        }
        return res;
        
    }
}



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
    public int rangeSumBST(TreeNode root, int low, int high) {
        //DFS level order; revursive
        int res = 0;
        if (root == null) return 0;
        
        if (root.val >= low && root.val <= high) {
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        }
        
        return rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        
    }
}




//50. Pow(x, n)
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        
        double prod = x;
        double res = 1.0;
        
        for (long i = N; i > 0; i /= 2) {
            if (i % 2 == 1) {
                res *= prod;
            }
            prod = prod * prod;
        }
        return res;

    }
}




//523. Continuous Subarray Sum
//O(N^2)
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
        /*
        presum []
        two pointer, j - i > = 1
        if (presum[j] - presum[i]) % k == 0
        
        **/
        
        int[] presum = new int[nums.length];
        if (nums == null || nums.length == 0) return false;
        
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            presum[i] = sum;
        }
        
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int summ = presum[j] - presum[i] + nums[i];// cover both i and j
                if (summ == k || (k != 0 && summ % k == 0)) { // summ == k covers the 0, 0 case
                    return true;
                }
            }
        }
        return false;   
    }
}



//O(N)
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        /**
        store the remainder of ith sum in a hashmap,
        if two indexs have same remainder and index diff > 1, return true
    
        **/
        
        HashMap<Integer, Integer> map = new HashMap<>();
        //key remainder of 0 - ith sum, 
        //value is index
        
        map.put(0, -1);//???
        
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            if (k != 0)
                sum = sum % k;
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1)
                    return true;
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }
}


//636. Exclusive Time of Functions
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        String[] s  = logs.get(0).split(":");
        stack.push(Integer.parseInt(s[0]));
        int i = 1, prev = Integer.parseInt(s[2]);
        
        while (i < logs.size()) {
            s = logs.get(i).split(":");
            if (s[1].equals("start")) {
                if (!stack.isEmpty()) {
                    res[stack.peek()] += Integer.parseInt(s[2]) - prev;
                }
                stack.push(Integer.parseInt(s[0]));
                prev = Integer.parseInt(s[2]);
            } else {
                res[stack.peek()] += Integer.parseInt(s[2]) - prev + 1;
                stack.pop();
                prev = Integer.parseInt(s[2]) + 1;
            }
            i++;
            
        }
        return res;
    }
}


//986. Interval List Intersections
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        
        int i = 0, j = 0;
        List<int[]> res = new ArrayList<>();
        
        while (i < firstList.length && j < secondList.length) {
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);
            
            if (start <= end) {
                int[] cur = new int[2];
                cur[0] = start;
                cur[1] = end;
                
                res.add(cur);
            }
            
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
            
        }
        return res.toArray(new int[res.size()][]);
    }
}



//278. First Bad Version
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        
        //binary search
        
        int lo = 1, hi = n;
        
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            
            if (isBadVersion(mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}



//56. Merge Intervals
class Solution {
    public int[][] merge(int[][] intervals) {
        
        
        /*
        sort according to the first element
        
        if no overlap with prev, add prev to res
        else 
          update prev's last element
        **/
        List<int[]> res = new ArrayList<>();
        if (intervals == null || intervals.length == 0) return null;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] prev = intervals[0];
        
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            
            if (start > prev[1]) {
                res.add(prev);
                prev = intervals[i];
            } else {
                prev[1] = Math.max(prev[1], end);
            }
            
        }
        res.add(prev);//add the last instance
        return res.toArray(new int[res.size()][2]);
    }
}




// 543. Diameter of Binary Tree
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
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        helper(root);
        return res;
    }
    
    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        
        res = Math.max(res, left + right);
        return Math.max(left, right) + 1;
    }
}



//270. Closest Binary Search Tree Value
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
    public int closestValue(TreeNode root, double target) {
        //res = min(abs(troot.val - target))
        
        int res = root.val;
        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(res - target)) {
                res = root.val;
            }
            
            root = root.val < target ? root.right : root.left;
        }
        return res;
    }
}