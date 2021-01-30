class Solution {
    public String removeDuplicates(String S) {
        /*
        1. example
        2. data structure
        3. logic
        4. result
        5. analysis
        =================
        aaab is no the case; question only has 2 adjacent and queal letters, so can use stack
        =================
        Using stack ;
        add char ; if the new char == the stak.peek(), pop()
        **/
        
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (!stack.isEmpty() && c == stack.peek()) {
                stack.pop();
            } else {
                stack.push(c);
            }   
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}