class Solution {
    public int findMaxLength(int[] nums) {
        
        //a counter : when 0, counter -1 ; when 1, counter + 1
        // when the counter exists in map, the subarray between the map.get(counter) and i has same number of 0 and 1
        //map.put(counter, i)
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int counter = 0;
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) counter--;
            else counter++;
            
            if (map.containsKey(counter)) {
                maxLength = Math.max(maxLength, i - map.get(counter));
            } else {
                map.put(counter, i);
            }
        }
        
        return maxLength;
    }
}