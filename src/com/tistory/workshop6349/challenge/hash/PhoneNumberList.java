package com.tistory.workshop6349.challenge.hash;

import java.util.Arrays;

public class PhoneNumberList {

    public static boolean solution(String[] phoneBook) {
        Arrays.sort(phoneBook);
        for (int i = 0; i < phoneBook.length - 1; i++) {
            if (phoneBook[i + 1].startsWith(phoneBook[i])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(
                solution(
                        new String[]{"119", "97674223", "1195524421"}
                )
        );
    }

}
