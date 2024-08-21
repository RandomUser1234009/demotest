private system
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiService {
    public void sendPostRequest(String urlString, String jsonInputString) {
        try {
            // Create a URL object
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Set request properties
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // Send the request payload
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Handle the response
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("POST request was successful!");
            } else {
                System.out.println("POST request failed with response code: " + responseCode);
            }

            // Close the connection
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


public class Main {
    public static void main(String[] args) {
        // Create an instance of the service class
        ApiService apiService = new ApiService();

        // Define the URL and JSON payload
        String url = "https://api.example.com/endpoint";
        String jsonPayload = "{\"key1\": \"value1\", \"key2\": \"value2\"}";

        // Make the POST request
        apiService.sendPostRequest(url, jsonPayload);
    }
}
