package com.tistory.workshop6349.common;

public class HasshadNumber {

    public boolean solution(int x) {
        int y = x;
        if (x < 10) {
            return true;
        }
        int tenThousand = x / 10000;
        x %= 10000;
        int thousand = x / 1000;
        x %= 1000;
        int hundred = x / 100;
        x %= 100;
        int ten = x / 10;
        x %= 10;
        int one = x;

        int sum = tenThousand + thousand + hundred + ten + one;
        return y % sum == 0;
    }


}
