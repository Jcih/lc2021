class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        /*
        build a map to store the (x + y : value list), and reverse the list
        
        because every diagonal, x + y is same; and for loop, order is reversed
        
        **/
        if (nums == null || nums.size() == 0) return null;
        int n = 0;
        int maxKey = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                n++;
                if (!map.containsKey(i + j)) {
                    map.put(i + j, new ArrayList<>());
                }
                map.get(i + j).add(nums.get(i).get(j));
                maxKey = Math.max(maxKey, i + j);
            }
        }
        
        int[] res = new int[n];
        int index = 0;
        
        for (int i = 0; i <= maxKey; i++) {
            List<Integer> cur = map.get(i);
            
            for (int j = cur.size() - 1; j >= 0; j--) {
                res[index++] = cur.get(j);
            }
        }
        return res;
    }
}