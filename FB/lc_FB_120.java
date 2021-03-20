//266. Palindrome Permutation
class Solution {
    public boolean canPermutePalindrome(String s) {
        /*
        map to store the frequency
        if there are greater than 1 odd frequency characters, return false;
        else return true;
        
        
        **/
        
        if (s == null || s.length() == 0) return true;
        Map<Character, Integer> map = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int count_odd = 0;
        
        for (char c : map.keySet()) {
            if (map.get(c) % 2 == 1) count_odd++;
            if (count_odd > 1) return false;
        }
        return true;
    }
}



//39
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        
        /*
        
        sort candidates
        backtrack
        res, 0, cur, target
        
        **/
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        helper(res, 0, new ArrayList<>(), target, candidates);
        return res;
    }
    
    private void helper(List<List<Integer>> res, int index, List<Integer> cur, int target, int[] candidates) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        
        
        for (int i = index; i < candidates.length; i++) {
            cur.add(candidates[i]);
            helper(res, i, cur, target - candidates[i], candidates);
            cur.remove(cur.size() - 1);
        }
        
    }
}



//1216. Valid Palindrome III
//Similar with 516 using dp
class Solution {
    public boolean isValidPalindrome(String s, int k) {
        
        
        /*
        longest common sequence of s and reversed s is the longest palindrome subsequence
        
        find if the length of (len of s - lcs) <= k 
        
        how to find lcs of String s?
        1. reverse s
        2. dp[i][j]
        **/
        String s_r = new StringBuilder(s).reverse().toString();
        
        int len_lcs = lcs(s, s_r);
        
        return (s.length() - len_lcs) <= k;
    }
    
    private int lcs(String s1, String s2) {
        
        int n = s1.length();
        int[][] dp = new int[n + 1][n + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
                else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][n];
    }
}



//977 Squares of a Sorted Array
class Solution {
    public int[] sortedSquares(int[] nums) {
        
        /*
        
        two pointers 
        i = 0, j = nums.length - 1
        nums[i] decrease
        nums[j] decrease
        
        merge
        
        **/
        
        int[] res = new int[nums.length];
        int n = nums.length;
        
        int left = 0, right = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            int picked;
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                picked = nums[left];
                left++;
            } else {
                picked = nums[right];
                right--;
            }
            res[i] = picked * picked;
        }
        return res;
    }
}


//921. Minimum Add to Make Parentheses Valid
class Solution {
    public int minAddToMakeValid(String S) {
        int open = 0; 
        int close = 0;
        
        for (char c : S.toCharArray()) {
            if (c == '(') {
                close++;
            } else {
                if (close > 0) {
                    close--;
                } else {
                    open++;
                }
            }
        }
        return open + close;
    }
}


//23. Merge k Sorted Lists
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
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
    
        for (ListNode list : lists) {
            if (list == null) continue;
            pq.offer(list);
        }
        
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        
        while (!pq.isEmpty()) {
            
            ListNode tmp = pq.poll();
            cur.next = tmp;
            cur = cur.next;
            
            if (cur.next != null) {
                pq.offer(cur.next);
            }
            
        }

        return dummy.next;
        
        
    }
}




