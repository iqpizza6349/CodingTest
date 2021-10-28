package com.tistory.workshop6349;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveMinNumber {

    public int[] solution(int[] arr) {
        if (arr.length == 1) return new int[]{-1};
        Integer[] copy = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        int min = Arrays.stream(arr).min().getAsInt();

        List<Integer> list = new ArrayList<>(Arrays.asList(copy));

        list.remove((Integer) min);
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
