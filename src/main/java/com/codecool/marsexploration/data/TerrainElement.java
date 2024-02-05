package com.codecool.marsexploration.data;


public enum TerrainElement {
    MOUNTAIN('^'),
    PIT('#'),
    MINERAL('*'),
    WATER('~');

    private final char sign;


    TerrainElement(char sign) {
        this.sign = sign;
    }
    public char getSign() {
        return sign;
    }

}
