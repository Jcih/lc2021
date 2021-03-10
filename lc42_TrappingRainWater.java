class Solution {
    public int trap(int[] height) {
        
        /*
        1. Find the max height index
        2. traverse from left and right to the peak index
        3. define leftMax and rightMax, 
             if height[i] < leftMax, water + leftMax - height[i]
             else leftMax = height[i]
             same for right
        **/
        //edge cases
        if (height == null || height.length <= 2) return 0;
        
        int maxHeight = 0;
        int maxIndex = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > maxHeight) {
                maxHeight = height[i];
                maxIndex = i;
            } 
        }
        int water = 0;
        int leftMax = height[0];
        for (int i = 0; i < maxIndex; i++) {
            if (height[i] < leftMax) {
                water += leftMax - height[i];
            } else {
                leftMax = height[i];
            }
        }
        
        int rightMax = height[height.length - 1];
        for (int i = height.length - 1; i > maxIndex; i--) {
            if (height[i] < rightMax) {
                water += rightMax - height[i];
            } else {
                rightMax = height[i];
            }
        }
        return water;
    }
}