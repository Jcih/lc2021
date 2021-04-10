//FACEBOOK
class Solution {
    public boolean backspaceCompare(String S, String T) {
        String s1 = getCuttedString(S);
        String s2 = getCuttedString(T);
        return s1.equals(s2);
    }
    
    private String getCuttedString(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
         
        //return String.valueOf(stack); //值得记住
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}



//Time O(1)
// Space O(M + N)
class Solution {
    public boolean backspaceCompare(String s, String t) {
        /* using two pointer to start from back**/
        if (s == null || t == null) return s == t;
        int i = s.length() - 1;
        int j = t.length() - 1;
        
        int back1 = 0, back2 = 0;
        
        while (i >= 0 || j >= 0) {
            
            while (i >= 0 && (s.charAt(i) == '#' || back1 > 0)) {
                if (s.charAt(i) == '#') back1++;
                else back1--;
                
                i--;
            }
            
            while (j >= 0 && (t.charAt(j) == '#' || back2 > 0)) {
                if (t.charAt(j) == '#') back2++;
                else back2--;
                
                j--;
            }
            
            
            if (i >= 0 && j >= 0 && s.charAt(i) == t.charAt(j)) {
                i--;
                j--;
            } else {
                return i == -1 && j == -1;
            }
        }
        return true;
        
        
    }
}