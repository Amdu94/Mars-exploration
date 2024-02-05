package com.codecool.marsexploration.logic.resourceLogic;

import com.codecool.marsexploration.data.MapConfig;
import com.codecool.marsexploration.data.TerrainElement;

public class WaterPlacer extends Placer{
    public WaterPlacer(int amount, MapConfig map) {
        super(amount, map);
        this.toPlace = TerrainElement.WATER;
        this.placeNear = TerrainElement.PIT;
    }
}
