package com.tistory.workshop6349.challenge.stack;

import java.util.ArrayDeque;
import java.util.Queue;

public class Printer {

    /*
    중요한 문서가 뒤에 위치에 있으면
    현재 값을 맨 뒤로 보냄 (즉, 해당 문서가 맨 앞에 올때까지 계속 뒤로 보내 결국 0번째에 이동하게됨)

     */

    public static int solution(int[] priorities, int location) {
        Queue<Integer> papers = new ArrayDeque<>();
        for (int paper : priorities) {
            papers.add(paper);
        }

        int tempLocation = location;
        int result = 0;
        while (!papers.isEmpty()) {
            // 중복값이 있더라도 내 문서 위치를 정확하게 알아내야함

//            System.out.println("papers: " + papers + ", 위치: " + tempLocation);
            int current = papers.peek(); // 제일 처음 값
            if (isHighest(current, papers)) {
                // 현재 값이 제일 크다면
                papers.remove();

                if (tempLocation < 0) {
                    continue;
                }

                if (tempLocation == 0) {
                    tempLocation = -1;
                }
                result++;
                tempLocation--;
            }
            else {
                // 현재 값이 제일 크지 않다면
                papers.remove();
                papers.add(current);
                if (tempLocation == 0) {
                    tempLocation = papers.size() - 1;
                }
                else {
                    tempLocation--;
                }
            }
        }

        return result;
    }

    public static boolean isHighest(int current, Queue<Integer> papers) {
        for (int i : papers) {
            if (i > current) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(
                solution(new int[]{1, 9, 3, 8, 2, 1, 7}, 6)
        );
    }

}
