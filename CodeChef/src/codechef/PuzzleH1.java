package codechefprojects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    https://www.codechef.com/problems/H1
 */
public class PuzzleH1 {

    public static final int PUZZLE_SIZE = 3;
    public static final boolean[] IS_PRIME = {false, false, true, true, false, true, false, true, false, false, false, true, false, true, false, false, false, true};
    public static java.util.Map<codechefprojects.PuzzleH1.PuzzleState, Integer> reachableStates;

    public static class PuzzleState {

        private final int[][] puzzle = new int[PUZZLE_SIZE][PUZZLE_SIZE];
        private int level = 0;
        private int signature = 0;

        public PuzzleState() {
        }

        public PuzzleState(PuzzleState pattern) {
            this.level = pattern.level;
            this.signature = pattern.signature;
            for (int row = 0; row < puzzle.length; ++row) {
                for (int col = 0; col < puzzle[row].length; ++col) {
                    puzzle[row][col] = pattern.puzzle[row][col];
                }
            }
        }

        public PuzzleState(int[][] pattern, int level) {
            this.level = level;
            for (int row = 0; row < pattern.length; ++row) {
                for (int col = 0; col < pattern[row].length; ++col) {
                    puzzle[row][col] = pattern[row][col];
                }
            }
            calculateSignature();
        }

        private void calculateSignature() {
            signature = 0;
            for (int row = 0; row < puzzle.length; ++row) {
                for (int col = 0; col < puzzle[row].length; ++col) {
                    signature = signature * 10 + puzzle[row][col];
                }
            }
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public void incLevel() {
            level++;
        }

        public int getLevel() {
            return level;
        }

        public java.util.Set<codechefprojects.PuzzleH1.PuzzleState> getPossibleMoves() {
            java.util.Set<codechefprojects.PuzzleH1.PuzzleState> result = new java.util.HashSet<>();

            for (int row = 0; row < puzzle.length - 1; ++row) {
                for (int col = 0; col < puzzle[row].length; ++col) {
                    if (canSwap(row, col, row + 1, col)) {
                        result.add(swapAndGet(row, col, row + 1, col));
                    }
                }

                for (int col = 0; col < puzzle[row].length - 1; ++col) {
                    if (canSwap(row, col, row, col + 1)) {
                        result.add(swapAndGet(row, col, row, col + 1));
                    }
                }
            }

            // check the last row
            int row = puzzle.length - 1;
            for (int col = 0; col < puzzle[row].length - 1; ++col) {
                if (canSwap(row, col, row, col + 1)) {
                    result.add(swapAndGet(row, col, row, col + 1));
                }
            }

            return result;
        }

        public boolean canSwap(int firstRow, int firstCol, int secondRow, int secondCol) {
            return (IS_PRIME[puzzle[firstRow][firstCol] + puzzle[secondRow][secondCol]]);
        }

        public codechefprojects.PuzzleH1.PuzzleState swapAndGet(int firstRow, int firstCol, int secondRow, int secondCol) {
            codechefprojects.PuzzleH1.PuzzleState copy = new codechefprojects.PuzzleH1.PuzzleState(this);

            int tmp = copy.puzzle[firstRow][firstCol];
            copy.puzzle[firstRow][firstCol] = copy.puzzle[secondRow][secondCol];
            copy.puzzle[secondRow][secondCol] = tmp;

            copy.incLevel();
            copy.calculateSignature();
            return copy;
        }

        public static codechefprojects.PuzzleH1.PuzzleState getGoal() {
            codechefprojects.PuzzleH1.PuzzleState goalState = new codechefprojects.PuzzleH1.PuzzleState();

            int counter = 1;
            for (int row = 0; row < goalState.puzzle.length; ++row) {
                for (int col = 0; col < goalState.puzzle[row].length; col++) {
                    goalState.puzzle[row][col] = counter++;
                }
            }

            goalState.calculateSignature();
            return goalState;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null) {
                return false;
            }

            if (!(o instanceof codechefprojects.PuzzleH1.PuzzleState)) {
                return false;
            }
            return (signature == ((PuzzleState) o).signature);

        }

        @Override
        public int hashCode() {
            return signature;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int row = 0; row < puzzle.length; ++row) {
                for (int col = 0; col < puzzle[row].length; ++col) {
                    if (col != 0) {
                        sb.append(" ");
                    }
                    sb.append(puzzle[row][col]);
                }
                sb.append("\n");
            }

            return sb.toString();
        }
    }

    public static java.util.Map<codechefprojects.PuzzleH1.PuzzleState, Integer> calculateReachableStates(codechefprojects.PuzzleH1.PuzzleState initialState) {
        java.util.Map<codechefprojects.PuzzleH1.PuzzleState, Integer> reachable = new java.util.HashMap<>(200000);

        java.util.Deque<codechefprojects.PuzzleH1.PuzzleState> toSearch = new java.util.LinkedList<>();

        toSearch.add(initialState);

        while (toSearch.size() > 0) {

            codechefprojects.PuzzleH1.PuzzleState actualState = toSearch.removeFirst();
            if (reachable.containsKey(actualState)) {
                continue;
            }
            reachable.put(actualState, actualState.getLevel());
            for (codechefprojects.PuzzleH1.PuzzleState newState : actualState.getPossibleMoves()) {
                if (!reachable.containsKey(newState)) {
                    toSearch.addLast(newState);
                }
            }
        }
        return reachable;
    }

    public static void main(String[] args) throws IOException {

        reachableStates = calculateReachableStates(codechefprojects.PuzzleH1.PuzzleState.getGoal());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer testCases = Integer.parseInt(br.readLine());
        codechefprojects.PuzzleH1.PuzzleState goalState = codechefprojects.PuzzleH1.PuzzleState.getGoal();

        for (int tc = 0; tc < testCases; ++tc) {
            br.readLine(); // skip empty line
            codechefprojects.PuzzleH1.PuzzleState startingState = new codechefprojects.PuzzleH1.PuzzleState();
            for (int row = 0; row < startingState.puzzle.length; ++row) {
                String[] rowData = br.readLine().split("\\s+");
                for (int col = 0; col < startingState.puzzle[row].length; ++col) {
                    startingState.puzzle[row][col] = java.lang.Integer.parseInt(rowData[col]);
                }
            }
            startingState.calculateSignature();

            if (reachableStates.containsKey(startingState)) {
                System.out.println(reachableStates.get(startingState));
            } else {
                System.out.println(-1);
            }
        }
    }
}

/*

Input:
2

7 3 2
4 1 5 
6 8 9 

9 8 5 
2 4 1 
3 7 6

Output;
6
-1

 */
