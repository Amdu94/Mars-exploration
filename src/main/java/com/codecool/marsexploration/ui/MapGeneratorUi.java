package com.codecool.marsexploration.ui;

import com.codecool.marsexploration.data.MapConfig;
import com.codecool.marsexploration.data.TerrainElement;
import com.codecool.marsexploration.logic.Validator;
import com.codecool.marsexploration.logic.resourceLogic.MineralPlacer;
import com.codecool.marsexploration.logic.resourceLogic.WaterPlacer;
import com.codecool.marsexploration.logic.shape.MountainShape;
import com.codecool.marsexploration.logic.shape.PitShape;

import java.util.ArrayList;
import java.util.Scanner;

public class MapGeneratorUi {
    private final Validator validator;
    private final int WIDTH = 33;

    public MapGeneratorUi(Validator validator) {
        this.validator = validator;
    }

    public void run() {
        greetUser();

        String mapName = getValidInput("Enter map name:", validator::validateMapName);

        int mapTileCount = WIDTH * WIDTH;

        ArrayList<Integer> mountainAreas = new ArrayList<>();
        int mountainCount = Integer.parseInt(getValidInput("Enter mountain count:",
                input -> validator.validateMountainCount(parseIntInput(input), mapTileCount)));

        for (int i = 1; i <= mountainCount; i++) {
            int area = Integer.parseInt(getValidInput("Enter " + i + ". mountain area:",
                    input -> validator.validateMountainAreaSum(mountainAreas.stream()
                            .mapToInt(Integer::intValue)
                            .sum()
                            + parseIntInput(input), mapTileCount)));
            mountainAreas.add(area);
        }

        int availableMapArea =  mapTileCount;

        availableMapArea -= mountainAreas.stream()
                .mapToInt(Integer::intValue)
                .sum();

        ArrayList<Integer> pitAreas = new ArrayList<>();
        int pitCount = Integer.parseInt(getValidInput("Enter pit count:",
                input -> validator.validatePitCount(parseIntInput(input), mapTileCount)));

        for (int i = 1; i <= pitCount; i++) {
            int area = Integer.parseInt(getValidInput("Enter " + i + ". pit area:",
                    input -> validator.validatePitAreaSum(pitAreas.stream()
                            .mapToInt(Integer::intValue)
                            .sum()
                            + parseIntInput(input), mapTileCount)));
            pitAreas.add(area);
        }

        availableMapArea -= pitAreas.stream()
                .mapToInt(Integer::intValue)
                .sum();

        String input;
        int waterArea;

        do {
            System.out.println("Enter water area:");
            input = getInput();
            waterArea = parseIntInput(input);
        } while (!validator.validateWaterArea(waterArea, availableMapArea));

        availableMapArea -= waterArea;

        int resourceArea;

        do {
            System.out.println("Enter resource area:");
            input = getInput();
            resourceArea = parseIntInput(input);
        } while (!validator.validateResourceArea(resourceArea, availableMapArea));

        MapConfig config = new MapConfig(mapName, WIDTH, mountainCount, mountainAreas, pitCount, pitAreas, waterArea, resourceArea);
        printConfig(config);
        generate(config);
    }

    private void generate(MapConfig config){
        for(int i = 0; i < config.getMountainCount(); i++){
            new MountainShape((Integer) config.getMountainAreas().get(i), 1, TerrainElement.MOUNTAIN, config).generateRandomShape();
        }

        for(int i = 0; i < config.getPitCount(); i++){
            new PitShape((Integer) config.getPitAreas().get(i), 1, TerrainElement.PIT, config).generateRandomShape();
        }

        new MineralPlacer(config.getResourceArea(), config).placeSymbolsRandomlyToThePossiblePlaces();
        new WaterPlacer(config.getWaterArea(), config).placeSymbolsRandomlyToThePossiblePlaces();


        FileWriter fileWriter = new FileWriter();
        fileWriter.Writer(config, config.getMapName());

        char[][] map = config.getMap();

        for(int i = 0; i < config.getMapWidth(); i++){
            for(int j = 0; j < config.getMapWidth(); j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    private static void greetUser() {
        System.out.println("Welcome! Enter the desired parameters to start terraforming.");
    }

    private String getValidInput(String prompt, java.util.function.Predicate<String> validator) {
        String input;
        do {
            System.out.println(prompt);
            input = getInput();
        } while (!validator.test(input));
        return input;
    }

    private static String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private int parseIntInput(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void printConfig(MapConfig config) {
        System.out.println("Configuration Summary:");
        System.out.println("Map Name: " + config.getMapName());
        System.out.println("Map Width: " + config.getMapWidth());
        System.out.println("Mountain Count: " + config.getMountainCount());
        System.out.println("Mountain Areas: " + config.getMountainAreas());
        System.out.println("Pit Count: " + config.getPitCount());
        System.out.println("Pit Areas: " + config.getPitAreas());
        System.out.println("Water Area: " + config.getWaterArea());
        System.out.println("Resource Area: " + config.getResourceArea());
    }
}
