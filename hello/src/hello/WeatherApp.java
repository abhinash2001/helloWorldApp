package hello;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import java.util.Scanner;

public class WeatherApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter city name: ");
        String city = scanner.nextLine();
        
        // Replace with your actual API key
        String apiKey = "YOUR_API_KEY_HERE"; 
        
        String urlString = String.format(
            "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric", 
            city, apiKey);

        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream())
            );
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Parse JSON
            JSONObject obj = new JSONObject(response.toString());

            String weather = obj.getJSONArray("weather")
                                .getJSONObject(0)
                                .getString("description");

            double temp = obj.getJSONObject("main").getDouble("temp");
            double feelsLike = obj.getJSONObject("main").getDouble("feels_like");
            int humidity = obj.getJSONObject("main").getInt("humidity");

            System.out.println("\nWeather: " + weather);
            System.out.println("Temperature: " + temp + "°C");
            System.out.println("Feels Like: " + feelsLike + "°C");
            System.out.println("Humidity: " + humidity + "%");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}
