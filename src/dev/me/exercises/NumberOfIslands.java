package dev.me.exercises;

/*
Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
 */
public class NumberOfIslands {
    public static void main(String[] args) {
        /*char[][] grid = new char[][] {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };*/

        char[][] grid = new char[][] {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        NumberOfIslands r = new NumberOfIslands();
        System.out.println(r.numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        int count = 0;

        for (int i=0; i<grid.length; i++) {
            for (int j=0;j<grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    callDfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private void callDfs(char[][] grid, int row, int col) {
        // check boundaries
        if(row >= grid.length || row < 0 || col >= grid[row].length || col < 0 || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';
        callDfs(grid, row+1, col); // up
        callDfs(grid, row-1, col); // down
        callDfs(grid, row, col+1); // right
        callDfs(grid, row, col-1); // left
    }
}
