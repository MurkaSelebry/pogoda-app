package com.example.proekt;

public class CityInfo {
    private String city;
    private int temperature;
    private int humidity;
    private int pressure;
    private int wind;
    CityInfo(){}
    CityInfo(String city, int temperature, int humidity, int pressure, int wind){
        this.setCity(city);
        this.setTemperature(temperature);
        this.setHumidity(humidity);
        this.setPressure(pressure);
        this.setWind(wind);
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getWind() {
        return wind;
    }

    public void setWind(int wind) {
        this.wind = wind;
    }
    public void printCityInfo(){
        System.out.println(city);
        System.out.println( temperature);
        System.out.println( humidity);
        System.out.println( pressure);
        System.out.println( wind);
        System.out.println();
    }
}

