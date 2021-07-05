import java.util.HashMap;
import java.net.*;
import java.io.UnsupportedEncodingException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * @author Noah Phillips
 * @version 1.00
 * @see https://github.com/phillipsnoah/OpenName
 * The namer is what we use to parse JSON using Google's GSON, gather the metadata for that content, and store it.  
 * The namer can be used in a loop for batch editing as well. 
 */
public class OpenName_namer {
    HashMap<String, String> metaMap = new HashMap<String, String>();
    String toSearch;
    String url = "https://imdb-api.com/API/Search/";
    String charset = "UTF-8";
    String apiKey = "k_jsht09u1"; //"INSERT_IMDB_APIKEY_HERE";

    public OpenName_namer(String titleName){
        toSearch = titleName;
    }
    public static void Main(String[] args){
    }

    public void getRequest(){
        try{
            String query = String.format("apiKey=%s&toSearch=%s",
            URLEncoder.encode(apiKey, charset), 
            URLEncoder.encode(toSearch, charset));
            URLConnection connection = new URL(url + "?" + query).openConnection();
            connection.setRequestProperty("Accept-Charset", charset);
            InputStream response = connection.getInputStream(); 

            // if we make it here, we got a response and no errors. 

            try (Scanner scanner = new Scanner(response)) {
                String responseBody = scanner.useDelimiter("\\A").next();
                System.out.println(responseBody);
            }catch (Exception e) {
                System.out.println("Ooops!" + e);
            }

        } catch (UnsupportedEncodingException Error) {
            System.out.println("Error!: " + Error);
        } catch (IOException e) {
            System.out.println("Error!: " + e);
        }

    }

    
}
