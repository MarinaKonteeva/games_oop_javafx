package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        boolean rsl = false;
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == 1 && (checkV(board, i) || checkG(board, i))) {
                rsl = true;
                break;
            }
        }

        return rsl;
    }

    public static boolean checkV(int[][] board, int i) {
        boolean rsl = true;
        for (int j = 0; j < board.length; j++) {
            if (board[j][i] != 1) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

    public static boolean checkG(int[][] board, int i) {
        boolean rsl = true;
        for (int j = 0; j < board[i].length; j++) {
            if (board[i][j] != 1) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

}

