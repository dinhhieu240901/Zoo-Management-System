package com.codegym.model.Cage;

import com.codegym.model.animal.Animal;

public interface Habitat {
    boolean isCompatible(Animal animal);
}
