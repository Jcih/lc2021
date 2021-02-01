class Solution {
    public int calculate(String s) {
        /*
        1. example
        2. data structure
        3. logic
        4. result
        5. analysis
        ===================
        
        3, 2, 2
        
        +, *
        
        stack to store 2*2 as a result 4, 3/ 2 as a result 1, push to stack. finally add all
        


        **/
        
        Stack<Integer> stack = new Stack<>();
        if (s == null || s.length() == 0) return 0;
        char operand = '+';
        int num = 0;
        
        for (int i = 0; i < s.length(); i++) {
        
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            
            if (!Character.isDigit(c) && ' ' != c || i == s.length() - 1) {
                if (operand == '+') {
                    stack.push(num);
                }else if (operand == '-') {
                    stack.push(-num);
                }else if (operand == '*') {
                    stack.push(stack.pop() * num);
                } else if (operand == '/') {
                    stack.push(stack.pop() / num);
                }
                operand = c;
                num = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}