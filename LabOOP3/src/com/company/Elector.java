package com.company;

import java.util.HashMap;
import java.util.Map;


public class Elector {
    private boolean voted = false;
    protected Map<String, Integer> voices = new HashMap<>();


    // Прооверка, проголосовал ли человек

    public boolean isVoted(String Login){
        if(this.voices.get(Login) == null){
            return false;
        }
        return true;
    }

    // Вернуть id кандидата

    public int getVotedName(String Login){
        return this.voices.get(Login);
    }

    // Проголосовать

    public void vote(String Login,Integer candidate){
        this.voted = true;
        voices.put(Login,candidate);
    }
}
