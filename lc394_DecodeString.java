class Solution {
    public String decodeString(String s) {
        
        
        /*
        
        3[a]2[bc]
        
        stack: 3        2
        stack: aaa      
        cur = aaa       bc        aaabcbc      
        1. num: get number , push to stack
        2. [, create a string variable to hold until ']'
        3. ], repeat the current string n times, push back to stack
        
        **/
        Stack<String> res = new Stack<>();
        Stack<Integer> repeat = new Stack<>();
        String cur = "";
        
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int num = s.charAt(i) - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = 10 * num + (s.charAt(i + 1) - '0');
                    i++;
                }

                repeat.push(num);
            } else if (s.charAt(i) == '[') {
                res.push(cur);
                cur = "";
            } else if (s.charAt(i) == ']') {
                //generate the repeat string
                StringBuilder sb = new StringBuilder(res.pop());
                int times = repeat.pop();
                for (int j = 0; j < times; j++) {
                    sb.append(cur);
                }
                
                cur = sb.toString();
                
            } else {
                cur += s.charAt(i);
            }
        }
        return cur;
    }
}