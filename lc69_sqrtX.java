//binary search
class Solution {
    public int mySqrt(int x) {
        //while loop , binary search
        //if m == x, return m
        //if l*l > x, return l - 1, because the l * l will overflow Integer, so use x / l to compare.
        //when not sure around the bound, or should return left or right, test a case that goes throught the last loop
        //8, l = 1, r = 8, m = 4, div = 2, r = 4 - 1 = 3; l = 1, r = 3, m = 1+ 2/2 = 2, div = 8 / 2 = 4, div > m,l = m + 1 = 3;
        //l = 3, r = 3, m = 3, div = 2 < m, r = 2; r < l, return right;
        
        int left = 1;
        int right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int div = x / mid;
            if (div == mid) return mid;
            else if (div > mid) {
               left = mid + 1; 
            } else {
                right = mid - 1;
               
            }
        }
        return right;
    }
}