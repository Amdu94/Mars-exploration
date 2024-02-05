package com.codecool.marsexploration.logic.resourceLogic;

import com.codecool.marsexploration.data.MapConfig;
import com.codecool.marsexploration.data.TerrainElement;

public class MineralPlacer extends Placer{
    public MineralPlacer(int amount, MapConfig map) {
        super(amount, map);
        this.toPlace = TerrainElement.MINERAL;
        this.placeNear = TerrainElement.MOUNTAIN;
    }
}
