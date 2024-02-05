package com.codecool.marsexploration.logic;

public interface Validator {
    boolean validateMapName(String mapName);
    boolean validateMapWidth(int width);
    boolean validateMountainCount(int mountainCount, int mapArea);
//      ...
//     mountainAreaSum = the sum of mountain tiles
//     the user can enter the area of each mountain
//     e.g. if the mountainCount=3; the mountainAreas can be 10, 20, 30
//     in this case, the mountainAreaSum = 10+20+30 = 60
    boolean validateMountainAreaSum(int mountainAreaSum, int availableMapArea);
    boolean validatePitCount(int pitCount, int availableMapArea);
    boolean validatePitAreaSum(int pitAreaSum, int availableMapArea);
    boolean validateWaterArea(int waterArea, int availableMapArea);
    boolean validateResourceArea(int resourceArea, int availableMapArea);
}