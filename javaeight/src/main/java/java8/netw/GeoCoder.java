package java8.netw;

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

    public String getData(List<String> addresses){
        String address = encode(addresses);
        String response ="";
        try {
            URL url = new URL(String.format("%saddress=%s",BASE_URL,address));
            String line ="";
            try(BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))){
                while( (line = br.readLine()) != null){
                    response = response + "\n" + line;

                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return  response;
    }

    public static void main(String args[]){
        String data = new GeoCoder().getData(Arrays.asList("1600 Ampitheatre Parkway","Mountain View","CA"));
        System.out.println(data);

    }
}
