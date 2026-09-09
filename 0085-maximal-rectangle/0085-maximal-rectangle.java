import java.util.*;

class Solution {

    public int largestRectangleArea(int[] arr) {
        int n = arr.length;

        Stack<Integer> st = new Stack<>();
        int[] nse = new int[n];

        nse[n - 1] = n;
        st.push(n - 1);

        for (int i = n - 2; i >= 0; i--) {
            while (st.size() > 0 && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.size() == 0)
                nse[i] = n;
            else
                nse[i] = st.peek();

            st.push(i);
        }

        while (st.size() > 0)
            st.pop();

        int[] pse = new int[n];
        pse[0] = -1;
        st.push(0);

        for (int i = 1; i < n; i++) {
            while (st.size() > 0 && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.size() == 0)
                pse[i] = -1;
            else
                pse[i] = st.peek();

            st.push(i);
        }

        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int area = arr[i] * (nse[i] - pse[i] - 1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[] height = new int[n];
        int max = 0;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }

            max = Math.max(max, largestRectangleArea(height));
        }

        return max;
    }
}