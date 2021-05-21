package com.example.SpringExample1.controller;


import com.example.SpringExample1.model.City;
import com.example.SpringExample1.model.CurrentCityWeather;
import com.example.SpringExample1.model.JSONHandler;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class WeatherController {
    private CurrentCityWeather ccw;

    @GetMapping("/method1")
    public List<City> displayCity() {
        List<City> cities = new ArrayList<>();
        cities.add(new City("Rome", 41.908399, 12.500558));
        cities.add(new City("Milan", 45.471862, 9.166057));
        cities.add(new City("Berlin", 52.466373, 13.316215));
        cities.add(new City("Madrid", 40.399708, 3.716624));
        cities.add(new City("Barcelona", 41.401980, 2.073235));
        cities.add(new City("Paris", 48.848672, 2.323712));
        cities.add(new City("Bern", 46.953473, 7.380805));
        cities.add(new City("London", 51.539236, 0.192929));
        cities.add(new City("Manchester", 53.458122, 2.262947));
        cities.add(new City("Dortmund", 51.464616, 7.441417));
        return cities;
    }

    @GetMapping("/method2")
    public CurrentCityWeather displayCurrentWeather(@RequestParam(name = "name") String name) {

        JSONHandler handler = new JSONHandler();

        handler.APIcall("http://api.openweathermap.org/data/2.5/weather?q=" + name + "&appid=1110ad18e853db5fdaab300d420615dc", true);
        JSONObject currentStats = (JSONObject) handler.getObject().get("main");
        CurrentCityWeather ccw = new CurrentCityWeather();
        long unixSeconds = (long) handler.getObject().get("dt");
// convert seconds to milliseconds
        Date date = new java.util.Date(unixSeconds * 1000L);
// the format of your date
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
// give a timezone reference for formatting (see comment at the bottom)
        sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT+2"));
        String formattedDate = sdf.format(date);

        ccw.setDate(formattedDate);
        ccw.setName((String) handler.getObject().get("name"));
        ccw.setTemp((double) currentStats.get("temp"));
        ccw.setPressure((long) currentStats.get("pressure"));
        ccw.setHumidity((long) currentStats.get("humidity"));
        return ccw;

    }

    @GetMapping("/method3")
    public List<CurrentCityWeather> display7DaysForecast(@RequestParam(name = "lat") double lat, @RequestParam(name = "lon") double lon) {
        JSONHandler handler = new JSONHandler();
        List<CurrentCityWeather> ccw = new ArrayList<>();
        handler.APIcall("https://api.openweathermap.org/data/2.5/onecall?lat=" + lat + "&lon=" + lon + "&exclude=minutely,hourly&appid=1110ad18e853db5fdaab300d420615dc", true);
        JSONArray dailyStats = (JSONArray) handler.getObject().get("daily");
        JSONObject obj1;
        JSONObject obj2;

        for(int i=0;i<dailyStats.size();i++){
            obj1 = (JSONObject) dailyStats.get(i);
            long unixSeconds = (long) obj1.get("dt");
            obj2= (JSONObject) obj1.get("temp");
// convert seconds to milliseconds
            Date date = new java.util.Date(unixSeconds * 1000L);
// the format of your date
            SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
// give a timezone reference for formatting (see comment at the bottom)
            sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT+2"));
            String formattedDate = sdf.format(date);


            ccw.add(new CurrentCityWeather(formattedDate, (String) handler.getObject().get("timezone"), (Double) obj2.get("day"), (Long) obj1.get("pressure"), (Long) obj1.get("humidity")));
        }
        return ccw;
    }

}
