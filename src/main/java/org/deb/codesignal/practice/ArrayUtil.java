package org.deb.codesignal.practice;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.BiConsumer;

public class ArrayUtil {
    private int e;

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
                for (int a : p) {
                    if (i - a == distance) {
                        c++;
                    }
                }
            }
            p.add((i + 1));
            cm.put(ch, p);

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

    int kthLargestElement(int[] nums, int k) {
        List<Integer> l = new ArrayList<>();
        for (int e : nums) {
            l.add(e);
        }
        Collections.sort(l);
        if (k > l.size()) {
            return -1;
        }
        return l.get(l.size() - k);
    }

    public static String simplifyPath(String path) {
        String[] arr = path.split("/");
        Stack<String> dirQueue = new Stack<>();
        for (String e : arr) {
            e = e.trim();
            if (e.length() > 0) {
                if (!".".equals(e)) {
                    if (!"..".equals(e)) {
                        dirQueue.push(e);
                    } else {
                        if (!dirQueue.empty()) {
                            dirQueue.pop();
                        }
                    }
                }
            }

        }

        if (!dirQueue.empty()) {
            String[] a = dirQueue.toArray(new String[0]);
            StringBuilder sb = new StringBuilder();
            for (String e : a) {
                sb.append("/");
                sb.append(e);
            }
            return sb.toString();
        }
        return "/";
    }

    public String decodeString(String s) {
        Stack<Integer> operator = new Stack<>();
        Stack<String> operand = new Stack<>();
        StringBuilder word = new StringBuilder();
        StringBuilder decoded = new StringBuilder();
        int occurrence = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                if (word.length() > 0) {
                    operand.push(word.toString());
                    word.delete(0, word.length());
                }
                if (occurrence != -1) {
                    operator.push(occurrence);
                    occurrence = -1;
                }
            } else if (c == ']') {
                if (!operator.empty()) {
                    int n = operator.pop();
                    int a = 1;

                    String eachWord = word.toString();
                    if (word.length() == 0) {
                        eachWord = operand.pop();
                        word.append(eachWord);
                    }
                    while (a < n) {
                        a++;
                        word.append(eachWord);
                    }
                    if (!operand.isEmpty()) {
                        String existing = operand.pop();
                        operand.push(existing + word.toString());
                    } else {
                        operand.push(word.toString());
                    }
                    word.delete(0, word.length());
                }
            } else if (c >= '0' && c <= '9') {
                if (occurrence == -1) {
                    occurrence = c - '0';
                } else {
                    occurrence *= 10;
                    occurrence += c - '0';
                }

            } else {
                word.append(c);
            }
        }

        if (word.length() > 0) {
            operand.push(word.toString());
        }
        List<String> wordList = new ArrayList<>();
        while (!operand.isEmpty()) {
            wordList.add(operand.pop());
        }

        for (int i = wordList.size() - 1; i > -1; i--) {
            decoded.append(wordList.get(i));
        }

        return decoded.toString();
    }


    private void addWord(Stack<String> operand, StringBuilder word) {
        if (word.length() > 0) {
            operand.push(word.toString());
            word.delete(0, word.length());
        }
    }

    String[] sortByLength(String[] inputArray) {
        SortedMap<Integer, List<String>> ss = new TreeMap<>();
        for (String e : inputArray) {
            int l = e.length();
            List<String> sl = ss.get(l);
            if (sl == null) {
                sl = new ArrayList<>();
            }
            sl.add(e);
            ss.put(l, sl);
        }

        List<String> r = new ArrayList<>();
        ss.values().forEach(e -> e.forEach(fe -> r.add(fe)));
        return r.toArray(new String[0]);
    }


    String reverseInParentheses(String inputString) {
        StringBuilder complete = new StringBuilder();
        StringBuilder eachWord = new StringBuilder();
        int openBracketCount = 0;
        Stack<String> multipleBrcketContainer = new Stack<>();
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            switch (c) {
                case '(':
                    openBracketCount++;
                    if (eachWord.length() > 1) {
                        multipleBrcketContainer.push(eachWord.toString());
                        eachWord.delete(0, eachWord.length());
                    }
                    break;
                case ')':
                    if (openBracketCount == 1) {
                        if (eachWord.length() > 0) {
                            complete.append(eachWord.reverse().toString());
                            eachWord.delete(0, eachWord.length());
                        } else {
                            if (!multipleBrcketContainer.empty()) {
                                complete.append(new StringBuilder(multipleBrcketContainer.pop()).reverse());
                            }
                        }

                    } else {
                        String str = eachWord.reverse().toString();
                        multipleBrcketContainer.push(new StringBuilder(multipleBrcketContainer.pop()).append(str).toString());
                        eachWord.delete(0, eachWord.length());
                    }
                    openBracketCount--;
                    break;
                default:
                    if (openBracketCount == 0) {
                        complete.append(c);
                    } else {
                        eachWord.append(c);
                    }

                    break;
            }

        }
        return complete.toString();
    }

    boolean camelCaseSeparation(String[] words, String variableName) {


        boolean first = true;
        StringBuilder sb = new StringBuilder();
        boolean found = false;
        for (int i = 0; i < variableName.length(); i++) {
            char c = variableName.charAt(i);
            if (Character.isLowerCase(c)) {
                sb.append(c);
            } else {
                if (!first) {
                    String current = sb.toString();
                    found = false;
                    for (int a = 0; a < words.length; a++) {
                        if (current.equals(words[a])) {
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println(current);
                        return false;
                    }

                }
                first = false;
                sb.delete(0, sb.length());
                sb.append(Character.toLowerCase(c));
            }
        }

        if (sb.toString().length() > 0) {
            String current = sb.toString();
            for (int a = 0; a < words.length; a++) {
                if (current.equals(words[a])) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }


    int chessKnightMoves(String cell) {
        int r = cell.charAt(0) - 'a';
        int c = cell.charAt(1) - '1';
        int[] x = new int[]{-2, -2, -1, 1, 2, 2, -1, -1};
        int[] y = new int[]{-1, 1, 2, 2, 1, -1, -2, -2};
        int t = 0;
        for (int i = 0; i < x.length; i++) {
            int a = r + x[i];
            int b = c + y[i];
            if (a > -1 && a < 8 && b > -1 && b < 8) {
                t++;
            }
        }
        return t;
    }

    int smallestUnusualNumber(String a) {
        int c = 0;

        if (a.indexOf("0") < 0) {

            BigInteger n = new BigInteger(a);
            int i = n.intValue();
            if ((i > 9 && i < 22)) {
                return 0;
            }

            while (true) {
                BigInteger r = n.mod(BigInteger.TEN);

                if (a.length() > 1) {
                    if ((r.equals(BigInteger.ZERO))) {
                        break;
                    } else if (a.contains("1")) {
                        int s = 0;
                        for (int b = 0; b < a.length(); b++) {
                            s += a.charAt(b) - '0';
                        }

                        boolean m = false;
                        long p = 1;
                        for (int b = 0; b < a.length(); b++) {
                            p *= a.charAt(b) - '0';
                            if (p >= s) {
                                m = true;
                                break;
                            }
                        }

                        if (!m) {
                            return 0;
                        }
                    }
                }
                n = n.add(BigInteger.ONE);
                c++;
                a = n.toString();
            }
        }
        return c;
    }


    public String cipher26(String message) {
        StringBuilder sb = new StringBuilder();


        int pc = 0;
        for (int i = 0; i < message.length(); i++) {

            char c = message.charAt(i);
            int d = c - 'a';
            char f = 'a';
            if (d >= pc){
                f += ( d - pc);
            }else{
                f += ( 26 + d - pc);
            }

            pc = d;
            sb.append(f);
        }
        return sb.toString();

    }

    public String decipher26(String message) {
        StringBuilder sb = new StringBuilder();

        int t = 0;


        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            t += c - 'a';

            char f = 'a';
            f += t % 26;
            sb.append(f);

        }

        return sb.toString();

    }

    public int combs(String comb1, String comb2) {
        int m = comb1.length() + comb2.length();
        char[] arr = new char[m];
        System.arraycopy(comb1.toCharArray(), 0, arr, 0, comb1.length());
        System.arraycopy(comb2.toCharArray(), 0, arr, comb1.length(), comb2.length());


        for (int i = comb1.length() - 2; i > 0; i--) {
            boolean ok = true;
            boolean part2 = false;
//            int a = m - 1;
            char[] temp = new char[m];
            System.arraycopy(arr, 0, temp, 0, m);
            for (int j = 0; j < i + comb2.length(); j++) {
                if (temp[i] == '*' && comb2.charAt(j) == '*') {
                    ok = false;
                    break;
                } else {
                    int b = 0;
                    for (int a = i; a < i + comb2.length(); a++) {
                        if (temp[a] == '.') {
                            temp[a] = comb2.charAt(a - i);
                        }
                        b = a;
                    }
                    int c = arr.length - 1;
                    while (c > b && c > comb1.length() - 1) {
                        temp[c] = 'X';
                        c--;
                    }
                }
            }
            if (ok) {

                for (int a = arr.length - 1; a > -1; a--) {
                    if (temp[a] != 'X') {
                        m = a + 1;
                        break;
                    }
                }
            }

        }
        return m;
    }

    public int combs0(String comb1, String comb2) {
        return mergingCost(comb1, comb2);
    }

    public int mergingCost(String comb1, String comb2) {
        int l1 = comb1.length();
        int l2 = comb2.length();
        int m = 0;

        if (l1 > l2) {
            m = Math.min(traverse(comb1, comb2, l1, l2), traverse(comb1, reverse(comb2), l1, l2));

        } else {
            m = Math.min(traverse(comb2, comb1, l2, l1), traverse(comb2, reverse(comb1), l1, l2));
        }
        return m;
    }

    private String reverse(String comb2) {
        char[] r = new char[comb2.length()];
        int j = 0;
        for (int i = comb2.length() - 1; i > -1; i--) {
            r[j++] = comb2.charAt(i);
        }
        return String.valueOf(r);
    }

    public int traverse(String comb1, String comb2, int l1, int l2) {
        boolean ok = true;
        if (l1 - l2 >= 2) {
            for (int i = 1; i < comb1.length(); i++) {
                for (int j = 0; j < comb2.length(); j++) {
                    if (comb1.charAt(i) == '*' && comb2.charAt(j) == '*') {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    // best case
                    return l1;
                }
            }
        }

        // checking from front
        int f = 0;
        int e = 0;
        for (int i = 1; i < comb2.length(); i++) {
            ok = true;
            for (int a = 0; a < comb2.length() - 1; a++) {
                if (comb1.charAt(a) == '*' && (i + a) < l2 && comb2.charAt(i + a) == '*') {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                f = l1 + i;
                break;
            }
        }

        // checking from end
        for (int i = l1 - 2; i > 1; i--) {
            ok = true;
            for (int a = 0; a < l2 - i + 1; a++) {
                if (comb1.charAt(i) == '*' && comb2.charAt(a) == '*') {
                    ok = false;
                    break;
                }
            }
            if (ok) {

                e = l1 + l2 - i;

            }
        }


        if (f > 0 && e > 0) {
            return Math.min(f, e);
        } else if (f > 0) {
            return f;
        } else if (e > 0) {
            return e;
        }
        // worst case
        return l1 + l2;
    }
}
