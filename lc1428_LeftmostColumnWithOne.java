/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

//Time O(row * log(col))
class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        // dimensions get the row, col
        // for each row, find the index of first 1
        // binanry search
        
        int row = binaryMatrix.dimensions().get(0);
        int col = binaryMatrix.dimensions().get(1);
        
        int res = col;
        
        //for each row, find the smallest index of 1
        
        for (int i = 0; i < row; i++) {
            int left = 0; 
            int right = col - 1;
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
        
    }
}




// O(row + col)
///**
 /* // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        // dimensions get the row, col
        // 
        
        int row = binaryMatrix.dimensions().get(0);
        int col = binaryMatrix.dimensions().get(1);
        
        int res = col;
        
        int i = 0, j = col - 1;
        
        while ( i < row && j >= 0) {
            if (binaryMatrix.get(i, j) == 1) {
                j--;
            } else {
                i++;
            }
        }
        
        return j == col - 1 ? -1 : j + 1;
        
    }
}