package Leet.CodeChallenge;

import java.util.*;

public class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);

        int left = 0, right = Math.min(tasks.length, workers.length), ans = 0;


        while (left <= right) {
            System.out.println(left+" "+right);
            int mid = (left + right) / 2;
            if (canAssign(mid, tasks, workers, pills, strength)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }


    private boolean canAssign(int k, int[] tasks, int[] workers, int pills, int strength) {

        Deque<Integer> taskDeque = new ArrayDeque<>();
        for (int i = tasks.length - k; i < tasks.length; i++) {
            taskDeque.addLast(tasks[i]);
        }


        TreeMap<Integer, Integer> workerMap = new TreeMap<>();
        for (int i = workers.length - k; i < workers.length; i++) {
            workerMap.put(workers[i], workerMap.getOrDefault(workers[i], 0) + 1);
        }

        int remainingPills = pills;


        while (!taskDeque.isEmpty()) {
            int task = taskDeque.pollLast();

            // Try without pill
            Integer worker = workerMap.floorKey(task);
            if (worker != null) {
                removeWorker(workerMap, worker);
                continue;
            }


            if (remainingPills == 0) return false;

            worker = workerMap.floorKey(task - strength);
            if (worker != null) {
                removeWorker(workerMap, worker);
                remainingPills--;
            } else {
                return false;
            }
        }

        return true;
    }


    private void removeWorker(TreeMap<Integer, Integer> map, int key) {
        if (map.get(key) == 1) {
            map.remove(key);
        } else {
            map.put(key, map.get(key) - 1);
        }
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxTaskAssign(new int[]{3, 2, 1}, new int[]{0, 3, 3}, 1, 1));
        System.out.println(sol.maxTaskAssign(new int[]{5, 4}, new int[]{0, 0, 0}, 1, 5));
        System.out.println(sol.maxTaskAssign(new int[]{10, 15, 30}, new int[]{0, 10, 10, 10, 10}, 3, 10));
    }
}
