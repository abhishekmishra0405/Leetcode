class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1000000007;
        
        long[] dp = new long[26];
        
        for (char ch : s.toCharArray()) {
            int idx = ch - 'a';
            
            long total = 1; // new subsequence containing only this character
            
            for (int i = 0; i < 26; i++) {
                total = (total + dp[i]) % MOD;
            }
            
            dp[idx] = total;
        }
        
        long ans = 0;
        
        for (int i = 0; i < 26; i++) {
            ans = (ans + dp[i]) % MOD;
        }
        
        return (int) ans;
    }
}