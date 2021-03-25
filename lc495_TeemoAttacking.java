class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        /*
        start from index 1
        if timeSeries  i - (i - 1) > duration, 
           
        */
        
        int res = 0;
        
        if (timeSeries == null || timeSeries.length == 0) return res;
        if (timeSeries.length == 1) return duration;
        
        for (int i = 1; i < timeSeries.length; i++) {
            res += Math.min(duration, timeSeries[i] - timeSeries[i - 1]);
        }
        res += duration;
        
        return res;
    }
}