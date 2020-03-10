package com.company;
import java.util.*;

public class Main {

    private final static String AdminLogin = "admin"; // Логин от панели от администратора
    private final static String AdminPass = "admin"; // Пароль от панели от администратора

    public static User user = new User(); // Создаем экземляр класса пользователей
    public static boolean isAuthorizated;
    public static boolean isTemp = false;



    public static Map<Integer,Candidate> listCandidates = new HashMap<Integer,Candidate>();

    public static void main(String[] args)  {
        Candidate candidate1 = new Candidate("Василий Пупкин");
        Candidate candidate2 = new Candidate("Владимир Путин");
        Candidate candidate3 = new Candidate("Владимир Жириновский");
        Candidate candidate4 = new Candidate("Алексей Навальный");
        Candidate candidate5 = new Candidate("Сергей Дружко");
        listCandidates.put(1,candidate1);
        listCandidates.put(2,candidate2);
        listCandidates.put(3,candidate3);
        listCandidates.put(4,candidate4);
        listCandidates.put(5,candidate5);

        menu();
    }

    // Основное меню

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        if(isAuthorizated == false) {
            System.out.println("Лабораторная работа №3 Чистяков Алексей ИКБО-06-17\n\nДобро пожаловать в систему выборов");
            System.out.println("(1) Вход");
            System.out.println("(2) Регистрация");
            System.out.println("(3) Вход в панель администратора");
            switch (scanner.nextInt()) {
                case 1:
                    Auth(); // Вызываем функцию авторизации
                    break;
                case 2:
                    Register(); // Вызываем функцию регистрацию
                    break;
                case 3:
                    AdmAuth(); // Вызываем функцию авторизации от имени администратора
                    break;
                default:
                    menu(); // Вызываем функцию меню
                    break;
            }
        }
        else{
            if(user.isVoted(user.getLogin()) == false) {
                System.out.println("Выбери за кого вы хотите проголосовать: ");
                for(int i = 1; i <= listCandidates.size(); i++){
                    System.out.println("(" + i + ")" + listCandidates.get(i).getName());
                }
                int voice = scanner.nextInt();
                if(voice > listCandidates.size()){
                    System.out.println("Данного кандидата нет в списке");
                    menu(); // Вызываем функцию меню
                }
                listCandidates.get(voice).addVoice();
                user.vote(user.getLogin(),voice);
                System.out.println("Ваш голос учтен!");
                isTemp = true;
                menu();  // Вызываем функцию меню
            }
            else {
                if(isTemp == false) {
                    System.out.println("Вы уже голосовали! За " + listCandidates.get(user.getVotedName(user.getLogin())).getName());
                }
                isTemp = false;
                System.out.println("(0) Выход из аккаунта");
                scanner.nextInt();
                isAuthorizated = false;
                menu();  // Вызываем функцию меню
            }

        }



    }

    // Блок авторизации

    public static void Auth() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите логин: ");
        String login = scanner.nextLine();
        System.out.println("Введите пароль: ");
        String password = scanner.nextLine();

        isAuthorizated = user.enter(login, password);
        menu();  // Вызываем функцию меню
    }

    // Блок регистрации

    public static void Register(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Придумайте логин: ");
        String login = scanner.nextLine();
        System.out.println("Придумайте пароль: ");
        String password = scanner.nextLine();

        user.addUser(login, password);
        menu();  // Вызываем функцию меню
    }

    // Блок авторизации администратора

    public static void AdmAuth(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите логин администратора: ");
        String admLogin = scanner.nextLine();
        System.out.println("Введите пароль администратора: ");
        String admPass = scanner.nextLine();
        if(admLogin.equals(AdminLogin) && admPass.equals(AdminPass)){
            AdmPanel();
        }
        else{
            System.out.println("Данные не верны!");
        }
    }

    // Блок Админ панели

    public static void AdmPanel(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вы авторизовали как администратор");
        System.out.println("(1) Вывести результаты голосования");
        System.out.println("(0) Выход");
        switch (scanner.nextInt()){
            case 1:
                getResult(); // Выводим результаты
                break;
            case 0:
                isAuthorizated = false;
                menu();  // Вызываем функцию меню
                break;
        }
    }

    // Блок вывода результатов голосования

    public static void getResult() {
        System.out.println("Результаты голования: ");
        for(int i = 1; i <= listCandidates.size(); i++){
            System.out.println(listCandidates.get(i).getName() + " Количество голосов: " + listCandidates.get(i).getVoices());
        }
        AdmPanel();  // Вызываем функцию с Админ Панелью
    }
}

