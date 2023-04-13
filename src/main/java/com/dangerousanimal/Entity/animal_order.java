package com.dangerousanimal.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class animal_order {
    private String name;
//    private ArrayList<String> families;
    private ArrayList<animal_family> children;

    public animal_order(String name) {
        this.name = name;
    }
}
