package com.github.paprok.advent1;

import com.github.paprok.commons.AdventMapper;
import com.github.paprok.commons.FileReader;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;

@RequiredArgsConstructor
public class SonarSweepService {
    private final FileReader fileReader;
    private final AdventMapper<Integer> integerAdventMapper;

    public static final String fileName = "day1.txt";

    // could have been parametrized with ie enum instead of repeating public methods
    public int measurementIncreases() throws IOException {
        List<Integer> measurements = fileReader.produceWith(fileName, integerAdventMapper);

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

    // could have been parametrized with ie enum instead of repeating public methods same for countIncreases
    public int summedMeasurementIncreases() throws IOException {
        List<Integer> measurements = fileReader.produceWith(fileName, integerAdventMapper);

        return countSummedIncreases(measurements);
    }

    private int countSummedIncreases(List<Integer> measurements) {
        return IntStream.range(3, measurements.size())
                .map(index -> mapIndexTo1IfSumIncreased(index, measurements))
                .sum();
    }

    private int mapIndexTo1IfSumIncreased(int index, List<Integer> measurements) {
        int rightSum = measurements.subList(index - 2, index+1).stream().reduce(0, Integer::sum);
        int leftSum = measurements.subList(index - 3, index).stream().reduce(0, Integer::sum);
        return rightSum > leftSum ? 1 : 0;
    }
}
