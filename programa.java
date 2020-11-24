import org.dom4j.DocumentException;
import org.json.*;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class programa {
    public static final String DOCUMENTO_XML = "data.xml";
    public static final String DOCUMENTO_JSON = "data.json";


    public static void main(String[] args) {
        try {
            // CREAR JSON
            String doc = Files.readString(Paths.get(DOCUMENTO_XML), StandardCharsets.ISO_8859_1);
            JSONObject json = XML.toJSONObject(doc); // converts xml to json
            String jsonPrettyPrintString = json.toString(4); // json pretty print
            Files.writeString(Paths.get(DOCUMENTO_JSON), jsonPrettyPrintString, StandardCharsets.ISO_8859_1);

            //validar xml

            SAXReader reader = new SAXReader();
            reader.setValidation(true);
            reader.read(DOCUMENTO_XML);

            // MISC
            System.out.println(jsonPrettyPrintString);
            System.out.println(doc);
            System.out.println( "aaaaa" + json.getJSONObject("videoteca"));





        } catch(JSONException | IOException je) {
            System.out.println(je.toString());
        }
        catch (DocumentException de){
            System.out.println(de.toString());
        }

    }
}