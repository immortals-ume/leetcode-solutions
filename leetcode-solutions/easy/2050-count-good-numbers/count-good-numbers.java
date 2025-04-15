class Solution {
    private static final long MOD = 1_000_000_007;
    public int countGoodNumbers(long n) {
        long evenPositions = (n + 1) / 2;
        long oddPositions = n / 2;

        long evenPow = modPow(5, evenPositions, MOD);
        long oddPow = modPow(4, oddPositions, MOD);

        return (int)((evenPow * oddPow) % MOD); 
    }
    private long modPow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;

        while (exp > 0) {
            if ((exp & 1) == 1) { // If exp is odd
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1; // Divide exp by 2
        }

        return result;
    }
}