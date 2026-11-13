// Problem no. 2
public class WarehouseBinGridScan {
    public static void warehouseSummary(int[][] grid) {
        if (grid == null || grid.length == 0) return;

        int total = 0;
        int maxVal = -1;
        int maxRow = 0;
        int maxCol = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                total += grid[r][c];
                if (grid[r][c] > maxVal) {
                    maxVal = grid[r][c];
                    maxRow = r;
                    maxCol = c;
                }
            }
        }

        System.out.printf("total = %d, maxCoordinate = (%d, %d)%n", total, maxRow, maxCol);
    }

    public static void main(String[] args) {
        int[][] grid = {
            {4, 9, 2},
            {7, 1, 6},
            {3, 12, 5}
        };
        warehouseSummary(grid); // total = 49, maxCoordinate = (2, 1)
    }
}
