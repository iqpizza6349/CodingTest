package com.tistory.workshop6349.common;

public class CensoredTelephone {

    public String solution(String phone_number) {
        int length = phone_number.length();
        phone_number = phone_number.substring(length-4);
        StringBuilder sb = new StringBuilder();
        sb.append("*".repeat(length-4));
        String string = sb.toString();
        phone_number = string + phone_number;
        return phone_number;
    }
}
