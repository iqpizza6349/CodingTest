package com.tistory.workshop6349.challenge.hash;

import java.util.HashMap;
import java.util.Map;

public class Disguise {

    public static int solution(String[][] clothes) {
        HashMap<String, Integer> parts = new HashMap<>();

        for (String[] clothe : clothes) {
            String key = clothe[1];
            parts.put(key, parts.getOrDefault(key, 0) + 1);
        }

        int answer = 1;

        for (Map.Entry<String, Integer> entry : parts.entrySet()) {
            answer *= entry.getValue() + 1;
        }

        return answer - 1;
    }

    public static void main(String[] args) {
        System.out.println(
                solution(
                        new String[][]{
                                {"yellowhat", "headgear"},
                                {"bluesunglasses", "eyewear"},
                                {"green_turban", "headgear"}
                        }
                )
        );
    }
}
