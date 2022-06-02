package com.tistory.workshop6349.weekcoding.june2022;

import java.io.*;
import java.util.StringTokenizer;

// 백준 3048
public class AntSort {

    static class Ant {
        private final char value;
        private final int direction;

        public Ant(char value, int direction) {
            this.value = value;
            this.direction = direction;
        }
    }

    public static void main(String[] args) {
        // 1번째 그룸의 개미들은 반대방향으로 이동을 하고
        // 2번째 그룹의 개미들은 정방향으로 이동을 한다.
        // n 초가 흐른 뒤에는 1번째 그룹이 점프를 하여 최종 정렬상태를 확인한다.
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in)
        )) {
            StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
            int aGroupSize = Integer.parseInt(tokenizer.nextToken());
            int bGroupSize = Integer.parseInt(tokenizer.nextToken());

            Ant[] aGroup = new Ant[aGroupSize + 1];
            Ant[] bGroup = new Ant[bGroupSize + 1];

            String input = bufferedReader.readLine();
            for (int i = aGroupSize - 1; i >= 0; i--) {
                aGroup[i] = new Ant(input.charAt(aGroupSize - i - 1), 1);
            }

            input = bufferedReader.readLine();
            for (int i = 0; i < bGroupSize; i++) {
                bGroup[i] = new Ant(input.charAt(i), - 1);
            }

            Ant[] start = new Ant[aGroupSize + bGroupSize];
            if (aGroupSize >= 0) {
                System.arraycopy(aGroup, 0, start, 0, aGroupSize);
            }
            if (aGroupSize + bGroupSize - aGroupSize >= 0) {
                System.arraycopy(bGroup, 0, start, aGroupSize, aGroupSize + bGroupSize - aGroupSize);
            }
            int times = Integer.parseInt(bufferedReader.readLine());

            for (int i = 0; i < times; i++) {
                Ant[] current = start.clone();
                for (int j = 0; j < aGroupSize + bGroupSize - 1; j++) {
                    if (current[j].direction == 1 && current[j + 1].direction == -1) {
                        Ant temp = current[j];
                        start[j] = current[j + 1];
                        start[j + 1] = temp;
                    }
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < aGroupSize + bGroupSize; i++) {
                stringBuilder.append(start[i].value);
            }
            System.out.println(stringBuilder);
        } catch (IOException ignored) {
        }
    }
}
