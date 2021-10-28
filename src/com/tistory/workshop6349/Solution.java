package com.tistory.workshop6349;

public class Solution {

    public int[] solution(int n, int m) {
        int[] answer = new int[2];

        int highNumber = Math.max(n, m);
        int lowNumber = Math.min(n, m);

        answer[0] = gcd(highNumber, lowNumber);
        answer[1] = (highNumber * lowNumber / gcd(highNumber, lowNumber));

        return answer;
    }

    public int gcd(int a, int b) {
        if (a==b) return 1;
        if (b == 0) return a;
        return gcd(b, a%b);
    }

}
