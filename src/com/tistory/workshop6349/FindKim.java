package com.tistory.workshop6349;

import java.util.Arrays;

public class FindKim {

    public String solution(String[] seoul) {
        return "김서방은 " + Arrays.asList(seoul).indexOf("Kim") + "에 있다.";
        
//        for(int i = 0; i < seoul.length; i++) {
//            if (seoul[i].equals("Kim")) {
//                return String.valueOf(i);
//            }
//        }
//        return "김서방은 " + String.valueOf(-1) + "에 있다.";
    }
}
