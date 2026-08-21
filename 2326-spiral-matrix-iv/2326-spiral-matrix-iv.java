class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {

        int[][] matrix = new int[m][n];

        // Fill entire matrix with -1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = -1;
            }
        }

        // Directions: right, down, left, up
        int[][] directions = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
        };

        int row = 0;
        int col = 0;
        int dir = 0;

        while (head != null) {

            // Put linked list value in current cell
            matrix[row][col] = head.val;
            head = head.next;

            // Calculate next position
            int newRow = row + directions[dir][0];
            int newCol = col + directions[dir][1];

            // If next position is invalid or already filled
            if (newRow < 0 || newRow >= m ||
                newCol < 0 || newCol >= n ||
                matrix[newRow][newCol] != -1) {

                // Change direction clockwise
                dir = (dir + 1) % 4;

                newRow = row + directions[dir][0];
                newCol = col + directions[dir][1];
            }

            row = newRow;
            col = newCol;
        }

        return matrix;
    }
}