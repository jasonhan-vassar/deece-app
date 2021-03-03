package com.vcplusplus.deeceapp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URL;
import java.net.URLConnection;
import java.net.MalformedURLException;
import java.net.HttpURLConnection;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.vcplusplus.deeceapp.Response;

public class App {
    public static void main(String[] args) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("HH:mm");
        Gson gson = gsonBuilder.create();

        Response response = null;

        try {
            // URL url = new URL("https://legacy.cafebonappetit.com/api/2/menus?cafe=1626&date=2021-02-20,2021-02-21");
            URL url = new URL("https://legacy.cafebonappetit.com/api/2/menus?cafe=1626,1627,1628,1629,1630&date=2021-02-22,2021-02-23,2021-02-24,2021-02-25,2021-02-26");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestProperty("Accept", "application/json");

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            String result = new BufferedReader(new InputStreamReader(in))
                            .lines().collect(Collectors.joining("\n"));
            JsonElement jsonElement = JsonParser.parseString(result);
            JsonObject responseJson = jsonElement.getAsJsonObject();

            // TODO: find a better way to save Response
            response = gson.fromJson(responseJson, Response.class);

            urlConnection.disconnect();
        } catch (MalformedURLException err) {
            System.out.println("MalformedURLException!");
            System.out.println(err);
        } catch (IOException err) {
            System.out.println("IOException!");
            System.out.println(err);
        }

        // TODO: better null Response detection method
        if (response == null) {
            System.out.println("bruh");
            return;
        }

        Day[] days = response.getDays();
        Map<Integer, Item> items = response.getItems();

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("Enter the food ID to search for this week");
            int foodID = scan.nextInt();

            for (Day day : days) {
                String date = day.getDate();
                Map<Integer, Cafe> cafes = day.getCafes();

                Cafe gordonCommons = cafes.get(1626);
                List<DayPart> dayParts = gordonCommons.getDayParts();
                for (DayPart dayPart : dayParts) {
                    String label = dayPart.getLabel();

                    List<Station> stations = dayPart.getStations();
                    for (Station station : stations) {
                        String stationLabel = station.getLabel();
                        List<Integer> stationItems = station.getItems();

                        if (stationItems.contains(foodID)) {
                            System.out.print(date + " " + label + " " + stationLabel);
                            System.out.println();
                        }
                    }
                }
            }
        }
    }
}
