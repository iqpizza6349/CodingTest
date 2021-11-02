package com.tistory.workshop6349;

public class ReverseInteger {

    public long solution(long n) {
        String temp = String.valueOf(n);
        char[] chars = temp.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars.length -1 - i; j++) {
                if (chars[j] > chars[j+1]) {
                    char t = chars[j];
                    chars[j] = chars[j+1];
                    chars[j+1] = t;
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = chars.length-1; i >= 0; i--) {
            builder.append(chars[i]);
        }

        return Long.parseLong(builder.toString());
    }

}
