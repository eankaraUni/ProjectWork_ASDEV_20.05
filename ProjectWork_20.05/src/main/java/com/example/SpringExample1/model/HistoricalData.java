package com.example.SpringExample1.model;

public class HistoricalData {

        private double minTemp;
        private  double maxTemp;
        private double avgTemp;

        private long minPressure;
        private long maxPressure;
        private  long avgPressure;

        private long minHumidity;
        private long maxHumidity;
        private  long getAvgPressure;
        private  String date;

        public HistoricalData(double minTemp, double maxTemp, double avgTemp, long minPressure, long maxPressure, long avgPressure, long minHumidity, long maxHumidity, long getAvgPressure, String date) {
            this.minTemp = minTemp;
            this.maxTemp = maxTemp;
            this.avgTemp = avgTemp;
            this.minPressure = minPressure;
            this.maxPressure = maxPressure;
            this.avgPressure = avgPressure;
            this.minHumidity = minHumidity;
            this.maxHumidity = maxHumidity;
            this.getAvgPressure = getAvgPressure;
            this.date = date;
        }

        public double getMinTemp() {
            return minTemp;
        }

        public void setMinTemp(double minTemp) {
            this.minTemp = minTemp;
        }

        public double getMaxTemp() {
            return maxTemp;
        }

        public void setMaxTemp(double maxTemp) {
            this.maxTemp = maxTemp;
        }

        public double getAvgTemp() {
            return avgTemp;
        }

        public void setAvgTemp(double avgTemp) {
            this.avgTemp = avgTemp;
        }

        public long getMinPressure() {
            return minPressure;
        }

        public void setMinPressure(long minPressure) {
            this.minPressure = minPressure;
        }

        public long getMaxPressure() {
            return maxPressure;
        }

        public void setMaxPressure(long maxPressure) {
            this.maxPressure = maxPressure;
        }

        public long getAvgPressure() {
            return avgPressure;
        }

        public void setAvgPressure(long avgPressure) {
            this.avgPressure = avgPressure;
        }

        public long getMinHumidity() {
            return minHumidity;
        }

        public void setMinHumidity(long minHumidity) {
            this.minHumidity = minHumidity;
        }

        public long getMaxHumidity() {
            return maxHumidity;
        }

        public void setMaxHumidity(long maxHumidity) {
            this.maxHumidity = maxHumidity;
        }

        public long getGetAvgPressure() {
            return getAvgPressure;
        }

        public void setGetAvgPressure(long getAvgPressure) {
            this.getAvgPressure = getAvgPressure;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }


