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
    
    1. build a undirected graph from the tree (get the parent of each node)
    2. Traverse the graph from target
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