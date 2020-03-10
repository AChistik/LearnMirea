package com.company;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class class3 {

    public void CheckDomain(String Domain){
        Pattern pattern = Pattern.compile("^([\\da-z]+)(([\\.$])([a-z]{2,6})$)");
        Matcher m = pattern.matcher(Domain.toLowerCase());
        if(m.matches()){
            System.out.println("Строка является доменом второго уровня!");
        }
        else {
            System.out.println("Строка НЕ является доменом второго уровня!");
        }
    }

    public void ReplaceRu(String Domain){
        Pattern pattern  = Pattern.compile("\\.[r][u]");
        Matcher matcher = pattern.matcher(Domain.toLowerCase());
        String result = matcher.replaceAll(".рус"); // строка с результатом (замена всего найденного на "/")
        System.out.println(result);
    }
}
