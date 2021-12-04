package com.github.paprok.advent2;

enum DiveInstruction {
    FORWARD,
    UP,
    DOWN;

    public static DiveCoordinates getCoordinates(String[] instructions) {
        int value = Integer.parseInt(instructions[1]);
        String instruction = instructions[0];
        if (instruction.equalsIgnoreCase(FORWARD.name())) return new DiveCoordinates(value, 0);
        else if (instruction.equalsIgnoreCase(UP.name())) return new DiveCoordinates(0, value * -1);
        else if (instruction.equalsIgnoreCase(DOWN.name())) return new DiveCoordinates(0, value);
        else throw new IllegalArgumentException("Non existent coordinate");
    }

}