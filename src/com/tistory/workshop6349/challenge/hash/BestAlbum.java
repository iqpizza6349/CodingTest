package com.tistory.workshop6349.challenge.hash;

import java.util.*;

public class BestAlbum {

    /*
    장르, 횟수 HashMap 으로 설정
    classic, 500
    pop 600
    classic 150
    classic 800,
    pop 2500

    classic={[500, 150, 800]}
    pop={[600, 2500]}

    조건
    1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
    -> 해당 키에 위치한 values 를 전부 더한 값을 비교

    2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
    -> 해당 키에 위치한 values 가 가장 큰 값

    3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
    -> values 가 같을 경우 i 값이 낮은 순

     */

    public static int[] solution(String[] genres, int[] plays) {
        HashMap<String, ArrayList<Integer>> songs = new HashMap<>();        // 장르, 횟수
        HashMap<String, Integer> heardTimes = new HashMap<>();              // 장르, 총 횟수
        HashMap<Integer, Integer> unique = new HashMap<>();                 // 고유 번호, 횟수
        for (int i = 0; i < genres.length; i++) {
            // 장르를 키로 몇 번 들었는 지 넣기
            if (songs.containsKey(genres[i])) {
                songs.get(genres[i]).add(plays[i]);
            }
            else {
                songs.put(genres[i], new ArrayList<>());
                songs.get(genres[i]).add(plays[i]);
            }
            heardTimes.put(genres[i], heardTimes.getOrDefault(genres[i], 0) + plays[i]);
            unique.put(i, plays[i]);
        }

        ArrayList<Integer> answer = new ArrayList<>();
        List<String> genreList = new ArrayList<>(heardTimes.keySet());

        genreList.sort((o1, o2) -> (heardTimes.get(o2).compareTo(heardTimes.get(o1)))); // 내림차순으로 정렬
        for (String key : genreList) {

            if (songs.get(key).size() == 1) {
                for (int i : unique.keySet()) {
                    if (answer.contains(i)) {
                        continue;
                    }

                    if (Objects.equals(songs.get(key).get(0), unique.get(i))) {
                        answer.add(i);
                        break;
                    }
                }
            }
            else {
                // 횟수가 많으면 선택됨
                // 해당 key 로 arrayList 정렬 (내림차순)
                songs.get(key).sort(Comparator.reverseOrder());
                for (int j = 0; j < 2; j++) {
                    for (int i : unique.keySet()) {
                        if (answer.contains(i)) {
                            continue;
                        }

                        if (Objects.equals(songs.get(key).get(j), unique.get(i))) {
                            answer.add(i);
                            break;
                        }
                    }
                }
            }
        }

        int[] result = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

    public static void main(String[] args) {
        solution(
                new String[]{"classic", "pop", "rap", "classic", "classic", "pop"},
                new int[]{100, 200, 300, 100, 100, 200}
        );
    }
}
