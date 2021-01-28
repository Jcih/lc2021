class Solution {
    public boolean isValid(String s) {
        /*
        1. example
        2. data structure
        3. logic
        4. result
        5. analysis
        =================
        ({[]})
        the latest open should be closed first 
        
        last come in , first come out 
        
        using stack
        =================
        when meet (, stack push )
        when meet [, stack push ]
        when meet {, stack push }
        when meet close braket, compate the stack pop with the char
        
        
        **/
        
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else {
                if (stack.isEmpty()) return false;
                
                if (stack.peek() != c) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}