package main.java;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main{
    public static void main(String[] args) {
        System.out.println("Hello world!");
        doTryWithResources();
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
