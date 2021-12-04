package com.github.paprok.commons;

import com.github.paprok.advent1.IntegerMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class FileReaderTest {

    FileReader fileReader;
    AdventMapper<Integer> mapper;

    @BeforeEach
    void init() {
        fileReader = new FileReader();
        mapper = new IntegerMapper();
    }

    @Test
    @SneakyThrows
    void produceWith() {
        // given
        String fileName = "day1.txt";

        // when
        List<Integer> actual = fileReader.produceWith(fileName, mapper);

        //then
        assertEquals(actual.size(), 2000);
        assertEquals(actual.get(0), Integer.valueOf(189));
    }
}