package com.tistory.workshop6349.weekcoding.may2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 백준 10798
public class ReadLength {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in)
        );
        HashMap<Integer, ArrayList<Character>> inputHashMap = new HashMap<>();
        int maxLength = 1;

        for (int i = 0; i < 5; i++) {
            char[] input = bufferedReader.readLine().toCharArray();
            inputHashMap.put(i, new ArrayList<>());
            for (char c : input) {
                inputHashMap.get(i).add(c);
            }
            if (maxLength < input.length) {
                maxLength = input.length;
            }
        }
        
        for (int i = 0; i < maxLength; i++) {
            for (int j = 0; j < 5; j++) {
                try {
                    System.out.printf("%c", inputHashMap.get(j).get(i));
                } catch (IndexOutOfBoundsException e) {
                    // 오류 해결을 위한 블럭에 불과함
                }
            }
        }
    }
}
