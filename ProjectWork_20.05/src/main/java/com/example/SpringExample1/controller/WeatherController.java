package com.example.SpringExample1.controller;
import com.example.SpringExample1.model.City;
import com.example.SpringExample1.model.CurrentCityWeather;
import com.example.SpringExample1.model.HistoricalData;
import com.example.SpringExample1.model.JSONHandler;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * This is the controller class for displaying depending the method
 * the Cities or the the Weather of the selected City and the Forecast of the selected City
 * @author Erda Ymeri ASDEV
 */
@RestController
public class WeatherController {

    private CurrentCityWeather ccw;
    /**
     * Here are added to a list our selected Cities, so that the
     * user can choose one of the them
     * @return the List of the Cities
     */
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

    /**
     * In this method the user by giving the wanted City can get the Weather of that City
     * @param name of the selected City
     * @return the current Weather of that City
     */
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

    /**
     * In this method we get the Forecast of the City
     * @param lat latitude of that City
     * @param lon longitude of that City
     * @return the 7 DAy Forecast of that City
     */
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

    @GetMapping("/method4")
    public HistoricalData displayPrevious1DaysTempPressureHumidity(@RequestParam(name = "lat") double lat, @RequestParam(name = "lon") double lon, @RequestParam(name = "time") long time) {
        JSONHandler handler1 = new JSONHandler();
        handler1.APIcall("https://api.openweathermap.org/data/2.5/onecall/timemachine?lat=" + lat + "&lon=" + lon + "&dt=" + time + "&appid=1110ad18e853db5fdaab300d420615dc", true);
        JSONArray stats1 = (JSONArray) handler1.getObject().get("hourly");
        JSONObject obj1;
        List<Double> temp = new ArrayList<>();
        List<Long> pressure = new ArrayList<>();
        List<Long> humidity = new ArrayList<>();
        for (int i = 0; i < stats1.size(); i++) {
            obj1 = (JSONObject) stats1.get(i);
            temp.add((Double) obj1.get("temp"));
            pressure.add((long) obj1.get("pressure"));
            humidity.add((long) obj1.get("humidity"));
        }
        double minTemp = Collections.min(temp);
        double maxTemp = Collections.max(temp);
        double sumTemp = 0;
        for (double i : temp) {
            sumTemp += i;
        }
        double avgTemp = sumTemp / temp.size();
        long minPressure = Collections.min(pressure);
        long maxPressure = Collections.max(pressure);
        long sumPressure = 0;
        for (long j : pressure) {
            sumPressure += j;
        }
        long avgPressure = sumPressure / pressure.size();
        long minHumidity = Collections.min(humidity);
        long maxHumidity = Collections.max(humidity);
        long sumHumidity = 0;
        for (long z : humidity) {
            sumHumidity += z;
        }
        long avgHumidity = sumPressure / pressure.size();
        long unixSeconds = time;
// convert seconds to milliseconds
        Date date = new java.util.Date(unixSeconds * 1000L);
// the format of your date
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
// give a timezone reference for formatting (see comment at the bottom)
        sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT+2"));
        String formattedDate = sdf.format(date);
        HistoricalData hwtph = new HistoricalData(minTemp,maxTemp,avgTemp,minPressure,maxPressure,avgPressure,minHumidity,maxHumidity,avgHumidity,formattedDate);
        return hwtph;
    }



}
