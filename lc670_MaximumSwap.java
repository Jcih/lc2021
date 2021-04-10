class Solution {
    public int maximumSwap(int num) {
        /*
        find the most right index for each char
        to swap, need to swap with the largest and right most char than cur;
        
        for cur char, loop through from 9 to cur number as j, if the j > i, swap j, i
        
        
        **/
        
        
        char[] numarr = String.valueOf(num).toCharArray();
        int[] rightMost = new int[10];
        
        for (int i = 0; i < numarr.length; i++) {
            rightMost[numarr[i] - '0'] = i;
        }
        
        for (int i = 0; i < numarr.length; i++) {
            //loop through 9 to 0
            
            for (char d = '9'; d > numarr[i]; d--) {
                if (rightMost[d - '0'] > i) {
                    swap(numarr, i, rightMost[d - '0']);
                    return Integer.valueOf(String.valueOf(numarr));
                }
            }
        }
        return num;
    }
    
    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}