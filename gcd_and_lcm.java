class Solution {
	public int gcd_greatestCommonDivisor(int a, int b) {
	    if (b == 0) {
	    	return a;
	    }
	    return gcd_greatestCommonDivisor(b, a % b);
	}

	public int lcm_lowestCommonMultiplier(int a, int b) {
		return a * b / gcd_greatestCommonDivisor(a, b);
	}
}