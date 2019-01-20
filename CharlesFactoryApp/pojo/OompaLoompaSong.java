
package pojo;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OompaLoompaSong {
    int lines;
    List<String> songLines = new ArrayList<String>();

    private OompaLoompaSong() {
        try {
            songLines = Files.readAllLines(Paths.get("OompaLoompaSong.txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public OompaLoompaSong(int lines) {
        this();
        this.lines = lines;
    }

    public String sing() {
        Random ran = new Random();
        String singText = "";
        for (int i = 0; i < lines; i++) {
            singText += songLines.get(ran.nextInt(songLines.size())) +" ";
        }
        return singText;
    }

}
