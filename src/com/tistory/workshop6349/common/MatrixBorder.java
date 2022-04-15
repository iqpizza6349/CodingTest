package com.tistory.workshop6349.common;

import java.util.Arrays;

public class MatrixBorder {

    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] border = createBorder(rows, columns);
        int[] result = new int[queries.length];
        int i = 0;

        for (int[] query : queries) {
            int n = moveMatrix(border, query);
            result[i++] = n;
        }

        return result;
    }

    private int[][] createBorder(int rows, int columns) {
        int[][] border = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                border[i][j] = i * columns + j + 1;
            }
        }

        return border;
    }

    private int moveMatrix(int[][] border, int[] query) {
        // row: 가로, col: 세로
        int row1 = query[0] - 1;
        int col1 = query[1] - 1;
        int row2 = query[2] - 1;
        int col2 = query[3] - 1;

        int temp = border[row1][col1];  // 시작하는 위치
        int min = temp;

        // (row1, col1) -> (row2, col1)
        for (int i = row1; i < row2; i++) {
            border[i][col1] = border[i + 1][col1];
            if (min > border[i][col1]) {
                min = border[i][col1];
            }
        }

        // (row2, col1) -> (row2, col2)
        for (int i = col1; i < col2; i++) {
            border[row2][i] = border[row2][i + 1];
            if (min > border[row2][i]) {
                min = border[row2][i];
            }
        }

        // (row2, col2) -> (row1, col2)
        for (int i = row2; i > row1; i--) {
            border[i][col2] = border[i - 1][col2];
            if (min > border[i][col2]) {
                min = border[i][col2];
            }
        }

        // (row1, col2) -> (row1, col1)
        for (int i = col2; i > col1; i--) {
            border[row1][i] = border[row1][i - 1];
            if (min > border[row1][i]) {
                min = border[row1][i];
            }
        }

        border[row1][col1 + 1] = temp; // 임시 저장한 값 저장

        return min;
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(new MatrixBorder().solution(
                        6, 6, new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}}
                ))
        );
    }
}
