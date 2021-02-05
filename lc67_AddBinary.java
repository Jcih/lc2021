class Solution {
    public String addBinary(String a, String b) {
        /*
        ======
        add from the back
        
        **/
        
        
        int i = a.length() - 1;
        int j = b.length() - 1;
        
        int carry = 0;
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int na = 0;
            int nb = 0;
            
            if (i >= 0) na = a.charAt(i) - '0';
            if (j >= 0) nb = b.charAt(j) - '0';
            sum = na + nb + carry;
            carry = sum / 2;
            sum = sum % 2;
            sb.append(sum);
            i--;
            j--;

        }
        if (carry == 1) sb.append(carry);
        return sb.reverse().toString();
    }
}