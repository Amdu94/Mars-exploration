package com.codecool.marsexploration.logic.shape;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.MapConfig;
import com.codecool.marsexploration.data.TerrainElement;

import java.util.Random;

public abstract class Shape {
    private int shapeSize;
    private int shapeAmount;
    private TerrainElement shapeSymbol;
    private MapConfig mapConfig;
    private Random random = new Random();

    public Shape(int shapeSize, int shapeAmount, TerrainElement shapeSymbol, MapConfig mapConfig) {
        this.shapeSize = shapeSize;
        this.shapeAmount = shapeAmount;
        this.shapeSymbol = shapeSymbol;
        this.mapConfig = mapConfig;
    }

    public abstract void generateRandomShape();

    protected void generateShapeRecursively(int x, int y, int size){
        if(size <= 0){
            return;
        }

        if(isWithinMapBounds(x, y) && mapConfig.getMap()[x][y] == ' '){
            mapConfig.setCoordinate(new Coordinate(x, y), shapeSymbol);
            size--;
        }

        int direction = generateRandomDirection();

        switch (direction) {
            case 0 -> {
                if (isWithinMapBounds(x, y - 1)) {
                    generateShapeRecursively(x, y - 1, size);
                }
                else{
                    generateShapeRecursively(x, y, size);
                }
            }
            case 1 -> {
                if (isWithinMapBounds(x, y + 1)) {
                    generateShapeRecursively(x, y + 1, size);
                }
                else{
                    generateShapeRecursively(x, y, size);
                }
            }
            case 2 -> {
                if (isWithinMapBounds(x - 1, y)) {
                    generateShapeRecursively(x - 1, y, size);
                }
                else{
                    generateShapeRecursively(x, y, size);
                }
            }
            case 3 -> {
                if (isWithinMapBounds(x + 1, y)) {
                    generateShapeRecursively(x + 1, y, size);
                }else{
                    generateShapeRecursively(x, y, size);
                }
            }
        }
    }

    private int generateRandomDirection(){
        return random.nextInt(4);
    }

    private boolean isWithinMapBounds(int x, int y){
        return x >= 0 && x < mapConfig.getMapWidth() && y >= 0 && y < mapConfig.getMapWidth();
    }

    public int getShapeAmount() {
        return shapeAmount;
    }

    public Random getRandom() {
        return random;
    }

    public MapConfig getMapConfig() {
        return mapConfig;
    }

    public int getShapeSize() {
        return shapeSize;
    }
}
