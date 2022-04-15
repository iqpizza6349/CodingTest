package com.tistory.workshop6349.common;

import java.util.Arrays;

public class Lotto {

    public int[] solution(int[] lottos, int[] winNums) {
        // 순서와 상관없이 해당 번호가 있기만 하면 맞춘거임
        LottoNumber lottoNumber = correctCount(lottos, winNums);
        int correctCount = lottoNumber.getCorrect();

        if (correctCount == 6) {
            return new int[]{1, 1};
        }

        return new int[]{rank(lottoNumber.getZero() + correctCount), rank(correctCount)};
    }

    private int rank(int n) {
        switch (n) {
            case 6: return 1;
            case 5: return 2;
            case 4: return 3;
            case 3: return 4;
            case 2: return 5;
            default: return 6;
        }
    }

    private LottoNumber correctCount(int[] lottos, int[] winNums) {
        int count = 0;
        int zero = 0;

        for (int lotto : lottos) {
            for (int num : winNums) {
                if (lotto == 0) {
                    zero++;
                    break;
                }
                if (lotto == num) {
                    count++;
                    break;
                }
            }
        }

        return new LottoNumber().setCorrect(count)
                .setZero(zero);
    }
    
    static class LottoNumber {
        private int correct;
        private int zero;

        public LottoNumber setCorrect(int correct) {
            this.correct = correct;
            return this;
        }

        public LottoNumber setZero(int zero) {
            this.zero = zero;
            return this;
        }

        public int getCorrect() {
            return correct;
        }

        public int getZero() {
            return zero;
        }
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Lotto().solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19})));
    }

}
