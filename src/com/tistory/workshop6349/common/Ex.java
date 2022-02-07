package com.tistory.workshop6349.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = Integer.parseInt(input);
        if (n == 3) {
            System.out.println((n+1) * 1920 + 3600);
            return;
        }
        System.out.println((n+1) * 1920);
    }
}