package com.codecool.marsexploration.logic.resourceLogic;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.MapConfig;
import com.codecool.marsexploration.data.TerrainElement;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class Placer {
    protected TerrainElement toPlace;
    protected TerrainElement placeNear;
    private int amount;
    private final MapConfig map;
    private final ValidCases singleValidator;


    public Placer(int amount, MapConfig map) {
        this.amount = amount;
        this.map = map;
        singleValidator = new ValidCases();
    }

    public void placeSymbolsRandomlyToThePossiblePlaces() {
        List<Coordinate> possiblePlaces = singleValidator.getPlaceableCoordinates(map, placeNear);

        if (possiblePlaces.size() < amount) {
            amount = possiblePlaces.size();
        }

        placeSymbolsRandomly(possiblePlaces, amount, toPlace, map);
    }

    private void placeSymbolsRandomly(List<Coordinate> possiblePlaces, int amount, TerrainElement toPlace, MapConfig map) {
        int placedCounter = 0;
        while (placedCounter < amount) {
            Coordinate randomCoordinate = pickRandomElement(possiblePlaces);
            map.setCoordinate(randomCoordinate, toPlace);
            possiblePlaces.remove(randomCoordinate);
            placedCounter++;
        }
    }

    private Coordinate pickRandomElement(List<Coordinate> items){
        Random random = new Random();
        int randomIndex = random.nextInt(items.size());
        return items.get(randomIndex);
    }


}
