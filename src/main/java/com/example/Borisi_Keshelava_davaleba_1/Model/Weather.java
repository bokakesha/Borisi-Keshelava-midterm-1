package com.example.Borisi_Keshelava_davaleba_1.Model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Weather {
    private String cityName;

    private String Temperature;

    private String Humidity;

    private String Pressure;

    private DirectionTypes windDirection;

    private String windSpeed;

    public Weather(String cityName, String temperature, String humidity, String pressure, DirectionTypes windDirection, String windSpeed) {
        this.cityName = cityName;
        this.Temperature = temperature;
        this.Humidity = humidity;
        this.Pressure = pressure;
        this.windDirection = windDirection;
        this.windSpeed = windSpeed;
    }

    public Weather() {

    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getTemperature() {
        return Temperature;
    }

    public void setTemperature(String temperature) {
        this.Temperature = temperature;
    }

    public String getHumidity() {
        return Humidity;
    }

    public void setHumidity(String humidity) {
        this.Humidity = humidity;
    }

    public String getPressure() {
        return Pressure;
    }

    public void setPressure(String pressure) {
        this.Pressure = pressure;
    }

    public DirectionTypes getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(DirectionTypes windDirection) {
        this.windDirection = windDirection;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "cityName='" + cityName + '\'' +
                ", Temperature='" + Temperature + '\'' +
                ", Humidity='" + Humidity + '\'' +
                ", Pressure='" + Pressure + '\'' +
                ", windDirection=" + windDirection +
                ", windSpeed='" + windSpeed + '\'' +
                '}';
    }

}
