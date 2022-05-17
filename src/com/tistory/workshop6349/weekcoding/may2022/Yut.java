package com.tistory.workshop6349.weekcoding.may2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 2490
public class Yut {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in)
        );
        Yut yut = new Yut();
        for (int i = 0; i < 3; i++) {
            String input = bufferedReader.readLine();
            System.out.println(yut.parseYut(input));
        }
    }

    private char parseYut(String yutString) {
        int oneCount = parseCount(yutString, '1');
        if (oneCount == 4) {
            return 'E';
        }

        int zeroCount = parseCount(yutString, '0');
        char result = 'A';
        switch (zeroCount) {
            case 4: result = 'D'; break;
            case 3: result = 'C'; break;
            case 2: result = 'B'; break;
        }
        return result;
    }

    private int parseCount(String yutString, char target) {
        return yutString.length() -
                yutString.replace(String.valueOf(target), "")
                        .length();
    }
}
