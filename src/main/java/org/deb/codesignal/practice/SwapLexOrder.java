package org.deb.codesignal.practice;

import java.util.*;

public class SwapLexOrder {

    String swapLexOrder(String str, int[][] pairs) {
        Map<Integer, Set<Integer>> pMap = new HashMap<>();

        for (int[] arr : pairs) {
            mapPositions(pMap, arr[0], arr[1]);
            mapPositions(pMap, arr[1], arr[0]);
        }

        char[] cArr = str.toCharArray();
        Map<Character, List<Integer>> cMap = createCharacterMap(cArr);

        Character[] arr = cMap.keySet().toArray(new Character[0]);

        System.out.println(pMap);
        boolean[] occupancy = new boolean[cArr.length];
        for (int i = arr.length - 1; i > -1; i--) {
            List<Integer> position = cMap.get(arr[i]);
            System.out.println(arr[i] + " positions " + position);
            Collections.sort(position);
            for (int a = position.size() - 1; a > -1; a--) {
                Set<Integer> individualMap = pMap.get(position.get(a));
                if (individualMap != null && !individualMap.isEmpty()) {
                    Integer[] replaceablePositions = individualMap.toArray(new Integer[0]);
                    Arrays.sort(replaceablePositions);
                    System.out.println(Arrays.toString(replaceablePositions));

                    if (!occupancy[replaceablePositions[0] - 1]) {
                        // replace

                        System.out.println(Arrays.toString(cArr) + " " + cMap);
                        char temp = cArr[position.get(a) - 1];
                        cArr[position.get(a) - 1] = cArr[replaceablePositions[0] - 1];
                        cArr[replaceablePositions[0] - 1] = temp;
                        occupancy[replaceablePositions[0] - 1] = true;

                        cMap = createCharacterMap(cArr);
                        System.out.println(Arrays.toString(cArr) + " " + cMap);
                        individualMap.remove(replaceablePositions[0]);
                    }

                }

            }
        }

        return String.valueOf(cArr);
    }

    public Map<Character, List<Integer>> createCharacterMap(char[] arr) {
        Map<Character, List<Integer>> cMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            List<Integer> cList = cMap.get(c);
            if (cList == null) {
                cList = new ArrayList<>();
            }
            cList.add(i + 1);
            cMap.put(c, cList);
        }
        return cMap;
    }

    public void mapPositions(Map<Integer, Set<Integer>> pMap, int n1, int n2) {
        Set<Integer> pList = pMap.get(n1);
        if (pList == null) {
            pList = new HashSet<>();
        }
        Set<Integer> n2List = pMap.get(n2);
        pList.add(n2);
        if (n2List != null) {
            pList.addAll(n2List);
            pList.remove(n1);
        }
        pMap.put(n1, pList);
    }


    String swapLexOrder1(String str, int[][] pairs) {

        SortedMap<Character, Integer> cMap = new TreeMap<>();
        int l = str.length();
        for (int i = 0; i < l; i++) {
            char c = str.charAt(i);
            cMap.put(c, i + 1);
        }
        System.out.println(cMap);

        char[] ret = str.toCharArray();


        int[] minMatrix = new int[l];
        for (int i = 0; i < l; i++) {
            minMatrix[i] = Integer.MAX_VALUE;
        }
        boolean[][] adjacencyMatrix = new boolean[str.length()][str.length()];
        for (int i = 0; i < pairs.length; i++) {
            adjacencyMatrix[pairs[i][0] - 1][pairs[i][1] - 1] = true;
            if (minMatrix[pairs[i][0] - 1] > pairs[i][1] - 1) {
                minMatrix[pairs[i][0] - 1] = pairs[i][1] - 1;
            }

            adjacencyMatrix[pairs[i][1] - 1][pairs[i][0] - 1] = true;
            if (minMatrix[pairs[i][1] - 1] > pairs[i][0] - 1) {
                minMatrix[pairs[i][1] - 1] = pairs[i][0] - 1;
            }
        }

        for (int i = 0; i < l; i++) {
            System.out.println(Arrays.toString(adjacencyMatrix[i]));
        }

        Character[] arr = cMap.keySet().toArray(new Character[0]);
        boolean[] occupied = new boolean[str.length()];
        for (int i = arr.length - 1; i > -1; i--) {
            Integer pos = cMap.get(arr[i]);
            if (pos != null) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < l; j++) {
                    if (adjacencyMatrix[pos - 1][j]) {
                        if (j < min) {
                            min = j;
                        }
                    }
                }
                if (min != Integer.MAX_VALUE && !occupied[min]) {
                    char temp = ret[pos - 1];
                    ret[pos - 1] = ret[min];
                    ret[min] = temp;
                    occupied[min] = true;
                }
            }
        }

        System.out.println(Arrays.toString(minMatrix));
        return String.valueOf(ret);

    }

    private void setPositions(int key, int value, Map<Integer, Set<Integer>> poistionalMap) {
        Set<Integer> currentPositions = poistionalMap.get(key);
        if (currentPositions == null) {
            currentPositions = new HashSet<>();
        }
        currentPositions.add(value);
        poistionalMap.put(key, currentPositions);
    }


    String swapLexOrder0(String str, int[][] pairs) {
        char[] arr = str.toCharArray();
        SortedSet<String> t = new TreeSet<>();

        if (pairs.length > 0) {


            for (int i = 0; ; i++) {

                i = i % pairs.length;

                char c = arr[pairs[i][0] - 1];

                if (arr[pairs[i][0] - 1] != arr[pairs[i][1] - 1]) {
                    arr[pairs[i][0] - 1] = arr[pairs[i][1] - 1];
                    arr[pairs[i][1] - 1] = c;
                    str = String.valueOf(arr);

                    if (!t.add(str)) {
                        System.out.println(String.format("Not able to add %s", str));
                        break;
                    }
                } else {
                    System.out.println("Same " + arr[pairs[i][0] - 1] + " " + arr[pairs[i][1] - 1]);
                }


            }
            String[] sarr = t.toArray(new String[0]);
            System.out.println(Arrays.toString(sarr));
            return sarr[sarr.length - 1];
        }

        return str;

    }


}
