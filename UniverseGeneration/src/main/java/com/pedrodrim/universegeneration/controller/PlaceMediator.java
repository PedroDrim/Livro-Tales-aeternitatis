package com.pedrodrim.universegeneration.controller;

import com.pedrodrim.universegeneration.model.Mediator;
import com.pedrodrim.universegeneration.model.ProceduralFactory;
import com.pedrodrim.universegeneration.model.ProceduralGeneration;
import java.util.Random;

public class PlaceMediator implements Mediator {

    private ProceduralFactory factory;
    private Random random;

    public PlaceMediator(ProceduralFactory factory) {
        this.factory = factory;
        this.random = new Random();
    }

    @Override
    public ProceduralGeneration call(ProceduralGeneration place) {

        int max = place.getMaxPlaceAmmount();

        for (int index = 0; index < max; index++) {

            ProceduralGeneration newPlace = this.factory.create();
            this.call(newPlace);
            place.insertPlace(index, newPlace);
        }

        return place;
    }
}
