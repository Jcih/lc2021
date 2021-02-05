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