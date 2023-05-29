package gr.aueb.cf.ch9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NioCopyApp {
    public static void main(String[] args) {
        byte [] videoBytes;
        Path sourcePath = Paths.get("C:/Users/Dell/WebDev/html/images/london.jpg");
        Path targetFile = Paths.get("C:/Users/Dell/WebDev/html/images/londonOut.jpg");

        try{
            videoBytes = Files.readAllBytes(sourcePath);
            Files.write(sourcePath, videoBytes);
        } catch (IOException e)  {
            e.printStackTrace();
        }
    }
}
