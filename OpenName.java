//import java.util.HashMap;
import java.net.*;
import java.io.UnsupportedEncodingException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class OpenName {
public static void main(String[] args){
    //OpenName_namer firstAttempt = new OpenName_namer("harry potter chamber of secrets");

        //HashMap<String, String> metaMap = new HashMap<String, String>();
try{

        String url = "http://www.omdbapi.com/";
        String charset = "UTF-8";
        String searchType = "?t=";
        String toSearch = "harry potter and the chamber of secrets";
        String apiKey = "apikey=bed3cce4"; //"INSERT_OMDB_APIKEY_HERE";
        String encodedSearch = URLEncoder.encode(toSearch, charset);
        
        
        
        String query = searchType + encodedSearch + '&' + apiKey;

        System.out.println(query);


    URLConnection connection = new URL(url + query).openConnection();
    //URLConnection connection = new URL(url).openConnection();

    connection.setRequestProperty("Accept-Charset", charset);
    InputStream response = connection.getInputStream(); 

    // if we make it here, we got a response and no errors. 

    Scanner scanner = new Scanner(response);
    String responseBody = scanner.useDelimiter("\\A").next();
    System.out.println(responseBody);
    scanner.close();

} catch (Exception e) {
    System.out.println("Error!: " + e);
}


    System.out.println("end!");
}

}
