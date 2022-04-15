package com.tistory.workshop6349.common;

import java.util.Arrays;
import java.util.HashMap;

public class Toothpaste {

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, Employee> employeeHashMap = new HashMap<>();

        for (String name : enroll) {
            employeeHashMap.put(name, new Employee(0, null));
        }
        int enrollLength = enroll.length;
        int sellLength = seller.length;

        for (int i = 0; i < enrollLength; i++) {
            if (referral[i].equals("-")) {
                continue;
            }
            employeeHashMap.get(enroll[i]).employee = employeeHashMap.get(referral[i]);
        }

        for (int i = 0; i < sellLength; i++) {
            employeeHashMap.get(seller[i]).calcProfit(amount[i] * 100);
        }

        int[] result = new int[enrollLength];

        for (int i = 0; i < result.length; i++) {
            result[i] = employeeHashMap.get(enroll[i]).profit;
        }

        return result;
    }

    static class Employee {
        private int profit;
        private Employee employee;

        public Employee(int profit, Employee employee) {
            this.profit = profit;
            this.employee = employee;
        }

        public void calcProfit(int profit) {
            int profitToRecommender = profit / 10;
            this.profit += profit - profitToRecommender;
            if (this.employee != null && profitToRecommender >= 1) {
                this.employee.calcProfit(profitToRecommender);
            }

        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                new Toothpaste().solution(
                        new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                        new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                        new String[]{"young", "john", "tod", "emily", "mary"},
                        new int[]{12, 4, 2, 5, 10}
                )
        ));
    }
}
