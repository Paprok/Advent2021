package com.github.paprok.advent3;

import com.github.paprok.commons.AdventMapper;

public class BinaryMapper implements AdventMapper<Integer[]> {
    @Override
    public Integer[] map(String line) {
        return line.chars().mapToObj(x -> x - (int) '0').toArray(Integer[]::new);
    }
}
