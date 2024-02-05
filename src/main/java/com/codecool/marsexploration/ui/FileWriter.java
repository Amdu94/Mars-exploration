package com.codecool.marsexploration.ui;

import com.codecool.marsexploration.data.MapConfig;

import java.io.BufferedWriter;
import java.io.IOException;


public class FileWriter {


    public void Writer(MapConfig map, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new
                java.io.FileWriter("./" + fileName + ".map", true))) {
            writer.write(buildString(map));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String buildString(MapConfig map) {
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < map.getMapWidth(); i++) {
            for (int j = 0; j < map.getMapWidth(); j++) {
                content.append(map.getMap()[i][j]);

            }
            content.append("\n");
        }
        return content.toString();
    }
}
