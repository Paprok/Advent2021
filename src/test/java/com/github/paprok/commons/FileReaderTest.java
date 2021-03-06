package com.github.paprok.commons;

import com.github.paprok.advent1.IntegerMapper;
import com.github.paprok.advent2.DiveCoordinates;
import com.github.paprok.advent2.DiveCoordinatesMapper;
import com.github.paprok.advent3.BinaryMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class FileReaderTest {

    @Test
    @SneakyThrows
    void FileReaderWithIntegerMapperReturnsList() {
        // given
        AdventMapper<Integer> mapper = new IntegerMapper();
        FileReader<Integer> integerFileReader = new FileReader<>(mapper);
        String fileName = "day1.txt";

        // when
        List<Integer> actual = integerFileReader.produceWith(fileName);

        //then
        assertEquals(2000, actual.size());
        assertEquals(Integer.valueOf(189), actual.get(0));
    }

    @Test
    @SneakyThrows
    void FileReaderWithDiveCoordinatesMapperReturnsList() {
        // given
        AdventMapper<DiveCoordinates> mapper = new DiveCoordinatesMapper();
        FileReader<DiveCoordinates> diveFileReader = new FileReader<>(mapper);
        String fileName = "day2.txt";

        //when
        List<DiveCoordinates> actual = diveFileReader.produceWith(fileName);

        //them
        assertEquals(1000, actual.size());
        assertEquals(new DiveCoordinates(0,0,0, 4), actual.get(0));
        assertEquals(new DiveCoordinates(0, 0, 9, 0), actual.get(1));
        assertEquals(new DiveCoordinates(0,0,-2, 0), actual.get(5));
    }

    @Test
    @SneakyThrows
    void FileReaderWithBinaryMapperReturnsList() {
        // given
        AdventMapper<Integer[]> mapper = new BinaryMapper();
        FileReader<Integer[]> integerFileReader = new FileReader<>(mapper);
        String fileName = "day3.txt";

        // when
        List<Integer[]> actual = integerFileReader.produceWith(fileName);

        //then
        assertEquals(1000, actual.size());
        assertArrayEquals(new Integer[]{1,0,0,1,0,1,0,0,1,0,0,0}, actual.get(0));
    }
}