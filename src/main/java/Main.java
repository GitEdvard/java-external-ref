import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;

public class Main{
    public static void main(String[] args) {
        System.out.println("Hello world!");
        // doTryWithResources();
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("/home/edvard/sources/dev/java-external-ref/resources/file2.json"));
            JSONObject jsonObject = (JSONObject)obj;
            String name = (String)jsonObject.get("name");
            System.out.println(name);
        } catch (FileNotFoundException e ) {
            System.out.println(e.getMessage());
        } catch (IOException e ) {
            System.out.println(e.getMessage());
        }
        catch (ParseException e){
            System.out.println(e.getMessage());
        }
    }

    static public Reader openReader(String fileName) throws IOException {
        return Files.newBufferedReader(Paths.get(fileName));
    }

    public static void doTryWithResources() {
        char[] buff = new char[8];
        int length;
        try (Reader reader = openReader("/home/edvard/sources/dev/java-external-ref/resources/file1.txt")) {
            while((length = reader.read(buff)) >= 0) {
                System.out.println("\nlength: " + length);
                for(int i=0; i < length; i++)
                    System.out.print(buff[i]);
            }
        } catch(IOException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

}
