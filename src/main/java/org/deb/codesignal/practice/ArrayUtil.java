package org.deb.codesignal.practice;

import java.util.*;

public class ArrayUtil {
    public int[] arrayCenter(int[] a) {
        if (a.length > 0) {
            Arrays.sort(a);

            List<Integer> intList = new ArrayList<>();
            // Calculate average
            int avg = 0;
            for (int i : a) {
                avg += i;
            }
            avg /= a.length;
            for (int i : a) {
                if (Math.abs(i - avg) < a[0]) {
                    intList.add(i);
                }
            }

            int[] b = new int[intList.size()];
            for (int i = 0; i < intList.size(); i++) {
                b[i] = intList.get(i);
            }
            return b;
        }

        return null;

    }

    public int countDistantPairs(String inputString, int distance) {
        Map<Character, List<Integer>> cm = new HashMap<>();
        int c = 0;
        for (int i = 0; i < inputString.length(); i++) {
            char ch = inputString.charAt(i);
            List<Integer> p = cm.get(ch);
            if (p == null) {
                p = new ArrayList<>();
            } else {
                for(int a:p){
                    if (i-a==distance){
                        c++;
                    }
                }
            }
            p.add((i + 1));
            cm.put(ch,p);

        }
        return c;
    }

    public int countDistantPairs0(String inputString, int distance) {
        int[] l = new int[26];
        int c = 0;
        for (int i = 0; i < inputString.length(); i++) {
            int p = inputString.charAt(i) - 'a';

            if (l[p] != 0 && i - l[p] == distance) {
                c++;
            }
            l[p] = i + 1;
        }
        return c;
    }

}
