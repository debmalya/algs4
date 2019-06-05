package org.deb.codesignal.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CatHouse {

    public int[] houseOfCats(int legs) {
        Set<Integer> ls = new HashSet<>();

        int  np = legs / 2;
        if (legs%2 == 0) {
            ls.add(np);
        }

        while (np>=0){
            if ((legs - (np * 2))%4==0){
                ls.add(np);
            }
            np--;
        }


        int[] arr = new int[ls.size()];
        int i = 0;
        Iterator<Integer> legrator = ls.iterator();
        while (legrator.hasNext()){
            arr[i++] = legrator.next();
        }
        Arrays.sort(arr);
        return arr;
    }

}
