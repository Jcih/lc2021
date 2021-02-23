class Solution {
    public boolean isMonotonic(int[] A) {
        if (A == null || A.length <= 2) return true;
        
        boolean increase = false;
        boolean decrease = false;
        
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] > A[i])
                decrease = true;
            
            if (A[i - 1] < A[i])
                increase = true;
        }
        
        if (increase && decrease)
            return false;
        else 
            return true;
    }
}