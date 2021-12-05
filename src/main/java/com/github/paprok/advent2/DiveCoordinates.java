package com.github.paprok.advent2;

import lombok.Data;

@Data
public class DiveCoordinates {
    private final int horizontal;
    private final int depth;
    private final int aim;
    private final int forward;

    public DiveCoordinates add(DiveCoordinates other) {

        int newAim = this.aim + other.aim;
        int newDepth = this.depth + newAim* other.forward;
        int newHorizontal = this.horizontal + other.forward;
        return new DiveCoordinates(newHorizontal, newDepth, newAim, 0);
    }

    public long multiply() {
        return (long) horizontal * depth;
    }
}
