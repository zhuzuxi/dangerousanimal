package com.dangerousanimal.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class animal_class {
    private String name;
//    private ArrayList<String> orders;
    private ArrayList<animal_order> children;

    public animal_class(String name) {
        this.name = name;
    }
}
