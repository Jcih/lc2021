//greedy
class Solution {
    public int candy(int[] ratings) {

        if (ratings.length == 0) return 0;
        int[] res = new int[ratings.length];
        
        Arrays.fill(res, 1);
        
        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i + 1] > ratings[i]) 
                res[i + 1] = res[i] + 1;
        }
        
        for (int j = ratings.length - 1; j > 0; j--) {
            if (ratings[j - 1] > ratings[j]) 
                res[j - 1] = Math.max(res[j] + 1, res[j - 1]);// to make sure satisfy both conditions
        }
        
        int count = 0;
        
        for (int k : res) {
            count += k;
        }
        return count;
    }
}