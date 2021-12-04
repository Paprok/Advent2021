package com.github.paprok.advent1;

import com.github.paprok.commons.AdventMapper;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class IntegerMapper implements AdventMapper<Integer> {

    @Override
    public Integer map(String line) {
        return Integer.valueOf(line);
    }
}
