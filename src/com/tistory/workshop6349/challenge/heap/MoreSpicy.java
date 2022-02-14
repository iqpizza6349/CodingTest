package com.tistory.workshop6349.challenge.heap;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class MoreSpicy {

    public static int solution(int[] scoville, int k) {
        // 1. 정렬
        // 2. 가장 낮은 거 2개씩 계산한다.
        // 3. k보다 높으면 중단

        Queue<Integer> scovilles = new PriorityQueue<>(); // 우선순위 큐
        for (int s : scoville) {
            scovilles.add(s);
        }
        boolean overK = false;
        int result = 0;

        while (!overK) {
            if (scovilles.isEmpty() || scovilles.size() == 1) {
                return -1;
            }

            int notSpicy = scovilles.poll();
            int lessSpicy = 0;
            if (!scovilles.isEmpty()) {
                lessSpicy= scovilles.poll();
            }

            scovilles.add(notSpicy + (lessSpicy * 2));
            result++;

            // 평균값이 k 이상이면 됨
            overK = isOverThan(scovilles, k);
        }

        return result;
    }
    
    public static boolean isOverThan(Queue<Integer> queue, int k) {
        for (int i : queue) {
            if (i < k) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(
                solution(
                        new int[]{1, 1}, 7
                )
        );
    }
}
