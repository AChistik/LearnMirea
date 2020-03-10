package com.company;

public class Candidate {
    private String name;
    private int voices = 0;

    public Candidate(String name){
        this.name = name;
    }

    // Вернуть имя кандидата

    public String getName(){
        return this.name;
    }

    // Добавить голос

    public void addVoice(){
        this.voices++;
    }

    // Вернуть количество голосов

    public int getVoices(){
        return this.voices;
    }
}
