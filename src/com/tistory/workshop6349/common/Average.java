package com.tistory.workshop6349.common;

public class Average {

    public double solution(int[] arr) {
        double answer = 0;

        for (int i : arr) {
            answer += i;
        }

        return answer / arr.length;
    }
}
