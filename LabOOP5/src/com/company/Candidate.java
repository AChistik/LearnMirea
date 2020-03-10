package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Candidate {

    protected Map<Integer, Integer> voices = new HashMap<>();

    public Candidate() throws IOException, ClassNotFoundException {
        if(Files.exists(Paths.get("voices"))) {
            FileInputStream fileInputStream = new FileInputStream("voices");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            voices = (Map<Integer, Integer>) objectInputStream.readObject();
        }
        else{
            for(int i = 0; i < 7; i++){
                voices.put(i,0);
                writeToFile();
            }
        }
    }


    // Добавить голос

    public void addVoice(int num) throws IOException {
        voices.put(num,voices.get(num)+1);
        writeToFile();

    }

    public int getVoices(int num) throws IOException {
        return voices.get(num);

    }

    public void writeToFile() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("voices");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(voices);
        objectOutputStream.close();
    }
}
