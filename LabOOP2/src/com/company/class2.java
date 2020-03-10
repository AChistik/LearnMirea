package com.company;
import java.math.BigInteger;

public class class2 {
    private StringBuilder Numbers = new StringBuilder();
    public String[] DelNumbers;
    private StringBuilder HexNumbers = new StringBuilder();
    public int DelNumbersSize;
    private StringBuilder ReplaceNumbers = new StringBuilder();

    public void SetNumberString(String NumberString){ // Устанавливаем строку с последовательностью чисел
        this.Numbers.append(NumberString);
        DelNumbers = this.Numbers.toString().split(" "); // Разделяем строку на массив по делителю "Пробел"
        DelNumbersSize = DelNumbers.length;
    }

    public void Change10to16(){
        for (int i = 0; i < DelNumbers.length; i++) {
            String sHexNum = new BigInteger(DelNumbers[i]).toString(16);
            HexNumbers.append(sHexNum + " ");
        }
        System.out.println("Заменены числа содержашие буквы в 16-ричном коде");
        System.out.println(HexNumbers);
    }

    public void AddSum(){
        int sum = 0;
        for(int i = 0; i < DelNumbersSize; i++){
            sum += Integer.parseInt(DelNumbers[i]);
        }
        System.out.println(Numbers + " | Сумма: " + sum);
    }

    public void ReplaceNum(){

        for(int i = 0; i < DelNumbers.length; i++){
            if(Integer.parseInt(DelNumbers[i]) >= 10) { // Если число больше или равно 10, то переставляем
                StringBuilder temp = new StringBuilder(DelNumbers[i]);
                char start = temp.charAt(0);
                char end = temp.charAt(temp.length()-1);
                temp.setCharAt(0,end);
                temp.setCharAt(temp.length()-1,start);
                ReplaceNumbers.append(temp);
            }
            else {
                ReplaceNumbers.append(DelNumbers[i]);
            }
            ReplaceNumbers.append(" ");
        }
        System.out.println("Первая и последняя цифра поменяны местами");
        System.out.println(ReplaceNumbers);
    }


}
