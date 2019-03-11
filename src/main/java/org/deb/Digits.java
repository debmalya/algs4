package org.deb;

import java.util.*;

public class Digits {
    int[] digitDifferenceSort(int[] a) {
        int[] d = new int[a.length];
        SortedMap<Integer, List<Integer>> cm = new TreeMap<>();
        int s = a.length;
        for (int i = 0; i < s; i++) {
            d[i] = getD(a[i]);
            List<Integer> e = cm.get(d[i]);
            if (e == null) {
                e = new ArrayList();
            }
            e.add(i);
            cm.put(d[i], e);
        }

        Arrays.sort(d);


        List<Integer> r = new ArrayList<>();
        cm.forEach((k, v) -> {
                    Collections.sort(v);
                    for (int b = v.size() - 1; b > -1; b--) {
                        r.add(a[v.get(b)]);
                    }
                }
        );

        int[] c = new int[s];
        for (int f = 0; f < r.size(); f++) {
            c[f] = r.get(f);
        }


        return c;
    }

    int getD(int n) {
        List<Integer> d = new ArrayList<>();
        while (n > 0) {
            d.add(n % 10);
            n /= 10;
        }

        Collections.sort(d);
        return d.get(d.size() - 1) - d.get(0);
    }
}
