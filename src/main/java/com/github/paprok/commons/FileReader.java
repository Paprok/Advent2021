package com.github.paprok.commons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    // TODO refactor with producers implementing same interfaces, and ofc generic return type (or another interface?) based on interface<T>
    public List<String> produceWith(String fileName) throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            return produce(reader);
        }
    }

    // TODO: producer will contain method  to return empty
    List<String> produce(BufferedReader reader) throws IOException {
        return produce(reader, new ArrayList<>());
    }

    List<String> produce(BufferedReader reader, List<String> product) throws IOException {
        return reader.ready() ? produce(reader, updateAndGet(product, reader.readLine())) : product;
    }

    List<String> updateAndGet(List<String> product, String line) {
        product.add(line);
        return product;
    }
}