//341 Flatten Nested List Iterator
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    /*
    use recursive to add integer to queue
    
    */
    List<NestedInteger> nested;
    Queue<Integer> queue = new LinkedList<>();
    public NestedIterator(List<NestedInteger> nestedList) {
        nested = nestedList;
        flat(nested);
    }
    
    private void flat(List<NestedInteger> nestedList) {
        
        for (NestedInteger cur : nestedList) {
            if (cur.isInteger()) {
                queue.offer(cur.getInteger());
            } else {
                List<NestedInteger> tmp = cur.getList();
                flat(tmp);
            }
        }
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return queue.poll();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */


//348 Design Tic-Tac-Toe
class TicTacToe {
    
    int[] row_arr;
    int[] col_arr;
    int diagonal;
    int antiDiagonal;
    int n;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        row_arr = new int[n];
        col_arr = new int[n];
        diagonal = 0;
        antiDiagonal = 0;
        this.n = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if (row < 0 || row >= n || col < 0 || col >= n) return 0;
        
        int flag = player == 1 ? 1 : -1;
        
        row_arr[row] += flag;
        col_arr[col] += flag;
        
        if (row == col) {
            diagonal += flag;
        }
        if (row + col == n - 1) {
            antiDiagonal += flag;
        }
        
        if (Math.abs(row_arr[row]) == n || 
            Math.abs(col_arr[col]) == n ||
            Math.abs(diagonal) == n ||
            Math.abs(antiDiagonal) == n) {
            return player;
        } 
        return 0;
   
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */

//824 Goat Latin
class Solution {
    public String toGoatLatin(String S) {
        /*
        split S
        loop through each word
        have a set to hold aeiouAEIOU
        **/
        
        if (S == null || S.length() == 0) return S;
        String[] s_arr = S.split("\\s+");
        Set<Character> vowel = new HashSet<>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');
        vowel.add('A');
        vowel.add('E');
        vowel.add('I');
        vowel.add('O');
        vowel.add('U');
        String res = "";
        
        for (int i = 0; i < s_arr.length; i++) {
            String word = s_arr[i];
            String tmp = "";
            if (!vowel.contains(word.charAt(0)) && word.length() > 1) {
                
                tmp = word.substring(1) + word.charAt(0) + "ma";    
            } else {
                tmp = word + "ma";
            }
            
            for (int j = 0; j < i + 1; j++) {
                tmp = tmp + "a";
            }
            tmp = tmp + " ";
            res += tmp;
            
        }
        return res.trim();
    }
}

//329. Longest Increasing Path in a Matrix
//https://www.youtube.com/watch?v=IgCyyYNRpVE
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        
        int res = 0;
        int row = matrix.length, col = matrix[0].length;
        int[][] dp = new int[row][col];
        for ( int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res = Math.max(res, dfs(matrix, i, j, dp));
            }
        }
        return res;
    }
    
    private int dfs(int[][] matrix, int row, int col, int[][] dp) {
        if (dp[row][col] > 0) return dp[row][col];
        
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            
            if (newRow < 0 || newRow >= matrix.length || newCol < 0 ||
                newCol >= matrix[0].length || matrix[newRow][newCol] <= matrix[row][col])
                continue;
            dp[row][col] = Math.max(dp[row][col], dfs( matrix, newRow, newCol,dp));
        }
        //return ++dp[row][col];
        dp[row][col] = dp[row][col] + 1;//update first, then return
        return dp[row][col];
    }
}

//380  Insert Delete GetRandom O(1)
class RandomizedSet {
    List<Integer> list;
    Map<Integer, Integer> map;// key: value, value: index in list
    Random rand;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int index = map.get(val);
        //if not the last element, swap with the last element
        if (index != list.size() - 1) {
            int lastValue = list.get(list.size() - 1);
            list.set(index, lastValue);
            map.put(lastValue, index);
        }
        
        //remove last element in the list
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
        
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */


//958  Check Completeness of a Binary Tree
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
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (queue.peek() != null) { // break condition, memorize
            TreeNode cur = queue.poll();
            queue.offer(cur.left);
            queue.offer(cur.right);
            
        }
        
        while (!queue.isEmpty() && queue.peek() == null) {
            queue.poll();
        }
        return queue.isEmpty();
    }
}


//162. Find Peak Element
class Solution {
    public int findPeakElement(int[] nums) {
        if (nums== null || nums.length < 2) return 0;
        
        if (nums[0] > nums[1])
                return 0;
        if (nums[nums.length - 1] > nums[nums.length - 2])
            return nums.length - 1;
        
        for (int i = 1; i < nums.length - 1; i++) {
            
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1])
                return i;
        }
        return 0;
    }
}