package com.github.paprok.advent2;

import lombok.Data;

@Data
public class DiveCoordinates {
    private final int horizontal;
    private final int depth;

    public DiveCoordinates add(DiveCoordinates other) {
        return new DiveCoordinates(this.horizontal + other.horizontal, this.depth + other.depth);
    }

    public long multiply() {
        return (long) horizontal * depth;
    }
}
