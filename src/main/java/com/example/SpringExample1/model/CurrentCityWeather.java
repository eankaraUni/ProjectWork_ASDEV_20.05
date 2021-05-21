package com.example.SpringExample1.model;

public class CurrentCityWeather {


        private String date;
        private String name;
        private double temp;
        private long pressure;
        private long humidity;

        public CurrentCityWeather() {

        }

        public CurrentCityWeather(String date, String name, double temp, long pressure, long humidity) {
            this.date = date;
            this.name = name;
            this.temp = temp;
            this.pressure = pressure;
            this.humidity = humidity;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getTemp() {
            return temp;
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }

        public long getPressure() {
            return pressure;
        }

        public void setPressure(long pressure) {
            this.pressure = pressure;
        }

        public long getHumidity() {
            return humidity;
        }

        public void setHumidity(long humidity) {
            this.humidity = humidity;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }

