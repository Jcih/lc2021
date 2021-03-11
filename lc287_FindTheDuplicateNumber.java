class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        
        //// mean there is a cycle, but this point is not same as the start of the cycle
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
            
        } while (slow != fast);
        
        int find = 0;
        while (find != slow) {
            slow = nums[slow];
            find = nums[find];
        }
        return find;
    }
}
