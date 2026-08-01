class Solution {
    public String nearestPalindromic(String n) {
        long self = Long.parseLong(n);
        int len = n.length();

        Set<Long> set = new HashSet<>();

        set.add((long)Math.pow(10, len - 1) - 1);
        set.add((long)Math.pow(10, len) + 1);

        long prefix = Long.parseLong(n.substring(0, (len + 1) / 2));

        for (long i = prefix - 1; i <= prefix + 1; i++) {
            String left = String.valueOf(i);
            StringBuilder sb = new StringBuilder(left);

            String right;
            if (len % 2 == 0) {
                right = sb.reverse().toString();
            } else {
                right = sb.deleteCharAt(sb.length() - 1).reverse().toString();
            }

            set.add(Long.parseLong(left + right));
        }

        set.remove(self);

        long ans = -1;

        for (long x : set) {
            if (ans == -1 ||
                Math.abs(x - self) < Math.abs(ans - self) ||
                (Math.abs(x - self) == Math.abs(ans - self) && x < ans)) {
                ans = x;
            }
        }

        return String.valueOf(ans);
    }
}