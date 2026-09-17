class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int INF = n + 1;

        int[] best = new int[n];

        // Initially, no valid subarray exists
        for (int i = 0; i < n; i++) {
            best[i] = INF;
        }

        int left = 0;
        int sum = 0;
        int ans = INF;

        for (int right = 0; right < n; right++) {

            sum += arr[right];

            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            // Carry previous best
            if (right > 0) {
                best[right] = best[right - 1];
            }

            // Found a subarray with sum = target
            if (sum == target) {

                int len = right - left + 1;

                // Check for another non-overlapping subarray
                if (left > 0 && best[left - 1] != INF) {
                    ans = Math.min(ans, len + best[left - 1]);
                }

                // Store shortest subarray found so far
                best[right] = Math.min(best[right], len);
            }
        }

        return ans == INF ? -1 : ans;
    }
}