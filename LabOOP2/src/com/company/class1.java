package com.company;
import java.math.BigInteger;

public class class1 {
    private int MaxDischarge = 1; // Максимальная разрядность
    private String NumberString;
    public String[] DelNumbers;
    private String[] ChangeNumbers;
    private String HexNumbers = "";
    public int DelNumbersSize;

    public void SetNumberString(String NumberString){ // Устанавливаем строку с последовательностью чисел
        this.NumberString = NumberString;
        DelNumbers = this.NumberString.split(" "); // Разделяем строку на массив по делителю "Пробел"
        DelNumbersSize = DelNumbers.length;
        ChangeNumbers = new String[DelNumbersSize];
    }

    public int GetMaxDischarge(){ // Возращаем максимальную разрядность числа из последовательности
        for(int i = 0; i < DelNumbers.length; i++){
            int TempDischarge = 0;
            int n = Integer.parseInt(DelNumbers[i]);
            while( n > 0){
                n /= 10;
                TempDischarge++;
            }
            if(TempDischarge > MaxDischarge){
                MaxDischarge = TempDischarge;
            }
        }
        return MaxDischarge;
    }

    public void ChangeNum(){ // Переставляем первое и последнее число
        for(int i = 0; i < DelNumbers.length; i++){
            if(Integer.parseInt(DelNumbers[i]) >= 10) { // Если число больше или равно 10, то переставляем
                ChangeNumbers[i] = DelNumbers[i].substring(DelNumbers[i].length() - 1) + DelNumbers[i].substring(1, DelNumbers[i].length() - 1) + DelNumbers[i].substring(0, 1);
            }
            else {
                ChangeNumbers[i] = DelNumbers[i];
            }
        }
        this.GetChangeNumbers();
    }

    public void GetChangeNumbers(){ // Выводим числа с помененой первой и последней цифрой
        for(int i = 0; i < ChangeNumbers.length; i++) {
            System.out.println(ChangeNumbers[i]);
        }
    }

    public void GetHexNumbers() {
        for (int i = 0; i < DelNumbers.length; i++) {
            String sHexNum = new BigInteger(DelNumbers[i]).toString(16);
            if (!sHexNum.matches("[0-9]+")) {
                HexNumbers += DelNumbers[i] + " - " +  sHexNum + " ";
            }
        }

        System.out.println(HexNumbers);

    }

    public void GetIndexArray(){
        for (int i = 0; i < DelNumbers.length; i++){
            String temp = DelNumbers[i];
            System.out.println(DelNumbers[i] + " Максимальный индекс - " + (temp.length()-1));
        }
    }
}