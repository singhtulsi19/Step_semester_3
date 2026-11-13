// Problem no. 10
public class BusiestBusRow {
    public static void busiestRow(int[][] grid) {
        if (grid == null || grid.length == 0) return;

        int bestRow = 0;
        int maxTotal = -1;

        for (int r = 0; r < grid.length; r++) {
            int rowTotal = 0;
            for (int c = 0; c < grid[r].length; c++) {
                rowTotal += grid[r][c];
            }
            if (rowTotal > maxTotal) {
                maxTotal = rowTotal;
                bestRow = r;
            }
        }

        System.out.println("Row " + bestRow + ", Total " + maxTotal);
    }

    public static void main(String[] args) {
        int[][] grid = {
            {2, 0, 1},
            {3, 3, 1},
            {1, 1, 1}
        };
        busiestRow(grid); // Expected: Row 1, Total 7
    }
}
