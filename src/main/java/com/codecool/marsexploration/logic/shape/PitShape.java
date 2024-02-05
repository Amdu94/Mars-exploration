package com.codecool.marsexploration.logic.shape;

import com.codecool.marsexploration.data.MapConfig;
import com.codecool.marsexploration.data.TerrainElement;

public class PitShape extends Shape {
    public PitShape(int shapeSize, int shapeAmount, TerrainElement shapeSymbol, MapConfig mapConfig) {
        super(shapeSize, shapeAmount, shapeSymbol, mapConfig);
    }

    @Override
    public void generateRandomShape() {
        for(int i = 0; i < getShapeAmount(); i++){
            int startX = getRandom().nextInt(getMapConfig().getMapWidth());
            int startY = getRandom().nextInt(getMapConfig().getMapWidth());

            generateRandomPitShape(startX, startY, getShapeSize());
        }
    }

    private void generateRandomPitShape(int startX, int startY, int size){
        generateShapeRecursively(startX, startY, size);
    }
}
