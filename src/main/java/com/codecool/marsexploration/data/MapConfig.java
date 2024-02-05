package com.codecool.marsexploration.data;

import java.util.ArrayList;

public class MapConfig {
    private final char[][] map;

    private final int mapWidth;

    private final String mapName;

    private final int mountainCount;
    private final ArrayList mountainAreas;

    private final ArrayList pitAreas;
    private final int pitCount;
    private final int resourceArea;
    private final int waterArea;


    public MapConfig(String mapName, int mapWidth, int mountainCount,
                     ArrayList<Integer> mountainAreas,
                     int pitCount, ArrayList<Integer> pitAreas,
                     int waterArea, int resourceArea)
    {
        this.map = new char[mapWidth][mapWidth];
        this.mapWidth = mapWidth;
        this.mapName = mapName;
        this.waterArea = waterArea;
        this.resourceArea = resourceArea;
        this.pitCount = pitCount;
        this.pitAreas = pitAreas;
        this.mountainAreas = mountainAreas;
        this.mountainCount = mountainCount;
        fillMapWithEmptySpaces();
    }

    public String getMapName() {
        return mapName;
    }

    public int getMapWidth() {
        return mapWidth;
    }

    public char[][] getMap() {
        return map;
    }

    public int getMountainCount() {
        return mountainCount;
    }

    public ArrayList getMountainAreas() {
        return mountainAreas;
    }

    public ArrayList getPitAreas() {
        return pitAreas;
    }

    public int getPitCount() {
        return pitCount;
    }

    public int getResourceArea() {
        return resourceArea;
    }

    public int getWaterArea() {
        return waterArea;
    }

    public void setCoordinate(Coordinate coordinate, TerrainElement symbol) {
        if (coordinate.x() < 0 || coordinate.y() < 0 || coordinate.x() >= mapWidth || coordinate.y() >= mapWidth) {
            System.out.println("You wanted to set coordinates out of the map!");
            return;
        }

        map[coordinate.x()][coordinate.y()] = symbol.getSign();
    }

    private void fillMapWithEmptySpaces() {
        for (int i = 0; i < mapWidth; i++) {
            for (int j = 0; j < mapWidth; j++) {
                map[i][j] = ' ';
            }
        }
    }
}

