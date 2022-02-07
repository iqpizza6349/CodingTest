package com.tistory.workshop6349.challenge.hash;

import java.util.Arrays;

public class DidntFinishAthletes {

    // 완주하지 못한 선수

    public static String solution(String[] participant, String[] completion) {
        // 선수 목록에는 있지만, 완주자 목록에 없으면
        // 해당 선수 이름을 반환

        // 둘 다 정렬하면 해당 위치에 동일한 이름이 올라갈 것임
        Arrays.sort(participant);
        Arrays.sort(completion);

        int i;
        for (i = 0; i < completion.length; i++) {
            if (!completion[i].equals(participant[i])) {
                return participant[i];
            }
        }

        return participant[i];
    }

    public static void main(String[] args) {
        System.out.println(solution(
                new String[]{"leo", "kiki", "eden"},
                new String[]{"kiki", "eden"}
                ));
    }

}
