package Hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


class Result {

    /*
     * Complete the 'reformatDate' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY dates as parameter.
     */

    public static List<String> reformatDate(List<String> dates) {
        // Write your code here
        List<String> formattedDate = new ArrayList<>();

        for (int i = 0; i < dates.size(); i++) {
            String[] dateParts = dates.get(i).split("\\s");
            StringBuilder sb = new StringBuilder(dateParts[2]);
            sb.append("-");

            if (dateParts[1].equalsIgnoreCase("Jan")) {
                sb.append("01");
            } else if (dateParts[1].equalsIgnoreCase("Feb")) {
                sb.append("02");
            } else if (dateParts[1].equalsIgnoreCase("Mar")) {
                sb.append("03");
            } else if (dateParts[1].equalsIgnoreCase("Apr")) {
                sb.append("04");
            } else if (dateParts[1].equalsIgnoreCase("May")) {
                sb.append("05");
            } else if (dateParts[1].equalsIgnoreCase("Jun")) {
                sb.append("06");
            } else if (dateParts[1].equalsIgnoreCase("Jul")) {
                sb.append("07");
            } else if (dateParts[1].equalsIgnoreCase("Aug")) {
                sb.append("08");
            } else if (dateParts[1].equalsIgnoreCase("Sep")) {
                sb.append("09");
            } else if (dateParts[1].equalsIgnoreCase("Oct")) {
                sb.append("10");
            } else if (dateParts[1].equalsIgnoreCase("Nov")) {
                sb.append("11");
            } else if (dateParts[1].equalsIgnoreCase("Dec")) {
                sb.append("12");
            }
            sb.append("-");

            String day = "";
            for (int j = 0; j < dateParts[0].length(); j++) {
                char eachChar = dateParts[0].charAt(j);
                if (eachChar >= '0' && eachChar <= '9'){
                    day+=eachChar;
                }
            }
            if (day.length()<2){
                sb.append("0");
            }
            sb.append(day);
            formattedDate.add(sb.toString());
        }
        return formattedDate;

    }

}

public class Question3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int datesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> dates = new ArrayList<>();

        for (int i = 0; i < datesCount; i++) {
            String datesItem = bufferedReader.readLine();
            dates.add(datesItem);
        }

        List<String> result = Result.reformatDate(dates);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(result.get(i));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

