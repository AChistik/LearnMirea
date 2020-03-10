package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String Login = null;
    private String Password = null;
    public boolean isAuth = false;
    private Map<String, String> userinfo = new HashMap<>();

    // Авторизация пользователя

        public User() throws IOException, ClassNotFoundException {
            if(Files.exists(Paths.get("user"))) {
                FileInputStream fileInputStream = new FileInputStream("user");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                userinfo = (Map<String, String>) objectInputStream.readObject();
            }
            else {
                userinfo.put("admin","admin");

            }
        }

    public boolean enter(String login, String password){
        if(userinfo.get(login) == null){
            this.isAuth = false;
            return false;
        }
        if(!userinfo.get(login).equals(password)){
            this.isAuth = false;
            return false;
        }
        if(userinfo.get(login).equals(password)){
            this.isAuth = true;
            this.Login = login;
            this.Password = password;
            return true;
        }
        return false;
    }


    // Регистрация нового пользователя

    public void addUser(String login, String password) throws IOException {
        if(userinfo.get(login) != null) {
            System.out.println("Логин уже зарегистрирован");
        }
        else{
            userinfo.put(login,password);
            FileOutputStream fileOutputStream = new FileOutputStream("user");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(userinfo);
            System.out.println("Вы успешно зарегистрировались!");
        }
    }

    // Возрврат логина авторизованного пользователя

    public String getLogin(){
        return this.Login;
    }
}

