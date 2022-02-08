package com.tistory.workshop6349.challenge.sort;

import java.util.Arrays;

public class KthNumber {

    public static int[] solution(int[] array, int[][] commands) {
        int commandLength = commands.length;
        int[] answer = new int[commandLength];
        for (int i = 0; i < commandLength; i++) {
            int firstIndex = commands[i][0];
            int finalIndex = commands[i][1];
            int index = commands[i][2];
            if (firstIndex != finalIndex) {
                int[] temp = Arrays.copyOfRange(array, firstIndex - 1, finalIndex);
                Arrays.sort(temp);
                answer[i] = temp[index-1];
            }
            else {
                int temp = array[firstIndex-1];
                answer[i] = temp;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(solution(
                        new int[]{1, 5, 2, 6, 3, 7, 4},
                        new int[][]{
                                {2, 5, 3},
                                {4, 4, 1},
                                {1, 7, 3}
                        }
                ))
        );
    }

}
