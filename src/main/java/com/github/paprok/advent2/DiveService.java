package com.github.paprok.advent2;

import com.github.paprok.commons.FileReader;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
public class DiveService {
    private final FileReader<DiveCoordinates> fileReader;
    public static final String fileName = "day2.txt";

    public long getMultipliedCoordinates() throws IOException {
        List<DiveCoordinates> diveCoordinates = fileReader.produceWith(fileName);
        return diveCoordinates.stream().reduce(new DiveCoordinates(0,0), DiveCoordinates::add).multiply();
    }
}
