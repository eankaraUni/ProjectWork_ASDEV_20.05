package com.example.SpringExample1.model;

/**
 * The informations of the City
 */
public class City {
        String cityName;
        double lat;
        double lon;

        /**
         * the constructor initializing the City informations
         * @param cityName the name of the City
         * @param lat latitude inf of the City
         * @param lon longitude inf of the City
         */
        public City(String cityName, double lat, double lon) {
                this.cityName = cityName;
                this.lat = lat;
                this.lon = lon;
            }

        /**
         * get the information the city name
          * @return the name of the City
         */
        public String getCityName() {
                return cityName;
            }

        /**
         * used for modifyng or initializing the name of the city
         * @param cityName name of the City
         */
        public void setCityName(String cityName) {
                this.cityName = cityName;
            }
        /**
         * get the information the city latitude
         * @return the latitude of the City of the City
         */
        public double getLat() {
            return lat;
        }

        /**
         * used for modifyng or initializing the latitude of the city
         * @param lat given latitude inf of the city
         */
        public void setLat(double lat) {
                this.lat = lat;
            }
        /**
         * get the information the city longitude
         * @return the longitude of the City
         */
        public double getLon() {
            return lon;
        }

        /**
         * used for modifyng or initializing the name of the city
         * @param lon longitude information of the city
         */
        public void setLon(double lon) {
                this.lon = lon;
            }
        }

