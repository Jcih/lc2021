//https://leetcode.com/problems/nth-magical-number/discuss/154613/C%2B%2BJavaPython-Binary-Search
//Time Complexity: O(log(10**14))
class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        /*
        4, 2, 3: 2, 3, 4, 6
        5, 2, 4: 2, 4, 6, 8, 10
        3, 6, 4: 4, 6, 8
        */
        long tmp, l = 2, r = (long) 1e14, mod = (long) 1e9 + 7;
        long lcm = (long) lcm(a, b);
		
		while (l < r) {
			long m = (l + r) / 2;
			if (m / a + m / b - m /lcm < n) 
				l = m + 1;
			else 
				r = m;
		}
		return (int) (l % mod);
        
        
        
    }
    
    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
    
    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}