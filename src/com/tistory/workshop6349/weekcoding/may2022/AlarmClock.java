package com.tistory.workshop6349.weekcoding.may2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 2884
public class AlarmClock {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in)
        );
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        int H = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        // 45분을 뒤로 움직여야한다.
        // 분이 음수가 된다면 시에서 1을 뺀다.
        // 1을 뺐을 때, 음수가 된다면, 23으로 바꾼다.
        M -= 45;
        if (M < 0) {
            M += 60;
            H = (H - 1 < 0) ? 23 : H - 1;
        }
        System.out.printf("%d %d %n", H, M);

    }
}
