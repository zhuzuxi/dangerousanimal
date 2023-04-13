package com.dangerousanimal.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class animal_family {
    private String name;

    public animal_family(String name) {
        this.name = name;
    }

        private ArrayList<AnimalOnlyName> children;
//    private ArrayList<Animal> animals;

}
