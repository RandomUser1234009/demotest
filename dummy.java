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


import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PostRequestExample {

    public static void main(String[] args) {
        try {
            // URL of the service you want to POST to
            URL url = new URL("https://example.com/api/resource");

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method to POST
            connection.setRequestMethod("POST");

            // Set the request content-type
            connection.setRequestProperty("Content-Type", "application/json; utf-8");

            // Enable input/output streams
            connection.setDoOutput(true);

            // JSON data to be sent in the request body
            String jsonInputString = "{\"name\":\"John\", \"age\":30}";

            // Write the JSON data to the output stream
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Check the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Optionally, read the response body (not shown here)

            // Close the connection
            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
