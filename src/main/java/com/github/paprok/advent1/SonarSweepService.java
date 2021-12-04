package com.github.paprok.advent1;

import com.github.paprok.commons.FileReader;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;

@RequiredArgsConstructor
public class SonarSweepService {
    public static final String fileName = "day1.txt";
    private final FileReader fileReader;

    public int measurementIncreases() throws IOException {
        List<Integer> measurements = fileReader.produceWith(fileName);

        return countIncreases(measurements);
    }

    private int countIncreases(List<Integer> measurements) {
        return IntStream.range(1, measurements.size())
                .map(index -> mapIndexTo1IfIncreased(index, measurements))
                .sum();
    }

    private int mapIndexTo1IfIncreased(int index, List<Integer> measurements) {
        return measurements.get(index) > measurements.get(index - 1) ? 1 : 0;
    }
}
