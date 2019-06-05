package org.deb.codesignal.practice;

import java.math.BigInteger;
import java.util.*;

public class DigitUtil {
    public int pagesNumberingWithInk(int current, int numberOfDigits) {
        int p = String.valueOf(current).length();
        numberOfDigits -= p;
        while (numberOfDigits >= p) {
            p = String.valueOf(current + 1).length();
            if (p <= numberOfDigits) {
                numberOfDigits -= p;
                current++;
            }
        }
        System.out.println(numberOfDigits);
        return current;

    }

    public int goodSegment(List<Integer> badNumbers, int l, int r) {
        Collections.sort(badNumbers);
        int max = Integer.MIN_VALUE;
        int p = -1;
        int d = 0;
        int a = 0;
        for (int i = 0; i < badNumbers.size(); i++) {
             a = badNumbers.get(i);

            if (a >= l && a <= r) {

              d = a - p - 1;
              if (p==-1){
                  d = a - l;
              }
              if (d>max){
                  max = d;
              }

               p = a;
            }else if (a > r){
                d= r - p;
                if (d>max){
                    max = d;
                }
                break;
            }
        }

        a = badNumbers.get(badNumbers.size() -1);
        if (a < r){
            d = r - a;
            if (d>max){
                max = d;
            }
        }
        if (max == Integer.MIN_VALUE){
            return -1;
        }
        return max;
    }

    int[][] meanGroups(int[][] a) {
        LinkedHashMap<Double,List<Integer>> lhm = new LinkedHashMap<>();
        for (int i = 0; i < a.length; i++){
            double total =0.00;
            for (int j = 0; j < a[i].length; j++){
                total += a[i][j];
            }
            double avg = total / a[i].length;
            List<Integer> entry = lhm.get(avg);
            if (entry == null){
                entry = new ArrayList<>();
            }
            entry.add(i);
            lhm.put(avg,entry);
        }

        int[][] arr = new int[lhm.size()][];
        Set<Double> lhmKeys = lhm.keySet();
        Double[] keysArr = lhmKeys.toArray(new Double[0]);
        for (int i = 0; i < lhmKeys.size(); i++){
            List<Integer> entry = lhm.get(keysArr[i]);
            arr[i] = new int[entry.size()];
            for (int j = 0; j < entry.size(); j++){
                arr[i][j] = entry.get(j);
            }
        }

        return arr;

    }


    long concatenationsSum(int[] a) {

        long total = 0L;
        String form1 = "";
        String fromL = "";
        for (int i = 0; i < a.length; i++){
            total += new BigInteger(a[i]+""+a[i]).longValue();
            form1 += a[i];
            fromL += a[a.length-i-1];
            if (i > 0){
                total += new BigInteger(form1).longValue();
                total += new BigInteger(fromL).longValue();
            }
        }
        return total;
    }

}
