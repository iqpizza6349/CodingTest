package com.tistory.workshop6349.challenge.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;

public class TruckBridge {

    public static class Truck {
        private final int weight;
        private int moved;

        public Truck(int weight) {
            this.weight = weight;
            this.moved = 0;
        }

        public int getWeight() {
            return weight;
        }

        public void move() {
            moved++;
        }

        public int getMoved() {
            return moved;
        }
    }

    public static int solution(int bridgeLength, int weight, int[] truckWeights) {
        Queue<Truck> trucks = new ArrayDeque<>();
        for (int truck : truckWeights) {
            trucks.add(new Truck(truck));
        }

        int i = 0;
        ArrayList<Truck> bridge = new ArrayList<>();    // 다리
        while(!trucks.isEmpty() || !bridge.isEmpty()) {
            for (Iterator<Truck> truckIterator = bridge.iterator(); truckIterator.hasNext();) {
                Truck currentTruck = truckIterator.next();
                currentTruck.move();
                if (currentTruck.getMoved() >= bridgeLength) {
                    truckIterator.remove();
                }
            }

            int weights = 0;
            for (Truck bridgeTruck : bridge) {
                weights += bridgeTruck.getWeight();
            }

            if (!trucks.isEmpty()) {
                if (weights + trucks.peek().getWeight() <= weight) {
                    bridge.add(trucks.poll());
                }
            }
            i++;
        }

        return i;
    }

    public static void main(String[] args) {
        System.out.println(solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10}));
    }

}
