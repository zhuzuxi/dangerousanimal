package com.dangerousanimal.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AnimalOrderAndLevel {
    private String name;
    private Integer FirstLevel;
    private Integer SecondLevel;
}
