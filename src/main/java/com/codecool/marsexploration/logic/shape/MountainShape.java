package com.codecool.marsexploration.logic.shape;

import com.codecool.marsexploration.data.MapConfig;
import com.codecool.marsexploration.data.TerrainElement;

public class MountainShape extends Shape {
    public MountainShape(int shapeSize, int shapeAmount, TerrainElement shapeSymbol, MapConfig mapConfig) {
        super(shapeSize, shapeAmount, shapeSymbol, mapConfig);
    }

    @Override
    public void generateRandomShape() {
        for(int i = 0; i < getShapeAmount(); i++){
            int startX = getRandom().nextInt(getMapConfig().getMapWidth());
            int startY = getRandom().nextInt(getMapConfig().getMapWidth());

            generateRandomMountainShape(startX, startY, getShapeSize());
        }
    }

    private void generateRandomMountainShape(int startX, int startY, int size){
        generateShapeRecursively(startX, startY, size);
    }
}
