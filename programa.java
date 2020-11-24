import com.google.gson.Gson;
import org.dom4j.DocumentException;
import org.json.*;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class programa {
    public static final String DOCUMENTO_XML = "data.xml";
    public static final String DOCUMENTO_JSON = "data.json";


    public static void mostrarActores(String titulo,Videoteca videoteca){
        for(Pelicula pelicula : videoteca.getPelicula())
            if(pelicula.getTitulo().equals(titulo))
                System.out.println(pelicula.getReparto());
    }

    public static void mostrarGeneros(Videoteca videoteca){
        Set<String> generos = new HashSet<String>();

        for(Pelicula pelicula : videoteca.getPelicula()) {
            String genero = pelicula.getGenero();

            if (genero == null)
                generos.add("No calificada");
            else
                generos.add(genero);
        }

        System.out.println(generos);
    }


    public static void main(String[] args) {
        try {
            // CREAR JSON
            String doc = Files.readString(Paths.get(DOCUMENTO_XML), StandardCharsets.ISO_8859_1);
            JSONObject json = XML.toJSONObject(doc); // converts xml to json
            String jsonPrettyPrintString = json.toString(4); // json pretty print
            Files.writeString(Paths.get(DOCUMENTO_JSON), jsonPrettyPrintString, StandardCharsets.ISO_8859_1);

            //validar xml, ponerlo antes

            SAXReader reader = new SAXReader();
            reader.setValidation(true);
            //reader.read(DOCUMENTO_XML);

            // MISC
            System.out.println(jsonPrettyPrintString);
            System.out.println(doc);
            System.out.println( "aaaaa" + json.getJSONObject("videoteca"));
            Gson gson = new Gson();
            JSONArray peliculass = json.getJSONObject("videoteca").getJSONObject("peliculas").getJSONArray("pelicula");

        //PARSEO

           Videoteca vids = gson.fromJson(json.get("videoteca").toString(), Videoteca.class);
           Pelicula[] peliculas = gson.fromJson(peliculass.toString(), Pelicula[].class);

            for (Pelicula pelicula : peliculas) {
                System.out.println(pelicula);
            }
            System.out.println(peliculas);

            mostrarActores("Terminator",vids);
            mostrarGeneros(vids);





        } catch(JSONException | IOException je) {
            System.out.println(je.toString());
        }
        /*catch (DocumentException de){
            System.out.println(de.toString());
        }*/

    }
}