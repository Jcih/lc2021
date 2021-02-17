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