class Solution {

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        int lo = 0, hi = nums.length - 1;

        while (lo <= hi) {

            int pivot = nums[lo + (hi - lo) / 2];

            int left = lo;
            int i = lo;
            int right = hi;

            // 3-way partition
            while (i <= right) {

                if (nums[i] < pivot) {
                    swap(nums, left, i);
                    left++;
                    i++;
                }
                else if (nums[i] > pivot) {
                    swap(nums, i, right);
                    right--;
                }
                else {
                    i++;
                }
            }

            // target is in left part
            if (target < left) {
                hi = left - 1;
            }
            // target is in right part
            else if (target > right) {
                lo = right + 1;
            }
            // target is inside pivot/equal section
            else {
                return nums[target];
            }
        }

        return -1;
    }
}