package com.example.Borisi_Keshelava_davaleba_1.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import com.example.Borisi_Keshelava_davaleba_1.Model.DirectionTypes;
import com.example.Borisi_Keshelava_davaleba_1.Model.Weather;


@Path("/api/weather")
public class WeatherController {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Weather> getWeathers() {
        List<Weather> weatherList = new ArrayList<>();
        weatherList.add(new Weather("Tbilisi","10","6","4.1", DirectionTypes.SOUTH,"12"));
        weatherList.add(new Weather("Batumi","14","13","6.1", DirectionTypes.NORTH,"12"));
        weatherList.add(new Weather("Telavi","13","5","5.1", DirectionTypes.WEST,"12"));
        weatherList.add(new Weather("Kutaisi","14","8","7.1", DirectionTypes.EAST,"12"));
        return weatherList;
    }

    @GET
    @Path("/{city}")
    @Produces(MediaType.APPLICATION_JSON)
    public Weather getWeather(@PathParam("city") String cityName) {
        Weather weather;
        List<Weather> weatherList = getWeathers();
        for (Weather w: weatherList) {
            if (w.getCityName() == cityName) {
                weather = w;
                System.out.println(w);
                return weather;
            }
        }
        return null;
    }
}
