package com.dangerousanimal.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class animal_phylum {
    private String name;
    private ArrayList<animal_class> children;
//    private ArrayList<String> classes;

    public animal_phylum(String name) {
        this.name = name;
    }
}
