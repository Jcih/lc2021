 //953. Verifying an Alien Dictionary
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        /*
        1. example
        2. data structure : array, for
        3. logic
        4. result
        5. analysis
        ==============
        1. construct lower case aphabet array
        2. compare words[i] and words[i - 1] each time
        3. get the arr[char] for each word, compare, if equal, i++
        ==============    
        Time: O(N * M), N is the number of words, M is the average character of words    
        **/
        
        int[] alien = new int[26];
        int k = 0;
        for (char c : order.toCharArray()) {
            alien[c - 'a'] = k++;
        }
        
        if (words == null || words.length <= 1) return true;
        for (int i = 1; i < words.length; i++) {
            if (!compare(words[i - 1], words[i], alien)) {
                return false;
            }
        }
        return true;
    }
    public boolean compare(String s1, String s2, int[] alien) {
        int l1 = s1.length();
        int l2 = s2.length();
        
        int i = 0;
        while (i < l1 && i < l2) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            
            int diff = alien[c1 - 'a'] - alien[c2 - 'a'];
            if (diff < 0) return true;
            else if (diff > 0) return false;
            else {
                //diff == 0
                i++;
            }
        }
        //apple, app
        return l1 <= l2;  
    }
}



//1428. Leftmost Column with at Least a One
/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        
        /*
        
        1. example
        2. data structure
        3. logic
        4. result
        5. analysis
        ==========
        
        row = 2, col = 2
        brute force: loop by column from col 0; TLE
        optimize:
        
        
        **/
        /*Brute force
        int row = binaryMatrix.dimensions().get(0);
        int col = binaryMatrix.dimensions().get(1);
        
        for (int j = 0; j < col; j++){
            for (int i = 0; i < row; i++) {
                if (binaryMatrix.get(i, j) == 1)
                    return j;
            }
            
        }
        return -1;
        */
        
        /* binary search
        int row = binaryMatrix.dimensions().get(0);
        int col = binaryMatrix.dimensions().get(1);
        int res = col;
        //for each row, find the left most 1 using binary search
        // get the minimum left index
        for (int i = 0; i < row; i++) {
            int left = 0, right = col - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (binaryMatrix.get(i, mid) == 1) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if (binaryMatrix.get(i, left) == 1) {
                res = Math.min(res, left);
            }
            
        }
        return res == col ? -1 : res;
        */
        
        /* start from top right corner, Time : O(row + col) */
        int row = binaryMatrix.dimensions().get(0);
        int col = binaryMatrix.dimensions().get(1);
        int res = col;
        int i = 0, j = col - 1;
        while (i < row && j >= 0) {
            if (binaryMatrix.get(i, j) == 0) {
                i++;
            } else {
                res = Math.min(res, j);
                j--;
            }
        }
        return res == col ? -1 : res;
    }
}



//1249. Minimum Remove to Make Valid Parentheses
class Solution {
    public String minRemoveToMakeValid(String s) {
        /*1. example
          2. data structure / algo\
          3. logic
          4. result
          5. analysis
          ==================
          from right to left, count the number of "("
          if number of "(" >= 0, add ")". number of "("--
          else skip
          
          from left to tight:
          count number of ")", if number of ")" > 0, add "(", number--
          else skip
        
        */
        
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                cnt++;
            }
            if (cnt > 0 && c == ')') {
                cnt--;
            } else if (cnt <= 0 && c == ')') {
                continue;
            }
            sb.append(c);
        }
        // get "ab(c)d"
        // get "(("
        // get "(a(b(c)d)"

        cnt = 0;
        String tmp = sb.toString();
        sb = new StringBuilder();
        for (int i = tmp.length() - 1; i >= 0; i--) {
            char c = tmp.charAt(i);
            if (c == ')') cnt++;
            if (cnt > 0 && c == '(') cnt--;
            else if (cnt <= 0 && c == '(') continue;
            sb.append(c);
        }
        return sb.reverse().toString();
        
    }
}



//973. K Closest Points to Origin
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        /*
        1. exmaple
        2. data structure
        3. logic
        4. result
        5. analysis
        ==============
        use priorityQueue where (a, b)-> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1])
        if pq.size() >= k
           pq.poll();// the smallest left
        
        Space: O(N) to build a heap 
        Time: O(Klog(N)) to extract.
        */   
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));
        
        for (int[] point : points) {
            pq.offer(point);
            
            if (pq.size() > K)
                pq.poll();     
        }
        
        int[][] res = new int[K][2];
        int i = 0;
        while (!pq.isEmpty()) {
            res[i++] = pq.poll();
        }
        return res;
    }
}

