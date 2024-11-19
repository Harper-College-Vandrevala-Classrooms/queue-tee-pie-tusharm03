package com.csc;

public class Kitty implements Cutie {
    @Override
    public String description() {
        return "A cute kitty with soft fur and playful paws";
    }

    @Override
    public Integer cutenessRating() {
        return 9; // This kitty gets a 9 / 10 for its cuteness
    }
}
