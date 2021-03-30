//https://leetcode.com/problems/strobogrammatic-number-ii/discuss/358470/Java-easy-recursive-solution-with-explanation
class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String>result = new ArrayList<>();
        if (n%2==1) {
            insertStrobogrammatic(result, "1", n, 1);
            insertStrobogrammatic(result, "8", n, 1);
            insertStrobogrammatic(result, "0", n, 1);
        } else 
            insertStrobogrammatic(result, "", n, 0);
        return result;
    }
     public void insertStrobogrammatic(List<String>result, String input, int n, int l){
        if (l==n)result.add(input);
        else {
            if (n-l>2) insertStrobogrammatic(result, "0"+input+"0", n, l+2);
            insertStrobogrammatic(result, "6"+input+"9", n, l+2);
            insertStrobogrammatic(result, "1"+input+"1", n, l+2);
            insertStrobogrammatic(result, "8"+input+"8", n, l+2);
            insertStrobogrammatic(result, "9"+input+"6", n, l+2);
        }   
    }
}