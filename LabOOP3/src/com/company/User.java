package com.company;

import java.util.HashMap;
import java.util.Map;

public class User extends Elector {
    private String Login = null;
    private String Password = null;
    public boolean isAuth = false;
    private Map<String, String> hashMap = new HashMap<>();


    public User() {
        Elector elector = new Elector();
    }

    // Авторизация пользователя

    public boolean enter(String login, String password){
        if(hashMap.get(login) == null){
            System.out.println("Логин не найден!");
            this.isAuth = false;
            return false;
        }
        if(!hashMap.get(login).equals(password)){
            System.out.println("Пароль не верный");
            this.isAuth = false;
            return false;
        }
        if(hashMap.get(login).equals(password)){
            System.out.println("Вы успешно авторизовались");
            this.isAuth = true;
            this.Login = login;
            this.Password = password;
            return true;
        }
        return false;
    }


    // Регистрация нового пользователя

    public void addUser(String login, String password) {
        if(hashMap.get(login) != null) {
            System.out.println("Логин уже зарегистрирован");
        }
        else{
            hashMap.put(login,password);
            System.out.println("Вы успешно зарегистрировались!");
        }
    }

    // Возрврат логина авторизованного пользователя

    public String getLogin(){
        return this.Login;
    }

}

