package com.codecool.marsexploration.logic;

import java.util.Arrays;

public class ValidatorImpl implements Validator {
    private static final int MAX_WIDTH = 32;
    public static final Character[] INVALID_FILENAME_CHARS = {'"', '*', '<', '>', '?', '|', '\000', ' '};

    @Override
    public boolean validateMapName(String mapName) {
            if (mapName == null || mapName.isEmpty() || mapName.length() > 255) {
                return false;
            }
            return Arrays.stream(INVALID_FILENAME_CHARS)
                    .noneMatch(ch -> mapName.contains(ch.toString()));
        }

    @Override
    public boolean validateMapWidth(int width) {
        return width < MAX_WIDTH;
    }

    @Override
    public boolean validateMountainCount(int mountainCount, int mapArea) {
        return mountainCount < mapArea;
    }

    @Override
    public boolean validateMountainAreaSum(int mountainAreaSum, int availableMapArea) {
        return mountainAreaSum < availableMapArea;
    }

    @Override
    public boolean validatePitCount(int pitCount, int availableMapArea) {
        return pitCount < availableMapArea;
    }

    @Override
    public boolean validatePitAreaSum(int pitAreaSum, int availableMapArea) {
        return pitAreaSum < availableMapArea;
    }

    @Override
    public boolean validateWaterArea(int waterArea, int availableMapArea) {
        return waterArea < availableMapArea;
    }

    @Override
    public boolean validateResourceArea(int resourceArea, int availableMapArea) {
        return resourceArea < availableMapArea;
    }
}
