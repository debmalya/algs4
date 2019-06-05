package Hackerrank;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.net.*;

import com.google.gson.*;


public class Question4 {
    /*
     * Complete the function below.
     */
    public static void openAndClosePrices(String firstDate, String lastDate, String weekDay) {

        SimpleDateFormat sdf = new SimpleDateFormat("d-MMMM-yyyy");

        int specifiedDayOfWeek = 1;
        if (weekDay.equalsIgnoreCase("Monday")) {
            specifiedDayOfWeek = 2;
        } else if (weekDay.equalsIgnoreCase("Tuesday")) {
            specifiedDayOfWeek = 3;
        } else if (weekDay.equalsIgnoreCase("Wednesday")) {
            specifiedDayOfWeek = 4;
        } else if (weekDay.equalsIgnoreCase("Thursday")) {
            specifiedDayOfWeek = 5;
        } else if (weekDay.equalsIgnoreCase("Friday")) {
            specifiedDayOfWeek = 6;
        } else if (weekDay.equalsIgnoreCase("Saturday")) {
            specifiedDayOfWeek = 7;
        }

        JsonParser jsonParser = new JsonParser();


        String currentDate = firstDate;

        try {
            Date startDate = sdf.parse(firstDate);
            Date endDate = sdf.parse(lastDate);

            Calendar calendar = Calendar.getInstance();

            while (!startDate.after(endDate)) {
                URL url = new URL("https://jsonmock.hackerrank.com/api/stocks?date=" + sdf.format(startDate));
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestProperty("Content-type", "application/json");
                httpURLConnection.setRequestMethod("GET");
                BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                String inputLine;
                StringBuilder responseContent = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    responseContent.append(inputLine);
                }
                in.close();

                calendar.setTime(startDate);
                int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
                if (dayOfWeek == specifiedDayOfWeek) {

                    JsonObject jsonResponse = jsonParser.parse(responseContent.toString()).getAsJsonObject();
                    String dayJsonData = jsonResponse.get("data").toString();
                    if (!dayJsonData.equals("[]")) {
                        JsonArray jsonArray = jsonResponse.getAsJsonArray("data");
                        JsonObject jsonData = jsonArray.get(0).getAsJsonObject();
                        String price = String.format("%s %s %s", jsonData.get("date").getAsString(), jsonData.get("open"), jsonData.get("close"));
                        System.out.println(price);
                        startDate.setTime(startDate.getTime() + 86400000 * 6);
                    }
                }
                startDate.setTime(startDate.getTime() + 86400000);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String _firstDate;
        try {
            _firstDate = in.nextLine();
        } catch (Exception e) {
            _firstDate = null;
        }

        String _lastDate;
        try {
            _lastDate = in.nextLine();
        } catch (Exception e) {
            _lastDate = null;
        }

        String _weekDay;
        try {
            _weekDay = in.nextLine();
        } catch (Exception e) {
            _weekDay = null;
        }

        openAndClosePrices(_firstDate, _lastDate, _weekDay);

    }
}
