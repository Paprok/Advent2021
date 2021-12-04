package com.github.paprok.advent2;

import com.github.paprok.commons.AdventMapper;

public class DiveCoordinatesMapper implements AdventMapper<DiveCoordinates> {
    @Override
    public DiveCoordinates map(String line) {
        return DiveInstruction.getCoordinates(line.split(" "));
    }
}
