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