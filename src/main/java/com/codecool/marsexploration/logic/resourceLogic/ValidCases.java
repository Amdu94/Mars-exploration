package com.codecool.marsexploration.logic.resourceLogic;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.MapConfig;
import com.codecool.marsexploration.data.TerrainElement;

import java.util.ArrayList;
import java.util.List;

public class ValidCases {

    public boolean isValidPlacement(Coordinate coordinate, MapConfig map, TerrainElement placeNear) {
        if (map.getMap()[coordinate.x()][coordinate.y()] != ' ') {
            return false;
        }
        for (int i = coordinate.x() - 1; i <= coordinate.x() + 1; i++) {
            for (int j = coordinate.y() - 1; j <= coordinate.y() + 1; j++) {
                if (!(i < 0 || j < 0 || i >= map.getMapWidth() || j >= map.getMapWidth())) {
                    if (map.getMap()[i][j] == placeNear.getSign()) {
                        return true;
                    }
                }
            }

        }
        return false;
    }

    public List<Coordinate> getPlaceableCoordinates(MapConfig map, TerrainElement placeNear) {
        List<Coordinate> possibleCoordinates = new ArrayList<>();
        for (int i = 0; i < map.getMapWidth(); i++) {
            for (int j = 0; j < map.getMapWidth(); j++) {
                if (isValidPlacement(new Coordinate(i, j), map, placeNear)) {
                    possibleCoordinates.add(new Coordinate(i, j));
                }
            }
        }
        return possibleCoordinates;
    }
}
