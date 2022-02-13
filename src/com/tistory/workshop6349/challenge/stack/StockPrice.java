package com.tistory.workshop6349.challenge.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class StockPrice {

    public static int[] solution(int[] prices) {
        Queue<Integer> stockPrices = new ArrayDeque<>();
        for (int price : prices) {
            stockPrices.add(price);
        }

        int i = 0;
        int[] result = new int[prices.length];
        while (!stockPrices.isEmpty()) {
            int currentPrice = stockPrices.poll(); // 삭제 및 값 가져옴

            int countPriceFalls = getTimeWhenFalls(currentPrice, stockPrices); // 가격이 떨어지기까지 버틴 시간

            result[i++] = countPriceFalls;
        }

        return result;
    }

    public static int getTimeWhenFalls(int currentPrice, Queue<Integer> leftStocks) {
        int i = 0;
        for (int price : leftStocks) {
            i++;
            if (price < currentPrice) {
                break;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 2, 3})));
    }

}
