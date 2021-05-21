package com.example.SpringExample1.model;

public class City {
        String cityName;
        double lat;
        double lon;
        
        public City(String cityName, double lat, double lon) {
            this.cityName = cityName;
            this.lat = lat;
            this.lon = lon;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public double getLon() {
            return lon;
        }

        public void setLon(double lon) {
            this.lon = lon;
        }
    }

