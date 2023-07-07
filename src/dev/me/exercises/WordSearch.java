package dev.me.exercises;

public class WordSearch {
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        final int rows = board.length;
        final int cols = board[0].length;
        visited = new boolean[rows][cols];

        for(int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (word.charAt(0) == board[i][j] // the search starts where the first letter of the word is
                        && search(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, int row, int col, String word, int wordIndex) {
        // Stop condition
        if (wordIndex == word.length()) {
            return true;
        }

        if (row < 0 || row >= board.length || col < 0 || col >= board[row].length // boundaries
                || word.charAt(wordIndex) != board[row][col] || visited[row][col]) {
            return false;
        }

        visited[row][col] = true;
        if (search(board, row + 1, col, word, wordIndex + 1) ||
            search(board, row - 1, col, word, wordIndex + 1) ||
            search(board, row, col + 1, word, wordIndex + 1) ||
            search(board, row, col - 1, word, wordIndex + 1)) {
            return true;
        }

        visited[row][col] = false;
        return false;
    }

    public static void main(String[] args) {
        char [][] board = new char[][] {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        String word = "ABCCED";

        WordSearch ws = new WordSearch();
        System.out.println(ws.exist(board, word));
    }
}
