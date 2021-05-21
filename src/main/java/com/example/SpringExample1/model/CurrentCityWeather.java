package com.example.SpringExample1.model;

/**
 * This Class saves the informations of the Current Weather of the selected City
 */
public class CurrentCityWeather {


        private String date;
        private String name;
        private double temp;
        private long pressure;
        private long humidity;

    /**
     * the default Constructor
     */
    public CurrentCityWeather() {

        }

    /**
     * the parametrisiert Constructor giving values
     * @param date the date of this current Weather
     * @param name the name of the City
     * @param temp the temperatur of the City
     * @param pressure the pressure of the City
     * @param humidity the humidity of that day in the City
     */
    public CurrentCityWeather(String date, String name, double temp, long pressure, long humidity) {
        this.date = date;
        this.name = name;
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    /**
     * Get-Method
     * @return the value of the variable name of the City
     */
    public String getName() {
        return name;
    }

    /**
     * changes the value of the name of the City
     * @param name of the City
     */

    public void setName(String name) {
            this.name = name;
        }
        /**
         * Get-Method
         * @return the value of the variable name of the City
         */
    public double getTemp() {
        return temp;
    }

    /**
     * modify and set the value of the temperature of the weather
     * @param temp of the City
     */
    public void setTemp(double temp) {
        this.temp = temp;
    }
    /**
     * Get-Method
     * @return the value of the pressure of the City
     */
    public long getPressure() {
        return pressure;
    }

    /**
     * modify and set the value of the pressure of the weather
     * @param pressure of the City
     */
    public void setPressure(long pressure) {
        this.pressure = pressure;
    }

    /**
     * Get-Method
     * @return the value of the humidity of the City
     */
    public long getHumidity() {
        return humidity;
    }

    /**
     * modify and set the value of the humidity of the weather
     * @param humidity of the City
     */
    public void setHumidity(long humidity) {
        this.humidity = humidity;
    }
    /**
     * Get-Method
     * @return the value of the date of the weather information of that City
     */
    public String getDate() {
        return date;
    }

    /**
     * modify and set the value of the date of the weather in that City
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }
    }

