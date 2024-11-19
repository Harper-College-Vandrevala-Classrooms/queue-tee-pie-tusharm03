package com.csc;

public class Puppy implements Cutie {
    @Override
    public String description() {
        return "A little puppy with big, sad eyes";
    }

    @Override
    public Integer cutenessRating() {
        return 11; // This puppy gets a 11 out of 10 for cuteness
    }
}