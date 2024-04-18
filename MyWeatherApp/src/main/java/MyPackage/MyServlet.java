package MyPackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method 
		/*String inputData = request.getParameter("userInput");
		System.out.println(inputData);
		doGet(request,response);*/
		
		//API Key
				String apiKey = "a66030a74d3efb1ed367425318349b89";
				// Get the city from the form input
		        String city = request.getParameter("city"); 
		        
		        // Create the URL for the OpenWeatherMap API request
		        String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;

               // Api Intigretion
		        try {
		        URL url = new URL(apiUrl);
		        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	            connection.setRequestMethod("GET");
	            
              // Reading the data from the network
                InputStream inputStream = connection.getInputStream();
                InputStreamReader reader = new InputStreamReader(inputStream);
              
              //Want to store in string 
               StringBuilder responseContent = new StringBuilder();
               
              //For taking the input from the reader ,will create scanner object
                Scanner scanner = new Scanner(reader);
                
                while (scanner.hasNext()) {
                    responseContent.append(scanner.nextLine());
                }
                // System.out.println(responseContent);
                scanner.close();
                System.out.println(responseContent);
                
                //TypeCsating= Parse the JSON response to extract temperature, date, and humidity
                Gson gson = new Gson();
                JsonObject jsonObject = gson.fromJson(responseContent.toString(), JsonObject.class);
              //  System.out.println(jsonObject);
                
              //Date & Time
                long dateTimestamp = jsonObject.get("dt").getAsLong() * 1000;
                String date = new Date(dateTimestamp).toString();     //Object typecasting
                
                //Temperature
                double temperatureKelvin = jsonObject.getAsJsonObject("main").get("temp").getAsDouble();
                int temperatureCelsius = (int) (temperatureKelvin - 273.15);
               
                //Humidity
                int humidity = jsonObject.getAsJsonObject("main").get("humidity").getAsInt();
                
                //Wind Speed
                double windSpeed = jsonObject.getAsJsonObject("wind").get("speed").getAsDouble();
                
                //Weather Condition
                String weatherCondition = jsonObject.getAsJsonArray("weather").get(0).getAsJsonObject().get("main").getAsString();
                
                
                // Set the data as request attributes (for sending to the jsp page)
                request.setAttribute("date", date);
                request.setAttribute("city", city);
                request.setAttribute("temperature", temperatureCelsius);
                request.setAttribute("weatherCondition", weatherCondition); 
                request.setAttribute("humidity", humidity);    
                request.setAttribute("windSpeed", windSpeed);
                request.setAttribute("weatherData", responseContent.toString());
                
                connection.disconnect();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
                
                
                
               // Forward the request to the weather.jsp page for rendering
                request.getRequestDispatcher("index.jsp").forward(request, response);
                
	}

}
