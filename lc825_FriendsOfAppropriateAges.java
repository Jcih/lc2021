//825. Friends Of Appropriate Ages

class Solution {
    public int numFriendRequests(int[] ages) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int age : ages) {
            map.put(age, map.getOrDefault(age, 0) + 1);
        }
        
        int res = 0;
        for (int a : map.keySet()) {
            for (int b : map.keySet()) {
                if (request(a, b)) {
                    res += map.get(a) * (map.get(b) - (a == b ? 1 : 0));
                }
            }
        }
        return res;
    }
    
    private boolean request(int a, int b) {
        return !(b <= 0.5 * a + 7 || b > a || (b > 100 && a < 100));
    }
    
}