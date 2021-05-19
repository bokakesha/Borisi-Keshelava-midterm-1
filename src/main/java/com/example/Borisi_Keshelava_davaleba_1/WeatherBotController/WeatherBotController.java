package com.example.Borisi_Keshelava_davaleba_1.WeatherBotController;


import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


@ServerEndpoint("/weather-bot")
public class WeatherBotController {
    @OnOpen
    public void handleOpen() {
        System.out.println("Connected ...");
    }

    @OnMessage
    public String handleMessage(String message) throws IOException {
        System.out.println("MSG From Client : " + message);
        StringBuilder result = new StringBuilder();
        if (message.equals("all")){
            URL url = new URL("http://localhost:8080/shalva_turashvili_davaleba_1_war_exploded/api/weather");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output;
            System.out.println("Output from Server :  \n");

            while ((output = br.readLine()) != null) {
                result.append(output);
            }
            conn.disconnect();
        }
        else {
            URL url = new URL("http://localhost:8080/borisi_keshelava_davaleba_1_war_exploded/api/weather/" + message);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output;
            System.out.println("Output from Server :  \n");

            while ((output = br.readLine()) != null) {
                result.append(output);
            }
            conn.disconnect();
        }
        return result.toString();
    }

    @OnClose
    public void handleClose() {
        System.out.println("End Connection ...");
    }

    @OnError
    public void handleError(Throwable t) {
        t.printStackTrace();
    }
}
