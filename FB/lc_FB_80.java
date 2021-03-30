
//146. LRU Cache

class LRUCache {

    /*
    HashMap key: Node
    Node {
    key
    val
    prev
    next
    }
    
    get () : check if the node in map,if not return -1; else , remove in list, add to head of list, return val
    
    put () check if the node in map, if yes, update val of node, remove from list and add to head
                                     if no, check size of map, and add to head of list
    
    **/
    
    class Node {
        int key;
        int val;
        Node prev;
        Node next;
        
        public Node() {
            prev = null;
            next = null;
        }
    }
    
    Node head;
    Node tail;
    Map<Integer, Node> map;
    int size;
    
    
    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        size = capacity;
        
        
    }
    
    public int get(int key) {
        
        Node cur = map.get(key);
        if (cur != null) {
            remove(cur);
            addHead(cur);
            return cur.val;
        }
        return -1;
        
    }
    
    public void put(int key, int value) {
        Node cur = map.get(key);
        
        if (cur != null) {
            cur.val = value;
            remove(cur);
            addHead(cur);
        } else {
            
            if (map.size() == size) {
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node tmp = new Node();
            tmp.key = key;
            tmp.val = value;
            addHead(tmp);
            map.put(key, tmp);
        }
    }
    
    
    private void addHead(Node node) {
        Node first = head.next;
        head.next = node;
        node.next = first;
        first.prev = node;
        node.prev = head;
    }
    
    private void remove(Node node) {
        Node before = node.prev;
        Node after = node.next;
        before.next = after;
        after.prev = before;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

//246. Strobogrammatic Number
class Solution {
    public boolean isStrobogrammatic(String num) {
        int i = 0, j = num.length() - 1;
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('9', '6');
        map.put('8', '8');
       
        while (i <= j) {
            if (!map.containsKey(num.charAt(i))) return false;
            if (num.charAt(j) != map.get(num.charAt(i))) return false;
            
            i++;
            j--;
        }
        
        
        return true;
    }
}


//311
class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int m = mat1.length,k = mat1[0].length, n = mat2[0].length;
        
        
        int[][] res = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                if (mat1[i][j] != 0) {
                    for (int z = 0; z < n; z++) {
                        if (mat2[j][z] != 0) {
                            res[i][z] += mat1[i][j] * mat2[j][z];
                        }
                    }
                }
            }
        }
        return res;
    }
}

//203. Remove Linked List Elements
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode prev = new ListNode(0);
        prev.next = head;
        ListNode dummy = prev;
        
        
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
                //prev = prev.next;
            } else {
                prev = prev.next;
            }
        }
        
        return dummy.next;
    }
}


//347. Top K Frequent Elements
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
         /*
         map of freq: 1: 3,2, 2, 3, 1
         
         PriorityQueue 
         **/
        
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i : nums) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> freq.get(a) - freq.get(b));
        
        for (int key : freq.keySet()) {
            pq.offer(key);
            
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        int n = pq.size() - 1;
        int[] res = new int[n + 1];
        while (!pq.isEmpty()) {
            res[n--] = pq.poll();
        }
        return res;
    }
}


// 658
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        /*
        Priority Queue
        compare abs , if ==, compare a ,b
        
        */
        
        PriorityQueue<Integer> pq = new PriorityQueue<>( (a, b) -> Math.abs(a - x) == Math.abs(b - x) ? b - a : Math.abs(b - x) - Math.abs(a - x));
        
        for (int ele : arr) {
            pq.offer(ele);
            
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll());
        }
        Collections.sort(res);
        return res;
    }
}




class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - k;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        List<Integer> res = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }
        return res;
        //return Arrays.stream(arr, left, left + k).boxed().collect(Collectors.toList());
    }
}


//378 Kth Smallest Element in a Sorted Matrix
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>( (a, b) -> b - a);
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                pq.offer(matrix[i][j]);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        return pq.poll();
    }
}

//binary search
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length, col = matrix[0].length;
        int low = matrix[0][0];
        int high = matrix[row - 1][col - 1];
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            //count how many numbers less than mid

            int cnt = 0;
            int j = col - 1;
            for (int i = 0; i < row; i++) {
                while (j >= 0 && matrix[i][j] > mid) {
                    j--; 
                }
                cnt += j + 1;
            }
            
            /*
            if count<k , meaning that you need to make mid become bigger.
            else, meaning that you should limit the high.
            then you get low == high and k == count.
            **/
            
            if (cnt < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        return low;
    }
}


//138
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node cur = head;
        
        //insert a new node for each node
        while (cur != null) {
            Node tmp = new Node(cur.val);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = tmp.next;
        }
        
        //copy random pointer
        
        cur =  head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        
        //break list to separate
        cur = head;
        Node dummy = head.next;
        while (cur != null) {
            Node p = cur.next;
            cur.next = p.next;
            if (p.next != null)
                p.next = p.next.next;
            cur = cur.next;
        }
        return dummy;
        
    }
}


//157. Read N Characters Given Read4
/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        boolean eof = false;      // end of file flag
          int total = 0;            // total bytes have read
          char[] tmp = new char[4]; // temp buffer

          while (!eof && total < n) {
            int count = read4(tmp);

            // check if it's the end of the file
            eof = count < 4;

            // get the actual count
            count = Math.min(count, n - total);

            // copy from temp buffer to buf
            for (int i = 0; i < count; i++) 
              buf[total++] = tmp[i];
          }

          return total;
    }
}


//10 Regular Expression Matching
class Solution {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) return s.length() == 0;
        
        boolean firstMatch = s.length() > 0 &&
                             (s.charAt(0) == p.charAt(0) ||
                             p.charAt(0) == '.'); // first character match condition
        
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || // a* 0 times
                   (firstMatch && isMatch(s.substring(1), p)); // a* multiple times, then compare the rest of s with full p
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));// first match and compare the rest
        }
    }
}


//304. Range Sum Query 2D - Immutable
class NumMatrix {
    int[][] sum;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int r = matrix.length, c = matrix[0].length;
        sum = new int[r + 1][c + 1]; // add one layer to take care the edge case when the 1st row and col need to be calculated
    
        //i <= r, j <= c, be cautious
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + matrix[i - 1][j - 1]; // matrix[i - 1][j - 1] be cautious
            }
        }
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        res = sum[row2 + 1][col2 + 1] - sum[row2 + 1][col1] - sum[row1][col2 + 1] + sum[row1][col1]; // add one in the original index
        return res;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */

//525. Contiguous Array
class Solution {
    public int findMaxLength(int[] nums) {
        
        //a counter : when 0, counter -1 ; when 1, counter + 1
        // when the counter exists in map, the subarray between the map.get(counter) and i has same number of 0 and 1
        //map.put(counter, i)
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int counter = 0;
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) counter--;
            else counter++;
            
            if (map.containsKey(counter)) {
                maxLength = Math.max(maxLength, i - map.get(counter));
            } else {
                map.put(counter, i);
            }
        }
        
        return maxLength;
    }
}



//515. Find Largest Value in Each Tree Row
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
    public List<Integer> largestValues(TreeNode root) {
        //level order traverse
        //use queue and get the max
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                max = Math.max(max, cur.val);
                
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            list.add(max);
        }
        
        
        return list;
    }
}