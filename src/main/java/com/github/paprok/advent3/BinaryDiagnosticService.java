package com.github.paprok.advent3;

import com.github.paprok.commons.FileReader;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequiredArgsConstructor
public class BinaryDiagnosticService {
    public static final String fileName = "day3.txt";
    private final FileReader<Integer[]> fileReader;

    public int getPowerConsumption() throws IOException {
        List<Integer[]> binaries = fileReader.produceWith(fileName);
        Integer[] summed = binaries.stream().reduce(this::sum).orElse(new Integer[0]);
        Integer[] mostCommon = Arrays.stream(summed).map(sum -> sum > binaries.size()/2 ? 1 : 0).toArray(Integer[]::new);
        Integer[] leastCommon = Arrays.stream(mostCommon).map(most -> most > 0 ? 0 : 1).toArray(Integer[]::new);
        return convertToDecimal(mostCommon) * convertToDecimal(leastCommon);
    }

    private Integer[] sum( Integer[] x, Integer[] y) {
        return IntStream.range(0, x.length)
                .mapToObj(index -> x[index] + y[index])
                .toArray(Integer[]::new);

    }
    private int convertToDecimal(Integer[] bits) {
        return Integer.parseInt(Arrays.stream(bits).map(String::valueOf).collect(Collectors.joining("")), 2);
    }


}
