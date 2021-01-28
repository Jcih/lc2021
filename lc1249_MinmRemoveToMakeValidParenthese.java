class Solution {
    public String minRemoveToMakeValid(String s) {
        /*
        1. example
        2. data structure: StringBuilder
        3. logic
        4. result
        5. analysis
        ================
        (())
        ))((
        ================
        from left to right:
        count number of ( , int open
        remove redundent ) close
        if (char == '(') {
            open++
        } else if (char == ')') {
            if (open == 0)
                continue;
            else open--;
        }
        
        after this, new string may have redundent '('
        from right to left
         skip '(' when open > 0)
        
        **/
        
        StringBuilder sb = new StringBuilder();
        int open = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else if (c == ')') {
                if (open == 0)
                    continue;
                open--;    
            }
            sb.append(c);
        }
        
        StringBuilder res = new StringBuilder();
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == '(' && open > 0) {
                open--;
                continue;
            }
            res.append(sb.charAt(i));
            //res.insert(0, sb.charAt(i));
        }
        return res.reverse().toString();
        //return res.toString();
    }
}