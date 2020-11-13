import com.google.gson.Gson;
import org.json.*;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class test {
    public static final String DOCUMENTO_XML = "data.xml";
    public static final String DOCUMENTO_JSON = "data.json";

    public static void main(String[] args) {
        try {
            //String doc = new String (String.valueOf(Files.readAllLines(Paths.get(DOCUMENTO_XML))));
            String doc = Files.readString(Paths.get(DOCUMENTO_XML), StandardCharsets.ISO_8859_1);
            JSONObject json = XML.toJSONObject(doc); // converts xml to json
            String jsonPrettyPrintString = json.toString(4); // json pretty print
            Files.writeString(Paths.get(DOCUMENTO_JSON), jsonPrettyPrintString, StandardCharsets.ISO_8859_1);
            System.out.println(jsonPrettyPrintString);
            System.out.println(doc);

            Gson gson = new Gson();
            Pelicula[] peliculas = gson.fromJson(json.get("pelicula").toString(), Pelicula[].class);

            for (Pelicula pelicula : peliculas) {
                System.out.println(pelicula);
            }

        } catch(JSONException | IOException je) {
            System.out.println(je.toString());
        }

    }
}