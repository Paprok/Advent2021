package com.github.paprok.commons;

import lombok.RequiredArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class FileReader <T>{
    private final AdventMapper<T> mapper;

    public List<T> produceWith(String fileName) throws IOException {
        return getLines(fileName).stream()
                .map(mapper::map)
                .collect(Collectors.toList());
    }

    private List<String> getLines(String fileName) throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            return readLines(reader);
        }
    }

    List<String> readLines(BufferedReader reader) throws IOException {
        return readLines(reader, new ArrayList<>());
    }

    List<String> readLines(BufferedReader reader, List<String> product) throws IOException {
        return reader.ready() ? readLines(reader, updateAndGet(product, reader.readLine())) : product;
    }

    List<String> updateAndGet(List<String> product, String line) {
        product.add(String.valueOf(line));
        return product;
    }
}
