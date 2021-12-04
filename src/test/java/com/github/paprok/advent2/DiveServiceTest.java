package com.github.paprok.advent2;

import com.github.paprok.advent1.IntegerMapper;
import com.github.paprok.advent1.SonarSweepService;
import com.github.paprok.commons.AdventMapper;
import com.github.paprok.commons.FileReader;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class DiveServiceTest {
    public static final String fileName = "day2.txt";
    @InjectMocks
    private DiveService diveService;
    @Spy
    private AdventMapper<DiveCoordinates> mapper = new DiveCoordinatesMapper();
    @Spy
    private FileReader<DiveCoordinates> fileReader = new FileReader<>(mapper);

    @Test
    @SneakyThrows
    void getMultipliedCoordinatesReturnsExpected() {
        // given
        doReturn(List.of(
                new DiveCoordinates(5, 0),
                new DiveCoordinates(0, 5),
                new DiveCoordinates(8, 0),
                new DiveCoordinates(0, -3),
                new DiveCoordinates(0, 8),
                new DiveCoordinates(2, 0)
                )).when(fileReader).produceWith(any());

        // when
        long actual = diveService.getMultipliedCoordinates();

        // then
        assertEquals(150, actual);
    }

    @Test
    @SneakyThrows
    void executeAdvent2Part1() {
        // given
        AdventMapper<DiveCoordinates> mapper = new DiveCoordinatesMapper();
        FileReader<DiveCoordinates> fileReader = new FileReader<>(mapper);
        DiveService diveService = new DiveService(fileReader);

        //when
        long actual = diveService.getMultipliedCoordinates();

        // then
        assertEquals(1893605, actual);
    }
}