class Solution {
    public String modifyString(String s) {
        char[] arr = s.toCharArray();
        
        for (int i = 0; i < arr.length; i++) {
            
            if (arr[i] == '?') {
                
                // use 3 different chars to check equals with neighbours, and pick one
                for (char j = 'a'; j <= 'c'; j++) {
                    if (i - 1 >= 0 && arr[i - 1] == j) continue;
                    if (i + 1 < arr.length && arr[i + 1] == j) continue;
                    arr[i] = j;
                }
            }
        }
        return String.valueOf(arr);
    }
}