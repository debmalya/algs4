package org.deb.codesignal.practice;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

public class SwapLexOrder {

    String swapLexOrder(String str, int[][] pairs) {
        char[] arr = str.toCharArray();
        SortedSet<String> t = new TreeSet<>();

        if (pairs.length > 0){


            for (int i = 0; t.add(str); i++){
                if (i == pairs.length){
                    i = 0;
                }


                if ((pairs[i][0] - 1 < pairs[i][1] - 1) && arr[pairs[i][1] - 1]-'a'>arr[pairs[i][0] - 1]-'a'){
                    char c = arr[pairs[i][0] - 1];
                    arr[pairs[i][0] - 1] = arr[pairs[i][1] - 1];
                    arr[pairs[i][1] - 1] = c;
                    str = String.valueOf(arr);
                }


            }
            String[] sarr = t.toArray(new String[0]);
            System.out.println(Arrays.toString(sarr));
            return sarr[sarr.length-1];
        }

        return str;

    }

    String swapLexOrder0(String str, int[][] pairs) {
        char[] arr = str.toCharArray();
        SortedSet<String> t = new TreeSet<>();

        if (pairs.length > 0){


            for (int i = 0; t.add(str); i++){
                if (i == pairs.length){
                    i = 0;
                }
                char c = arr[pairs[i][0]-1];

                arr[pairs[i][0]-1] = arr[pairs[i][1]-1];
                arr[pairs[i][1]-1] = c;
                str = String.valueOf(arr);

            }
            String[] sarr = t.toArray(new String[0]);
            System.out.println(Arrays.toString(sarr));
            return sarr[sarr.length-1];
        }

        return str;

    }



}
