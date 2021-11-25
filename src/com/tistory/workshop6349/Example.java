package com.tistory.workshop6349;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Example {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int[][] puddle = new int[99][99];
        int count = 0;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                int s = br.read();
                s = Integer.parseInt(String.valueOf(s));
                while (s == 10) {
                    s = br.read();
                    s = Integer.parseInt(String.valueOf(s));
                }
                puddle[i][j] = s;
            }
        }
        HashMap<Integer, ArrayList<Integer>> hole = new HashMap<>();
        for (int i = 0; i < a; i++) {
            hole.put(i, new ArrayList<>());
        }
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b-1; j++) {
                if (puddle[i][j] == 48 && puddle[i][j+1] != 48) {
                    count++;
                    hole.get(i).add(j);
                }
            }
            if (puddle[i][b-1] == 48) {
                count++;
                hole.get(i).add(b-1);
            }
        }
        int temp = 0;
        for (int i = 0; i < hole.size(); i++) {
            for (int j = 0; j < hole.get(i).size(); j++) {
                int key = (int) hole.keySet().toArray()[i] + 1;
                if (key > a) {
                    continue;
                }
                if (hole.get(i).get(temp) -1 == -1 || hole.get(i).get(temp) + 1 == b) {
                    if (puddle[key][hole.get(i).get(temp)] == 48) {
                        count--;
                    }
                    continue;
                }
                if (puddle[key][hole.get(i).get(temp)] == 48 || puddle[key][hole.get(i).get(temp)-1] == 48 || puddle[key][hole.get(i).get(temp) + 1] == 48) {
                    count--;
                }
                temp++;
            }
            temp = 0;
        }
        System.out.println(count);
    }

}
