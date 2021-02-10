//398. Random Pick Index
import java.util.Random;
class Solution {

    int[] nums;
    Random rand;
    
    public Solution(int[] nums) {
        this.nums = nums;
        rand = new Random();
    }
    
    public int pick(int target) {
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                list.add(i);
            }
        }
        int size = list.size();
        
        return list.get(rand.nextInt(size));
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */

//Reservior sampling
class Solution {
    Random rand;
    int[] num;

    public Solution(int[] nums) {
        this.num = nums;
        rand = new Random();
    }
    
    public int pick(int target) {
        int count = 0;
        int res = -1;;
        for (int i = 0; i < num.length; i++) {
            if (num[i] == target) {
                count++;
                
                if (rand.nextInt(count) == 0)
                    res = i;
            }
            
            
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */