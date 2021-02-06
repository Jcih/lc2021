
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