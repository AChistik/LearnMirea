package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Elector {
    private boolean voted = false;
    private String Login;
    public boolean fileExist = false;
    protected Map<String, Integer> electors = new HashMap<>();

    public Elector() throws IOException, ClassNotFoundException {
        if(Files.exists(Paths.get("electors"))) {
            FileInputStream fileInputStream = new FileInputStream("electors");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            electors = (Map<String, Integer>) objectInputStream.readObject();
            fileExist = true;
        }
    }

    // Прооверка, проголосовал ли человек

    public boolean isVoted(String Login){
        if(this.electors.get(Login) == null){
            return false;
        }
        return true;
    }


    // Проголосовать

    public void vote(String Login,Integer candidate) throws IOException {
        this.voted = true;
        electors.put(Login,candidate);
        FileOutputStream fileOutputStream = new FileOutputStream("electors");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(electors);
        objectOutputStream.close();
    }
}