//415. Add Strings
class Solution {
    public String addStrings(String num1, String num2) {
        /*
        1. example
        2. data structure
        3. logic
        4. result
        5. analysis
        ==========
        num1 = 123456
        num2 = 644334
        --------------
             return        767790
        ----------------
        
        loop from right to left 
        num = (c1 + c2 + carry) % 10
        carry = num / 10
        sb.append(num);
        ==============

        Time: O(max(N1, N2))
        Space: O(max(N1, N2)), maximum length of sb is max(N1, N2) + 1
        **/
        
        int l1 = num1.length() - 1, l2 = num2.length() - 1;
        int carry = 0;
        int sum = 0;
        
        StringBuilder sb = new StringBuilder();
        while (l1 >= 0 || 0 <= l2) {
            int char1 = 0, char2 = 0;
            
            if (0 <= l1) char1 = num1.charAt(l1) - '0';
            if (0 <= l2) char2 = num2.charAt(l2) - '0';
            sum = char1 + char2 + carry;
            carry = sum / 10;
            sum = sum % 10;
            sb.append(sum);
            l1--;
            l2--;
            
        }
        if (carry == 1) sb.append(carry);
        return sb.reverse().toString();
    }
}


//680. Valid Palindrome II
class Solution {
    public boolean validPalindrome(String s) {
        /*
        1. example
        2. data structure
        3. logic
        4. result
        5. analysis
        =================
        
        using left and right pointer to compare,
        if !=, compare (left + 1, right) || (left, right - 1)
                       remove left char       remove right char
        
        **
        */
        
        //Time Limit Exceeded brute force
        /*if (s == null || s.length() == 0) return true;
        
        for (int i = 0; i < s.length(); i++) {
            String tmp = s.substring(0 , i) + s.substring(i + 1, s.length());
            if (isPalindrome(s) || isPalindrome(tmp)) {
                return true;
            }
        }
        return false;
        */
        
        //Time: O(N) N is the length of string
        //Space: O(1) only variables
        int left = 0, right = s.length() - 1;
        
        while (left <= right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
                
            } else {
                
                return isPalindrome(s, left, right - 1) ||
                       isPalindrome(s, left + 1, right);
            }
        }
        return true;
           
    }
    
    public boolean isPalindrome(String s, int left, int right) {
        
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}


//238. Product of Array Except Self
class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        
        /*
        1. example
        2. data structure
        3. logic
        4. result
        5. analysis
        ================
        1: 2 * 3 * 4
        2: 1 * 3 * 4
        3: 1 * 2 * 4
        4: 1 * 2 * 3
        left [1, 1, 2, 6]
        right[24,12,4, 1]
        res[24, 12, 8, 6]
        
        =================
        Time: O(N): 3 times of loop
        Space: O(N): 3 arrays
        **/
        
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1; 
        right[n - 1] = 1;
        
        for (int i = 0; i < n - 1; i++) {
            left[i + 1] = left[i] * nums[i];
        }
     
        for (int i = n - 1; i > 0; i--) {
            right[i - 1] = right[i] * nums[i];
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
   
    }
}


//Follow-up- use variable to calculate right product
class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        
        /*
        1. example
        2. data structure
        3. logic
        4. result
        5. analysis
        ================
        1: 2 * 3 * 4
        2: 1 * 3 * 4
        3: 1 * 2 * 4
        4: 1 * 2 * 3
        left [1, 1, 2, 6]
        right[24,12,4, 1]
        res[24, 12, 8, 6]
        
        =================
        Time: O(N): 2 times of loop
        Space: O(1): only the output array res
        **/
        
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        
        
        for (int i = 0; i < n - 1; i++) {
            res[i + 1] = res[i] * nums[i];
        }
        
        int prodR = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] = res[i] * prodR;
            prodR = prodR * nums[i];// for next round
        }
        return res;
   
    }
}



//560. Subarray Sum Equals K
//https://www.youtube.com/watch?v=f0IY7_WpSB4
class Solution {
    public int subarraySum(int[] nums, int k) {
        //sum[j] - sum[i] = subarray[i, j] 's sum k
        //sum : (0 ~ i)'s sum
        
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}

//1570. Dot Product of Two Sparse Vectors
class SparseVector {
    
    HashMap<Integer, Integer> map;
    SparseVector(int[] nums) {

        map = new HashMap<>();
        //only store the non-zero index-values
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                map.put(i, nums[i]);
            }
        }
        
    }
    
    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int res = 0;
        for (int i : map.keySet()) {
            if (vec.map.containsKey(i)) {
                res += map.get(i) * vec.map.get(i);
            }
        }
        return res;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);



//273. Integer to English Words
class Solution {
    private final String[] belowTen = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private final String[] belowTwenty = new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] belowHundred = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        return helper(num); 
    }
    
    private String helper(int num) {
        String result = new String();
        if (num < 10) result = belowTen[num];
        else if (num < 20) result = belowTwenty[num -10];
        else if (num < 100) result = belowHundred[num/10] + " " + helper(num % 10);
        else if (num < 1000) result = helper(num/100) + " Hundred " +  helper(num % 100);
        else if (num < 1000000) result = helper(num/1000) + " Thousand " +  helper(num % 1000);
        else if (num < 1000000000) result = helper(num/1000000) + " Million " +  helper(num % 1000000);
        else result = helper(num/1000000000) + " Billion " + helper(num % 1000000000);
        return result.trim();
    }
    
}


