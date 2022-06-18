package com.tistory.workshop6349.weekcoding.june2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 2609 (유클리드 호제법)
public class EuclideanAlgorithm {

    private static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    private static int lcm(int a, int b, int gcd) {
        return a * b / gcd;
    }

    public static void main(String[] args) {
        int x = 0, y = 0, r = 1;

        try (final BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in)
        )) {
            StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
            x = Integer.parseInt(tokenizer.nextToken());
            y = Integer.parseInt(tokenizer.nextToken());
        } catch (IOException ignored) {}

        if (x <= 0 || y <= 0) {
            return;
        }

        int gcd = gcd(x, y);
        System.out.printf("%d%n", gcd);
        System.out.printf("%d%n", lcm(x, y, gcd));
    }
}
