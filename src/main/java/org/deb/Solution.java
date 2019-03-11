package org.deb;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Solution {
    /*
     * Complete the contacts function below.
     */
    static int[] contacts(String[][] queries) {
        /*
         * Write your code here.
         */
        StringBuilder sb = new StringBuilder();
        Map<String,Integer> wMap = new HashMap<>();
        List<Integer> counts = new ArrayList<>();
        for (int queriesRowItr = 0; queriesRowItr < queries.length; queriesRowItr++) {

                System.out.println(queries[queriesRowItr][0]+" " + queries[queriesRowItr][1]);
                if ("add".equals(queries[queriesRowItr][0])){
                    sb.delete(0,sb.length());
                    for (int i = 0; i < queries[queriesRowItr][1].length(); i++){
                        sb.append(queries[queriesRowItr][1].charAt(i));
                        String str = sb.toString();
                        Integer c =  wMap.get(str);
                        if (c == null){
                            c = 0;
                        }
                        c++;
                        wMap.put(str,c);
                    }

                }else if ("find".equals(queries[queriesRowItr][0])){
                    counts.add(wMap.get(queries[queriesRowItr][1]));
                }

        }

        int[] c_arr = new int[counts.size()];
        for (int i = 0; i < counts.size(); i++){
            c_arr[i] = counts.get(i);
        }
        return c_arr;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int queriesRows = Integer.parseInt(scanner.nextLine().trim());

        String[][] queries = new String[queriesRows][2];

        for (int queriesRowItr = 0; queriesRowItr < queriesRows; queriesRowItr++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");

            for (int queriesColumnItr = 0; queriesColumnItr < 2; queriesColumnItr++) {
                String queriesItem = queriesRowItems[queriesColumnItr];
                queries[queriesRowItr][queriesColumnItr] = queriesItem;
            }
        }

        int[] result = contacts(queries);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
