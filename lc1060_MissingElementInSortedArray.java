class Solution {
    public int missingElement(int[] nums, int k) {
        /*count how many missing in range nums , compare with K, if in range, return kth,
        else , need add extra**/
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i < nums.length - 1; i++) {
            if (nums[i] + 1 < nums[i + 1]) {
                //list.add(nums[i] + 1);
                addMissing(list, nums[i] + 1, nums[i + 1] - 1);
            }
        }
        
        if (list.size() < k) return (k - list.size()) + nums[nums.length - 1];
        else return list.get(k - 1);
    }
    
    
    private void addMissing(List<Integer> list, int left, int right) {
        
        for (int i = left; i <= right; i++) {
            list.add(i);
        }
    }
}





//Binary search
class Solution {
    public int missingElement(int[] nums, int k) {
        /*
        Binary search: count how many numbers missing in range
        
        
        
        **/
        
        int n = nums.length - 1;
        int left = 0;
        int right = n;
        
        int missingNumber = nums[n] - nums[0] - n;
        
        if (missingNumber < k) return nums[n] + k - missingNumber;
        
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            
            int missingFromLeftToMid = nums[mid] - nums[left] - (mid - left);
            
            if (missingFromLeftToMid >= k) {
                right = mid;
            } else {
                k = k - missingFromLeftToMid;
                left = mid;
            }
        }
        return nums[left] + k;
    }
}


