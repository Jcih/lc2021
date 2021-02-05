class Solution {
    public String addStrings(String num1, String num2) {
        /*
        1. example
        2. data structure
        3. logic
        4. result
        5. analysis
        ==========
        num1 = 123456
        num2 = 644334
        --------------
             return        767790
        ----------------
        
        loop from right to left 
        num = (c1 + c2 + carry) % 10
        carry = num / 10
        sb.append(num);
        ==============

        Time: O(max(N1, N2))
        Space: O(max(N1, N2)), maximum length of sb is max(N1, N2) + 1
        **/
        
        int l1 = num1.length() - 1, l2 = num2.length() - 1;
        int carry = 0;
        int sum = 0;
        
        StringBuilder sb = new StringBuilder();
        while (l1 >= 0 || 0 <= l2) {
            int char1 = 0, char2 = 0;
            
            if (0 <= l1) char1 = num1.charAt(l1) - '0';
            if (0 <= l2) char2 = num2.charAt(l2) - '0';
            sum = char1 + char2 + carry;
            carry = sum / 10;
            sum = sum % 10;
            sb.append(sum);
            l1--;
            l2--;
            
        }
        if (carry == 1) sb.append(carry);
        return sb.reverse().toString();
    }
}