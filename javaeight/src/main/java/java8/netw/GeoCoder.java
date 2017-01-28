package java8.netw;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
- Java SDK has URL class which can be used for simple http GET operation over web.
- For POST,PUT, DELETE we need URLConnection or other libraries.
-For JSON processing JavaEE 7 has specification. But its not part of SDK. We used here reference implementation
    from Glassfihs, better to use other alternatives in real practices like Google GSON.
 */
public class GeoCoder {
    private static String BASE_URL = "https://maps.googleapis.com/maps/api/geocode/json?";

    private  Function<String,String> encoder = s -> {
        try{
           return URLEncoder.encode(s,"UTF-8");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    };

    private  String encode(List<String> address){
       return  address.stream()
               .map(encoder)
               .collect(Collectors.joining(","));
    }

    public void fillLatLong(Location location){
        String address = encode(Arrays.asList(location.getStreet(),location.getCity(),location.getState()));
        try {
            URL url = new URL(String.format("%saddress=%s",BASE_URL,address));
            try(JsonReader jsonReader = Json.createReader(url.openStream())){
                JsonObject jsonObject = jsonReader.readObject();
                JsonObject loc = jsonObject.getJsonArray("results")
                        .getJsonObject(0)
                        .getJsonObject("geometry")
                        .getJsonObject("location");

                location.setLattitude(loc.getJsonNumber("lat").doubleValue());
                location.setLangitude(loc.getJsonNumber("lng").doubleValue());

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]){
        Location location = new Location("1600 Ampitheatre Parkway","Mountain View","CA");
        new GeoCoder().fillLatLong(location);
        System.out.println(location);
    }
}
