class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        
        int i = 0, j = 0;
        List<int[]> res = new ArrayList<>();
        
        while (i < firstList.length && j < secondList.length) {
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);
            
            if (start <= end) {
                int[] cur = new int[2];
                cur[0] = start;
                cur[1] = end;
                
                res.add(cur);
            }
            
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
            
        }
        return res.toArray(new int[res.size()][]);
    }
}