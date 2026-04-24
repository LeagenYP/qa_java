package com.example;

import java.util.List;

public class Lion {

    boolean hasMane;
    private final Feline feline;
    private final String animalKind;

    public Lion(String sex, Feline feline, String animalKind) throws Exception {
        this.feline = feline;
        this.animalKind = animalKind;
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    public Lion(String sex, Feline feline) throws Exception {
        this(sex, feline, null);
    }

    public int getKittens() {
        return feline.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return feline.getFood(animalKind);
    }
}