//67. Add Binary
class Solution {
    public String addBinary(String a, String b) {
        /*
        ======
        add from the back
        
        **/
        
        
        int i = a.length() - 1;
        int j = b.length() - 1;
        
        int carry = 0;
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int na = 0;
            int nb = 0;
            
            if (i >= 0) na = a.charAt(i) - '0';
            if (j >= 0) nb = b.charAt(j) - '0';
            sum = na + nb + carry;
            carry = sum / 2;
            sum = sum % 2;
            sb.append(sum);
            i--;
            j--;

        }
        if (carry == 1) sb.append(carry);
        return sb.reverse().toString();
    }
}

//301
//https://www.youtube.com/watch?v=-IbZA4WckOc&t=1s

class Solution {
    
    private int getMinParenToRemove(String s) {
        int minParenRemoveCount = 0;
        int open = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                open++;
            } else if (c == ')') {
                if (open == 0) {
                    minParenRemoveCount++;
                } else {
                    open--;
                }
            }
        }
        minParenRemoveCount += open;
        return minParenRemoveCount;
    }
    
    
    public List<String> removeInvalidParentheses(String s) {
        int minParenToRemove = getMinParenToRemove(s);
        Set<String> res = new HashSet<>();
        dfs(s, 0, minParenToRemove, 0, "", res);
        
        //convert set to list
        List<String> list = new ArrayList<>();
        for (String s1 : res) {
            list.add(s1);
        }
        return list;
    }
    
    private void dfs(String s, int index, int parenRemoveCount, int open, String tmp, Set<String> res) {
        if (index == s.length()) {
            if (parenRemoveCount == 0 && open == 0) {
                res.add(tmp);
            }
            return;
        }
        
        if (parenRemoveCount < 0) return;
        
        if (s.charAt(index) == '(') {
            dfs(s, index + 1, parenRemoveCount, open + 1, tmp + '(', res);
            dfs(s, index + 1, parenRemoveCount - 1, open, tmp, res);
        } else if (s.charAt(index) == ')') {
            if (open > 0) {
                dfs(s, index + 1, parenRemoveCount, open - 1, tmp + ')', res);
            }
            dfs(s, index + 1, parenRemoveCount - 1, open, tmp, res);
        } else {
            dfs(s, index + 1, parenRemoveCount, open, tmp + s.charAt(index), res);
        }
    }
}

//269. Alien Dictionary
class Solution {
    public String alienOrder(String[] words) {
        int[] inDegree = new int[26];
        Map<Character, List<Character>> graph = new HashMap<>();
        
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.put(c, new ArrayList<>());
            }
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            String start = words[i];
            String end = words[i + 1];
            if (start.length() > end.length() && start.startsWith(end)) return "";
            
            int len = Math.min(start.length(), end.length());
            for (int j = 0; j < len; j++) {
                
                char out = start.charAt(j);
                char  in = end.charAt(j);
                if (out != in) {
                    graph.get(out).add(in);
                    inDegree[in - 'a']++;
                    break; 
                }
            }
        }
        
        StringBuilder sb =  new StringBuilder();
        Queue<Character> q = new LinkedList<>();
        for (char c : graph.keySet()) {
            if (inDegree[c - 'a'] == 0) {
                q.offer(c);
            }
        }
        
        while (!q.isEmpty()) {
            char out = q.poll();
            sb.append(out);
            for (char in : graph.get(out)) {
                inDegree[in - 'a']--;
                if (inDegree[in - 'a'] == 0) {
                    q.offer(in);
                }
            }
        }
        return sb.length() == graph.size() ? sb.toString() : "";
    }
}


//125. Valid Palindrome
class Solution {
    public boolean isPalindrome(String s) {
        /*
        Alphanumeric
        **/



        if (s == null || s.length() == 0) return true;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isAlphabetic(c) || Character.isDigit(c)) {
                sb.append(c);
            }
        }
        
        s = sb.toString().toUpperCase();
        
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}


//199. Binary Tree Right Side View
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
    public List<Integer> rightSideView(TreeNode root) {
        /*
        1. example
        2. data structure: level order
        3. logic: get the last value in each level
        4. result
        5. analysis
        ===================
        
        **/
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode cur = queue.poll();
                if (i == n - 1) res.add(cur.val);
                
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
        }
        
        return res;
    }
}


//211. Design Add and Search Words Data Structure
class WordDictionary {

    
    class TrieNode {
        
        TrieNode[] children;
        boolean isWord;
        
        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }
    
    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode cur = root;
        
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }
    
    public boolean search(String word) {
        return searchWord(word, 0, root);
    }
    public boolean searchWord(String word, int index, TrieNode cur) {
        if (cur == null) return false;
        if (index == word.length()) return cur.isWord;
    
        char c = word.charAt(index);
        if (c == '.') {
            for (TrieNode next : cur.children) {
                if (searchWord(word, index + 1, next))
                    return true;
            }
        } else {
            return searchWord(word, index + 1, cur.children[c - 'a'] );
        }
        
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */