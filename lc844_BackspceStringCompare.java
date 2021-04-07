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