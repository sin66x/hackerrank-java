package com.behnam.hackerrank;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

// https://www.hackerrank.com/challenges/java-dequeue/problem
public class JavaDequeue {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();

        int n = in.nextInt();
        int m = in.nextInt();
        int maxUniques = Integer.MIN_VALUE;

        HashSet<Integer> uniques = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int input = in.nextInt();
            uniques.add(input);
            deque.add(input);
            if (deque.size() == m) {
                if (uniques.size() > maxUniques)
                    maxUniques = uniques.size();

                int first = (int) deque.remove();
                if (!deque.contains(first))
                    uniques.remove(first);
            }
        }
        System.out.println(maxUniques);
    }
}