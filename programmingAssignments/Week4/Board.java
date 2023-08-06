package programmingAssignments.Week4;

import java.util.ArrayList;

public class Board {
    private int n;
    private int[][] tiles;
    private int blankRow, blankCol;

    public Board(int[][] board) {
        if (board == null)
            throw new IllegalArgumentException();
        n = board.length;
        tiles = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    blankRow = i;
                    blankCol = j;
                }
                tiles[i][j] = board[i][j];
            }
        }
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(n).append("\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                builder.append(String.format("%2d ", tiles[i][j]));
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    public int dimension() {
        return n;
    }

    public int hamming() {
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == blankRow && j == blankCol)
                    continue;
                else if (tiles[i][j] != ((i * n) + (j + 1))) {
                    result++;
                }
            }
        }
        return result;
    }

    public int manhattan() {
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != blankRow || j != blankCol) {
                    int num = tiles[i][j] - 1;
                    int rowPos = num / n;
                    int colPos = (num % n);
                    int rowDif = Math.abs(i - rowPos);
                    int colDif = Math.abs(j - colPos);
                    result += rowDif + colDif;
                }
            }
        }
        return result;
    }

    public boolean isGoal() {
        return hamming() == 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        Board that = (Board) obj;
        if (n != that.dimension())
            return false;
        if ((this.blankRow != that.blankRow) || (this.blankCol != that.blankCol))
            return false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tiles[i][j] != that.tiles[i][j])
                    return false;
            }
        }
        return true;
    }

    public Iterable<Board> neighbors() {
        ArrayList<Board> neighbors = new ArrayList<>();
        if (blankRow > 0) {
            int[][] up = copyOf(tiles);
            swap(up, blankRow, blankCol, blankRow - 1, blankCol);
            neighbors.add(new Board(up));
        }
        if (blankRow < n - 1) {
            int[][] down = copyOf(tiles);
            swap(down, blankRow, blankCol, blankRow + 1, blankCol);
            neighbors.add(new Board(down));
        }
        if (blankCol > 0) {
            int[][] left = copyOf(tiles);
            swap(left, blankRow, blankCol, blankRow, blankCol - 1);
            neighbors.add(new Board(left));
        }
        if (blankCol < n - 1) {
            int[][] right = copyOf(tiles);
            swap(right, blankRow, blankCol, blankRow, blankCol + 1);
            neighbors.add(new Board(right));
        }
        return neighbors;
    }

    private int[][] copyOf(int[][] board) {
        int tmp = board.length;
        int[][] res = new int[tmp][tmp];
        for (int i = 0; i < tmp; i++) {
            for (int j = 0; j < tmp; j++) {
                res[i][j] = board[i][j];
            }
        }
        return res;
    }

    private void swap(int[][] board, int sRow, int sCol, int dRow, int dCol) {
        int tmp = board[sRow][sCol];
        board[sRow][sCol] = board[dRow][dCol];
        board[dRow][dCol] = tmp;
    }

    public Board twin() {
        int[][] tBoard = copyOf(tiles);
        if (blankRow != 0) {
            swap(tBoard, 0, 0, 0, 1);
        } else {
            swap(tBoard, 1, 0, 1, 1);
        }
        return new Board(tBoard);
    }

    public static void main(String[] args) {
    }
}
