package com.codecool.marsexploration;

import com.codecool.marsexploration.logic.Validator;
import com.codecool.marsexploration.logic.ValidatorImpl;
import com.codecool.marsexploration.ui.MapGeneratorUi;

import java.util.Random;

public class Application {
    public static void main(String[] args) {
        Validator validator = new ValidatorImpl();
        MapGeneratorUi mapGeneratorUi = new MapGeneratorUi(validator);
        mapGeneratorUi.run();
    }
}
