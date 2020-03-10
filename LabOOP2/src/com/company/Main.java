package com.company;
import java.util.Scanner;

public class Main {
    public static class1 cl1 = new class1();
    public static class2 cl2 = new class2();
    public static class3 cl3 = new class3();

    public static void main(String[] args) {
        Menu();
    }

    public static void Menu(){
        Scanner in = new Scanner(System.in);
        String ans;
        System.out.println("Лабораторная работа №2 Чистяков Алексей ИКБО-06-17 Вариант 1 \n\n(1) Задание 1");
        System.out.println("(2) Задание 2");
        System.out.println("(3) Задание 3");
        System.out.println("Ваш выбор? ");
        ans = in.nextLine();
        switch (Integer.parseInt(ans)){
            case 1:
                Task1();
                break;
            case 2:
                Task2();
                break;
            case 3:
                Task3();
                break;
        }
    }

    public static void Task1(){
        Scanner in = new Scanner(System.in);
        if(cl1.DelNumbersSize < 1){
            System.out.println("Введите последовательность чисел!");
            cl1.SetNumberString(in.nextLine());
            Task1();
        }
        else{
            System.out.println("(1) Определить, максимальную разрядность чисел последовательности");
            System.out.println("(2) Найти числа, в шестнадцатеричном коде которых присутствуют буквы, и сформировать из них массив-слов, отобразить сформированный массив");
            System.out.println("(3) Первую цифру числа заменить последней, а последнюю первой");
            System.out.println("(4) Сформировать массив, значениями которого являются индексы чисел последовательности, равных последнему числу");
            System.out.println("(0) Главное меню");
            Task1func();

        }

    }

    public static void Task1func(){
        System.out.println("Ваш выбор? ");
        Scanner in = new Scanner(System.in);
        String ans;
        ans = in.nextLine();
        switch (Integer.parseInt(ans)){
            case 1:
                System.out.println("Максимальная разрядность: " + cl1.GetMaxDischarge());
                break;
            case 2:
                cl1.GetHexNumbers();
                break;
            case 3:
                cl1.ChangeNum();
                break;
            case 4:
                cl1.GetIndexArray();
                break;
            case 0:
                Menu();
        }
        Task1func();
    }



    public static void Task2(){
        Scanner in = new Scanner(System.in);
        if(cl2.DelNumbersSize < 1){
            System.out.println("Введите последовательность чисел!");
            cl2.SetNumberString(in.nextLine());
            Task2();
        }
        else{
            System.out.println("(1) Заменить десятичные числа их шестнадцатеричным кодом, если в их шестнадцатеричном коде которых присутствуют буквы");
            System.out.println("(2) Добавить сумму всех десятичных чисел в конец строки");
            System.out.println("(3) Первую цифру каждого числа заменить последней, а последнюю первой");
            System.out.println("(0) Главное меню");
            Task2func();

        }
    }

    public static void Task2func(){
        System.out.println("Ваш выбор? ");
        Scanner in = new Scanner(System.in);
        String ans;
        ans = in.nextLine();
        switch (Integer.parseInt(ans)){
            case 1:
                cl2.Change10to16();
                break;
            case 2:
                cl2.AddSum();
                break;
            case 3:
                cl2.ReplaceNum();
                break;
            case 0:
                Menu();
        }
        Task2func();
    }

    public static void Task3(){
        System.out.println("(1) Проверить то, что введенная строка является доменом второго уровня.");
        System.out.println("(2) Дан текст. Заменить в тексте все доменные имена России: заменив ru на рус");
        System.out.println("(0) Главное меню");
        Task3func();

    }

    public static void Task3func(){
        System.out.println("Ваш выбор? ");
        Scanner in = new Scanner(System.in);
        int ans;
        ans = in.nextInt();
        switch (ans){
            case 1:

                Task3FirstFunc();
                break;
            case 2:

                Task3SecondFunc();
                break;
            case 0:
                Menu();
        }
        Task3func();
    }

    public static void Task3FirstFunc(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String ans = in.nextLine();
        cl3.CheckDomain(ans);
    }

    public static void Task3SecondFunc(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String ans = in.nextLine();
        cl3.ReplaceRu(ans);
    }


}
