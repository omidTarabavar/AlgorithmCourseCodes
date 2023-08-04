import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Solver {
    private SearchNode solution;
    private boolean solvable;

    public Solver(Board initial) {
        if (initial == null)
            throw new IllegalArgumentException();
        MinPQ<SearchNode> minPQ;
        minPQ = new MinPQ<>();
        minPQ.insert(new SearchNode(initial, 0, null));
        solution = null;
        solvable = true;
        while (solution == null && solvable) {
            SearchNode cur = minPQ.delMin();
            Board curBoard = cur.getBoard();
            if (curBoard.isGoal()) {
                solvable = true;
                solution = cur;
            } else if (curBoard.twin().isGoal()) {
                solvable = false;
            } else {
                int moves = cur.moves;
                Board prevBoard;
                if (moves > 0)
                    prevBoard = cur.getPrev().getBoard();
                else
                    prevBoard = null;
                for (Board nextBoard : curBoard.neighbors()) {
                    if (!nextBoard.equals(prevBoard))
                        minPQ.insert(new SearchNode(nextBoard, moves + 1, cur));
                }
            }
        }
    }

    public boolean isSolvable() {
        return solvable;
    }

    public int moves() {
        return isSolvable() ? solution.getMoves() : -1;
    }

    public Iterable<Board> solution() {
        if (!isSolvable())
            return null;
        Stack<Board> solStack = new Stack<>();
        SearchNode solCur = solution;
        while (solCur != null) {
            solStack.push(solCur.board);
            solCur = solCur.prev;
        }
        return solStack;
    }

    public static void main(String[] args) {

        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] tiles = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                tiles[i][j] = in.readInt();
        Board initial = new Board(tiles);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }

    private class SearchNode implements Comparable<SearchNode> {
        private final SearchNode prev;
        private final Board board;
        private final int moves;
        private final int priority;

        SearchNode(Board board, int moves, SearchNode prev) {
            this.board = board;
            this.moves = moves;
            this.prev = prev;
            this.priority = priority();
        }

        private int priority() {
            return board.manhattan() + moves;
        }

        public int getPriority() {
            return priority;
        }

        public SearchNode getPrev() {
            return prev;
        }

        public Board getBoard() {
            return board;
        }

        public int getMoves() {
            return moves;
        }

        @Override
        public int compareTo(SearchNode obj) {
            return this.getPriority() - obj.getPriority();
        }
    }
}
