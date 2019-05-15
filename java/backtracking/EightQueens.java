package backtracking;

public class EightQueens {

    private final int[] pos = new int[8];

    private int cnt = 0;

    public static void main(String[] args) {
        EightQueens eq = new EightQueens();
        eq.putAt(0);
        System.out.println(eq.cnt);
    }

    private void putAt(int row) {
        if (row == 8) {
            printPos(pos);
            cnt++;
            System.out.println();
            return;
        }

        for (int col = 0; col < 8; col++) {
            if (isValid(row, col)) {
                pos[row] = col;
                putAt(row + 1);
            }
        }
    }

    private boolean isValid(int row, int col) {
        int leftUpCol = col - 1;
        int rightUpCol = col + 1;
        for (int i = row - 1; i > -1; i--) {
            if (pos[i] == col || pos[i] == leftUpCol || pos[i] == rightUpCol) {
                return false;
            }
            leftUpCol--;
            rightUpCol++;
        }
        return true;
    }

    private void printPos(int[] pos) {
        for (int i = 0; i < 8; i++) {
            int p = pos[i];
            for (int j = 0; j < p; j++) {
                System.out.print("x ");
            }
            System.out.print("Q ");
            for (int j = p + 1; j < 8; j++) {
                System.out.print("x ");
            }
            System.out.println();
        }
    }
}
