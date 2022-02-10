package com.tistory.workshop6349.challenge.stack;

import java.util.*;

public class FunctionDevelopment {

    /*
    이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.
    즉, 첫 번째 기능이 완성되기전에 두 번째 기능이 먼저 완성이 된다면,
    두 번째 기능 따로 배포하지는 못하고
    첫 번째 기능 배포할 때 같이 배포하게됨

    반복 횟수를 기억하는 변수 i를 저장
    현재 맨 아래(제일 첫 번째) 값에 i * speeds[인덱스]가 100이상이라면
    나머지도 위와 한 번에 처리후, 배열에 저장
    그후, 해당 큐 값들은 삭제시켜버림 (중복 제거)

     */

    public static int[] solution(int[] progresses, int[] speeds) {
        // Queue 을 사용할 수 도 단순 배열로 처리할 수도 있음 (ArrayList 포함)
        Queue<Integer> progressQueue = new ArrayDeque<>();

        for (int progress : progresses) {
            progressQueue.add(progress);
        }

        ArrayList<Integer> list = new ArrayList<>();

        int i = 0, index = 0, resultIndex = -1; // index 는 값이 사라질때만 올라감
        while (!progressQueue.isEmpty()) {
            // 전부 빌 때 동안 계속 반복함
            int currentProgress = progressQueue.peek() + (i * speeds[index]);

            int temp = i;
            while (currentProgress < 100) {
                currentProgress += (speeds[index]);   // 현재 값(임의)에 speeds 값만큼 추가
                i++;
            }
            // 만일 100이 넘었다면, 삭제시킴
            index++;
            if (temp == i) {
                // 값이 바뀌지않았다면, 그냥 때려넣고
                list.set(resultIndex, list.get(resultIndex) + 1);
            }
            else {
                // 아니라면, resultIndex 값을 변동을 줘서 넣어야함
                list.add(++resultIndex, 1);
            }
            progressQueue.remove();
        }
        System.out.println(i);

        int[] result = new int[list.size()];
        for (int j = 0; j < list.size(); j++) {
            result[j] = list.get(j);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})
                )
        );
    }

}
